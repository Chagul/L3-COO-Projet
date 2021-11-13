package fr.ulille.l3.competitions;

import java.util.List;

import fr.ulille.l3.exceptions.CompetitorsNumberNotPowerOf2Exception;
import fr.ulille.l3.exceptions.EmptyCompetitorsListException;
import fr.ulille.l3.exceptions.InvalidNumberOfGroupException;
import fr.ulille.l3.exceptions.NoSuchTypeOfCompetitionException;
import fr.ulille.l3.modele.Competitor;
import fr.ulille.l3.util.DisplayerInterface;
import fr.ulille.l3.util.TypeOfCompetition;

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
	 * @throws InvalidNumberOfGroupException 
	 */
	public Competition createCompetition(String typeCompetition,List<Competitor> listOfCompetitors, int nbGroups,DisplayerInterface displayer) throws NullPointerException, EmptyCompetitorsListException, CompetitorsNumberNotPowerOf2Exception, NoSuchTypeOfCompetitionException, InvalidNumberOfGroupException {
		if(typeCompetition.toLowerCase().equals(TypeOfCompetition.League.getLabel())){
			return new League(listOfCompetitors, displayer);
		}
		else if(typeCompetition.toLowerCase().equals(TypeOfCompetition.Tournament.getLabel())) {
			return new Tournament(listOfCompetitors,displayer);
		}
		else if(typeCompetition.toLowerCase().equals(TypeOfCompetition.Master.getLabel())) {
			return new Master(listOfCompetitors, new SelectionStrategyBasicMaster(), nbGroups,displayer);
		}
		
		throw new NoSuchTypeOfCompetitionException("There is no competition with that name");
	}
	
	/**
	 * Singleton of the class, it is to be sure that only one instance of the factory exists.
	 * @return Instance of the factory
	 */
	public static CompetitionFactory getInstance() {
		if(factory == null) {
			factory = new CompetitionFactory();
		}
		return factory;
	}
	
}
