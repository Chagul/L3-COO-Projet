package fr.ulille.l3.competitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import main.java.fr.ulille.l3.competitions.Competition;
import main.java.fr.ulille.l3.competitions.League;
import main.java.fr.ulille.l3.modele.Competitor;

/**
 * Tests that concern a league specifically 
 * @author Aurélien, Lucas
 *
 */
public class TestLeague extends TestCompetition {


	/**
	 * Create a league with 5 competitors
	 */
	protected Competition createCompetition() throws Exception {
		this.competitors.add(c1);
		this.competitors.add(c2);
		this.competitors.add(c3);
		this.competitors.add(c4);
		this.competitors.add(c5);
		
		return new League(this.competitors);
	}
	
	/**
	 * Test if all the matches are played.
	 */
	@Test
	public void testRightCountOfMatches() {
		this.competition.play();
		int matchesPlayed = this.competition.getMatchesPlayed();
		int expectedNumberOfMatches = howManyMatchesExpected(competitors);
		assertEquals(expectedNumberOfMatches, matchesPlayed);
	}
	
	/**
	 * Allow to calculate how many matches should be played.
	 * @param competitors The list of competitors in this league
	 * @return The number of matches that need to be played with the given number of competitors
	 */
	private int howManyMatchesExpected(List<Competitor> competitors) {
		int expectedMatches = 0;
		for(int i = 0; i < competitors.size(); i++) {
			expectedMatches += (competitors.size()-1)-i;
		}
		return expectedMatches*2;
	}
}
