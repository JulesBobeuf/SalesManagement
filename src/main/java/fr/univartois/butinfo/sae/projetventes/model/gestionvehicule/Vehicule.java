package fr.univartois.butinfo.sae.projetventes.model.gestionvehicule;

public abstract class Vehicule {
    private String modele;

    private String immatriculation;

    private String marque;

    private double nbKm;

    private int anneeMiseEnCirculation;

    public String getModele() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.modele;
    }

    public String getImmatriculation() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.immatriculation;
    }

    public String getMarque() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.marque;
    }

    public double getNbKm() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.nbKm;
    }

    public void setNbKm(double value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.nbKm = value;
    }

    public int getAnneeMiseEnCirculation() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.anneeMiseEnCirculation;
    }

    public Vehicule() {
    }

    public String toString() {
		return null;
    }

}
