package fr.ulille.l3.competitions;

import java.util.List;

import fr.ulille.l3.exceptions.CannotCreateCompetitionException;
import fr.ulille.l3.exceptions.NoSuchTypeOfCompetitionException;
import fr.ulille.l3.exceptions.NoSuchTypeOfStrategyException;
import fr.ulille.l3.modele.Competitor;
import fr.ulille.l3.strategy.StrategyFactory;
import fr.ulille.l3.util.DisplayerInterface;

/**
 * Class implementing the factory method pattern. Use it to create any type of competition.
 * @author Aurélien,Lucas
 *
 */
public class CompetitionFactory {

	private static CompetitionFactory factory;
	
	/**
	 * Create a master with the given parameters
	 * @param typeCompetition specify which type of competition has to be instantiate.
	 * @param listOfCompetitors specify the competitors that take part in the created competition.
	 * @param nbGroups is the number of groups at the beginning of the master
	 * @param strategy The string representing the strategy that is selected by the user.
	 * @param displayer the wanted displayer for different output 
	 * @return a new instance of the competition type you specify, using all the competitors.
	 * @throws NullPointerException If the list of competitors is not allocated
	 * @throws NoSuchTypeOfCompetitionException If there is no competitions within the enum of competition
	 * @throws CannotCreateCompetitionException Thrown if the competitions can't be created with the given parameters 
	 * @throws NoSuchTypeOfStrategyException Thrown if the Strategy parameters don't belong to the strategy enum
	 */
	public Competition createCompetition(String typeCompetition, List<Competitor> listOfCompetitors, int nbGroups, String strategy, DisplayerInterface displayer) throws NullPointerException, NoSuchTypeOfCompetitionException, CannotCreateCompetitionException, NoSuchTypeOfStrategyException {
		if(typeCompetition.toLowerCase().equals(TypeOfCompetition.Master.getLabel())) {
			StrategyFactory subFactory = StrategyFactory.getInstance();
			return new Master(listOfCompetitors,subFactory.createStrategy(strategy.toLowerCase()), nbGroups,displayer);
		}
		
		throw new NoSuchTypeOfCompetitionException("There is no competition with that name");
	}
	/**
	 * Create any type of competition that exists in the application.
	 * @param typeCompetition specify which type of competition has to be instantiate.
	 * @param listOfCompetitors specify the competitors that take part in the created competition.
	 * @param displayer the wanted displayer for different output 
	 * @return a new instance of the competition type you specify, using all the competitors.
	 * @throws NullPointerException If the list of competitors is not allocated
	 * @throws NoSuchTypeOfCompetitionException If there is no competitions within the enum of competition
	 * @throws CannotCreateCompetitionException Thrown if the competitions can't be created with the given parameters 
	 * @throws NoSuchTypeOfStrategyException Thrown if the Strategy parameters don't belong to the strategy enum
	 */
	public Competition createCompetition(String typeCompetition, List<Competitor> listOfCompetitors, DisplayerInterface displayer) throws NullPointerException, NoSuchTypeOfCompetitionException, CannotCreateCompetitionException, NoSuchTypeOfStrategyException {
		if(typeCompetition.toLowerCase().equals(TypeOfCompetition.League.getLabel())){
			return new League(listOfCompetitors, displayer);
		}
		else if(typeCompetition.toLowerCase().equals(TypeOfCompetition.Tournament.getLabel())) {
			return new Tournament(listOfCompetitors,displayer);
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
