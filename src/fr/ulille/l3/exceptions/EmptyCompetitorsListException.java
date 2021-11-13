package fr.ulille.l3.exceptions;

/**
 * Exception expressing the fact that a competition is created with an empty list of competitors.
 * @author Aurélien, Lucas
 */
public class EmptyCompetitorsListException extends CannotCreateCompetitionException {

	private static final long serialVersionUID = -1533203553742898058L;

	public EmptyCompetitorsListException() {
		super("The list of competitors is empty.");
	}
}
