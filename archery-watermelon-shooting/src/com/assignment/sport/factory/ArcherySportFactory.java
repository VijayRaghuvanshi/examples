package com.assignment.sport.factory;

import com.assignment.sport.api.ISport;
import com.assignment.sport.category.SportCategory;
import com.assignment.sport.category.SportSubCategory;
import com.assignment.sport.pojo.Sport;

/**
 * Concrete archery sport factory.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public class ArcherySportFactory implements SportFactory {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ISport getSport(SportSubCategory subCategory) {

		ISport sport = null;
		if (SportSubCategory.ARCHERY_WATERMELON.equals(subCategory)) {
			sport = new Sport("a1", "archery water melon shooting", SportCategory.ARCHERY,
					SportSubCategory.ARCHERY_WATERMELON);
		}
		return sport;

	}
}
