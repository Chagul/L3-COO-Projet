package fr.ulille.l3.exceptions;

/**
 * Exception expressing the fact that the type of strategy we want to create does not exist.
 * @author Aurélien,Lucas
 */
public class NoSuchTypeOfStrategyException extends Exception {

	private static final long serialVersionUID = 3355438984674826483L;
	
	public NoSuchTypeOfStrategyException(String msg) {
		super(msg);
	}

}
