package com.groep9D.BetabitApp;

import javafx.scene.image.Image;
import models.Prijs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PrijzenData {
    public static ArrayList<Prijs> initialiseer() {
        ArrayList<Prijs> tempPrijs = new ArrayList<>();
        Scanner fileReader = null;
        try {
            fileReader = new Scanner(new File("data/prijzen.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert fileReader != null;
        while (fileReader.hasNextLine()) {
            tempPrijs.add(new Prijs(fileReader.nextLine(), new Image(fileReader.nextLine()), fileReader.nextLine(), Integer.parseInt(fileReader.nextLine())));
        }
        fileReader.close();
        return tempPrijs;
    }
}
