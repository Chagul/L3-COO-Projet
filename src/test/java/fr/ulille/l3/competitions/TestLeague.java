package test.java.fr.ulille.l3.competitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.java.fr.ulille.l3.competitions.Competition;
import main.java.fr.ulille.l3.competitions.League;

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
		int expectedNumberOfMatches = this.competitors.size()*4;
		assertEquals(expectedNumberOfMatches, matchesPlayed);
	}
}
