package com.example.JsonClient;

import android.util.JsonReader;

/**
 * Created with IntelliJ IDEA.
 * User: tibo
 * Date: 12/07/13
 * Time: 23:30
 * To change this template use File | Settings | File Templates.
 */
public class Def {

    private String titre;
    private String definition;

    public Def(String titre, String definition) {
        this.titre = titre;
        this.definition = definition;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    @Override
    public String toString() {
        return
                "titre='" + titre + '\'' +
                        ", definition='" + definition + '\''
                ;
    }
}
