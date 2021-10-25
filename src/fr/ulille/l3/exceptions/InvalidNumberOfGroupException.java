package fr.ulille.l3.exceptions;

public class InvalidNumberOfGroupException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -439759910210055890L;
	
	public InvalidNumberOfGroupException() {
		super("The number of group does not permit to successfully create the groups.");
	}
}
