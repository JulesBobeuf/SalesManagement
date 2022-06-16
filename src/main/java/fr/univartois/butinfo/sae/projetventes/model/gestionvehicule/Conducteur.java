package fr.univartois.butinfo.sae.projetventes.model.gestionvehicule;

import java.util.Objects;

/**
 * Classe abstraite qui possède deux sous classes : Commercial et Livreur.
 * @author Jules
 *
 */
public abstract class Conducteur {
	/**
	 * Attribut contenant le nom du conducteur.
	 */
    private String nom;

	/**
	 * Attribut contenant le prénom du conducteur.
	 */
    private String prenom;
    
	/**
	 * Attribut contenant le numéro de permis du conducteur.
	 */
    private String numPermis;
    
	/**
	 * Attribut contenant le type de permis du conducteur.
	 */

    private TypeDePermis typePermis;

    /**
     * Constructeur de Conducteur
     * @param nom
     * @param prenom
     * @param numPermis
     * @param typePermis
     */
    public Conducteur(String nom, String prenom, String numPermis, TypeDePermis typePermis) {
    	this.nom=nom;
    	this.prenom=prenom;
    	this.numPermis=numPermis;
    	this.typePermis=typePermis;
    }
    
    /**
     * Setter pour le nom
     * @param nom
     */
    public void setNom(String nom) {
		this.nom = nom;
	}

    /**
     * Setter pour le prénom
     * @param prenom
     */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Setter du numéro de permis
	 * @param numPermis
	 */
	public void setNumPermis(String numPermis) {
		this.numPermis = numPermis;
	}


	/**
     * Getter pour le nom
     * @return nom
     */
    public String getNom() {
        return this.nom;
    }
    
    /**
     * Getter pour le prénom
     * @return prenom
     */
    public String getPrenom() {
        return this.prenom;
    }
    
    /**
     * Getter du numéro de permis
     * @return numPermis
     */
    public String getNumPermis() {
        return this.numPermis;
    }
    
    /**
     * Getter du type de permis
     * @return typePermis
     */
    public TypeDePermis getTypePermis() {
        return this.typePermis;
    }
    
    /**
     * Setter du type de permis
     * @param value
     */
    public void setTypePermis(TypeDePermis value) {
        this.typePermis = value;
    }
    
    /**
     * Equals
     * @param obj
     */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Conducteur)) {
			return false;
		}
		Conducteur other = (Conducteur) obj;
		return Objects.equals(nom, other.nom) && Objects.equals(prenom, other.prenom);
	}

	/**
	 * toString
	 * @return String
	 */
	public String toString() {
    	return "Nom : " + this.nom + "\n Prenom : " + this.prenom + "\n Numéro de permis : " + this.numPermis + "\n Type de permis : " + this.typePermis + "\n";
    }

}
