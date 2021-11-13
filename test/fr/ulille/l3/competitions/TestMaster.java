package fr.ulille.l3.competitions;

import java.util.List;

import org.junit.jupiter.api.Test;

import fr.ulille.l3.modele.Competitor;

class TestMaster extends TestCompetition {
	
	protected Competitor c6;
	protected Competitor c7;
	protected Competitor c8;
	protected Competitor c9;


	@Override
	protected Competition createCompetition() throws Exception {
		c6 = new Competitor("Ambre");
		c7 = new Competitor("Axel");
		c8 = new Competitor("Bastien");
		c9 = new Competitor("Anaïs");
		
		this.competitors.add(c1);
		this.competitors.add(c2);
		this.competitors.add(c3);
		this.competitors.add(c4);
		this.competitors.add(c5);
		this.competitors.add(c6);
		this.competitors.add(c7);
		this.competitors.add(c8);
		this.competitors.add(c9);
		return new Master(this.competitors, new SelectionStrategyBasicMaster(), 3,displayer);
	}
	
	@Override
	protected int howManyMatchesExpected(List<Competitor> competitors) {
		int expectedMatches = 0;
		for(int i = 0; i < competitors.size(); i++) {
			expectedMatches += (competitors.size()-1)-i;
		}
		expectedMatches = expectedMatches * 2;
		expectedMatches += 5;
		return expectedMatches;
	}
	
	
	@Test
	public void testRightNumberOfGroups() {
		
	}
	
	@Test
	public void testRightNumberOfCompetitorsInFinalStage() {
		
	}
	
	@Test
	public void testThrowsInvalidNumberOfGroupException() {
		
	}

	

}
