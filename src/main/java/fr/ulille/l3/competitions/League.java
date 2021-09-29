package main.java.fr.ulille.l3.competitions;

import java.util.List;

import main.java.fr.ulille.l3.excpetions.EmptyCompetitorsListException;

public class League extends Competition {

	public League(List<Competitor> competitors) throws NullPointerException, EmptyCompetitorsListException {
		super(competitors);
	}
	
	@Override
	protected void play(List<Competitor> competitors) {
		for(int indexCompetitor1 = 0; indexCompetitor1 < competitors.size(); indexCompetitor1++) {
			for(int indexCompetitor2 = 1+indexCompetitor1; indexCompetitor2 < competitors.size(); indexCompetitor2++) {
				playMatch(competitors.get(indexCompetitor1),competitors.get(indexCompetitor2));
				playMatch(competitors.get(indexCompetitor2), competitors.get(indexCompetitor1));
			}
		}
	}
	
}
