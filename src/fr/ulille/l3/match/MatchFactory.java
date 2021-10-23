package fr.ulille.l3.match;

import fr.ulille.l3.exceptions.NoSuchTypeOfMatchException;
import fr.ulille.l3.modele.Competitor;

/**
 * Class implementing the factory method pattern. Use it to create any type of match.
 * @author Lucas
 *
 */
public class MatchFactory {
	
	/**
	 * Create any type of match that exists in the application.
	 * @param matchType specify which type of match has to be instantiate.
	 * @param c1 First competitor taking part in the match.
	 * @param c2 Second competitor taking part in the match.
	 * @return a new instance of the match type you specify, using the competitors.
	 * @throws NoSuchTypeOfMatchException
	 */
	public Match createMatch(String matchType, Competitor c1, Competitor c2) throws NoSuchTypeOfMatchException {
		if(matchType.equals("BasicMatch")) {
			return new BasicMatch(c1, c2);
		}
		
		throw new NoSuchTypeOfMatchException("There is no match with that name.");
	}
}
