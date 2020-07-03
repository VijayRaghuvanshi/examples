package com.assignment.sport.api;

/**
 * Api to provider attempt information.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public interface IAttempt {
	
	/**
	 * Provide tournament id of an attempt.
	 * 
	 * @return String
	 */
	public String getTournamentId();
	
	/**
	 * Provide player id of an attempt.
	 * 
	 * @return String
	 */
	public String getPlayerId();
	
	
	/**
	 * Provide round id of an attempt.
	 * 
	 * @return String
	 */
	public String getRoundId();
	
	/**
	 * Provide bow number of an attempt.
	 * 
	 * @return int 
	 */
	public int getBowNumber();
	
	/**
	 * Provide number successful of an attempt.
	 * 
	 * @return int
	 */
	public int getHits();
	
	
}
