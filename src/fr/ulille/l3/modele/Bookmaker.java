package fr.ulille.l3.modele;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.ulille.l3.competitions.Competition;
import fr.ulille.l3.util.CompetitionObserver;
import fr.ulille.l3.util.DisplayerInterface;

/**
 * Bookmaker maintaining and updating odds on the players of a competition
 * @author Aurélien, Lucas
 *
 */
public class Bookmaker implements CompetitionObserver, DisplayerInterface{

	private Competition competitionObserved;
	private Map<Competitor,Double> competitorAndTheirOdds;
	private final double MODIFIER_INCREASE_ODD_AFTER_WIN = 0.1;
	private final double MODIFIER_DECREASE_ODD_AFTER_LOSE = 0.1;

	/**
	 * Create a new bookmaker that is defined by a list of competitors and their odds
	 * @param competitors The list of the competitors in the competition observed.
	 * @param theCompetitionObserved A reference to the competition that this bookmaker observe.
	 */
	public Bookmaker(List<Competitor> competitors,Competition theCompetitionObserved) {
		this.competitorAndTheirOdds = new HashMap<>();
		for(Competitor c : competitors) {
			this.competitorAndTheirOdds.put(c, 1.0);
		}
		this.competitionObserved = theCompetitionObserved;
	}

	/**
	 * Update the map of competitor and their odds, for the winner, its odd is added with MODIFIER_INCREASE_ODD_AFTER_WIN. For the loser its odd is substracted by MODIFIER_DECREASE_ODD_AFTER_LOSE. Send the message to display
	 */
	@Override
	public void update() {
		Competitor winner = this.competitionObserved.getLastMatch().getWinner();
		Competitor loser  = this.competitionObserved.getLastMatch().getLoser();
		this.display("BOOKMAKER: After the win of " + winner + "against " + loser + "with their respective odds " + String.format("%,.1f",this.competitorAndTheirOdds.get(winner)) + " / " + String.format("%,.1f",this.competitorAndTheirOdds.get(loser)));
		this.competitorAndTheirOdds.put(winner, this.competitorAndTheirOdds.get(winner)+MODIFIER_INCREASE_ODD_AFTER_WIN);
		this.competitorAndTheirOdds.put(loser, this.competitorAndTheirOdds.get(loser)-MODIFIER_DECREASE_ODD_AFTER_LOSE);
		this.display(" their new respective odds are " + String.format("%,.1f",this.competitorAndTheirOdds.get(winner)) + " / " + String.format("%,.1f",this.competitorAndTheirOdds.get(loser)));
	}

	/**
	 * Display in the console the message, for this class it is implemented because it could be sent to an other communication canal
	 * @param msg The message to be displayed
	 */
	@Override
	public void display(String msg) {
		System.out.println(msg);
		
	}
	
	/**
	 * Getter returning the map of competitors and their respective odds
	 * @return Map of competitors and their odds
	 */
	public Map<Competitor,Double> getCompetitorsAndTheirOdds() {
		return this.competitorAndTheirOdds;
	}

	@Override
	public void changeCompetition(Competition compet) {
		this.competitionObserved = compet;
		
	}

}
