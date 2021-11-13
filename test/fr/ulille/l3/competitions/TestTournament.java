package fr.ulille.l3.competitions;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import fr.ulille.l3.exceptions.CannotCreateCompetitionException;
import fr.ulille.l3.exceptions.CompetitorsNumberNotPowerOf2Exception;
import fr.ulille.l3.modele.Competitor;

/**
 * Tests that concern a Tournament specifically 
 * @author Aurélien,Lucas
 *
 */
public class TestTournament extends TestCompetition {

	/**
	 * Create a Tournament with 4 competitors
	 */
	@Override
	protected Competition createCompetition() throws NullPointerException, CannotCreateCompetitionException {
		this.competitors.add(c1);
		this.competitors.add(c2);
		this.competitors.add(c3);
		this.competitors.add(c4);
		
		return new Tournament(this.competitors,displayer);
	}
	
	/**
	 * Test if the CompetitorsNumberNotPowerOf2Exception is raised at the creation of a tournament when there is a not modulo 2 number of competitor in the list
	 */
	@Test
	public void testCompetitorsNotPowerOf2Exception() {
		List<Competitor> competitorsNotPowerOf2 = new ArrayList<>();
		competitorsNotPowerOf2.add(c1);
		competitorsNotPowerOf2.add(c2);
		competitorsNotPowerOf2.add(c3);
		assertThrows(CompetitorsNumberNotPowerOf2Exception.class, () -> {
			new Tournament(competitorsNotPowerOf2,displayer);
		});
	}
	
	
	/**
	 * Calculate how many matches should be played in the tournament
	 * @param competitors The list of competitors at the beginning of the tournament
	 * @return The number of matches expected with the given list
	 */
	protected int howManyMatchesExpected(List<Competitor> competitors) {
		return competitors.size()-1;
	}
	
}
