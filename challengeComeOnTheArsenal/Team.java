/**
 * 
 */
package challengeComeOnTheArsenal;

/**
 * @author - Daithi O hAnluain - 15621049
 */
public class Team {
	
	// Constants
	
	public static final int POINTS_FOR_WIN = 3;
	
	// Instance Variables
	
	private String teamName;
	private int gamesPlayed;
	private int goalsFor;
	private int goalsAgainst;
	private int wins;
	private int draws;
	private int losses;
	private int totalPoints; 
	
	// Constructor
	
	public Team (String teamName) {
		this.setTeamName(teamName);
	}
	
	// Getters and Setters
	/**
	 * @return the teamName
	 */
	public String getTeamName() {
		return teamName;
	}
	
	/**
	 * @param teamName the teamName to set
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	/**
	 * @return the gamesPlayed
	 */
	public int getGamesPlayed() {
		return gamesPlayed;
	}
	/**
	 * @param gamesPlayed the gamesPlayed to set
	 */
	public void incrememtGamesPlayed() {
		this.gamesPlayed++;
	}
	/**
	 * @return the goalsFor
	 */
	public int getGoalsFor() {
		return goalsFor;
	}
	/**
	 * @param goalsFor the goalsFor to set
	 */
	public void increaseGoalsFor(int goalsFor) {
		this.goalsFor += goalsFor;
	}
	/**
	 * @return the goalsAgainst
	 */
	public int getGoalsAgainst() {
		return goalsAgainst;
	}
	/**
	 * @param goalsAgainst the goalsAgainst to set
	 */
	public void increaseGoalsAgainst(int goalsAgainst) {
		this.goalsAgainst += goalsAgainst;
	}
	/**
	 * @return the wins
	 */
	public int getWins() {
		return wins;
	}
	/**
	 * @param wins the wins to set
	 */
	public void incrementWins() {
		this.wins++;
	}
	/**
	 * @return the draws
	 */
	public int getDraws() {
		return draws;
	}
	/**
	 * @param draws the draws to set
	 */
	public void incrementDraws() {
		this.draws++;
	}
	/**
	 * @return the losses
	 */
	public int getLosses() {
		return losses;
	}
	/**
	 * @param losses the losses to set
	 */
	public void incrementLosses() {
		this.losses++;
	}
	/**
	 * @return the totalPoints
	 */
	public int getTotalPoints() {
		return (this.wins * POINTS_FOR_WIN) + this.draws;
	}
	
	// Methods
	
	public void Stats() {
		System.out.println(getTeamName());
		System.out.println("Games played  : " + getGamesPlayed());
		System.out.println("Goals for     : " + getGoalsFor());
		System.out.println("Goals against : " + getGoalsAgainst());
		System.out.println("Wins          : " + getWins());
		System.out.println("Draws         : " + getDraws());
		System.out.println("Losses        : " + getLosses());
		System.out.println("Points        : " + getTotalPoints());
	}
	
	
	
	
	
	
}
