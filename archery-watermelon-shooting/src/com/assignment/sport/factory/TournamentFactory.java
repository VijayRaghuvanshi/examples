package com.assignment.sport.factory;

import com.assignment.sport.api.ITournament;
import com.assignment.sport.category.SportCategory;
import com.assignment.sport.category.SportSubCategory;

/**
 * Generic factory for creating Tournament of a sub-category of giving sport
 * sub-category.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public interface TournamentFactory {

	/**
	 * Api returns a tournament object as per the sub-category passed in.
	 * 
	 * @param category
	 * @param subCategory
	 * @param torunamentId
	 * @param tournamentName
	 * @return ITournament tournament object.
	 */

	public ITournament getTournament(final SportCategory category, final SportSubCategory subCategory,
			final String torunamentId, final String tournamentName);

}
