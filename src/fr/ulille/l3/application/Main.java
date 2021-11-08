package fr.ulille.l3.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.ulille.l3.competitions.Competition;
import fr.ulille.l3.competitions.CompetitionFactory;
import fr.ulille.l3.exceptions.CompetitorsNumberNotPowerOf2Exception;
import fr.ulille.l3.exceptions.EmptyCompetitorsListException;
import fr.ulille.l3.exceptions.InvalidNumberOfGroupException;
import fr.ulille.l3.exceptions.NoSuchTypeOfCompetitionException;
import fr.ulille.l3.modele.Competitor;
import fr.ulille.l3.util.Displayer;

/**
 * Main class that runs the project. Asks for competitors and a type of competition before playing it.
 * @author Auréilen, Lucas
 *
 */

public class Main {

	public static void main(String[] args) throws NullPointerException, EmptyCompetitorsListException, CompetitorsNumberNotPowerOf2Exception, NoSuchTypeOfCompetitionException, InvalidNumberOfGroupException {
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
			String name = sc.next();
			Competitor compet = new Competitor(name);
			System.out.println(compet);
			competitors.add(compet);
			displayer.display("Competiteur ajouté !");
		}
		
		displayer.display("Veuillez entrer votre type de competition parmi :");
		displayer.display("League, Tournament ou Master");
		
		String answer = sc.next();
		answer = answer.toLowerCase();
		int nbGroups = 0;
		Competition competition = null;
		if(answer.equals("master")) {
			displayer.display("Entrez un nombre de groupes pour le Master");
			nbGroups = Integer.parseInt(sc.next());
			CompetitionFactory factory = new CompetitionFactory();
			competition = factory.createCompetition(answer, competitors, nbGroups);
		}else {
			CompetitionFactory factory = new CompetitionFactory();
			competition = factory.createCompetition(answer, competitors, nbGroups);
		}
		sc.close();

		competition.play();
	}
}
