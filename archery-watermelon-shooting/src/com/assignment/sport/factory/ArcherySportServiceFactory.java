/**
 * 
 */
package com.assignment.sport.factory;

import com.assignment.sport.category.SportSubCategory;
import com.assignment.sport.service.TournamentService;
import com.assignment.sport.service.impl.ArcheryTournamentServiceImpl;

/**
 * Archery sport service factory concrete class.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public class ArcherySportServiceFactory implements SportServiceFactory {

	/** 
	 * {@inheritDoc} 
	 */
	@Override
	public TournamentService getSportSerivceFactory(final SportSubCategory subCategory) {
		
		TournamentService tournamentService = null;
		if(SportSubCategory.ARCHERY_WATERMELON.equals(subCategory)) {
			tournamentService = new ArcheryTournamentServiceImpl();
		}
		return tournamentService;
	}

}
