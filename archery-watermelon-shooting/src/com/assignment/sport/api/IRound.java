package com.assignment.sport.api;

/**
 * Api to provide generic information of a round of a particular sport.
 *
 * @author vijaykumar02
 * @version $Revision: 1.10 $
 */
public interface IRound {
	
	/**
	 * Get round id.
	 * 
	 * @return String Round unique id.
	 */
	public String getRoundId();

 
	/**
	 * Get round name.
	 * 
	 * @return String round name.
	 */
	public String getRoundName();

}
