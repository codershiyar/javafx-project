package com.groep9D.BetabitApp;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.Gebruiker;

import java.io.IOException;

public class GebruikerAanmakenController {

    @FXML
    private TextField naamVeld;

    @FXML
    private TextField gebruikersnaamVeld;

    @FXML
    private PasswordField wachtwoordVeld;

    @FXML
    private CheckBox beheerderKnop;

    @FXML
    private Label foutmelding;

    @FXML
    protected void onTerugKnopClick() throws IOException {
        BetaBitApp.setScherm("beheerder/BeheerderDashboard.fxml");
    }

    @FXML
    protected void onAanmaakKnop() throws IOException {
        if (veldenControleren()) {
            Gebruiker gebruiker = new Gebruiker(true);
            gebruiker.setNaam(naamVeld.getText());
            gebruiker.setGebruikersnaam(gebruikersnaamVeld.getText());
            gebruiker.setWachtwoord(wachtwoordVeld.getText());
            gebruiker.setRole(beheerderKnop.isSelected() ? "Beheerder" : "Gebruiker");
            BetaBitApp.gebruikers.add(gebruiker);
            GebruikersData.opslaan();
            BetaBitApp.setScherm("beheerder/BeheerderDashboard.fxml");
        } else {
            foutmelding.setVisible(true);
        }
    }

    @FXML
    public boolean veldenControleren() {
        return !naamVeld.getText().equals("") && !gebruikersnaamVeld.getText().equals("") && !wachtwoordVeld.getText().equals("");
    }

}