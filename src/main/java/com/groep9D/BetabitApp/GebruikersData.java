package com.groep9D.BetabitApp;

import models.Gebruiker;
import models.IngevoerdeData;
import models.Voertuig;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class GebruikersData {
    public static ArrayList<Gebruiker> initialiseer() {
        ArrayList<Gebruiker> tempGebruikers = new ArrayList<>();
        Scanner fileReader = null;
        try {
            fileReader = new Scanner(new File("data/gebruikers.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert fileReader != null;

        int aantalGebruikers = Integer.parseInt(fileReader.nextLine());
        for (int i = 0; i < aantalGebruikers; i++) {
            Gebruiker gebruiker = new Gebruiker(false);
            gebruiker.setNaam(fileReader.nextLine());
            gebruiker.setGebruikersnaam( fileReader.nextLine());
            gebruiker.setWachtwoord(fileReader.nextLine());
            gebruiker.setRole(fileReader.nextLine());
            gebruiker.setPunten(Integer.parseInt(fileReader.nextLine()));

            ArrayList<IngevoerdeData> tempIngevoerdeData = new ArrayList<>();
            int aantalIngevoerdeData = Integer.parseInt(fileReader.nextLine());
            for (int j = 0; j < aantalIngevoerdeData; j++) {
                int km = Integer.parseInt(fileReader.nextLine());
                Voertuig voertuig = new Voertuig();
                voertuig.setVervoerNaam(fileReader.nextLine());
                voertuig.setBrandstofType(fileReader.nextLine());
                voertuig.setPunt(Integer.parseInt(fileReader.nextLine()));
                IngevoerdeData ingevoerdeData = new IngevoerdeData(km,voertuig);
                tempIngevoerdeData.add(ingevoerdeData);
            }
            gebruiker.setIngevoerdeData(tempIngevoerdeData);
            tempGebruikers.add(gebruiker);
        }
        fileReader.close();
        return tempGebruikers;
    }


    public static void opslaan() {
        PrintWriter fileWriter = null;
        try {
            fileWriter = new PrintWriter("data/gebruikers.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert fileWriter != null;
        fileWriter.println(BetaBitApp.gebruikers.size());
        for (Gebruiker gebruiker : BetaBitApp.gebruikers) {
            fileWriter.println(gebruiker.getNaam());
            fileWriter.println(gebruiker.getGebruikersnaam());
            fileWriter.println(gebruiker.getWachtwoord());
            fileWriter.println(gebruiker.getRole());
            fileWriter.println(gebruiker.getPunten());
            fileWriter.println(gebruiker.getIngevoerdeData().size());
            for (IngevoerdeData ingevoerdeData : gebruiker.getIngevoerdeData()) {
                fileWriter.println((int)ingevoerdeData.getTotaalKm());
                fileWriter.println(ingevoerdeData.getVoertuig().getVervoerNaam());
                fileWriter.println(ingevoerdeData.getVoertuig().getBrandstofType());
                fileWriter.println(ingevoerdeData.getVoertuig().getPunt());
            }
        }
        fileWriter.close();
    }

}
