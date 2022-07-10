package models;

public class Brandstof {
    private final String[] types = {"Elektrische","Benzine", "Diesel","Handmatig","Kerosine"};
    private static Brandstof brandstof = new Brandstof();

  // deze klasse kan niet worden geïnstantieerd
    private Brandstof(){ }

    public static Brandstof getBrandstof(){ return brandstof; }

    public String[] getTypes() { return types;}

}
