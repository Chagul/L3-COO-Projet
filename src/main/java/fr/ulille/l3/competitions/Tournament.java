package main.java.fr.ulille.l3.competitions;

import java.util.List;

import main.java.fr.ulille.l3.excpetions.EmptyCompetitorsListException;

public class Tournament extends Competition {

	public Tournament(List<Competitor> competitors) throws NullPointerException, EmptyCompetitorsListException {
		super(competitors);
	}

	@Override
	protected void play(List<Competitor> competitors) {
		
	}
	
}
