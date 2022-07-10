import com.groep9D.BetabitApp.InlogpaginaController;
import models.Gebruiker;
import org.junit.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AcceptatieCriteriaTests {

    @Test
    public void ongeldigeInvoerInloggenTest() {
        ArrayList<Gebruiker> testGebruikers = new ArrayList<>();
        Gebruiker testGebruiker = new Gebruiker(true);
        testGebruiker.setGebruikersnaam("testGebruikersnaam");
        testGebruiker.setWachtwoord("testWachtwoord");
        testGebruikers.add(testGebruiker);

        Gebruiker ingevoerdeGebruiker = new Gebruiker(true);
        ingevoerdeGebruiker.setGebruikersnaam("testGebruikersnaam");
        ingevoerdeGebruiker.setWachtwoord("testWachtwoord");

        assertEquals(0, InlogpaginaController.checkInloggegevens(testGebruikers, ingevoerdeGebruiker));
    }

    @Test
    public void geldigeInvoerInloggenTest() {
        ArrayList<Gebruiker> testGebruikers = new ArrayList<>();
        Gebruiker testGebruiker = new Gebruiker(true);
        testGebruiker.setGebruikersnaam("testGebruikersnaam");
        testGebruiker.setWachtwoord("testWachtwoord");
        testGebruikers.add(testGebruiker);

        Gebruiker ingevoerdeGebruiker = new Gebruiker(true);
        ingevoerdeGebruiker.setGebruikersnaam("testGebruikersnaam");
        ingevoerdeGebruiker.setWachtwoord("wachtwoord");

        assertEquals(-1, InlogpaginaController.checkInloggegevens(testGebruikers, ingevoerdeGebruiker));
    }
}
