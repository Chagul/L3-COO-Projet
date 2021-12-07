package fr.ulille.l3.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class that represent an observable object, it regroups all the methods that are needed
 * @author Aurélien, Lucas
 *
 */
public abstract class SpecialObservable {
	
	protected List<CompetitionObserver> competitionObservers;
	
	/**
	 * Add an observer to the list of observers
	 * @param observer The observer to be added
	 */
	public void addCompetitionObserver(CompetitionObserver observer) {
		this.competitionObservers.add(observer);
	}
	
	/**
	 * Remove an observer from the list of observers
	 * @param observer The observer to be removed
	 */
	public void removeCompetitionObserver(CompetitionObserver observer) {
		this.competitionObservers.remove(observer);
	}
	
	/**
	 * Notify the observers when the state changes
	 */
	public void somethingHappened() {
		this.fireObservers();
	}
	
	/**
	 * Call the update method on each observer contained in the list
	 */
	protected void fireObservers() {
		for(CompetitionObserver o : this.competitionObservers) {
			o.update();
		}
	}
	
	public List<CompetitionObserver> getCompetitionObservers(){
		return this.competitionObservers;
	}
	
	public void setCompetitionObservers(List<CompetitionObserver> observers) {
		this.competitionObservers = new ArrayList<>(observers);
	}
}
