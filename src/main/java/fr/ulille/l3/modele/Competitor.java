package main.java.fr.ulille.l3.modele;

import java.util.Objects;

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
