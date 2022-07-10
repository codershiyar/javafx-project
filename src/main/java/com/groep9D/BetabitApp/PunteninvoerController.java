package com.groep9D.BetabitApp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.IngelogdeGebruiker;
import models.IngevoerdeData;
import models.Voertuig;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class PunteninvoerController implements Initializable {

    @FXML
    private TextField kilometerInvoerVeld;

    @FXML
    private Label kilometerFoutmelding;

    @FXML
    private Label vervoersmiddelFoutmelding;

    @FXML
    private Label succesBericht;

    @FXML
    private ComboBox<String> voertuigenSelectOpties;

    @FXML
    protected void onTerugButtonClick() throws IOException {
        BetaBitApp.setScherm("gebruiker/GebruikersDashboard.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Voertuig voertuig : BetaBitApp.voertuigen) {
            voertuigenSelectOpties.getItems().add(voertuig.getVervoerNaam()+"("+ voertuig.getBrandstofType()+")");
        }
    }

    @FXML
    public void onToevoegenButtonClick() {
        int kilometers;

        try {
            kilometers = Integer.parseInt(kilometerInvoerVeld.getText());
            kilometerFoutmelding.setVisible(false);
        } catch (NumberFormatException numberFormatException) {
            kilometers = -1;
            kilometerFoutmelding.setVisible(true);
        }

        String vervoer = null;
        if (voertuigenSelectOpties.getValue() != null) {
            vervoer = voertuigenSelectOpties.getValue().substring(0,voertuigenSelectOpties.getValue().indexOf("(")) ;
            vervoersmiddelFoutmelding.setVisible(false);
        } else {
            vervoersmiddelFoutmelding.setVisible(true);
        }

        if (vervoer != null && kilometers != -1) {
            IngelogdeGebruiker.gebruiker.getIngevoerdeData().add(new IngevoerdeData(kilometers, getVoertuig(vervoer)));
            IngelogdeGebruiker.gebruiker.setPunten(IngelogdeGebruiker.gebruiker.getPunten() + (Objects.requireNonNull(getVoertuig(vervoer)).getPunt() * kilometers / 4));
            GebruikersData.opslaan();
            succesBericht.setVisible(true);
        }
    }

    public static Voertuig getVoertuig(String naam) {
        for (Voertuig voertuig : BetaBitApp.voertuigen) {
            if (voertuig.getVervoerNaam().equals(naam)) {
                return voertuig;
            }
        }
        return null;
    }
}
