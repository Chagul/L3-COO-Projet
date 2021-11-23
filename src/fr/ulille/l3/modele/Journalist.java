package fr.ulille.l3.modele;

import fr.ulille.l3.competitions.Competition;
import fr.ulille.l3.util.CompetitionObserver;
import fr.ulille.l3.util.DisplayerInterface;

public class Journalist implements CompetitionObserver, DisplayerInterface {

	private Competition competitionObserved;
	
	
	public Journalist(Competition theCompetitionObserved) {
		this.competitionObserved = theCompetitionObserved;
	}
	
	/**
	 * Send to the displayer the result of the last match
	 */
	@Override
	public void update() {
		this.display("REPORT : " + this.competitionObserved.getLastMatch().getWinner() + " won after and incredible match against " + this.competitionObserved.getLastMatch().getLoser());
	}

	/**
	 * Display in the console the message, for this class it is implemented because it could be sent to an other communication canal
	 * @param msg The message to be displayed
	 */
	@Override
	public void display(String msg) {
		System.out.println(msg);
		
	}

}
