package main.java.fr.ulille.l3.match;

import java.util.Random;

import main.java.fr.ulille.l3.modele.Competitor;
/**
 * A basic match is defined with the winner chosen randomly.
 * @author Aurélien, Lucas
 *
 */
public class BasicMatch extends Match {

	public BasicMatch(Competitor c1, Competitor c2) {
		super(c1,c2);
	}
	
	/**
	 * Play a basic match where the winner is chosen randomly
	 * @return randomWinner : the winner of the match
	 */
	@Override
	public Competitor play() {
		Random rng = new Random();
		int randomWinner = rng.nextInt(2);
		return randomWinner == 0 ? this.firstCompetitor : this.secondCompetitor;
	}

}
