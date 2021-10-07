package main.java.fr.ulille.l3.exceptions;

public class EmptyCompetitorsListException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1533203553742898058L;

	public EmptyCompetitorsListException() {
		super("La liste est vide");
	}
}
