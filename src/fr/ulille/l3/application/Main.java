package fr.ulille.l3.application;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import fr.ulille.l3.competitions.Competition;
import fr.ulille.l3.competitions.CompetitionFactory;
import fr.ulille.l3.exceptions.CompetitorsNumberNotPowerOf2Exception;
import fr.ulille.l3.exceptions.EmptyCompetitorsListException;
import fr.ulille.l3.exceptions.InvalidNumberOfGroupException;
import fr.ulille.l3.exceptions.NoSuchTypeOfCompetitionException;
import fr.ulille.l3.modele.Competitor;
import fr.ulille.l3.util.BasicDisplayer;

/**
 * Main class that runs the project. Asks for competitors and a type of competition before playing it.
 * @author Auréilen, Lucas
 *
 */

public class Main {

	public static void main(String[] args) throws NullPointerException, EmptyCompetitorsListException, CompetitorsNumberNotPowerOf2Exception, NoSuchTypeOfCompetitionException, InvalidNumberOfGroupException {
		final Path name_csv = Paths.get("ressources" + File.separator + "name.csv");
		BasicDisplayer displayer = new BasicDisplayer();
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
		List<String> listOfName = null;
		Random rng = new Random();
		try {
			listOfName = Files.readAllLines(name_csv);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < nbOfCompetitors; i++) {
			Competitor compet = new Competitor(listOfName.get(rng.nextInt(listOfName.size())));
			System.out.println(compet);
			competitors.add(compet);
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
			if(nbGroups == 0) {
				displayer.display("Nombre de groupe invalide !");
				displayer.display("Entrez un nombre de groupes pour le Master");
				nbGroups = Integer.parseInt(sc.next());
			}
			CompetitionFactory factory = new CompetitionFactory();
			competition = factory.createCompetition(answer, competitors, nbGroups,displayer);
		}else {
			CompetitionFactory factory = new CompetitionFactory();
			competition = factory.createCompetition(answer, competitors, nbGroups,displayer);
		}
		sc.close();

		competition.play();
	}
}
