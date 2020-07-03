package com.assignment.sport.pojo;

import com.assignment.sport.api.IPlayerScorecard;

/**
 * Concrete class to contain archer overall score card.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public class ArcherPlayerScorecard implements IPlayerScorecard {

	/**
	 * Players id.
	 */
	private String playerId;

	/**
	 * Player name.
	 */
	private String playerName;

	/**
	 * Player score.
	 */
	private int score;

	/**
	 * Constructor.
	 *
	 * @param palayerId
	 * @param playerName
	 * @param score
	 */
	public ArcherPlayerScorecard(final String palayerId, final String playerName, final int score) {

		this.playerId = palayerId;
		this.playerName = playerName;
		this.score = score;

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
	public String getPlayerName() {

		return this.playerName;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getScore() {
		return this.score;
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
	 * Setter of {@link #playerName}.
	 * 
	 * @param playerName
	 *            to be set
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	/**
	 * 
	 * Setter of {@link #score}.
	 * 
	 * @param score
	 *            to be set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((playerId == null) ? 0 : playerId.hashCode());
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
		ArcherPlayerScorecard other = (ArcherPlayerScorecard) obj;
		if (playerId == null) {
			if (other.playerId != null)
				return false;
		} else if (!playerId.equals(other.playerId))
			return false;
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ArcherScorecard [playerId=").append(playerId).append(", playerName=").append(playerName)
				.append(", score=").append(score).append("]");
		return builder.toString();
	}

}
