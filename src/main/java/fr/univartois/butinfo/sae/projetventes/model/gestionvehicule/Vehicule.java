package fr.univartois.butinfo.sae.projetventes.model.gestionvehicule;

public abstract class Vehicule {
    private String modele;

    private String immatriculation;

    private String marque;

    private double nbKm;

    private final int anneeMiseEnCirculation;
    
    

    public Vehicule(String modele, String immatriculation, String marque, double nbKm, int anneeMiseEnCirculation) {
		this.modele = modele;
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.nbKm = nbKm;
		this.anneeMiseEnCirculation = anneeMiseEnCirculation;
	}

	public String getModele() {
        return this.modele;
    }

    public String getImmatriculation() {
        return this.immatriculation;
    }

    public String getMarque() {
        return this.marque;
    }

    public double getNbKm() {
        return this.nbKm;
    }

    public void setNbKm(double value) {
        this.nbKm = value;
    }

    public int getAnneeMiseEnCirculation() {
        return this.anneeMiseEnCirculation;
    }

    public String toString() {
		return "Marque : " + this.marque + "\n Modele : " + this.modele + "\n Plaque d'immatriculation : " + this.immatriculation + " \n Kilometrage : +" + this.nbKm + "\n Année de mise en circulation : " + this.anneeMiseEnCirculation + "\n";
    }

}
