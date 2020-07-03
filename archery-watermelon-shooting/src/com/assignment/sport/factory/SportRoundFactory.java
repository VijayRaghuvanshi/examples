package com.assignment.sport.factory;

import com.assignment.sport.category.SportSubCategory;
import com.assignment.sport.pojo.ArcheryRound;

import java.util.Map;

/**
 * Round generic factory.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public interface SportRoundFactory {

	/**
	 * Builds collection of rounds to be played.
	 * 
	 * @param subCategory
	 *            sport sub-category.
	 * 
	 * @return Map<String, Round> map of rounds to played in a sport.
	 */
	Map<String, ArcheryRound> getRounds(SportSubCategory subCategory);

}
