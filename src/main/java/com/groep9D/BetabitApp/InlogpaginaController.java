package com.groep9D.BetabitApp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.Gebruiker;
import models.IngelogdeGebruiker;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class InlogpaginaController implements Initializable {

    @FXML
    private TextField gebruikersnaamInvoer;

    @FXML
    private PasswordField wachtwoordInvoer;

    @FXML
    private Label foutmeldingLabel;
    public static Label testFoutmeldingLabel;

    @FXML
    protected void onInlogButtonClick() throws IOException {
        Gebruiker gebruiker = new Gebruiker(false);
        gebruiker.setGebruikersnaam(gebruikersnaamInvoer.getText());
        gebruiker.setWachtwoord(wachtwoordInvoer.getText());
        int gebruikerIndex = checkInloggegevens(BetaBitApp.gebruikers,gebruiker);
        if (gebruikerIndex >= 0) {
            if (IngelogdeGebruiker.gebruiker.getRole().equals("Beheerder"))
                BetaBitApp.setScherm("beheerder/BeheerderDashboard.fxml");
            else if (IngelogdeGebruiker.gebruiker.getRole().equals("Gebruiker"))
                BetaBitApp.setScherm("gebruiker/GebruikersDashboard.fxml");
        } else if (gebruikerIndex == -1) {
            foutmeldingLabel.setVisible(true);
            testFoutmeldingLabel = foutmeldingLabel;
        }
    }

    public static int checkInloggegevens(ArrayList<Gebruiker> gebruikers, Gebruiker ingevoerdeGebruiker) {
        for (Gebruiker gebruiker : gebruikers) {
            if (ingevoerdeGebruiker.getGebruikersnaam().equals(gebruiker.getGebruikersnaam()) && ingevoerdeGebruiker.getWachtwoord().equals(gebruiker.getWachtwoord())) {
                IngelogdeGebruiker.gebruiker = gebruiker;
                return gebruikers.indexOf(gebruiker);
            }
        }
        return -1;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        IngelogdeGebruiker.gebruiker = null;
    }
}