package fr.ulille.l3.exceptions;

public abstract class CannotCreateCompetitionException extends Exception {

	/**
	 * Exception expressing the fact that a competition can't be created with the given parameters.
	 */
	private static final long serialVersionUID = -6370557684113308408L;
	
	public CannotCreateCompetitionException(String message) {
		super("This given competition can't be created with the selected parameters.\n" + message);
	}
	
}
