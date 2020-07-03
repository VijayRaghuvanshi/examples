package com.assignment.sport.api;

/**
 * API to provide score card information of a tournament.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public interface IScorecard {
	
	/**
	 * provide tournament unique id.
	 */
	public String getTournamentId();
	
	/**
	 * provide Player unique id.
	 */
	public String getPlayerId();
	
	/**
	 * provide Round id.
	 */
	public String getRoundId();

}
