package test.java.fr.ulille.l3.competitions;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.fr.ulille.l3.competitions.Competition;
import main.java.fr.ulille.l3.competitions.League;
import main.java.fr.ulille.l3.competitions.Tournament;
import main.java.fr.ulille.l3.excpetions.EmptyCompetitorsListException;
import main.java.fr.ulille.l3.modele.Competitor;

public abstract class TestCompetition {

	protected List<Competitor> competitors = new ArrayList<Competitor>();
	protected Competition competition;
	protected Competitor c1;
	protected Competitor c2;
	protected Competitor c3;
	protected Competitor c4;
	protected Competitor c5;
	protected Competitor c6;

	@BeforeEach
	public void init() {
		c1 = new Competitor("Aurélien");
		c2 = new Competitor("Lucas");
		c3 = new Competitor("Hugo");
		c4 = new Competitor("Antoine");
		c5 = new Competitor("Corentin");
		try {
			this.competition = this.createCompetition();
		}
		catch (Exception e) {
			fail();
		}
	}

	protected abstract Competition createCompetition() throws Exception;

	@Test
	public void testNullPointerException() {
		assertThrows(NullPointerException.class, () -> {
			new League(null);
		});
		assertThrows(NullPointerException.class, () -> {
			new Tournament(null);
		});
	}

	@Test
	public void testEmptyListOfCompetitors() {
		assertThrows(EmptyCompetitorsListException.class, () -> {
			new League(new ArrayList<Competitor>());
		});
		assertThrows(EmptyCompetitorsListException.class, () -> {
			new Tournament(new ArrayList<Competitor>());
		});
	}
	
}