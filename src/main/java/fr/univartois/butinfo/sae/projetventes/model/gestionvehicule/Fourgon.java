package fr.univartois.butinfo.sae.projetventes.model.gestionvehicule;

public class Fourgon extends Vehicule {
    private double poidsMax;

    private double volumeMax;

    private Livreur livreurs;

    public Livreur getLivreurs() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.livreurs;
    }

    public void setLivreurs(Livreur value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.livreurs = value;
    }

    public double getPoidsMax() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.poidsMax;
    }

    public double getVolumeMax() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.volumeMax;
    }

    public Fourgon() {
    }

    public String toString() {
		return null;
    }

}
