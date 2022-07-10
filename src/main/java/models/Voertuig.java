package models;

public class Voertuig {

    // Elektrische auto = 8         -> 0 gram per km p.p.
    // Autobus = 7                  -> 0 gram per km p.p.
    // Tram = 7                     -> 0 gram per km p.p.
    // Trein = 7                    -> 0 gram per km p.p.
    // Fiets = 9                    -> 0 gram per km p.p.
    // Elektrische fiets = 9        -> 0 gram per km p.p.
    // Lopen = 10                   -> 0 gram per km p.p.
    // Vliegtuig = 5                -> 90 gram per km p.p.
    // Diesel auto = 1              -> 153 gram per km p.p.
    // Benzine auto = 0             -> 190 gram per km p.p.
    public static final Brandstof brandstof = Brandstof.getBrandstof();

    private String vervoerNaam;
    private int punt;
    private String brandstofType;

    public String getVervoerNaam() {
        return vervoerNaam;
    }
    public int getPunt() {
        return punt;
    }
    public String getBrandstofType() {
        return brandstofType;
    }
    public void setVervoerNaam(String vervoerNaam) {
        this.vervoerNaam = vervoerNaam;
    }
    public void setBrandstofType(String brandstofType) {
        this.brandstofType = brandstofType;
    }
    public void setPunt(int punt) {
        this.punt = punt;
    }

}