package fr.ulille.l3.competitions;

import java.util.List;

import fr.ulille.l3.exceptions.CompetitorsNumberNotPowerOf2Exception;
import fr.ulille.l3.exceptions.EmptyCompetitorsListException;
import fr.ulille.l3.exceptions.InvalidNumberOfGroupException;
import fr.ulille.l3.exceptions.NoSuchTypeOfCompetitionException;
import fr.ulille.l3.modele.Competitor;
import fr.ulille.l3.util.Displayer;

/**
 * Class implementing the factory method pattern. Use it to create any type of competition.
 * @author Lucas
 *
 */
public class CompetitionFactory {

	private static CompetitionFactory factory;
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
	public Competition createCompetition(String typeCompetition,Displayer displayer, List<Competitor> listOfCompetitors, int nbGroups) throws NullPointerException, EmptyCompetitorsListException, CompetitorsNumberNotPowerOf2Exception, NoSuchTypeOfCompetitionException, InvalidNumberOfGroupException {
		if(typeCompetition.equals("league")){
			return new League(listOfCompetitors, displayer);
		}
		else if(typeCompetition.equals("tournament")) {
			return new Tournament(listOfCompetitors,displayer);
		}
		else if(typeCompetition.equals("master")) {
			return new Master(listOfCompetitors,displayer, new SelectionStrategyBasicMaster(), nbGroups);
		}
		
		throw new NoSuchTypeOfCompetitionException("There is no competition with that name");
	}
	
	
	public static CompetitionFactory getInstance() {
		if(factory == null) {
			factory = new CompetitionFactory();
		}
		return factory;
	}
	
}
