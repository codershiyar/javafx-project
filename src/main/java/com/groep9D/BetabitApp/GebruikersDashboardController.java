package com.groep9D.BetabitApp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import models.IngelogdeGebruiker;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GebruikersDashboardController implements Initializable {

    public boolean isMenuOpen = false;

    @FXML
    private Label aantalPunten;

    @FXML
    private VBox menu;

    @FXML
    private Rectangle shadow;

    @FXML
    protected void onToggleMenuButtonClick() {
        isMenuOpen = !isMenuOpen;
        shadow.setVisible(isMenuOpen);
        TranslateTransition animation = new TranslateTransition(Duration.seconds(0.5), menu);
        animation.setToX(isMenuOpen ? 238 : 0);
        animation.play();
    }

    @FXML
    protected void onPunteninvoerButtonClick() throws IOException {
        BetaBitApp.setScherm("gebruiker/Punteninvoer.fxml");
    }

    @FXML
    protected void onGrafiekButtonClick() throws IOException {
        BetaBitApp.setScherm("gebruiker/Grafiek.fxml");
    }

    @FXML
    protected void onRanglijstButtonClick() throws IOException {
        BetaBitApp.setScherm("gebruiker/Ranglijst.fxml");
    }

    @FXML
    protected void onShopButtonClick() throws IOException {
        BetaBitApp.setScherm("gebruiker/Shop.fxml");
    }

    @FXML
    protected void onUitloggenButtonClick() throws IOException {
        BetaBitApp.setScherm("inlogpagina/Inlogpagina.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        aantalPunten.setText(String.valueOf(IngelogdeGebruiker.gebruiker.getPunten()));
    }
}