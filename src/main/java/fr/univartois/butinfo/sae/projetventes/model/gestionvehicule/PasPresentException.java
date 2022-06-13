package fr.univartois.butinfo.sae.projetventes.model.gestionvehicule;

/**
 * Classe qui crée une exception qui occure lorsqu'un objet n'est pas présent dans une liste.
 * @author Jules
 *
 */
public class PasPresentException extends Exception {

	private static final long serialVersionUID = 2L;
	
	/**
	 * Constructeur de l'exception
	 */
	public PasPresentException() {
		super("L'objet n'est pas présent dans la liste. ");
	}

}
