package fr.ulille.l3.match;

/**
 * Enum that express all the type of matches to control match creation
 * @author Aurélien, Lucas
 *
 */
public enum TypeOfMatch {
	BasicMatch("BasicMatch","Un match basique, le vainqueur est déterminé aléatoirement");
	
	private final String label;
	private final String description;

	private TypeOfMatch(String label,String description) {
		this.label = label;
		this.description = description;
	}

	/**
	 * Returns the label string attribute of the element
	 * @return the label associated to the element
	 */
	public String getLabel() {
		return this.label.toLowerCase();
	}

	/**
	 * Control if the string passed in parameter corresponds to an element of this enum.
	 * @param lowerCase String that we want to control if it expresses a type of match. This string must be completely in lower case.
	 * @return True if the type of match exists otherwise false
	 */
	public static boolean contains(String lowerCase) {
		for(int i = 0; i < values().length; i++) {
			if(lowerCase.equals(values()[i].getLabel())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the description string attribute of the element
	 * @return the description associated to the element
	 */
	public String getDescription() {
		return this.description;
	}
}
