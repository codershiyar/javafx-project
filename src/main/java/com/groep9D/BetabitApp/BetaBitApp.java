package com.groep9D.BetabitApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import models.Gebruiker;
import models.Voertuig;
import models.Prijs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class BetaBitApp extends Application {

    public static ArrayList<Gebruiker> gebruikers = GebruikersData.initialiseer();
    public static ArrayList<Voertuig> voertuigen = VoertuigenData.initialiseer();
    public static ArrayList<Prijs> prijzen = PrijzenData.initialiseer();
    private static Stage stage;

    @Override
    public void start(Stage fxStage) throws IOException {
        stage = fxStage;
        stage.setResizable(false);
        stage.setTitle("BetaBit App");
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("icons/logo.png"))));
        BetaBitApp.setScherm("inlogpagina/Inlogpagina.fxml");
    }

    public static void setScherm(String fxmlFile) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BetaBitApp.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load(), 288, 512);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}