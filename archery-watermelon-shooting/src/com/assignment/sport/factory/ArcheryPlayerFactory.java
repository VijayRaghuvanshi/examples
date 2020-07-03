/**
 * 
 */
package com.assignment.sport.factory;

import com.assignment.sport.category.SportSubCategory;
import com.assignment.sport.pojo.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * Players factory for archery sport.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public class ArcheryPlayerFactory implements PlayerFactory {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Player> getPlayers(SportSubCategory subCategory) {

		Map<String, Player> players = null;

		if (SportSubCategory.ARCHERY_WATERMELON.equals(subCategory)) {
			players = createPlayers();
		}
		return players;
	}

	/**
	 * Create players map.
	 * 
	 * @return Map<String, Player> map of players.
	 */
	private Map<String, Player> createPlayers() {
		final Map<String, Player> players = new HashMap<>();
		players.put("p1", new Player("p1", "James", "1", "Austria", "t1"));
		players.put("p2", new Player("p2", "Thomas", "2", "Sweden", "t1"));
		return players;
	}

}
