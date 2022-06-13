package fr.univartois.butinfo.sae.projetventes.model.gestionvehicule;

public class Commercial extends Conducteur {
    private int nbVisites;
    
    public Commercial(String n, String p, String num, TypeDePermis type, int nbVisites) {
    	super(n,p,num,type);
    	this.nbVisites=nbVisites;
    }

    public int getNbVisites() {
        return this.nbVisites;
    }

    public void setNbVisites(int value) {
        this.nbVisites = value;
    }

    public String toString() {
    	String res = super.toString();
    	return res + "nbVisites :" + this.nbVisites + "\n";
    }

}
