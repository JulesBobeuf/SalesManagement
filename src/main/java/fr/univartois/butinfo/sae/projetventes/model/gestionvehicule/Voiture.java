package fr.univartois.butinfo.sae.projetventes.model.gestionvehicule;

	/**
	 * Classe permettant d'instancier des voitures. Sous classe de véhicule.
	 * @author Jules
	 *
	 */
public class Voiture extends Vehicule {
	
	/**
	 * Attribut stockant le potentiel commercial qui possede cette voiture.
	 */
    private Commercial commercial;
    
    /**
     * Constructeur avec commercial
     * @param modele
     * @param immatriculation
     * @param marque
     * @param nbKm
     * @param anneeMiseEnCirculation
     * @param commercial
     */
    public Voiture(String marque, String immatriculation, String modele, double nbKm, int anneeMiseEnCirculation, Commercial commercial) {
		super(marque, immatriculation, modele, nbKm, anneeMiseEnCirculation);
		this.commercial=commercial;
	}
    public void setCommercial(Commercial commercial) {
		this.commercial = commercial;
	}
	/**
     * Constructeur sans commercial
     * @param modele
     * @param immatriculation
     * @param marque
     * @param nbKm
     * @param anneeMiseEnCirculation
     */
    public Voiture(String marque, String immatriculation, String modele, double nbKm, int anneeMiseEnCirculation) {
		super(marque, immatriculation, modele, nbKm, anneeMiseEnCirculation);
		this.commercial=null;
	}

    /**
     * Getter du commercial
     * @return commercial
     */
    public Commercial getCommercial() {
        return this.commercial;
    }
    
    /**
     * toString
     * @return String
     */
	public String toString() {
		String res = super.toString();
		if (commercial!=null) {
			return res + " Commercial : \n" + commercial.toString() + "\n";
		}
		return res;
	}

}
