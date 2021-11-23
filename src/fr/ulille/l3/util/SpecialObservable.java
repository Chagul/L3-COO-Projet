package fr.ulille.l3.util;

import java.util.List;

/**
 * Abstract class that represent an observable object, it regroups all the methods that are needed
 * @author Aurélien, Lucas
 *
 */
public abstract class SpecialObservable {
	
	protected List<CompetitionObserver> competitonObservers;
	
	/**
	 * Add an observer to the list of observers
	 * @param observer The observer to be added
	 */
	public void addMatchObserver(CompetitionObserver observer) {
		this.competitonObservers.add(observer);
	}
	
	/**
	 * Remove an observer from the list of observers
	 * @param observer The observer to be removed
	 */
	public void removeMatchObserver(CompetitionObserver observer) {
		this.competitonObservers.remove(observer);
	}
	
	/**
	 * Notify the observers when the state changes
	 */
	public void somethingHappen() {
		this.fireObservers();
	}
	
	/**
	 * Call the update method on each observer contained in the list
	 */
	protected void fireObservers() {
		for(CompetitionObserver o : this.competitonObservers) {
			o.update();
		}
	}
}
