package com.groep9D.BetabitApp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Gebruiker;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GebruikersWeergevenTabelController implements Initializable {

    public static Gebruiker geselecteerdeGebruiker;

    @FXML
    private TableView<Gebruiker> gebruikersTable;

    @FXML
    protected void onTerugKnop() throws IOException {
        BetaBitApp.setScherm("beheerder/BeheerderDashboard.fxml");
    }

    @FXML
    protected void onPuntengeschiedenisButtonClick() throws IOException {
        geselecteerdeGebruiker = getGeselecteerdeGebruiker();
        BetaBitApp.setScherm("beheerder/PuntengeschiedenisWeergeven.fxml");
    }

    private Gebruiker getGeselecteerdeGebruiker() {
        return gebruikersTable.getSelectionModel().getSelectedItem();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TableColumn<Gebruiker, String> naamKolom = new TableColumn<>("Naam");
        naamKolom.setCellValueFactory(new PropertyValueFactory<>("Naam"));
        gebruikersTable.getColumns().add(naamKolom);

        TableColumn<Gebruiker, String> gebruikersnaamKolom = new TableColumn<>("Gebruikersnaam");
        gebruikersnaamKolom.setCellValueFactory(new PropertyValueFactory<>("Gebruikersnaam"));
        gebruikersTable.getColumns().add(gebruikersnaamKolom);

        TableColumn<Gebruiker, String> wachtwoordKolom = new TableColumn<>("Wachtwoord");
        wachtwoordKolom.setCellValueFactory(new PropertyValueFactory<>("Wachtwoord"));
        gebruikersTable.getColumns().add(wachtwoordKolom);

        TableColumn<Gebruiker, String> roleKolom = new TableColumn<>("Role");
        roleKolom.setCellValueFactory(new PropertyValueFactory<>("Role"));
        gebruikersTable.getColumns().add(roleKolom);

        TableColumn<Gebruiker, String> puntenKolom = new TableColumn<>("Punten");
        puntenKolom.setCellValueFactory(new PropertyValueFactory<>("Punten"));
        gebruikersTable.getColumns().add(puntenKolom);

        for (Gebruiker gebruiker : BetaBitApp.gebruikers) {
            gebruikersTable.getItems().add(gebruiker);
        }
    }
}