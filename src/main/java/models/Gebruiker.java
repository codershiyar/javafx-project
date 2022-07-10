package models;

import java.util.ArrayList;

public class Gebruiker {

    private ArrayList<IngevoerdeData> ingevoerdeData = new ArrayList<>();
    private String naam;
    private String gebruikersnaam;
    private String wachtwoord;
    private String role;
    private int punten;

    public Gebruiker(boolean newGebruiker) {
        if(newGebruiker){ punten = 0;  }
    }

    public ArrayList<IngevoerdeData> getIngevoerdeData() {
        return ingevoerdeData;
    }

    public void setIngevoerdeData(ArrayList<IngevoerdeData> ingevoerdeData) {
        this.ingevoerdeData = ingevoerdeData;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getPunten() {
        return punten;
    }

    public void setPunten(int punten) {
        this.punten = punten;
    }
}
