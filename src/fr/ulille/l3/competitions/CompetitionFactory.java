package fr.ulille.l3.competitions;

import java.util.List;

import fr.ulille.l3.exceptions.CompetitorsNumberNotPowerOf2Exception;
import fr.ulille.l3.exceptions.EmptyCompetitorsListException;
import fr.ulille.l3.exceptions.NoSuchTypeOfCompetitionException;
import fr.ulille.l3.modele.Competitor;

/**
 * Class implementing the factory method pattern. Use it to create any type of competition.
 * @author Lucas
 *
 */
public class CompetitionFactory {

	/**
	 * Create any type of competition that exists in the application.
	 * @param typeCompetition specify which type of competition has to be instantiate.
	 * @param listOfCompetitors specify the competitors that take part in the created competition.
	 * @return a new instance of the competition type you specify, using all the competitors.
	 * @throws NullPointerException
	 * @throws EmptyCompetitorsListException
	 * @throws CompetitorsNumberNotPowerOf2Exception
	 * @throws NoSuchTypeOfCompetitionException
	 */
	public Competition createCompetition(String typeCompetition, List<Competitor> listOfCompetitors) throws NullPointerException, EmptyCompetitorsListException, CompetitorsNumberNotPowerOf2Exception, NoSuchTypeOfCompetitionException {
		if(typeCompetition.equals("League")){
			return new League(listOfCompetitors);
		}
		else if(typeCompetition.equals("Tournament")) {
			return new Tournament(listOfCompetitors);
		}
		
		throw new NoSuchTypeOfCompetitionException("There is no competition with that name");
	}

	
}
