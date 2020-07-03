/**
 * 
 */
package com.assignment.sport.pojo;

import com.assignment.sport.api.IScorecard;

import java.util.HashMap;
import java.util.Map;

/**
 * Pojo contains a scorecard of a tournament.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public class ScorecardHolder {

	/**
	 * tournament id.
	 */
	private String tournamentId;

	/**
	 * Set of scorecard for a tournament.Where key is concat of tournament id,
	 * playerId, and round Id.
	 */
	private Map<String, ArcheryScorecard> scorecards;

	/**
	 * Create scorecard holder object.
	 *
	 * @param tournamentId
	 */
	public ScorecardHolder(final String tournamentId) {
		this.tournamentId = tournamentId;
		this.scorecards = new HashMap<>();
	}

	/**
	 * Update score card of the tournament.
	 * 
	 * @param scorecard
	 * @return boolean true/false
	 */
	public void updateScorecard(final ArcheryScorecard attempt) {
		final String key = new StringBuilder().append(attempt.getTournamentId()).append(attempt.getPlayerId())
				.append(attempt.getRoundId()).toString();
		this.scorecards.put(key, attempt);
	}

	/**
	 * 
	 * Getter of {@link #tournamentId}.
	 * 
	 * @return {@link #tournamentId}
	 */
	public String getTournamentId() {
		return tournamentId;
	}

	/**
	 * 
	 * Getter of {@link #scorecards}.
	 * 
	 * @return {@link #scorecards}
	 */
	public Map<String, ArcheryScorecard> getScorecards() {
		return scorecards;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tournamentId == null) ? 0 : tournamentId.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScorecardHolder other = (ScorecardHolder) obj;
		if (tournamentId == null) {
			if (other.tournamentId != null)
				return false;
		} else if (!tournamentId.equals(other.tournamentId))
			return false;
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ScorecardHolder [tournamentId=").append(tournamentId).append(", scorecards=").append(scorecards)
				.append("]");
		return builder.toString();
	}

}
