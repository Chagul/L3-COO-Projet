package test.java.fr.ulille.l3.competitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import main.java.fr.ulille.l3.competitions.Competition;
import main.java.fr.ulille.l3.competitions.League;
import main.java.fr.ulille.l3.modele.Competitor;

public class TestLeague extends TestCompetition {


	protected Competition createCompetition() throws Exception {
		this.competitors.add(c1);
		this.competitors.add(c2);
		this.competitors.add(c3);
		this.competitors.add(c4);
		this.competitors.add(c5);
		
		return new League(this.competitors);
	}
	
	@Test
	public void testRightCountOfMatches() {
		this.competition.play();
		int matchesPlayed = this.competition.getMatchesPlayed();
		int expectedNumberOfMatches = howManyMatchesExpected(competitors);
		assertEquals(expectedNumberOfMatches, matchesPlayed);
	}
	
	private int howManyMatchesExpected(List<Competitor> competitors) {
		int expectedMatches = 0;
		for(int i = 0; i < competitors.size(); i++) {
			expectedMatches += (competitors.size()-1)-i;
		}
		return expectedMatches*2;
	}
}
