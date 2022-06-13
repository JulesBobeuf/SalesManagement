package fr.univartois.butinfo.sae.projetventes.model.gestionvehicule;

/**
 *Classe qui crée une Exception qui occure lorsqu'un objet est deja présent dans une liste.
 * @author Jules
 *
 */
public class DejaPresentException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructeur de l'exception
	 */
	public DejaPresentException() {
		super("L'objet est déjà présent dans la liste. ");
	}
	
	

}
