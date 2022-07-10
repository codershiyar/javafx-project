package com.groep9D.BetabitApp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import models.Gebruiker;
import java.io.IOException;

public class GebruikersBeherenTabelController extends GebruikersWeergevenTabelController {

    public static Gebruiker geselecteerdeGebruiker;

    @FXML
    private TableView<Gebruiker> gebruikersTable;

    @FXML
    private Label foutmelding;

    @FXML
    protected void onVerwijderButtonClick() {
        geselecteerdeGebruiker = getGeselecteerdeGebruiker();
        int aantalBeheerders = aantalBeheerdersTellen();
        if (geselecteerdeGebruiker.getRole().equals("Gebruiker") || aantalBeheerders > 1) {
            BetaBitApp.gebruikers.remove(geselecteerdeGebruiker);
            gebruikersTable.getItems().remove(geselecteerdeGebruiker);
        } else {
            foutmelding.setVisible(true);
        }
        GebruikersData.opslaan();
    }

    @FXML
    protected void onBeheerButtonClick() throws IOException {
        geselecteerdeGebruiker = getGeselecteerdeGebruiker();
        BetaBitApp.setScherm("beheerder/GebruikerBeheren.fxml");
    }

    private Gebruiker getGeselecteerdeGebruiker() {
        return gebruikersTable.getSelectionModel().getSelectedItem();
    }

    static public int aantalBeheerdersTellen() {
        int aantalBeheerders = 0;
        for (Gebruiker gebruiker : BetaBitApp.gebruikers) {
            if (gebruiker.getRole().equals("Beheerder")) {
                aantalBeheerders++;
            }
        }
        return aantalBeheerders;
    }
}