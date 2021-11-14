package fr.ulille.l3.competitions;

public enum TypeOfCompetition {
	League("league"),Tournament("tournament"),Master("master");
	
	private final String label;

	private TypeOfCompetition(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}

	public static boolean contains(String lowerCase) {
		for(int i = 0; i < values().length; i++) {
			if(lowerCase.equals(values()[i].getLabel())) {
				return true;
			}
		}
		return false;
	}
}
