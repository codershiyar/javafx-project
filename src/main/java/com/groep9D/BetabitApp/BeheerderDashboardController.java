package com.groep9D.BetabitApp;

import javafx.fxml.FXML;
import java.io.IOException;

public class BeheerderDashboardController {

    @FXML
    protected void onUitlogKnopClick() throws IOException {
        BetaBitApp.setScherm("inlogpagina/Inlogpagina.fxml");
    }

    @FXML
    protected void onAanmaakKnop() throws IOException {
        BetaBitApp.setScherm("beheerder/GebruikerAanmaken.fxml");
    }

    @FXML
    protected void onGebruikersWeergevenKnop() throws IOException {
        BetaBitApp.setScherm("beheerder/GebruikersWeergevenTabel.fxml");
    }

    @FXML
    public void onGebruikersBeherenKnop() throws IOException {
        BetaBitApp.setScherm("beheerder/GebruikersBeherenTabel.fxml");
    }

    @FXML
    public void onRanglijstKnop() throws IOException {
        BetaBitApp.setScherm("gebruiker/Ranglijst.fxml");
    }

    @FXML
    protected void onNieuwVoertuigKnop() throws IOException {
        BetaBitApp.setScherm("beheerder/VoertuigAanmaken.fxml");
    }
}