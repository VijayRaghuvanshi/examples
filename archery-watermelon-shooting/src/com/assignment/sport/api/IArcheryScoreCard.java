package com.assignment.sport.api;

import com.assignment.sport.pojo.Point;

import java.util.Map;

/**
 * Api provides data of archery score card.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public interface IArcheryScoreCard extends IScorecard {
	
	/**
	 * Provide Points for each bow shoot.
	 */
	public Map<Integer, Point> getPoint();
	
	/**
	 * provide remaining arrow.
	 */
	public int getRemainingArrow();
	
	/**
	 * Get remaining target.
	 * 
	 * @return int
	 */
	public int remainingTarget();

}
