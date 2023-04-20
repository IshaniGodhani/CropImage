package com.example.comments_500;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Datamodel> arrayList=new ArrayList<>();
    Recycler_Adapter recyclerAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        String url="https://jsonplaceholder.typicode.com/comments";
        StringRequest request=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                JSONArray jsonArray=null;
                try {
                    jsonArray=new JSONArray(response);

                    for (int i=0;i< jsonArray.length();i++)
                    {
                        JSONObject mainObj=jsonArray.getJSONObject(i);

                        int pid=mainObj.getInt("postId");
                        int id=mainObj.getInt("id");
                        String name=mainObj.getString("name");
                        String email=mainObj.getString("email");
                        String body=mainObj.getString("body");

                        Datamodel datamodel=new Datamodel(pid,id,name,email,body);
                        arrayList.add(datamodel);
                    }
                    recyclerAdapter=new Recycler_Adapter(MainActivity.this,arrayList);
                    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this);
                    linearLayoutManager.setOrientation(linearLayoutManager.VERTICAL);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(recyclerAdapter);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(request);
    }
}