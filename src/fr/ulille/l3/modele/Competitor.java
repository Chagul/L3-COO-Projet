package fr.ulille.l3.modele;

import java.util.Objects;

/** Class that describe a competitor, for now, it's just a name.
 * @author Aurélien, Lucas
 */
public class Competitor {
	
	protected String name;
	protected static int cptIdCompetitor = 0;
	protected final int idCompetitor;
	
	public Competitor(String name) {
		this.name = name;
		idCompetitor = ++cptIdCompetitor;
		
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCompetitor, name);
	}

	/**
	 * Check if two competitors are equals
	 * @return True if the references of the two competitors are the same, or if they have the same name, return False if the competitor point to null, or if it's not a competitor
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Competitor other = (Competitor) obj;
		return idCompetitor == other.idCompetitor && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return name + " with id " + idCompetitor + " ";
	}


	
}
