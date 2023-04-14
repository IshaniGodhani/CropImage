package com.example.new_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

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

    ArrayList<DataModel> list = new ArrayList<>();
    RecyclerView recyclerView;
    Recycler_Adapter recyclerAdapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/users";
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                JSONArray jsonArray= null;
                try {
                    jsonArray = new JSONArray(response);
                    Log.d("bbb", "onResponse: "+jsonArray.toString());
                    for (int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject mainObj=jsonArray.getJSONObject(i);
                            JSONObject address = mainObj.getJSONObject("address");
                            JSONObject company = mainObj.getJSONObject("company");
                                JSONObject geo = address.getJSONObject("geo");
                                Log.d("MMM", "onResponse: "+mainObj);

                                Integer id=mainObj.getInt("id");
                        String name=mainObj.getString("name");
                        String username=mainObj.getString("username");
                        String email=mainObj.getString("email");
                        String street = address.getString("street");

                        String phone;
                        String website;
                        DataModel.Company com;
                        DataModel model=new DataModel(id,name,username,email);
                        list.add(model);

                        model.setId(mainObj.getInt("id"));
                        model.setId(mainObj.getInt("name"));
                        model.setId(mainObj.getInt("username"));
                        model.setId(mainObj.getInt("email"));

                        recyclerAdapter=new Recycler_Adapter(this,model);

                    }
                }
                catch (JSONException e) {
                    throw new RuntimeException(e);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
    }
}