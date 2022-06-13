package fr.univartois.butinfo.sae.projetventes.model.gestionvehicule;

/**
 * Classe créant un conducteur de type Commercial.
 * @author Jules
 *
 */
public class Commercial extends Conducteur {
	/**
	 * Int contenant le nombre de visite effectué dans l'année.
	 */
    private int nbVisites;
    
    /**
     * Constructeur 
     * @param n
     * @param p
     * @param num
     * @param type
     * @param nbVisites
     */
    public Commercial(String n, String p, String num, TypeDePermis type, int nbVisites) {
    	super(n,p,num,type);
    	this.nbVisites=nbVisites;
    }
    /**
     * Getter renvoyant le nombre de visite
     * @return nbVisites
     */
    public int getNbVisites() {
        return this.nbVisites;
    }
    /**
     * Setter modifiant le nombre de visite
     * @param value
     */
    public void setNbVisites(int value) {
        this.nbVisites = value;
    }
    /**
     * méthode qui renvoie sous forme de string toutes les informations du Commercial.
     * @return String.
     */
    public String toString() {
    	String res = super.toString();
    	return res + " nbVisites : " + this.nbVisites + "\n";
    }

}
