package fr.ulille.l3.competitions;

/**
 * Enum that express all the type of competitions to control user input
 * @author Aurélien, Lucas
 *
 */
public enum TypeOfCompetition {
	League("league"),Tournament("tournament"),Master("master");
	
	private final String label;

	private TypeOfCompetition(String label) {
		this.label = label;
	}

	/**
	 * Returns the string attribute of the element
	 * @return the string associated to the element
	 */
	public String getLabel() {
		return this.label;
	}

	/**
	 * Control if the string passed in parameter corresponds to an element of this enum.
	 * @param lowerCase String that we want to control if it expresses a type of competition. This string must be completely in lower case.
	 * @return True if the type of competition exists otherwise false
	 */
	public static boolean contains(String lowerCase) {
		for(int i = 0; i < values().length; i++) {
			if(lowerCase.equals(values()[i].getLabel())) {
				return true;
			}
		}
		return false;
	}
}
