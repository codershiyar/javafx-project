package com.groep9D.BetabitApp;

import javafx.scene.paint.Color;
import models.IngelogdeGebruiker;

public abstract class GrafiekFactory {

    public static Grafiek getGrafiekLayout(Integer[] layoutEigenschappen){
        Grafiek grafiekLayout = new Grafiek();
        grafiekLayout.setxPositie(layoutEigenschappen[0]);
        grafiekLayout.setyPositie(layoutEigenschappen[1]);
        grafiekLayout.setGrootte(layoutEigenschappen[2]);
        grafiekLayout.setColor(Color.PINK);
        return grafiekLayout;
    }

    public static Grafiek grafiekAanmaken(Integer[] layoutEigenschappen){
        return new Grafiek(getGrafiekLayout(layoutEigenschappen), IngelogdeGebruiker.gebruiker.getIngevoerdeData());
    }

}
