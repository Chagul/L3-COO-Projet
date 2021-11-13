package fr.ulille.l3.util;

public enum TypeOfCompetition {
	League("league"),Tournament("tournament"),Master("master");
	
	private final String label;

	private TypeOfCompetition(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}
}
