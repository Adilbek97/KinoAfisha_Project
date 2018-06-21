package com.example.adilbek.kinoafisha_project.modelder.kino_modelder;

import java.util.ArrayList;
public class Result {
    public String name;
    public String image;
    public ArrayList<Sessions> sessions;
    public String actors;
    public String rejisser;
    public String premier_ua;
    public String countries;
    public String vote;
// class Result (var name : String, var image : String, var sessions :ArrayList<Sessions>,var actors : String,var rejisser : String,var premier_ua : String, var countries: String,var vote : String)


    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public ArrayList<Sessions> getSessions() {
        return sessions;
    }

    public String getActors() {
        return actors;
    }

    public String getRejisser() {
        return rejisser;
    }

    public String getPremier_ua() {
        return premier_ua;
    }

    public String getCountries() {
        return countries;
    }

    public String getVote() {
        return vote;
    }

    public Result(String name, String image, ArrayList<Sessions> sessions, String actors, String rejisser, String premier_ua, String countries, String vote) {

        this.name = name;
        this.image = image;
        this.sessions = sessions;
        this.actors = actors;
        this.rejisser = rejisser;
        this.premier_ua = premier_ua;
        this.countries = countries;
        this.vote = vote;
    }
}