package com.assignment.sport.api;

/**
 * API to provide information for archery tournament round.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public interface IArcheryRound extends IRound {

	/**
	 * Get minimum number of arrows to be used.
	 * 
	 * @return int minimum number of arrows to be used.
	 */
	public int getMinNoOfArrow();

	/**
	 * Get maximum number of arrows to be used.
	 * 
	 * @return int maximum number of arrows to be used.
	 */
	public int getMaxNoOfArrow();
	
	
	/**
	 * Get maximum targets to hit.
	 * 
	 * @return int max number of targets for a round.
	 */
	public int getMaxTarget();
	
}
