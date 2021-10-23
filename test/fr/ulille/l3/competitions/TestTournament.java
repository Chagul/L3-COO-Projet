package fr.ulille.l3.competitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

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
	protected Competition createCompetition() throws Exception {
		this.competitors.add(c1);
		this.competitors.add(c2);
		this.competitors.add(c3);
		this.competitors.add(c4);
		
		return new Tournament(this.competitors);
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
			new Tournament(competitorsNotPowerOf2);
		});
	}
	
	/**
	 * Test if the matches played at the end of the tournament is equals to the one expected
	 */
	@Test
	public void testRightCountOfMatch() {
		this.competition.play();
		int matchesPlayed = this.competition.getMatchesPlayed();
		int expectedNumberOfMatches = howManyMatchesExpected(competitors);
		assertEquals(expectedNumberOfMatches, matchesPlayed);
	}
	
	/**
	 * Calculate how many matches should be played in the tournament
	 * @param competitors The list of competitors at the beginning of the tournament
	 * @return The number of matches expected with the given list
	 */
	private int howManyMatchesExpected(List<Competitor> competitors) {
		return competitors.size()-1;
	}
	
}
