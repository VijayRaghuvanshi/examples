/**
 * 
 */
package com.assignment.sport.pojo;

import com.assignment.sport.api.IAttempt;

/**
 * Pojo represents an attempt performed by an archery player
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public class ArcheryAttempt implements IAttempt {

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
	 * Bow number.
	 */
	private int bowNumber;

	/**
	 * Number of successful hits.
	 * 
	 */
	private int hits;

	/**
	 * Constructor.
	 * 
	 */
	public ArcheryAttempt() {

	}

	/**
	 * Constructor.
	 *
	 * @param tournamentId
	 * @param playerId
	 * @param roundId
	 * @param bowNumber
	 * @param hits
	 */
	public ArcheryAttempt(final String tournamentId, final String playerId, final String roundId, final int bowNumber,
			final int hits) {

		this.tournamentId = tournamentId;
		this.playerId = playerId;
		this.roundId = roundId;
		this.bowNumber = bowNumber;
		this.hits = hits;

	}

	/**
	 * 
	 * Setter of {@link #tournamentId}.
	 * 
	 * @param tournamentId
	 *            to be set
	 */
	public void setTournamentId(String tournamentId) {
		this.tournamentId = tournamentId;
	}

	/**
	 * 
	 * Setter of {@link #playerId}.
	 * 
	 * @param playerId
	 *            to be set
	 */
	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	/**
	 * 
	 * Setter of {@link #roundId}.
	 * 
	 * @param roundId
	 *            to be set
	 */
	public void setRoundId(String roundId) {
		this.roundId = roundId;
	}

	/**
	 * 
	 * Setter of {@link #bowNumber}.
	 * 
	 * @param bowNumber
	 *            to be set
	 */
	public void setBowNumber(int bowNumber) {
		this.bowNumber = bowNumber;
	}

	/**
	 * 
	 * Setter of {@link #hits}.
	 * 
	 * @param hits
	 *            to be set
	 */
	public void setHits(int hits) {
		this.hits = hits;
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
	public int getBowNumber() {
		return this.bowNumber;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getHits() {
		return this.hits;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bowNumber;
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
		ArcheryAttempt other = (ArcheryAttempt) obj;
		if (bowNumber != other.bowNumber)
			return false;
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
		builder.append("ArcheryAttempt [tournamentId=").append(tournamentId).append(", playerId=").append(playerId)
				.append(", roundId=").append(roundId).append(", bowNumber=").append(bowNumber).append(", hits=")
				.append(hits).append("]");
		return builder.toString();
	}

}
