package com.assignment.sport.factory;

import com.assignment.sport.category.SportCategory;

/**
 * Factory provider.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public class FactoryProvider {

	/**
	 * Provide sprot service factory.
	 * 
	 * @param category
	 * @return SportServiceFactory
	 */
	public static SportServiceFactory getServiceFactory(final SportCategory category) {

		SportServiceFactory serviceFactory = null;
		if (SportCategory.ARCHERY.equals(category)) {
			serviceFactory = new ArcherySportServiceFactory();
		}
		return serviceFactory;
	}

	/**
	 * Provides sport factory object.
	 * 
	 * @param category
	 *            sport category.
	 * @return SportFactory sport factory object.
	 */
	public static SportFactory getSportFactory(final SportCategory category) {
		SportFactory sportFactory = null;
		if (SportCategory.ARCHERY.equals(category)) {
			sportFactory = new ArcherySportFactory();
		}
		return sportFactory;
	}

	/**
	 * Creates sports rounds factory for a sport.
	 * 
	 * @param category
	 *            sport category.
	 * @return SportRoundFactory
	 */
	public static SportRoundFactory getSportRoundFactory(final SportCategory category) {
		SportRoundFactory sportRoundFactory = null;
		if (SportCategory.ARCHERY.equals(category)) {
			sportRoundFactory = new ArcheryRoundFactory();
		}
		return sportRoundFactory;
	}

	/**
	 * Creates player factory for a sport.
	 * 
	 * @param category
	 *            sport category.
	 * @return PlayerFactory player factory.
	 */
	public static PlayerFactory getPlayersFactory(final SportCategory category) {
		PlayerFactory playerFactory = null;
		if (SportCategory.ARCHERY.equals(category)) {
			playerFactory = new ArcheryPlayerFactory();
		}
		return playerFactory;
	}

	/**
	 * Create a Tournament factory for a sport.
	 * 
	 * @param category
	 *            sport category.
	 * @return TournamentFactory
	 */
	public static TournamentFactory getTournamentFactory(final SportCategory category) {
		TournamentFactory tournamentFactory = null;
		if (SportCategory.ARCHERY.equals(category)) {
			tournamentFactory = new ArcheryTournamentFactory();
		}
		return tournamentFactory;
	}

}
