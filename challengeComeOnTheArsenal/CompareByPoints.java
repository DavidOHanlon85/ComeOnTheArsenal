/**
 * 
 */
package challengeComeOnTheArsenal;

import java.util.Comparator;

/**
 * @author - Daithi O hAnluain - 15621049
 */
public class CompareByPoints implements Comparator<Team> {

	@Override
	public int compare(Team o1, Team o2) {
		// TODO Auto-generated method stub
		return o2.getTotalPoints() - o1.getTotalPoints();
	}

}
