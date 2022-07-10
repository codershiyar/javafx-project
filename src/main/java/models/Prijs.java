package models;

import javafx.scene.image.Image;

public class Prijs {

    public String naam;
    public Image image;
    public String omschrijving;
    public int aantalPunten;

    public Prijs(String naam, Image image, String omschrijving, int aantalPunten) {
        this.naam = naam;
        this.image = image;
        this.omschrijving = omschrijving;
        this.aantalPunten = aantalPunten;
    }

    public String getNaam() {
        return naam;
    }

    public Image getImage() {
        return image;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public int getAantalPunten() {
        return aantalPunten;
    }
}
