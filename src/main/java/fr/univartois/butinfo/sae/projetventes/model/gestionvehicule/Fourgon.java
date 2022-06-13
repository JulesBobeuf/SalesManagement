package fr.univartois.butinfo.sae.projetventes.model.gestionvehicule;

/**
 * Classe permettant de créer des Fourgons, sous classe de Vehicule
 * @author Jules
 *
 */
public class Fourgon extends Vehicule {
	
	/**
	 * double contenant le poids maximal d'un fourgon
	 */
    private double poidsMax;
    
	/**
	 * double contenant le volume maximal d'un fourgon
	 */
    private double volumeMax;
    
	/**
	 * Attribut contenant les informations du livreur qui possede ce fourgon.
	 */
    private Livreur livreur;
    
    /**
     * Constructeur avec Livreur
     * @param modele
     * @param immatriculation
     * @param marque
     * @param nbKm
     * @param anneeMiseEnCirculation
     * @param poidsMax
     * @param volumeMax
     * @param livreur
     */
    public Fourgon(String modele, String immatriculation, String marque, double nbKm, int anneeMiseEnCirculation, double poidsMax, double volumeMax, Livreur livreur) {
		super(modele, immatriculation, marque, nbKm, anneeMiseEnCirculation);
		this.poidsMax = poidsMax;
		this.volumeMax=volumeMax;
		this.livreur = livreur;
		
	}
    /**
     * Constructeur sans Livreur
     * @param modele
     * @param immatriculation
     * @param marque
     * @param nbKm
     * @param anneeMiseEnCirculation
     * @param poidsMax
     * @param volumeMax
     */
    public Fourgon(String modele, String immatriculation, String marque, double nbKm, int anneeMiseEnCirculation, double poidsMax, double volumeMax) {
		super(modele, immatriculation, marque, nbKm, anneeMiseEnCirculation);
		this.poidsMax = poidsMax;
		this.volumeMax=volumeMax;
		this.livreur = null;
		
	}

    /**
     * getter pour le Livreur
     * @return livreur
     */
    public Livreur getLivreur() {
        return this.livreur;
    }

	/**
	 * Setter pour le livreur
	 * @param value
	 */
    public void setLivreur(Livreur value) {
        this.livreur = value;
    }
    /**
     * Getter du poids maximal
     * @return poidsMax
     */
    public double getPoidsMax() {
        return this.poidsMax;
    }
    
    /**
     * getter du volume maximal du fourgon
     * @return volumeMax
     */
    public double getVolumeMax() {
        return this.volumeMax;
    }
    
    /**
     * toString
     * @return String
     */
	public String toString() {
		String res = super.toString();
		if (livreur!=null) {
			return res + " Poids max : " + this.poidsMax + "\n Volume max : " + this.volumeMax + "\n Livreur : \n" + livreur.toString() + "\n";
		}
		return res;
    }

}
