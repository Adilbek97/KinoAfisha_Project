package com.example.adilbek.kinoafisha_project.modelder.kino_modelder;

import java.util.ArrayList;
public class Kino {
Boolean succes;
int count;
public  ArrayList<Result> result;

    public Boolean getSucces() {
        return succes;
    }

    public int getCount() {
        return count;
    }

    public void setSucces(Boolean succes) {
        this.succes = succes;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setResult(ArrayList<Result> result) {
        this.result = result;
    }

    public ArrayList<Result> getResult() {
        return result;
    }


}
