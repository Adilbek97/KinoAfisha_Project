package com.example.adilbek.kinoafisha_project.modelder.kino_modelder;

public class Sessions {
   public String k_id;
    public String sessions;
    public String h_name;

    public Sessions(String k_id, String sessions, String h_name) {
        this.k_id = k_id;
        this.sessions = sessions;
        this.h_name = h_name;
    }

    public String getK_id() {
        return k_id;
    }

    public String getSessions() {
        return sessions;
    }

    public void setK_id(String k_id) {
        this.k_id = k_id;
    }

    public void setSessions(String sessions) {
        this.sessions = sessions;
    }

    public void setH_name(String h_name) {
        this.h_name = h_name;
    }

    public String getH_name() {
        return h_name;
    }
}
