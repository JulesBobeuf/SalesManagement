package fr.univartois.butinfo.sae.projetventes.model.gestionvehicule;

public abstract class Conducteur {
    private String nom;

    private String prenom;

    private String numPermis;

    private TypeDePermis typePermis;

    public String getNom() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.nom;
    }

    public String getPrenom() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.prenom;
    }

    public String getNumPermis() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.numPermis;
    }

    public TypeDePermis getTypePermis() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.typePermis;
    }

    public void setTypePermis(TypeDePermis value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.typePermis = value;
    }
    public boolean equals(Object o) {
		return false;
    }

    public Conducteur() {
    }
    public String toString() {
    return null;
    }

}
