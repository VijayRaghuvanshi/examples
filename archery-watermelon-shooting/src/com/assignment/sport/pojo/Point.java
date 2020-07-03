/**
 * 
 */
package com.assignment.sport.pojo;

/**
 * Point pojo contains point of each arrow.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public class Point {
		
	/**
	 * Bow number of a round.
	 */
	private int bowNumber;
	
	/**
	 * Points.
	 */
	private int point;
	
	/**
	 * Constructor.
	 *
	 * @param bowNum
	 * @param points 
	 */
	public Point(final int bowNum, final int points) {
		this.bowNumber = bowNum;
		this.point = points;
	}

	/**
	 * 
	 * Getter of {@link #bowNumber}.
	 * 
	 * @return {@link #bowNumber}
	 */
	public int getBowNumber() {
		return bowNumber;
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
	 * Getter of {@link #point}.
	 * 
	 * @return {@link #point}
	 */
	public int getPoint() {
		return point;
	}

	/**
	 * 
	 * Setter of {@link #point}.
	 * 
	 * @param point 
	 *            to be set
	 */
	public void setPoint(int point) {
		this.point = point;
	}

	
	/** 
	 * {@inheritDoc} 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bowNumber;
		result = prime * result + point;
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
		Point other = (Point) obj;
		if (bowNumber != other.bowNumber)
			return false;
		if (point != other.point)
			return false;
		return true;
	}

	/** 
	 * {@inheritDoc} 
	 */
	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("Point [bowNumber=").append(bowNumber).append(", point=").append(point).append("]");
		return builder.toString();
	}
	

}
