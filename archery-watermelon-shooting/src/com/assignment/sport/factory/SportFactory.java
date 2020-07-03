package com.assignment.sport.factory;

import com.assignment.sport.api.ISport;
import com.assignment.sport.category.SportSubCategory;

/**
 * Generic sport factory.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public interface SportFactory {

	/**
	 * API to return sport object.
	 * 
	 * @param subCategory sport sub-category
	 * 
	 * @return Sport.
	 */

	ISport getSport(SportSubCategory subCategory);

}
