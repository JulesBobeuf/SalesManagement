package fr.univartois.butinfo.sae.projetventes.model.gestionvehicule;

import java.util.Objects;

/**
 * Classe abstraite Vehicule. Celle-ci possède deux sous classes : Fourgon et Voiture
 * @author Jules
 *
 */
public abstract class Vehicule {
	
	/**
	 * String contenant le modèle du véhicule.
	 */
    private String modele;
    
	/**
	 * String contenant la plaque d'immatriculation du véhicule.
	 */
    private String immatriculation;
    
    /**
     * String contenant la marque du véhicule.
     */
    private String marque;
    
    /**
     * double contenant le kilométrage du véhicule.
     */
    private double nbKm;

    /**
     * Entier contenant l'année de mise en circulation du véhicule.
     */
    private int anneeMiseEnCirculation;
    
    
    /**
     * Constructeur d'un véhicule.
     * @param modele
     * @param immatriculation
     * @param marque
     * @param nbKm
     * @param anneeMiseEnCirculation
     */
    public Vehicule(String marque, String immatriculation, String modele, double nbKm, int anneeMiseEnCirculation) {
		this.modele = modele;
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.nbKm = nbKm;
		this.anneeMiseEnCirculation = anneeMiseEnCirculation;
	}
    /**
     * Getter pour le modele du véhicule
     * @return modele
     */
	public String getModele() {
        return this.modele;
    }
	
	/**
	 * Getteur pour la plaque d'immatriculation du véhicule
	 * @return immatriculation
	 */
    public String getImmatriculation() {
        return this.immatriculation;
    }

    /**
     * Getter pour la marque du véhicule
     * @return marque
     */
    public String getMarque() {
        return this.marque;
    }
    
    public void setAnneeMiseEnCirculation(int anneeC) {
    	this.anneeMiseEnCirculation=anneeC;
    }
	
    /**
     * Getteur pour le kilométrage du véhicule
     * @return nbKm
     */
    public double getNbKm() {
        return this.nbKm;
    }
    
    /**
     * setter pour le modele
     * @param modele
     */
    public void setModele(String modele) {
		this.modele = modele;
	}
    
    /**
     * setter pour la plaque d'immatriculation
     * @param immatriculation
     */
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	/**
	 * setter pour la marque
	 * @param marque
	 */
	public void setMarque(String marque) {
		this.marque = marque;
	}
	/**
     * Setter pour le kilométrage du véhicule
     * @param value
     */
    public void setNbKm(double value) {
        this.nbKm = value;
    }

	/**
	 * Getter pour l'année de mise en circulation.
	 * @return
	 */
    public int getAnneeMiseEnCirculation() {
        return this.anneeMiseEnCirculation;
    }
    
    /**
     * Equals, comparaison de deux véhicules
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Vehicule)) {
			return false;
		}
		Vehicule other = (Vehicule) obj;
		return Objects.equals(immatriculation, other.immatriculation);
	}
	
	/**
	 * Retourne un String contenant les informations d'un véhicule.
	 * @return String
	 */
	public String toString() {
		return "Marque : " + this.marque + "\n Modele : " + this.modele + "\n Plaque d'immatriculation : " + this.immatriculation + " \n Kilometrage : " + this.nbKm + "\n Année de mise en circulation : " + this.anneeMiseEnCirculation + "\n";
    }

}
