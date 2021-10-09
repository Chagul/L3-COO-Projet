package fr.ulille.l3.competitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.fr.ulille.l3.competitions.Competition;
import main.java.fr.ulille.l3.competitions.CompetitionFactory;
import main.java.fr.ulille.l3.competitions.League;
import main.java.fr.ulille.l3.competitions.Tournament;
import main.java.fr.ulille.l3.exceptions.CompetitorsNumberNotPowerOf2Exception;
import main.java.fr.ulille.l3.exceptions.EmptyCompetitorsListException;
import main.java.fr.ulille.l3.exceptions.NoSuchTypeOfCompetitionException;
import main.java.fr.ulille.l3.modele.Competitor;

class TestCompetitionFactory {

	private CompetitionFactory factory;
	private Competitor c1;
	private Competitor c2;
	
	@BeforeEach
	public void init() {
		this.factory = new CompetitionFactory();
		this.c1 = new Competitor("c1");
		this.c2 = new Competitor("c2");
	}
	
	@Test
	void testCreateLeague() throws NullPointerException, EmptyCompetitorsListException, CompetitorsNumberNotPowerOf2Exception, NoSuchTypeOfCompetitionException {
		List<Competitor> competitors = new ArrayList<>();
		competitors.add(c1); competitors.add(c2);
		Competition league = factory.createCompetition("League", competitors);
		assertEquals(League.class, league.getClass());
	}

	@Test
	void testCreateTournament() throws NullPointerException, EmptyCompetitorsListException, CompetitorsNumberNotPowerOf2Exception, NoSuchTypeOfCompetitionException {
		List<Competitor> competitors = new ArrayList<>();
		competitors.add(c1); competitors.add(c2);
		Competition tournament = factory.createCompetition("Tournament", competitors);
		assertEquals(Tournament.class, tournament.getClass());
	}
	
	@Test
	void testThrowsNoSuchTypeOfCompetitionException() {
		List<Competitor> competitors = new ArrayList<>();
		competitors.add(c1); competitors.add(c2);
		assertThrows(NoSuchTypeOfCompetitionException.class, () -> {
			factory.createCompetition("Unknown", competitors);
		});
	}
}
