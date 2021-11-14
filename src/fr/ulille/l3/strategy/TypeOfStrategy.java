package fr.ulille.l3.strategy;

public enum TypeOfStrategy {
	SelectionStrategyFirstOfEachGroup("premierChaqueGroupe","Le premier de chaque groupe est choisi"),SelectionStrategyBasicMaster("deuxMeilleur","Les deux premiers de chaque groupe sont choisis et les meilleurs troisièmes sur tout le reste sont choisis");
	
	private final String label;
	private final String description;

	private TypeOfStrategy(String label,String description) {
		this.label = label;
		this.description = description;
	}

	public String getLabel() {
		return this.label.toLowerCase();
	}

	public static boolean contains(String lowerCase) {
		for(int i = 0; i < values().length; i++) {
			if(lowerCase.equals(values()[i].getLabel())) {
				return true;
			}
		}
		return false;
	}

	public String getDescription() {
		return this.description;
	}
}
