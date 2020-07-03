package com.assignment.sport.api;

/**
 * Api to fetch player information.
 *
 * @author vijaykumar02
 * @version $Revision: 1.10 $
 */
public interface IPlayer {

	/**
	 * Get player id.
	 * 
	 * @return String unique player id.
	 */
	public String getId();

	/**
	 * Get player name.
	 * 
	 * @return String player name.
	 */
	public String getName();

	/**
	 * Get player number.
	 * 
	 * @return String number player
	 */
	public String getNumber();

	/**
	 * Get player nationality.
	 * 
	 * @return String player nationality.
	 */
	public String getNationality();

	/**
	 * Player's current tournament id.
	 * 
	 * @return String tournament id.
	 */
	public String getCurrentTournament();

}
