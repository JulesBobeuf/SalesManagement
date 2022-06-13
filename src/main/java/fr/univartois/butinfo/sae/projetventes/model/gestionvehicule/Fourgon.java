package fr.univartois.butinfo.sae.projetventes.model.gestionvehicule;

public class Fourgon extends Vehicule {
    private double poidsMax;

    private double volumeMax;

    private Livreur livreur;
    
    public Fourgon(String modele, String immatriculation, String marque, double nbKm, int anneeMiseEnCirculation, double poidsMax, double volumeMax, Livreur livreur) {
		super(modele, immatriculation, marque, nbKm, anneeMiseEnCirculation);
		this.poidsMax = poidsMax;
		this.volumeMax=volumeMax;
		this.livreur = livreur;
		
	}
    
    public Fourgon(String modele, String immatriculation, String marque, double nbKm, int anneeMiseEnCirculation, double poidsMax, double volumeMax) {
		super(modele, immatriculation, marque, nbKm, anneeMiseEnCirculation);
		this.poidsMax = poidsMax;
		this.volumeMax=volumeMax;
		this.livreur = null;
		
	}

    public Livreur getLivreur() {
        return this.livreur;
    }

    public void setLivreur(Livreur value) {
        this.livreur = value;
    }

    public double getPoidsMax() {
        return this.poidsMax;
    }

    public double getVolumeMax() {
        return this.volumeMax;
    }

	public String toString() {
		String res = super.toString();
		return res + "Poids max : " + this.poidsMax + "\n Volume max : " + this.volumeMax + "\n + livreur :" + livreur.toString() + "\n";
    }

}
