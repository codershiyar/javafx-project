package com.groep9D.BetabitApp;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Gebruiker;
import models.IngelogdeGebruiker;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RanglijstController implements Initializable {

    @FXML
    private TableView<Gebruiker> ranglijst;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nummeringTabel();
        TableColumn<Gebruiker, String> gebruikersnaamKolom = new TableColumn<>("Gebruikersnaam");
        gebruikersnaamKolom.setCellValueFactory(new PropertyValueFactory<>("Gebruikersnaam"));
        ranglijst.getColumns().add(gebruikersnaamKolom);
        TableColumn<Gebruiker, String> puntenKolom = new TableColumn<>("Punten");
        puntenKolom.setCellValueFactory(new PropertyValueFactory<>("Punten"));
        ranglijst.getColumns().add(puntenKolom);

        for (Gebruiker gebruiker : BetaBitApp.gebruikers) {
            ranglijst.getItems().add(gebruiker);
        }
        ranglijst.getSortOrder().add(puntenKolom);
    }

    private void nummeringTabel() {
        TableColumn<Gebruiker, Integer> indexColumn = new TableColumn<>("Top 15");
        indexColumn.setCellFactory(col -> {
            TableCell<Gebruiker, Integer> indexCell = new TableCell<>();
            ReadOnlyObjectProperty<TableRow<Gebruiker>> rowProperty = indexCell.tableRowProperty();
            ObjectBinding<String> rowBinding = Bindings.createObjectBinding(() -> {
                TableRow<Gebruiker> row = rowProperty.get();
                if (row != null) {
                    int rowIndex = row.getIndex() + 1;
                        return Integer.toString(rowIndex);
                }
                return null;
            }, rowProperty);
            indexCell.textProperty().bind(rowBinding);
            return indexCell;
        });
        ranglijst.getColumns().add(indexColumn);
    }

    @FXML
    protected void onTerugButtonClick() throws IOException {
        if (IngelogdeGebruiker.gebruiker.getRole().equals("Gebruiker")) {
            BetaBitApp.setScherm("gebruiker/GebruikersDashboard.fxml");
        }
        if (IngelogdeGebruiker.gebruiker.getRole().equals("Beheerder")) {
            BetaBitApp.setScherm("beheerder/BeheerderDashboard.fxml");
        }
    }

}