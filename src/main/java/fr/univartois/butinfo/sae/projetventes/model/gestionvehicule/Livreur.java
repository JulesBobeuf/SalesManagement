package fr.univartois.butinfo.sae.projetventes.model.gestionvehicule;

/**
 * Classe permettant de créer un Livreur. sous classe de Conducteur.
 * @author Jules
 *
 */
public class Livreur extends Conducteur {
	
	/**
	 * Entier stockant le nombre d'heures de conduite effectué dans l'année
	 */
    private int nbHeures;
    
    /**
     * Constructeur
     * @param nom
     * @param prenom
     * @param numPermis
     * @param typePermis
     * @param nbHeures
     */
    public Livreur(String nom, String prenom, String numPermis, TypeDePermis typePermis, int nbHeures) {
    	super(nom,prenom,numPermis,typePermis);
    	this.nbHeures=nbHeures;
    }
    
    /**
     * Getter du nombre d'heures.
     * @return nbheures
     */
    public int getNbHeures() {
        return this.nbHeures;
    }
    
    /**
     * setter du nombre d'heures
     * @param value
     */
    public void setNbHeures(int value) {
        this.nbHeures = value;
    }
    
    /**
     * toString
     * @return String
     */
    public String toString() {
    	String res = super.toString();
    	return res + " nbHeures : " + this.nbHeures + "\n";
    }

}
