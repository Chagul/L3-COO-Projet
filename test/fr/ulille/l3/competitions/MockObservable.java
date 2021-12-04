package fr.ulille.l3.competitions;

import java.util.List;

import fr.ulille.l3.util.CompetitionObserver;
import fr.ulille.l3.util.SpecialObservable;

public class MockObservable extends SpecialObservable {

	public MockObservable (List<CompetitionObserver> observers) {
		this.competitionObservers = observers;
	}

}
