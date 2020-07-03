package com.assignment.sport.pojo;

import com.assignment.sport.api.IArcheryScoreCard;

import java.util.HashMap;
import java.util.Map;

/**
 * Pojo contains scorecard data.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public class ArcheryScorecard implements IArcheryScoreCard {

	/**
	 * Tournament unique id.
	 */
	private String tournamentId;

	/**
	 * Player unique id.
	 */
	private String playerId;

	/**
	 * Round id.
	 */
	private String roundId;

	/**
	 * Contains points gained for each bow. Where key is bow number and value is
	 * points.
	 */
	private Map<Integer, Point> point;

	/**
	 * remaining arrow.
	 */
	private int remainingArrow;

	/**
	 * Remaining targets for a round.
	 */
	private int remainingTarget;

	/**
	 * Create score card object.
	 *
	 * @param tournamentId
	 *            tournament Id
	 * @param playerId
	 *            player Id
	 * @param roundId
	 *            roundId
	 */
	public ArcheryScorecard(final String tournamentId, final String playerId, final String roundId) {
		this.tournamentId = tournamentId;
		this.playerId = playerId;
		this.roundId = roundId;
		this.point = new HashMap<>();
	}

	/**
	 * Create score card object.
	 *
	 * @param tournamentId
	 *            tournament Id
	 * @param playerId
	 *            player Id
	 * @param roundId
	 *            roundId
	 * @param remainingArrow
	 *            remaining Arrow
	 * @param remainingTarget
	 *            remaining Target
	 */
	public ArcheryScorecard(final String tournamentId, final String playerId, final String roundId,
			final int remainingArrow, final int remainingTarget) {
		this(tournamentId, playerId, roundId);
		this.remainingArrow = remainingArrow;
		this.remainingTarget = remainingTarget;
	}

	/**
	 * 
	 * Setter of {@link #remainingArrow}.
	 * 
	 */
	public void updateRemainingArrow() {
		this.remainingArrow = remainingArrow-1;
	}

	/**
	 * Update remaining targets.
	 * 
	 * @param currentHits
	 */
	public void updateRemainingTarget(int currentHits) {
		this.remainingTarget = remainingTarget-currentHits;
	}
	
	/**
	 * Update point for an attempt.
	 * 
	 * @param point
	 */
	public void updatePoint(final int bowNum, final int points) {
		this.point.put(bowNum, new Point(bowNum, points));

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getTournamentId() {

		return this.tournamentId;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPlayerId() {

		return this.playerId;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getRoundId() {

		return this.roundId;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getRemainingArrow() {

		return this.remainingArrow;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int remainingTarget() {
		return this.remainingTarget;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<Integer, Point> getPoint() {
		return this.point;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((playerId == null) ? 0 : playerId.hashCode());
		result = prime * result + ((roundId == null) ? 0 : roundId.hashCode());
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
		ArcheryScorecard other = (ArcheryScorecard) obj;
		if (playerId == null) {
			if (other.playerId != null)
				return false;
		} else if (!playerId.equals(other.playerId))
			return false;
		if (roundId == null) {
			if (other.roundId != null)
				return false;
		} else if (!roundId.equals(other.roundId))
			return false;
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
		final StringBuilder builder = new StringBuilder();
		builder.append("ArcheryScorecard [tournamentId=").append(tournamentId).append(", playerId=").append(playerId)
				.append(", roundId=").append(roundId).append(", point=").append(point).append(", remainingArrow=")
				.append(remainingArrow).append(", remainingTarget=").append(remainingTarget).append("]");
		return builder.toString();
	}

}
