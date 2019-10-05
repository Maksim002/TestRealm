package com.example.testrealm.realm;

import com.google.gson.annotations.SerializedName;

class Answer {
    private int id;
    private String title;

    @SerializedName("is_correct")
    private Boolean correct;

    public Answer(int id, String title, Boolean correct) {
        this.id = id;
        this.title = title;
        this.correct = correct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle(int adapterPosition) {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }
}
