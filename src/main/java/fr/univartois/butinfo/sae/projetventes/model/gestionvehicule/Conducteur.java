package fr.univartois.butinfo.sae.projetventes.model.gestionvehicule;

import java.util.Objects;

public abstract class Conducteur {
    private String nom;

    private String prenom;

    private String numPermis;

    private TypeDePermis typePermis;

    
    public Conducteur(String nom, String prenom, String numPermis, TypeDePermis typePermis) {
    	this.nom=nom;
    	this.prenom=prenom;
    	this.numPermis=numPermis;
    	this.typePermis=typePermis;
    }
    
    
    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public String getNumPermis() {
        return this.numPermis;
    }

    public TypeDePermis getTypePermis() {
        return this.typePermis;
    }

    public void setTypePermis(TypeDePermis value) {
        this.typePermis = value;
    }
    
    

    @Override
	public int hashCode() {
		return Objects.hash(nom, prenom);
	}


	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Conducteur)) {
			return false;
		}
		Conducteur other = (Conducteur) obj;
		return Objects.equals(nom, other.nom) && Objects.equals(prenom, other.prenom);
	}


	public String toString() {
    	return "Nom : " + this.nom + "\n Prenom : " + this.prenom + "\n Numéro de permis :" + this.numPermis + "\n Type de permis : " + this.typePermis + "\n";
    }

}
