/**
 * 
 */
package com.assignment.sport.factory;

import com.assignment.sport.api.ISport;
import com.assignment.sport.category.SportCategory;
import com.assignment.sport.category.SportSubCategory;
import com.assignment.sport.pojo.ArcheryRound;
import com.assignment.sport.pojo.ArcheryTournament;
import com.assignment.sport.pojo.Player;
import com.assignment.sport.pojo.ScorecardHolder;

import java.util.Map;

/**
 * Archery tournament factory.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public class ArcheryTournamentFactory implements TournamentFactory {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArcheryTournament getTournament(final SportCategory category, final SportSubCategory subCategory,
			final String torunamentId, final String tournamentName) {
		
		ArcheryTournament tournament = null;
		if (SportSubCategory.ARCHERY_WATERMELON.equals(subCategory)) {
			System.out.println("Creating tournament for archery watermelon shooting.");
			final ISport sport = FactoryProvider.getSportFactory(category).getSport(subCategory);
			final Map<String, Player> players = FactoryProvider.getPlayersFactory(category).getPlayers(subCategory);
			final Map<String, ArcheryRound> rounds = FactoryProvider.getSportRoundFactory(category)
					.getRounds(subCategory);
			tournament = new ArcheryTournament(torunamentId, tournamentName, players, rounds, new ScorecardHolder(torunamentId));
		}
		return tournament;
	}
}
