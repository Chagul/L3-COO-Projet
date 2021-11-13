package fr.ulille.l3.application;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import fr.ulille.l3.competitions.Competition;
import fr.ulille.l3.competitions.CompetitionFactory;
import fr.ulille.l3.exceptions.CannotCreateCompetitionException;
import fr.ulille.l3.exceptions.NoSuchTypeOfCompetitionException;
import fr.ulille.l3.exceptions.NoSuchTypeOfStrategyException;
import fr.ulille.l3.modele.Competitor;
import fr.ulille.l3.util.BasicDisplayer;
import fr.ulille.l3.util.TypeOfCompetition;
import fr.ulille.l3.util.TypeOfStrategy;

/**
 * Main class that runs the project. Asks for competitors and a type of competition before playing it.
 * @author Auréilen, Lucas
 *
 */

public class Main {

	public final static String name = "res" + File.separator + "name.csv";
	public final static Scanner sc = new Scanner(System.in);
	public final static BasicDisplayer displayer = BasicDisplayer.getInstance();

	public static void main(String[] args) throws NullPointerException, NoSuchTypeOfCompetitionException, CannotCreateCompetitionException, NoSuchTypeOfStrategyException {
		List<Competitor> competitors = createListCompetitors();
		Competition competition = createCompetition(competitors);
		sc.close();
		competition.play();
	}


	/**
	 * Method that open a file as a stream and convert the line in a arrayList of String this method is neccessairy because file in a jar are not considered like file but stream.
	 * @param pathToFile The path of file that will be opened
	 * @return ArrayList<String> the list with all the name of the CSV file.
	 */
	private ArrayList<String> getNameFromFile(String pathToFile){
		ArrayList<String> listOfName = new ArrayList<>();
		InputStream is = getClass().getClassLoader().getResourceAsStream(pathToFile);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		try {
			while((line = br.readLine()) != null) {
				listOfName.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listOfName;
	}

	private static Competition createCompetition(List<Competitor> competitors) throws NoSuchTypeOfCompetitionException, NullPointerException, CannotCreateCompetitionException, NoSuchTypeOfStrategyException {
		displayer.display("Veuillez entrer votre type de competition parmi :");
		displayer.display("League, Tournament ou Master");
		String answer = sc.next().toLowerCase();
		while(!TypeOfCompetition.contains(answer)) {
			displayer.display("Nom de compétition invalide ! ");
			displayer.display("League, Tournament ou Master");
			answer = sc.next().toLowerCase();
		}
		int nbGroups = 0;
		Competition competition = null;
		if(answer.equals("master")) {
			String strategy = getStrategy();
			displayer.display("Entrez un nombre de groupes pour le Master");
			nbGroups = Integer.parseInt(sc.next());
			if(nbGroups == 0) {
				displayer.display("Nombre de groupe invalide !");
				displayer.display("Entrez un nombre de groupes pour le Master");
				nbGroups = Integer.parseInt(sc.next());
			}
			CompetitionFactory factory = new CompetitionFactory();
			competition = factory.createCompetition(answer, competitors, nbGroups,strategy, displayer);
		}else {
			CompetitionFactory factory = new CompetitionFactory();
			competition = factory.createCompetition(answer, competitors, displayer);
		}
		return competition;
	}



	private static String getStrategy() {
		TypeOfStrategy[] arrayStrategy = TypeOfStrategy.values();
		int answer = 0;
		while(answer <= 0 || answer > arrayStrategy.length) {
			for(int index = 0; index < arrayStrategy.length; index ++) {
				displayer.display(index+1 + ":" + arrayStrategy[index].getDescription());
			}
			displayer.display("Choisissez la strategie de sélection que vous souhaitez utiliser");
			answer = Integer.parseInt(sc.next());
		}
		return arrayStrategy[answer-1].getLabel();
	}


	private static List<Competitor> createListCompetitors() {
		displayer.display("Entrez votre nombre de compétiteurs");
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
		listOfName = new Main().getNameFromFile(name);

		for(int i = 0; i < nbOfCompetitors; i++) {
			Competitor compet = new Competitor(listOfName.get(rng.nextInt(listOfName.size())));
			System.out.println(compet);
			competitors.add(compet);
		}
		return competitors;
	}
}
