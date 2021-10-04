package main.java.fr.ulille.l3.application;

import java.util.ArrayList;
import java.util.List;

import main.java.fr.ulille.l3.competitions.Competition;
import main.java.fr.ulille.l3.competitions.Tournament;
import main.java.fr.ulille.l3.excpetions.CompetitorsNumberNotPowerOf2;
import main.java.fr.ulille.l3.excpetions.EmptyCompetitorsListException;
import main.java.fr.ulille.l3.modele.Competitor;

public class Main {
	
	public static void main(String[] args) {
		Competitor c1 = new Competitor("Lucas");
		Competitor c2 = new Competitor("Aurélien");
		Competitor c3 = new Competitor("Hugo");
		Competitor c4 = new Competitor("Antoine");
		List<Competitor> competitors = new ArrayList<>();
		
		competitors.add(c1); competitors.add(c2); competitors.add(c3); competitors.add(c4);
		
		Competition league = null;
		try {
			league = new Tournament(competitors);
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (EmptyCompetitorsListException e) {
			e.printStackTrace();
		} catch (CompetitorsNumberNotPowerOf2 e) {
			e.printStackTrace();
		}
		
		league.play();
		league.ranking();
	}
}
