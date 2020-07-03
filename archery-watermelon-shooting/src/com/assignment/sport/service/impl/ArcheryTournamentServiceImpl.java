package com.assignment.sport.service.impl;

import com.assignment.sport.api.ITournament;
import com.assignment.sport.factory.FactoryProvider;
import com.assignment.sport.pojo.ArcherPlayerScorecard;
import com.assignment.sport.pojo.ArcheryAttempt;
import com.assignment.sport.pojo.ArcheryScorecard;
import com.assignment.sport.pojo.ArcheryTournament;
import com.assignment.sport.pojo.Player;
import com.assignment.sport.pojo.Point;
import com.assignment.sport.pojo.ScorecardHolder;
import com.assignment.sport.pojo.TournamentRequest;
import com.assignment.sport.service.TournamentManager;
import com.assignment.sport.service.TournamentService;
import com.assignment.sport.util.RequestValidator;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * Archery tournament service class to provide controller over an archery
 * tournament. It provides apis to create a tournament and update record for
 * each attempt made by a player. It also expose api to diplay current score
 * card of a tournament.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public class ArcheryTournamentServiceImpl implements TournamentService {

	/**
	 * archery tournament manager instance.
	 */
	private static final TournamentManager<ArcheryTournament, ArcheryAttempt> tournamentManager = new ArcheryTournamentManager();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean createTournament(final TournamentRequest request) {

		boolean flag = false;
		if (RequestValidator.tournamentRequestValidator(request)) {

			ITournament tournament = FactoryProvider.getTournamentFactory(request.getCategory()).getTournament(
					request.getCategory(), request.getSubCategory(), request.getTournamentId(),
					request.getTournamentName());
			tournamentManager.addTournament((ArcheryTournament) tournament);
			flag = true;
		} else {

			System.out.println("Invalid request for creating a tournament.");
		}
		return flag;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateScorecard(ArcheryAttempt attempt) {

		if (RequestValidator.attemptValidator(attempt)) {
			tournamentManager.updateScorecard(attempt);
		} else {
			System.out.println("Invalid attempt made");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, ArcherPlayerScorecard> getScorecard(String tournamentId) {

		final Map<String, ArcherPlayerScorecard> playerScoreSheet = new TreeMap<>();

		if (tournamentId != null && !tournamentId.isEmpty()) {
			ScorecardHolder scorecardholder = tournamentManager.getScorecard(tournamentId);
			if (scorecardholder != null) {
				final ITournament tournament = tournamentManager.getTournament(tournamentId);
				final Map<String, Player> playersMap = tournament.getPlayers();
				Map<String, ArcheryScorecard> scoresheet = scorecardholder.getScorecards();
				scoresheet.forEach((key, archeryScorecard) -> {
					preparePlayerScoresheet(playerScoreSheet, playersMap, archeryScorecard);
				});
			} else {
				System.out.println("Invalid tournament id.");
			}
		}
		return playerScoreSheet;
	}

	/**
	 * Prepare score sheet.
	 * 
	 * @param playerScoreSheet
	 * @param playersMap
	 * @param archeryScorecard
	 */
	private void preparePlayerScoresheet(final Map<String, ArcherPlayerScorecard> playerScoreSheet,
			final Map<String, Player> playersMap, ArcheryScorecard archeryScorecard) {
		int playerFinalScore = 0;
		for (Point p : archeryScorecard.getPoint().values()) {
			playerFinalScore += p.getPoint();
		}
		ArcherPlayerScorecard scoreObj = playerScoreSheet.get(archeryScorecard.getPlayerId());
		if (Objects.isNull(scoreObj)) {
			scoreObj = new ArcherPlayerScorecard(archeryScorecard.getPlayerId(),
					playersMap.get(archeryScorecard.getPlayerId()).getName(), playerFinalScore);
		} else {
			scoreObj.setScore(scoreObj.getScore() + playerFinalScore);
		}
		playerScoreSheet.put(archeryScorecard.getPlayerId(), scoreObj);
	}
}
