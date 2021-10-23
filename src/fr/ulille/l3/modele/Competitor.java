package fr.ulille.l3.modele;

import java.util.Objects;

/** Class that describe a competitor, for now, it's just a name.
 * @author Aurélien, Lucas
 */
public class Competitor {
	
	protected String name;
	
	public Competitor(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	/**
	 * Check if two competitors are equals
	 * @return True if the references of the two competitors are the same, or if they have the same name.
	 * @return False if the competitor point to null, or if it's not a competitor
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
		return Objects.equals(name, other.name);
	}
	
}
