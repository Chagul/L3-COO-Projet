package fr.ulille.l3.strategy;

/**
 * Enum that express all the type of strategies to control master creation
 * @author Aurélien, Lucas
 *
 */
public enum TypeOfStrategy {
	SelectionStrategyFirstOfEachGroup("premierChaqueGroupe","Le premier de chaque groupe est choisi"),SelectionStrategyBasicMaster("deuxMeilleur","Les deux premiers de chaque groupe sont choisis et les meilleurs troisièmes sur tout le reste sont choisis");
	
	private final String label;
	private final String description;

	private TypeOfStrategy(String label,String description) {
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
	 * @param lowerCase String that we want to control if it expresses a type of strategy. This string must be completely in lower case.
	 * @return True if the type of strategy exists otherwise false
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
