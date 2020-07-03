package com.assignment.sport.factory;

import com.assignment.sport.category.SportSubCategory;
import com.assignment.sport.pojo.Player;

import java.util.Map;

/**
 * Generic factory for players.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public interface PlayerFactory {
	
	/**
	 * Create set of players for a sub-category.
	 * 
	 * @param subCategory sport sub-category.
	 * @return Map<String, Player> map of players.
	 */
	Map<String, Player> getPlayers(SportSubCategory subCategory);

}
