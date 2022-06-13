package fr.univartois.butinfo.sae.projetventes.model.gestionvehicule;

public class Voiture extends Vehicule {
    private Commercial commercial;


    public Voiture(String modele, String immatriculation, String marque, double nbKm, int anneeMiseEnCirculation, Commercial commercial) {
		super(modele, immatriculation, marque, nbKm, anneeMiseEnCirculation);
		this.commercial=commercial;
	}
    
    public Voiture(String modele, String immatriculation, String marque, double nbKm, int anneeMiseEnCirculation) {
		super(modele, immatriculation, marque, nbKm, anneeMiseEnCirculation);
		this.commercial=null;
	}

    public Commercial getCommercial() {
        return this.commercial;
    }

	public String toString() {
		String res = super.toString();
		return res + "Commercial : " + commercial.toString() + "\n";
	}

}
