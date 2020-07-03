/**
 * 
 */
package com.assignment.sport.api;

/**
 * Api to get player overall scorecard.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public interface IPlayerScorecard {
	
	/**
	 * Get player id.
	 * 
	 * @return String player id.
	 */
	public String getPlayerId();
	/**
	 * Get player name.
	 * 
	 * @return String player name
	 */
	public String getPlayerName();
	/**
	 * Get player overall score in the tournament.
	 * 
	 * @return int player score.
	 */
	public int getScore();
	
}
