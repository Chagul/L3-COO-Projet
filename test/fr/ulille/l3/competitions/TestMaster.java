package fr.ulille.l3.competitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import fr.ulille.l3.modele.Competitor;

class TestMaster extends TestCompetition {
	
	protected Competitor c6;
	protected Competitor c7;
	protected Competitor c8;
	protected Competitor c9;
	protected final int NB_MATCHES_IN_FINALSTAGE = 7;
	protected final int NB_GROUPS_IN_MASTER = 3;


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
		return new Master(this.competitors, new SelectionStrategyBasicMaster(), NB_GROUPS_IN_MASTER, displayer);
	}
	
	@Override
	protected int howManyMatchesExpected(List<Competitor> competitors) {
		int expectedMatches = 0;
		Master m = (Master) this.competition;
		for(League l : m.groups) {
			for(int i = 0; i < l.getNbCompetitors(); i++) {
				expectedMatches += (l.getNbCompetitors()-1)-i;
			}
		}
		expectedMatches = expectedMatches * 2;
		expectedMatches += NB_MATCHES_IN_FINALSTAGE;
		return expectedMatches;
	}
	
	
	@Test
	public void testRightNumberOfGroups() {
		Master m = (Master) this.competition;
		assertEquals(NB_GROUPS_IN_MASTER, m.groups.size());
	}
	
	@Test
	public void testRightNumberOfCompetitorsInFinalStage() {
		
	}
	
	@Test
	public void testThrowsInvalidNumberOfGroupException() {
		
	}

	

}
