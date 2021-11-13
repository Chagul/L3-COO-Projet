package fr.ulille.l3.exceptions;

/**
 * Exception expressing the fact that the type of match we want to create does not exist.
 * @author Aurélien,Lucas
 */
public class NoSuchTypeOfMatchException extends Exception {

	private static final long serialVersionUID = 7269254445709536989L;

	public NoSuchTypeOfMatchException(String msg) {
		super(msg);
	}
}
