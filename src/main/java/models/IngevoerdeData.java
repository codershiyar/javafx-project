package models;

public class IngevoerdeData {

    private int totaalKm;
    private Voertuig voertuig;

    public IngevoerdeData(int totaalKm, Voertuig voertuig) {
        this.totaalKm = totaalKm;
        this.voertuig = voertuig;
    }

    public double getTotaalKm() {
        return totaalKm;
    }

    public Voertuig getVoertuig() {
        return voertuig;
    }
}