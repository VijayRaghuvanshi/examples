/**
 * 
 */
package com.assignment.sport.service;

import com.assignment.sport.pojo.ArcherPlayerScorecard;
import com.assignment.sport.pojo.ArcheryAttempt;
import com.assignment.sport.pojo.ArcheryScorecard;
import com.assignment.sport.pojo.TournamentRequest;

import java.util.Map;

/**
 * Service to provide operations around a tournament. For example create a new
 * tournament, update score card of particular round or get current scorecard of
 * a tournament.
 *
 * @author vijaykumar02
 * @version $Revision: 1.10 $
 */
public interface TournamentService {

	/**
	 * Creates a new tournament.
	 * 
	 * @param tournamentCreateRequest
	 * @return boolean flag
	 */
	public boolean createTournament(TournamentRequest tournamentCreateRequest);

	/**
	 * Update scorecard of a round for a tournament.
	 * 
	 * @param scorecardReq
	 *            ScorecardRequest request object.
	 */
	public void updateScorecard(ArcheryAttempt scorecardReq);

	/**
	 * Provides current score card of a tournament.
	 * 
	 * @param tournamentId
	 *            tournament Id
	 * @return Map<String, ArcherPlayerScorecard>
	 */
	public Map<String, ArcherPlayerScorecard> getScorecard(String tournamentId);

}
