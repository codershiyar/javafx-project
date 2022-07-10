package com.groep9D.BetabitApp;

import models.Voertuig;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class VoertuigenData {

    public static ArrayList<Voertuig> initialiseer() {
        ArrayList<Voertuig> tempVoertuig = new ArrayList<>();
        Scanner fileReader = null;
        try {
            fileReader = new Scanner(new File("data/voertuigen.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert fileReader != null;
        while (fileReader.hasNextLine()) {
            Voertuig initialiseerVoertuig = new Voertuig();
            initialiseerVoertuig.setVervoerNaam(fileReader.nextLine());
            initialiseerVoertuig.setBrandstofType(fileReader.nextLine());
            initialiseerVoertuig.setPunt(Integer.parseInt(fileReader.nextLine()));
            tempVoertuig.add(initialiseerVoertuig);
        }
        fileReader.close();
        return tempVoertuig;
    }


    public static void opslaan() {
        PrintWriter fileWriter = null;
        try {
            fileWriter = new PrintWriter("data/voertuigen.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert fileWriter != null;
        for (Voertuig voertuig : BetaBitApp.voertuigen) {
            fileWriter.println(voertuig.getVervoerNaam());
            fileWriter.println(voertuig.getBrandstofType());
            fileWriter.println(voertuig.getPunt());
        }
        fileWriter.close();
    }


}
