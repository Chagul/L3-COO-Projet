package fr.ulille.l3.competitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.ulille.l3.util.CompetitionObserver;
import fr.ulille.l3.util.SpecialObservable;

public class TestSpecialObservable {
	
	protected SpecialObservable mockObservable;
	
	@BeforeEach
	public void init() {
		List<CompetitionObserver> observers = new ArrayList<>();
		mockObservable = new MockObservable(observers);
	}
	
	/**
	 * Tests if an observer is correctly added to the observer list.
	 */
	@Test
	public void testAddCompetitionObserver() {
		MockObserver mockObserver = new MockObserver();
		this.mockObservable.addCompetitionObserver(mockObserver);
		assertTrue(this.mockObservable.getCompetitionObservers().contains(mockObserver));
		assertEquals(1, this.mockObservable.getCompetitionObservers().size());
	}
	
	/**
	 * Tests if an observer is correctly removed from the observer list.
	 */
	@Test
	public void testRemoveCompetitionObserver() {
		MockObserver mockObserver = new MockObserver();
		this.mockObservable.addCompetitionObserver(mockObserver);
		assertTrue(this.mockObservable.getCompetitionObservers().contains(mockObserver));
		this.mockObservable.removeCompetitionObserver(mockObserver);
		assertFalse(this.mockObservable.getCompetitionObservers().contains(mockObserver));
		assertEquals(0, this.mockObservable.getCompetitionObservers().size());
	}
	
	/**
	 * Tests if the update method is correctly called on every observers from the list once.
	 */
	@Test
	protected void testFireObservers() {
		MockObserver mockObserver1 = new MockObserver();
		MockObserver mockObserver2 = new MockObserver();
		MockObserver mockObserver3 = new MockObserver();
		this.mockObservable.addCompetitionObserver(mockObserver1);
		this.mockObservable.addCompetitionObserver(mockObserver2);
		this.mockObservable.addCompetitionObserver(mockObserver3);
		int oldValue = mockObserver1.getCpt();
		this.mockObservable.somethingHappened();
		oldValue++;
		
		for(CompetitionObserver observer : this.mockObservable.getCompetitionObservers()) {
			MockObserver mock = (MockObserver) observer;
			assertEquals(oldValue, mock.getCpt());
		}
	}
}
