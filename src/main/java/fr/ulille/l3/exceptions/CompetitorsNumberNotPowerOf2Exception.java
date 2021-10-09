package main.java.fr.ulille.l3.exceptions;

/**
 * Exception expressing the fact that the number of competitors is not a power of 2 when creating a competition that requires it.
 * @author Aurélien, Lucas
 */
public class CompetitorsNumberNotPowerOf2Exception extends Exception {

	private static final long serialVersionUID = 8956628609972427534L;

	public CompetitorsNumberNotPowerOf2Exception() {
		super("The competitors number does not allowed for this type of competition (not a power of 2");
	}
}
