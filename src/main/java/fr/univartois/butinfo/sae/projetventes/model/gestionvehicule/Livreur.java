package fr.univartois.butinfo.sae.projetventes.model.gestionvehicule;


public class Livreur extends Conducteur {
	
    private int nbHeures;
    
    public Livreur(String nom, String prenom, String numPermis, TypeDePermis typePermis, int nbHeures) {
    	super(nom,prenom,numPermis,typePermis);
    	this.nbHeures=nbHeures;
    }

    public int getNbHeures() {
        return this.nbHeures;
    }

    public void setNbHeures(int value) {
        this.nbHeures = value;
    }

    public String toString() {
    	String res = super.toString();
    	return res + "nbHeures : " + this.nbHeures + "\n";
    }

}
