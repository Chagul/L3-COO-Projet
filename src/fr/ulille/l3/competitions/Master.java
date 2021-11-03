package fr.ulille.l3.competitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import fr.ulille.l3.exceptions.CompetitorsNumberNotPowerOf2Exception;
import fr.ulille.l3.exceptions.EmptyCompetitorsListException;
import fr.ulille.l3.exceptions.InvalidNumberOfGroupException;
import fr.ulille.l3.modele.Competitor;

public class Master extends Competition {
	
	protected SelectionStrategy selection;
	protected List<League> groups;
	protected Tournament finalStage;

	public Master(List<Competitor> competitors, SelectionStrategy selection, int nbGroups) throws NullPointerException, EmptyCompetitorsListException, InvalidNumberOfGroupException {
		super(competitors);
		this.selection = selection;
		this.groups = new ArrayList<>();
		createGroups(competitors, nbGroups);
	}

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

	@Override
	protected void play(List<Competitor> competitors) {
		this.playGroups();
		List<Competitor> qualifiedCompetitors = this.selection.selection(groups);
		this.finalStage = null;
		try {
			this.finalStage = new Tournament(qualifiedCompetitors);
		} catch (NullPointerException | EmptyCompetitorsListException | CompetitorsNumberNotPowerOf2Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		this.finalStage.play();
	}

	private void playGroups() {
		for(League l : this.groups) {
			l.play();
		}
	}
	
	@Override
	public Map<Competitor,Integer> ranking() {
		return this.finalStage.ranking();
	}
}
