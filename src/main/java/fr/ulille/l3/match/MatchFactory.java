package main.java.fr.ulille.l3.match;

import main.java.fr.ulille.l3.exceptions.NoSuchTypeOfMatchException;
import main.java.fr.ulille.l3.modele.Competitor;

public class MatchFactory {
	
	public Match createMatch(String matchType, Competitor c1, Competitor c2) throws NoSuchTypeOfMatchException {
		if(matchType.equals("BasicMatch")) {
			return new BasicMatch(c1, c2);
		}
		
		throw new NoSuchTypeOfMatchException("There is no match with that name.");
	}
}
