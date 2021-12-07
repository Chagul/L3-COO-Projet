package fr.ulille.l3.competitions;

import fr.ulille.l3.util.CompetitionObserver;

public class MockObserver implements CompetitionObserver {
	
	protected int cpt = 0;

	public int getCpt() {
		return cpt;
	}

	@Override
	public void update() {
		cpt++;
	}

	@Override
	public void changeCompetition(Competition compet) {
		//unused
		
	}

}
