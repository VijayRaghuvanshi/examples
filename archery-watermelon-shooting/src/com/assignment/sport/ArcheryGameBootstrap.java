package com.assignment.sport;

import com.assignment.sport.category.SportCategory;
import com.assignment.sport.category.SportSubCategory;
import com.assignment.sport.factory.FactoryProvider;
import com.assignment.sport.pojo.ArcherPlayerScorecard;
import com.assignment.sport.pojo.ArcheryAttempt;
import com.assignment.sport.pojo.TournamentRequest;
import com.assignment.sport.service.TournamentService;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Main class to trigger Archery water-melon shooting tournament.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public class ArcheryGameBootstrap {

	/**
	 * Main method.
	 * 
	 * @param arg
	 */
	public static void main(String... arg) {

		TournamentService tournamentService = FactoryProvider.getServiceFactory(SportCategory.ARCHERY)
				.getSportSerivceFactory(SportSubCategory.ARCHERY_WATERMELON);
		final TournamentRequest tournamentRequest = getTournamentRequest();
		boolean flag = tournamentService.createTournament(tournamentRequest);
		if (flag) {
			Set<ArcheryAttempt> attempts = getPlayersAttempt();
			Iterator<ArcheryAttempt> attemptIterator = attempts.iterator();
			while (attemptIterator.hasNext()) {
				tournamentService.updateScorecard(attemptIterator.next());
			}
			final Map<String, ArcherPlayerScorecard> scoresheet = tournamentService
					.getScorecard(tournamentRequest.getTournamentId());
			for (ArcherPlayerScorecard score : scoresheet.values()) {

				System.out.println(String.format("Player: %s \n Score: %s,", score.getPlayerName(), score.getScore()));
			}

		}

	}

	/**
	 * Creates archers attempt data.
	 * 
	 * @return Set<ArcheryAttempt>
	 */
	private static Set<ArcheryAttempt> getPlayersAttempt() {

		// archer 1
		final Set<ArcheryAttempt> attempts = new LinkedHashSet<>();
		attempts.add(new ArcheryAttempt("t1", "p1", "r1", 1, 4));
		attempts.add(new ArcheryAttempt("t1", "p1", "r1", 2, 2));

		attempts.add(new ArcheryAttempt("t1", "p1", "r2", 1, 3));
		attempts.add(new ArcheryAttempt("t1", "p1", "r2", 2, 4));
		attempts.add(new ArcheryAttempt("t1", "p1", "r3", 1, 7));
		attempts.add(new ArcheryAttempt("t1", "p1", "r3", 2, 3));
		attempts.add(new ArcheryAttempt("t1", "p1", "r4", 1, 10));
		attempts.add(new ArcheryAttempt("t1", "p1", "r4", 2, 0));
		attempts.add(new ArcheryAttempt("t1", "p1", "r5", 1, 6));
		attempts.add(new ArcheryAttempt("t1", "p1", "r5", 2, 0));
		attempts.add(new ArcheryAttempt("t1", "p1", "r6", 1, 0));
		attempts.add(new ArcheryAttempt("t1", "p1", "r6", 2, 5));
		attempts.add(new ArcheryAttempt("t1", "p1", "r7", 1, 9));
		attempts.add(new ArcheryAttempt("t1", "p1", "r7", 2, 0));
		attempts.add(new ArcheryAttempt("t1", "p1", "r8", 1, 2));
		attempts.add(new ArcheryAttempt("t1", "p1", "r8", 2, 1));
		attempts.add(new ArcheryAttempt("t1", "p1", "r9", 1, 5));
		attempts.add(new ArcheryAttempt("t1", "p1", "r9", 2, 2));

		attempts.add(new ArcheryAttempt("t1", "p1", "r10", 1, 10));
		attempts.add(new ArcheryAttempt("t1", "p1", "r10", 2, 10));
		attempts.add(new ArcheryAttempt("t1", "p1", "r10", 3, 5));

		// archer2
		attempts.add(new ArcheryAttempt("t1", "p2", "r1", 1, 4));
		attempts.add(new ArcheryAttempt("t1", "p2", "r1", 2, 6));

		attempts.add(new ArcheryAttempt("t1", "p2", "r2", 1, 10));
		attempts.add(new ArcheryAttempt("t1", "p2", "r2", 2, 0));
		attempts.add(new ArcheryAttempt("t1", "p2", "r3", 1, 0));
		attempts.add(new ArcheryAttempt("t1", "p2", "r3", 2, 10));
		attempts.add(new ArcheryAttempt("t1", "p2", "r4", 1, 3));
		attempts.add(new ArcheryAttempt("t1", "p2", "r4", 2, 4));
		attempts.add(new ArcheryAttempt("t1", "p2", "r5", 1, 3));
		attempts.add(new ArcheryAttempt("t1", "p2", "r5", 2, 1));
		attempts.add(new ArcheryAttempt("t1", "p2", "r6", 1, 0));
		attempts.add(new ArcheryAttempt("t1", "p2", "r6", 2, 5));
		attempts.add(new ArcheryAttempt("t1", "p2", "r7", 1, 9));
		attempts.add(new ArcheryAttempt("t1", "p2", "r7", 2, 0));
		attempts.add(new ArcheryAttempt("t1", "p2", "r8", 1, 2));
		attempts.add(new ArcheryAttempt("t1", "p2", "r8", 2, 1));
		attempts.add(new ArcheryAttempt("t1", "p2", "r9", 1, 5));
		attempts.add(new ArcheryAttempt("t1", "p2", "r9", 2, 2));

		attempts.add(new ArcheryAttempt("t1", "p2", "r10", 1, 3));
		attempts.add(new ArcheryAttempt("t1", "p2", "r10", 2, 2));

		return attempts;
	}

	/**
	 * Create tournament request object.
	 * 
	 * @return TournamentRequest
	 */
	private static TournamentRequest getTournamentRequest() {

		TournamentRequest request = new TournamentRequest();
		request.setCategory(SportCategory.ARCHERY);
		request.setSubCategory(SportSubCategory.ARCHERY_WATERMELON);
		request.setTournamentId("t1");
		request.setTournamentName("Archery water-melon shooting tournament");
		return request;

	}

}
