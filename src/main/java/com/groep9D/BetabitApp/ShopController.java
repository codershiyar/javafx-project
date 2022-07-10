package com.groep9D.BetabitApp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import models.IngelogdeGebruiker;
import models.Prijs;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ShopController implements Initializable {

    @FXML
    private VBox prijzen;

    @FXML
    protected void onTerugButtonClick() throws IOException {
        BetaBitApp.setScherm("gebruiker/GebruikersDashboard.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        VoertuigenData.opslaan();

        if (BetaBitApp.prijzen.isEmpty()) {
            prijzen.getChildren().add(new Label("Er zijn nog geen prijzen toegevoegd"));
            return;
        }

        for (Prijs huidigePrijs : BetaBitApp.prijzen) {
            VBox vBox = new VBox();
            vBox.setPrefHeight(200);
            vBox.setPrefWidth(10);
            vBox.setAlignment(Pos.CENTER);
            vBox.setSpacing(5);
            vBox.setStyle("-fx-background-color: white;");

            Label naam = new Label(huidigePrijs.getNaam());

            naam.getStyleClass().add("naamLabel");
            naam.setPrefWidth(288);
            naam.setAlignment(Pos.valueOf("CENTER"));

            ImageView image = new ImageView(huidigePrijs.getImage());
            image.setFitWidth(120);
            image.setFitHeight(120);

            Label omschrijving = new Label(huidigePrijs.getOmschrijving());
            omschrijving.setFont(new Font(12));

            Label aantalPunten = new Label("Prijs: " + huidigePrijs.getAantalPunten() + " punten");
            aantalPunten.setFont(new Font(12));

            Button koopKnop = new Button("Koop");
            koopKnop.getStyleClass().add("groenKnopje");
            koopKnop.setPrefWidth(288);
            koopKnop.setOnAction(event -> onKoopButtonClick(BetaBitApp.prijzen.indexOf(huidigePrijs)));

            vBox.getChildren().addAll(naam, image, omschrijving, aantalPunten, koopKnop);
            prijzen.getChildren().add(vBox);
        }
    }

    private void onKoopButtonClick(int index) {
        if (IngelogdeGebruiker.gebruiker.getPunten() >= BetaBitApp.prijzen.get(index).getAantalPunten()) {
            IngelogdeGebruiker.gebruiker.setPunten(IngelogdeGebruiker.gebruiker.getPunten() - BetaBitApp.prijzen.get(index).getAantalPunten());
            GebruikersData.opslaan();
        } else {
            prijzen.getChildren().clear();
            Label foutmelding = new Label("Je hebt hiervoor niet genoeg punten");
            Button opnieuwButton = new Button("Probeer opnieuw");
            opnieuwButton.setOnAction(event -> {
                try {
                    BetaBitApp.setScherm("gebruiker/Shop.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            prijzen.getChildren().addAll(foutmelding, opnieuwButton);
        }
    }
}