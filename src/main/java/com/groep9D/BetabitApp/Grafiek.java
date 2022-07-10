package com.groep9D.BetabitApp;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import models.IngevoerdeData;
import java.util.ArrayList;

public class Grafiek extends Parent {

    private  int xPositie;
    private  int yPositie;
    private  int grootte;
    private  ArrayList<Double> data;
    private  Color color;
    private final Pane nodes = new Pane();

    public  Grafiek(){ }
    public Grafiek(Grafiek grafiek, ArrayList<IngevoerdeData> data ) {
        this.xPositie = grafiek.xPositie;
        this.yPositie = grafiek.yPositie;
        this.grootte = grafiek.grootte;
        this.data = getValidData(data);
        this.color = grafiek.color;
        createBorders();
        createLines();
        createScale();
    }

    public void setGrootte(int grootte) {
        this.grootte = grootte;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public void setxPositie(int xPositie) {
        this.xPositie = xPositie;
    }
    public void setyPositie(int yPositie) {
        this.yPositie = yPositie;
    }

    private void createBorders() {
        for (int i = 0; i <= grootte; i += grootte / 10) {
            nodes.getChildren().add(new Line(xPositie, xPositie + i, grootte + xPositie, xPositie + i));
            nodes.getChildren().add(new Line(yPositie + i, yPositie, yPositie + i, grootte + yPositie));
        }
    }

    private void createLines() {
        for (int j = 0; j < data.size(); j++) {
            double currentX = xPositie + j * grootte / 10.0;
            double currentY = yPositie + grootte - data.get(j) * grootte / 10;
            nodes.getChildren().add(new Circle(currentX, currentY, grootte / 100.0, color));

            if (j > 0) {
                double previousX = xPositie + (j - 1) * grootte / 10.0;
                double previousY = yPositie + grootte - data.get(j - 1) * grootte / 10;
                Line line = new Line(previousX, previousY, currentX, currentY);
                line.setStrokeWidth(grootte / 120.0);
                line.setStroke(color);
                nodes.getChildren().add(line);
            }
        }
    }

    private void createScale() {
        Label label = new Label("0");
        label.setAlignment(Pos.CENTER);
        label.setMinWidth(12);
        label.setLayoutX(xPositie - 19);
        label.setLayoutY(yPositie + grootte);
        nodes.getChildren().add(label);

        for (int i = 1; i <= 10; i++) {
            Label labelX = new Label(String.valueOf(i));
            labelX.setAlignment(Pos.CENTER);
            labelX.setMinWidth(12);
            labelX.setLayoutX(xPositie + i * (grootte / 10.0) - 7);
            labelX.setLayoutY(yPositie + grootte + 3);
            nodes.getChildren().add(labelX);

            Label labelY = new Label(String.valueOf(11 - i));
            labelY.setAlignment(Pos.CENTER);
            labelY.setMinWidth(12);
            labelY.setLayoutX(xPositie - 22);
            labelY.setLayoutY(yPositie + (i - 1) * (grootte / 10.0) - 7);
            nodes.getChildren().add(labelY);
        }
    }

    private ArrayList<Double> getValidData(ArrayList<IngevoerdeData> data) {

        ArrayList<Double> tempData = new ArrayList<>();
        for (IngevoerdeData ingevoerdeData : data) {
            tempData.add(ingevoerdeData.getTotaalKm());
        }

        if (tempData.isEmpty()) {
            tempData = new ArrayList<>();
            for (int i = 0; i <= 10; i++) {
                tempData.add(0.0);
            }
        } else if (tempData.size() <= 10) {
            double laatsteWaarde = tempData.get(tempData.size() - 1);
            int size = tempData.size();
            for (int i = 0; i <= 10 - size; i++) {
                tempData.add(laatsteWaarde);
            }
        }

        return tempData;
    }

    public Pane getNodes() {
        return nodes;
    }
}