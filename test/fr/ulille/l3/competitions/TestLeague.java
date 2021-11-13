package fr.ulille.l3.competitions;

import java.util.List;

import fr.ulille.l3.modele.Competitor;

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
		
		return new League(this.competitors,displayer);
	}
	
	
	/**
	 * Allow to calculate how many matches should be played.
	 * @param competitors The list of competitors in this league
	 * @return The number of matches that need to be played with the given number of competitors
	 */
	protected int howManyMatchesExpected(List<Competitor> competitors) {
		int expectedMatches = 0;
		for(int i = 0; i < competitors.size(); i++) {
			expectedMatches += (competitors.size()-1)-i;
		}
		return expectedMatches*2;
	}
}
