package com.assignment.sport.factory;

import com.assignment.sport.category.SportSubCategory;
import com.assignment.sport.service.TournamentService;

/**
 * Factory to provide service factory instance of a sport service provider based on a .
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public interface SportServiceFactory {
	
	/**
	 * Api to create a service facotry.
	 * 
	 * @param subCategory
	 * @return TournamentService 
	 */
	public TournamentService getSportSerivceFactory(SportSubCategory subCategory);

}
