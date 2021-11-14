package fr.ulille.l3.match;


import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;

import fr.ulille.l3.modele.Competitor;

/**
 * Abstract class that assemble all the common behviour between matches
 * @author Aurélien, Plancke
 *
 */
public abstract class TestMatch {

	protected Competitor c1;
	protected Competitor c2;
	protected Match match1;
	
	/**
	 * Init a match with 2 competitors
	 */
	@BeforeEach
	void init() {
		c1 = new Competitor("Lucas");
		c2 = new Competitor("Aurélien");
		try {
			match1 = this.createMatch();
		} catch (Exception e) {
			fail();
		}
	}

	protected abstract Match createMatch() throws Exception;

}
