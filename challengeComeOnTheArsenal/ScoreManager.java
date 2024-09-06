/**
 * 
 */
package challengeComeOnTheArsenal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

/**
 * @author - Daithi O hAnluain - 15621049
 */
public class ScoreManager {

	/**
	 * @param args
	 */

	private static Map<String, Team> teams = new HashMap<String, Team>();

	public static void main(String[] args) {

		// Map

		// Read in results

		ArrayList<String> results = convertResultsToArrayList();

		// Process results

		processResultsAndUpdateTeams(results);

		// Print each teams stats in alphabetical order

		printEachTeamsIndividualStats();

		printLeagueTable();

	}

	/**
	 * This method prints the league table in descending order
	 */
	public static void printLeagueTable() {
		List<Team> allTeams = new ArrayList<Team>(teams.values());

		Collections.sort(allTeams, new CompareByPoints());
		
		System.out.println("League Table");

		System.out.printf("%-20s %-6s %-5s %-10s %-2s %-2s %-8s %-6s\n", "Team", "Played", "For", "Against", "W", "D",
				"L", "Points");

		for (Team t : allTeams) {

			System.out.printf("%-20s %-6s %-5s %-10s %-2s %-2s %-8s %-6s\n", t.getTeamName(), t.getGamesPlayed(),
					t.getGoalsFor(), t.getGoalsAgainst(), t.getWins(), t.getDraws(), t.getLosses(), t.getTotalPoints());
		}
	}

	/**
	 * This method prints each teams individual stats to the console
	 */
	public static void printEachTeamsIndividualStats() {
		SortedMap<String, Team> sortedTeams = new TreeMap<String, Team>(teams);

		for (String team : sortedTeams.keySet()) {
			// System.out.println(team);
			Team t = teams.get(team);
			t.Stats();
			System.out.println();

		}
	}

	/**
	 * This method processes the results and updates the team statistics
	 * 
	 * @param results
	 */
	public static void processResultsAndUpdateTeams(ArrayList<String> results) {
		String[] resultsSplit;
		String team1;
		String team2;
		int team1Goals;
		int team2Goals;
		String team1Result, team2Result;

		for (String r : results) {

			resultsSplit = r.split(" ");

			team1 = resultsSplit[0];
			team2 = resultsSplit[3];

			team1Goals = Integer.parseInt(resultsSplit[1]);
			team2Goals = Integer.parseInt(resultsSplit[2]);

			if (team1Goals > team2Goals) {
				team1Result = "Win";
				team2Result = "Loss";
			} else if (team1Goals < team2Goals) {
				team1Result = "Loss";
				team2Result = "Win";
			} else {
				team1Result = "Draw";
				team2Result = "Draw";
			}

			updateTeamStats(team1, team1Goals, team2Goals, team1Result);
			updateTeamStats(team2, team2Goals, team1Goals, team2Result);
		}
	}

	/**
	 * This method reads the results and convert them to an Array List
	 * 
	 * @return
	 */
	public static ArrayList<String> convertResultsToArrayList() {
		ArrayList<String> results = new ArrayList<String>();

		String line;

		File file = new File("Results-1.txt");

		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			line = br.readLine();

			while (line != null) {

				results.add(line);

				line = br.readLine();

			}

			System.out.println("Results in results AL");
			System.out.println(results);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}

	/**
	 * Updates Team stats based on every result read in
	 * 
	 * @param teamName
	 * @param goalsScored
	 * @param goalsConceded
	 * @param result
	 */
	private static void updateTeamStats(String teamName, int goalsScored, int goalsConceded, String result) {

		if (teams.containsKey(teamName)) {

			Team teamdetails = teams.get(teamName);
			teamdetails.incrememtGamesPlayed();
			teamdetails.increaseGoalsFor(goalsScored);
			teamdetails.increaseGoalsAgainst(goalsConceded);

			switch (result) {
			case "Win":
				teamdetails.incrementWins();
				break;
			case "Draw":
				teamdetails.incrementDraws();
				break;
			case "Loss":
				teamdetails.incrementLosses();
				break;
			default:
				break;
			}

		} else {
			teams.put(teamName, new Team(teamName));
			updateTeamStats(teamName, goalsScored, goalsConceded, result);
		}

	}

}
