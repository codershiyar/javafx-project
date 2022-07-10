package com.groep9D.BetabitApp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.Gebruiker;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GebruikerBeherenController implements Initializable {

    Gebruiker geselecteerdeGebruiker = GebruikersBeherenTabelController.geselecteerdeGebruiker;

    @FXML
    private TextField naam;

    @FXML
    private TextField gebruikersnaam;

    @FXML
    private TextField wachtwoord;

    @FXML
    private CheckBox role;

    @FXML
    private Label foutmelding;

    @FXML
    protected void onTerugButtonClick() throws IOException {
        BetaBitApp.setScherm("beheerder/GebruikersBeherenTabel.fxml");
    }

    @FXML
    protected void onOpslaanButtonClick() throws IOException {
        if (geselecteerdeGebruiker.getRole().equals("Gebruiker") || role.isSelected() || GebruikersBeherenTabelController.aantalBeheerdersTellen() > 1) {
            geselecteerdeGebruiker.setNaam(naam.getText());
            geselecteerdeGebruiker.setGebruikersnaam(gebruikersnaam.getText());
            geselecteerdeGebruiker.setWachtwoord(wachtwoord.getText());
            geselecteerdeGebruiker.setRole(role.isSelected() ? "Beheerder" : "Gebruiker");
            GebruikersData.opslaan();
            BetaBitApp.setScherm("beheerder/BeheerderDashboard.fxml");
        } else {
            foutmelding.setVisible(true);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        naam.setText(geselecteerdeGebruiker.getNaam());
        gebruikersnaam.setText(geselecteerdeGebruiker.getGebruikersnaam());
        wachtwoord.setText(geselecteerdeGebruiker.getWachtwoord());
        role.setSelected(geselecteerdeGebruiker.getRole().equals("Beheerder"));
    }
}