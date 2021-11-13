package fr.ulille.l3.exceptions;

public class InvalidNumberOfGroupException extends CannotCreateCompetitionException {

	/**
	 * Exception expressing the fact that the number of groups specified to create the master isn't valid and doesn't permit to divide the competitors in equal groups.
	 */
	private static final long serialVersionUID = -439759910210055890L;
	
	public InvalidNumberOfGroupException() {
		super("The number of group does not permit to successfully create the groups.");
	}
}
