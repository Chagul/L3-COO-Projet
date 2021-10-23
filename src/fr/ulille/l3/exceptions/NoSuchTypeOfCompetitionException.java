package fr.ulille.l3.exceptions;

/**
 * Exception expressing the fact that the type of competition we want to create does not exist.  
 * @author Aurélien
 */
public class NoSuchTypeOfCompetitionException extends Exception {

	private static final long serialVersionUID = -1101013621017129223L;

	public NoSuchTypeOfCompetitionException(String msg) {
		super("This type of competition does not exist.");
	}
}
