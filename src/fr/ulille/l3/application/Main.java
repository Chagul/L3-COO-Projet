package fr.ulille.l3.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import fr.ulille.l3.competitions.Competition;
import fr.ulille.l3.competitions.CompetitionFactory;
import fr.ulille.l3.exceptions.CompetitorsNumberNotPowerOf2Exception;
import fr.ulille.l3.exceptions.EmptyCompetitorsListException;
import fr.ulille.l3.exceptions.InvalidNumberOfGroupException;
import fr.ulille.l3.exceptions.NoSuchTypeOfCompetitionException;
import fr.ulille.l3.modele.Competitor;
import fr.ulille.l3.util.Displayer;
import fr.ulille.l3.util.MapUtil;

/**
 * Main class that runs the project. Asks for competitors and a type of competition before playing it.
 * @author Auréilen, Lucas
 *
 */

public class Main {

	public static void main(String[] args) throws NullPointerException, EmptyCompetitorsListException, CompetitorsNumberNotPowerOf2Exception, NoSuchTypeOfCompetitionException {
		Displayer displayer = Displayer.getInstance();
		displayer.display("Entrez votre nombre de compétiteurs");
		Scanner sc = new Scanner(System.in);
		int nbOfCompetitors = 0;
		
		try {
			nbOfCompetitors = Integer.parseInt(sc.next());
		}
		catch (NumberFormatException exception) {
			System.exit(1);
		}
		
		List<Competitor> competitors = new ArrayList<>();
		
		for(int i = 0; i < nbOfCompetitors; i++) {
			displayer.display("Entre le nom du competiteur");
			competitors.add(new Competitor(sc.next()));
			displayer.display("Competiteur ajouté !");
		}
		
		displayer.display("Veuillez entrer votre type de competition parmi :");
		displayer.display("League, Tournament ou Master");
		
		String answer = sc.next();
		int nbGroups = 0;
		if(answer.equals("Master")) {
			displayer.display("Entrez un nombre de groupes pour le Master");
			nbGroups = Integer.parseInt(sc.next());
			CompetitionFactory factory = new CompetitionFactory();
			try {
				Competition competition = factory.createCompetition(answer, competitors, nbGroups);
			} catch (NullPointerException | EmptyCompetitorsListException | CompetitorsNumberNotPowerOf2Exception
					| NoSuchTypeOfCompetitionException | InvalidNumberOfGroupException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
		CompetitionFactory factory = new CompetitionFactory();
		Competition competition = null;
		try {
			competition = factory.createCompetition(answer, competitors, nbGroups);
		} catch (NullPointerException | EmptyCompetitorsListException | CompetitorsNumberNotPowerOf2Exception
				| NoSuchTypeOfCompetitionException | InvalidNumberOfGroupException e) {
			e.printStackTrace();
			System.exit(1);
		}
		sc.close();

		competition.play();
		Map<Competitor,Integer> ranks = competition.ranking();
		ranks = MapUtil.sortByDescendingValue(ranks);
		displayer.display("\n*** RANKING ***");
		for (Map.Entry<Competitor,Integer> entryMap : ranks.entrySet()) {
			displayer.display(entryMap.getKey().getName() + " --> " + entryMap.getValue());
		}
	}
}
