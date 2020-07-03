package com.assignment.sport.api;

import com.assignment.sport.category.SportCategory;
import com.assignment.sport.category.SportSubCategory;

/**
 * Expose api to provide sport information.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public interface ISport {

	/**
	 * Provide a unique sport id.
	 * 
	 * @return String sport id;
	 */
	public String getId();

	/**
	 * Provides sport name.
	 * 
	 * @return String Name of the sport
	 */
	public String getName();

	/**
	 * Provides sport category.
	 * 
	 * @return SportCategory sport category enum.
	 */
	public SportCategory category();

	/**
	 * Provides sport sub-category.
	 * 
	 * @return SportSubCategory sport sub-category.
	 */
	public SportSubCategory getSubCategory();

}
