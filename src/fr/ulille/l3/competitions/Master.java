package fr.ulille.l3.competitions;

import java.util.ArrayList;
import java.util.List;

import fr.ulille.l3.exceptions.CannotCreateCompetitionException;
import fr.ulille.l3.exceptions.CompetitorsNumberNotPowerOf2Exception;
import fr.ulille.l3.exceptions.InvalidNumberOfGroupException;
import fr.ulille.l3.exceptions.NoSuchTypeOfCompetitionException;
import fr.ulille.l3.exceptions.NoSuchTypeOfStrategyException;
import fr.ulille.l3.modele.Competitor;
import fr.ulille.l3.strategy.SelectionStrategy;
import fr.ulille.l3.util.DisplayerInterface;

/**
 * Master is a type of competition where you have a group phase, and then a final phase. You can act on how the competition will be handled by changing the strategy.
 * @author Aurélien, Lucas
 *
 */
public class Master extends Competition {
	
	protected SelectionStrategy strategy;
	protected List<League> groups;
	protected Competition finalStage;

	public Master(List<Competitor> competitors, SelectionStrategy selection, int nbGroups,DisplayerInterface displayer) throws NullPointerException, CannotCreateCompetitionException {
		super(competitors, displayer);
		this.strategy = selection;
		this.groups = new ArrayList<>();
		createGroups(competitors, nbGroups);
		checkIfPossible();
	}
	
	/**
	 * Check if the number of competitors is a modulo 2. It is needed to check if a Tournament is possible
	 * @param numberOfCompetitor The number of competitors to be checked
	 * @throws CompetitorsNumberNotPowerOf2 Exception if modulo 2 is not respected
	 */
	private void checkModulo2(int numberOfCompetitor) throws CompetitorsNumberNotPowerOf2Exception {
		while(numberOfCompetitor > 1) {
			if(numberOfCompetitor%2 != 0){
				throw new CompetitorsNumberNotPowerOf2Exception();
			}
			numberOfCompetitor = numberOfCompetitor/2;
		}
	}
	
	@Override
	protected void checkIfPossible() throws CannotCreateCompetitionException {
		this.checkModulo2(this.strategy.numberOfCompetitorsSelected(this.groups));
	}

	/**
	 * Used to create all the groups of the master.
	 * @param competitors The list of total competitors
	 * @param nbGroups The number of groups to be created with the given competitors
	 * @throws CannotCreateCompetitionException 
	 * @throws NullPointerException 
	 */
	private void createGroups(List<Competitor> competitors, int nbGroups) throws NullPointerException, CannotCreateCompetitionException {
		if(competitors.size() % nbGroups != 0) {
			throw new InvalidNumberOfGroupException();
		}
		int sizeOfGroup = competitors.size()/nbGroups;
		int index = 0;
		for(int i = 0; i < nbGroups; i++) {
			List<Competitor> groupList = new ArrayList<>();
			for(int j = 0; j < sizeOfGroup; j++) {
				try {
					groupList.add(competitors.get(index));
					index++;
				}
				catch(IndexOutOfBoundsException e) {
					throw new InvalidNumberOfGroupException();
				}
			}
			this.groups.add(new League(groupList,this.displayer));
		}
	}

	/**
	 * Play the master with the following order :
	 * - Play each group phase
	 * - Select the winners of each group phase with the given strategy
	 * - Play the final stage with tournament rules
	 * @param competitors The list of competitors that are taking part in this competition.
	 */
	@Override
	protected void play(List<Competitor> competitors){
		this.playGroups();
		this.createFinalStage();
		this.displayer.display("\n play final stage");
		this.playFinalStage();
	}
	
	/**
	 * Use the strategy to select the competitors that should be in the final stage.
	 * @return a list of competitor
	 */
	private List<Competitor> qualifyCompetitors() {
		return this.strategy.selection(groups);
	}
	
	/**
	 * Used to create the final phase of the master which is a tournament
	 */
	private void createFinalStage() {
		List<Competitor> qualifiedCompetitors = this.qualifyCompetitors();
		this.finalStage = null;
		try {
			CompetitionFactory factory = CompetitionFactory.getInstance();
			this.finalStage = factory.createCompetition(TypeOfCompetition.Tournament.getLabel(), qualifiedCompetitors,this.displayer);
		} catch (NullPointerException | CannotCreateCompetitionException | NoSuchTypeOfCompetitionException | NoSuchTypeOfStrategyException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	/**
	 * Used to play the final phase of the master
	 */
	private void playFinalStage() {
		this.finalStage.play();
		this.matchesPlayed += this.finalStage.matchesPlayed;
	}

	/**
	 * Used to play every group 
	 */
	private void playGroups(){
		for(League l : this.groups) {
			l.play();
			this.matchesPlayed += l.matchesPlayed;
		}
	}
}
