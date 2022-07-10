package com.groep9D.BetabitApp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PuntengeschiedenisWeergevenController implements Initializable {

    @FXML
    private VBox content;

    @FXML
    protected void onTerugButtonClick() throws IOException {
        BetaBitApp.setScherm("beheerder/GebruikersWeergevenTabel.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Integer[] layoutEigenschappen = {25,25,250};
        content.getChildren().addAll(GrafiekFactory.grafiekAanmaken(layoutEigenschappen), GrafiekFactory.grafiekAanmaken(layoutEigenschappen).getNodes());
    }
}