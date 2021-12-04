package fr.ulille.l3.modele;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.ulille.l3.competitions.Competition;
import fr.ulille.l3.competitions.League;
import fr.ulille.l3.competitions.Tournament;
import fr.ulille.l3.exceptions.CannotCreateCompetitionException;
import fr.ulille.l3.util.CompetitionObserver;
import fr.ulille.l3.util.TestDisplayer;

public abstract class TestObservers {

	protected List<Competitor> competitors = new ArrayList<Competitor>();
	protected TestDisplayer displayer = TestDisplayer.getInstance();
	protected CompetitionObserver observer = null;
	protected Competition competition = null;
	
	@BeforeEach
	public void init() throws NullPointerException, CannotCreateCompetitionException {
		competitors.add(new Competitor("Aurélien"));competitors.add(new Competitor("Lucas"));competitors.add(new Competitor("Hugo"));competitors.add(new Competitor("Antoine"));competitors.add(new Competitor("Corentin"));competitors.add(new Competitor("Ambre"));
		this.observer = this.createObserver();
		this.competitors = new ArrayList<Competitor>();
		this.competitors.add(new Competitor("Aurélien"));this.competitors.add(new Competitor("Lucas"));
		this.competition = new Tournament(competitors,displayer);
	}

	protected abstract CompetitionObserver createObserver();
	
	
	/**
	 * Test if an observer is created and affected to a competition on creation
	 * @throws NullPointerException If the list of competitors for creating the competition is null
	 * @throws CannotCreateCompetitionException If we can't create the said competition with the given list of competitors
	 */
	@Test 
	public void testObserverObservingCompetition() throws NullPointerException, CannotCreateCompetitionException {
		this.competitors = new ArrayList<Competitor>();
		this.competitors.add(new Competitor("Aurélien"));this.competitors.add(new Competitor("Lucas"));
		Competition competition = new League(competitors,displayer);
		for(CompetitionObserver o : competition.getCompetitionObservers()) {
			if(o.getClass().equals(this.observer.getClass())) {
				assertTrue(true);
			}
		}

	}
}
