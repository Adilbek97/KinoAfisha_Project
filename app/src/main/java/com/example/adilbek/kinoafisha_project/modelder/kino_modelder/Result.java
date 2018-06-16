package com.example.adilbek.kinoafisha_project.modelder.kino_modelder;

import java.util.ArrayList;

public class Result {
public String name;
public String image;
public ArrayList<Sessions> sessions;

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setSessions(ArrayList<Sessions> sessions) {
        this.sessions = sessions;
    }

    public Result(String name, String image, ArrayList<Sessions> sessions) {
        this.name = name;
        this.image = image;
        this.sessions = sessions;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public ArrayList<Sessions> getSessions() {
        return sessions;
    }
}
