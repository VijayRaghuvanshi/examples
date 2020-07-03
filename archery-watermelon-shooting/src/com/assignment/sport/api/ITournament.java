package com.assignment.sport.api;

import com.assignment.sport.pojo.Player;

import java.util.Map;

/**
 * Api to provide generic information of a tournament.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public interface ITournament {

	/**
	 * Get Tournament id.
	 * 
	 * @return String id
	 */
	public String getId();

	/**
	 * Get tournament name.
	 * 
	 * @return String name
	 */
	public String getName();

	/**
	 * Get sport type.
	 * 
	 * @return ISport sport type.
	 */
	public ISport getSport();

	/**
	 * Players participated in tournament.
	 * 
	 * @return Set<Player> set of players.
	 */
	public Map<String, Player> getPlayers();

}
