package fr.ulille.l3.competitions;

import java.util.ArrayList;
import java.util.List;

import fr.ulille.l3.exceptions.CompetitorsNumberNotPowerOf2Exception;
import fr.ulille.l3.exceptions.EmptyCompetitorsListException;
import fr.ulille.l3.exceptions.InvalidNumberOfGroupException;
import fr.ulille.l3.exceptions.NoSuchTypeOfCompetitionException;
import fr.ulille.l3.modele.Competitor;
import fr.ulille.l3.modele.Leaderboard;
import fr.ulille.l3.util.Displayer;

public class Master extends Competition {
	
	protected SelectionStrategy strategy;
	protected List<League> groups;
	protected Tournament finalStage;

	public Master(List<Competitor> competitors,Displayer displayer, SelectionStrategy selection, int nbGroups) throws NullPointerException, EmptyCompetitorsListException, InvalidNumberOfGroupException {
		super(competitors, displayer);
		this.strategy = selection;
		this.groups = new ArrayList<>();
		createGroups(competitors, nbGroups);
	}

	/**
	 * 
	 * @param competitors The list of total competitors
	 * @param nbGroups The number of groups to be created with the given competitors
	 * @throws EmptyCompetitorsListException Thrown if the list is empty
	 * @throws InvalidNumberOfGroupException Thrown if the master cannot be created with given number of competitors and group
	 */
	private void createGroups(List<Competitor> competitors, int nbGroups) throws EmptyCompetitorsListException, InvalidNumberOfGroupException {
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
			this.groups.add(new League(groupList));
		}
	}

	/**
	 * Play the master with the following order :
	 * Play each group phase
	 * Select the winners of each group phase with the given strategy
	 * Play the final stage with tournament rules
	 * @throws InvalidNumberOfGroupException 
	 * @throws NoSuchTypeOfCompetitionException 
	 */
	@Override
	protected void play(List<Competitor> competitors) throws NoSuchTypeOfCompetitionException, InvalidNumberOfGroupException{
		this.playGroups();
		List<Competitor> qualifiedCompetitors = this.strategy.selection(groups);
		this.finalStage = null;
		try {
			CompetitionFactory factory = factory.getInstance();
			this.finalStage = (Tournament) factory.createCompetition("league", this.displayer, qualifiedCompetitors, 0);
		} catch (NullPointerException | EmptyCompetitorsListException | CompetitorsNumberNotPowerOf2Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		System.out.println("play final stage");
		this.finalStage.play();
	}

	private void playGroups() {
		for(League l : this.groups) {
			l.play();
		}
	}
}
