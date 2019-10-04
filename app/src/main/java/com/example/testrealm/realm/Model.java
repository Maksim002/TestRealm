package com.example.testrealm.realm;

import java.util.List;

public class Model {

    private List<Product> questionnaires;

    public Model(List<Product> questionnaires) {
        this.questionnaires = questionnaires;
    }

    public List<Product> questionnaires() {
        return questionnaires;
    }
    public void setBook(List<Product> questionnaires) {
        this.questionnaires = questionnaires;
    }
}
