package com.example.adilbek.kinoafisha_project.modelder.kino_modelder;

import java.util.ArrayList;

public class Kino  {
    public Boolean succes;
    public int count;
    public  ArrayList<Result> result;


    public Boolean getSucces() {
        return succes;
    }

    public int getCount() {
        return count;
    }

    public ArrayList<Result> getResult() {
        return result;
    }

    public Kino(Boolean succes, int count, ArrayList<Result> result) {

        this.succes = succes;
        this.count = count;
        this.result = result;
    }
}

