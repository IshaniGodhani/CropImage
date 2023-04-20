package com.example.postapi;

public class Model {

    int success;
    int connection;

    public Model(int success, int connection) {
        this.success = success;
        this.connection = connection;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public int getConnection() {
        return connection;
    }

    public void setConnection(int connection) {
        this.connection = connection;
    }
}
