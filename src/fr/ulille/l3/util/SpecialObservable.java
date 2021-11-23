package fr.ulille.l3.util;

import java.util.List;

/**
 * Abstract class that represent an observable object, it regroups all the methods that are needed
 * @author Aurélien, Lucas
 *
 */
public abstract class SpecialObservable {
	
	private List<MatchObserver> matchObservers;
	
	/**
	 * Add an observer to the list of observers
	 * @param observer The observer to be added
	 */
	public void addMatchObserver(MatchObserver observer) {
		this.matchObservers.add(observer);
	}
	
	/**
	 * Remove an observer from the list of observers
	 * @param observer The observer to be removed
	 */
	public void removeMatchObserver(MatchObserver observer) {
		this.matchObservers.remove(observer);
	}
	
	public void somethingHappen() {
		this.fireObservers();
	}
	
	protected void fireObservers() {
		for(MatchObserver o : this.matchObservers) {
			o.update();
		}
	}
}
