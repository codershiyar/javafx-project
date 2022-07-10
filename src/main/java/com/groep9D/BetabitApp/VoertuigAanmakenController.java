package com.groep9D.BetabitApp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.Voertuig;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class VoertuigAanmakenController implements Initializable {

    @FXML
    private TextField gramPerKMVeld;

    @FXML
    private TextField naamVoertuigVeld;

    @FXML
    private Label foutmeldingGeenGetal;

    @FXML
    private Label foutmeldingLegeVelden;

    @FXML
    private ComboBox<String> brandstoffen;

    @FXML
    protected void onTerugKnopClick() throws IOException {
        BetaBitApp.setScherm("beheerder/BeheerderDashboard.fxml");
    }


    @FXML
    protected void onVoertuigAanmakenKnop() throws IOException {
        int gram = 0;
        try {
            gram = Integer.parseInt(gramPerKMVeld.getText());
        } catch (Exception e) {
            foutmeldingGeenGetal.setVisible(true);
            foutmeldingGeenGetal.setText("Dit is geen nummer");
        }

        if (gram != 0 && !naamVoertuigVeld.getText().equals("")) {
            if (gram < 40) {
                puntenBerekenenLaag(gram);
            } else {
                puntenBerekenenHoog(gram);
            }
            BetaBitApp.setScherm("beheerder/BeheerderDashboard.fxml");
        }
        if (naamVoertuigVeld.getText().equals("") || brandstoffen.getValue()==null) {
            foutmeldingLegeVelden.setVisible(true);
            foutmeldingLegeVelden.setText("Er is voor een veld niks ingevoerd");
        }else{
            VoertuigenData.opslaan();
        }

    }

    public void puntenBerekenenLaag(int gram) {
        if (gram >= 0 && gram <= 20) {
            BetaBitApp.voertuigen.add(aangemaakteVoertuig(9));
        }
        else if (gram > 20 && gram <= 35) {
            BetaBitApp.voertuigen.add(aangemaakteVoertuig(7));
        }
        else {
            BetaBitApp.voertuigen.add(aangemaakteVoertuig(5));
        }
    }

    public void puntenBerekenenHoog(int gram) {
        if (gram >= 40 && gram <= 50) {
            BetaBitApp.voertuigen.add(aangemaakteVoertuig(4));
        }
        else if (gram > 50 && gram <= 65) {
            BetaBitApp.voertuigen.add(aangemaakteVoertuig(2));
        }
        else {
            BetaBitApp.voertuigen.add(aangemaakteVoertuig(0));
        }
    }

    @FXML
    public Voertuig aangemaakteVoertuig(int punt){
        Voertuig voertuig = new Voertuig();
        voertuig.setVervoerNaam(naamVoertuigVeld.getText());
        voertuig.setBrandstofType(brandstoffen.getValue());
        voertuig.setPunt(punt);
        return voertuig;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (String type : Voertuig.brandstof.getTypes()) {
            brandstoffen.getItems().add(type);
        }
    }
}
