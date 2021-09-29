package test.java.fr.ulille.l3.competitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.fr.ulille.l3.match.BasicMatch;
import main.java.fr.ulille.l3.match.Match;
import main.java.fr.ulille.l3.modele.Competitor;

public abstract class TestMatch {

	protected Competitor c1;
	protected Competitor c2;
	protected Match match1;
	
	@BeforeEach
	void init() {
		c1 = new Competitor("Lucas");
		c2 = new Competitor("Aurélien");
		match1 = new BasicMatch(c1,c2);
	}


}
