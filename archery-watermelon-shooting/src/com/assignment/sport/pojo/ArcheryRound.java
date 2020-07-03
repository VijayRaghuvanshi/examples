package com.assignment.sport.pojo;

import com.assignment.sport.api.IArcheryRound;

/**
 * Contains information for a round.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public class ArcheryRound implements IArcheryRound {

	/**
	 * Uniquely identity a round.
	 */
	private String roundId;

	/**
	 * Round name;
	 */
	private String roundName;

	/**
	 * Minimum number of arrows can be used in the round.
	 */
	private int minNoOfArrow;

	/**
	 * Minimum number of arrows can be used in the round.
	 */
	private int maxNoOfArrow;
	
	/**
	 * max number of targets.
	 */
	private int maxTarget;

	/**
	 * Creates a round.
	 *
	 * @param roundId
	 *            unique round id.
	 * @param roundName
	 *            round name.
	 * @param minNoOfArrow
	 *            minimum number of arrows to be used.
	 * @param maxNoOfArrow
	 *            max number of arrows to be used.
	 * @param maxTarget
	 *            max number of targets to be hit.
	 */
	public ArcheryRound(final String roundId, final String roundName, final int minNoOfArrow, final int maxNoOfArrow, final int maxTarget) {

		this.roundId = roundId;
		this.roundName = roundName;
		this.minNoOfArrow = minNoOfArrow;
		this.maxNoOfArrow = maxNoOfArrow;
		this.maxTarget = maxTarget;

	}
	
	

	/** 
	 * {@inheritDoc} 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roundId == null) ? 0 : roundId.hashCode());
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
		ArcheryRound other = (ArcheryRound) obj;
		if (roundId == null) {
			if (other.roundId != null)
				return false;
		} else if (!roundId.equals(other.roundId))
			return false;
		return true;
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
	public String getRoundName() {
		 
		return this.roundName;
	}



	/** 
	 * {@inheritDoc} 
	 */
	@Override
	public int getMinNoOfArrow() {
	 
		return this.minNoOfArrow;
	}



	/** 
	 * {@inheritDoc} 
	 */
	@Override
	public int getMaxNoOfArrow() {
		 
		return this.maxNoOfArrow;
	}


	/** 
	 * {@inheritDoc} 
	 */
	@Override
	public int getMaxTarget() {
		return this.maxTarget;
	}



	/** 
	 * {@inheritDoc} 
	 */
	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("ArcheryRound [roundId=").append(roundId).append(", roundName=").append(roundName)
				.append(", minNoOfArrow=").append(minNoOfArrow).append(", maxNoOfArrow=").append(maxNoOfArrow)
				.append(", maxTarget=").append(maxTarget).append("]");
		return builder.toString();
	}
	
}
