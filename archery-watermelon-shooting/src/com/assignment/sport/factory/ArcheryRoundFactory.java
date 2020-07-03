package com.assignment.sport.factory;

import com.assignment.sport.category.SportSubCategory;
import com.assignment.sport.pojo.ArcheryRound;

import java.util.HashMap;
import java.util.Map;

/**
 * Archery factory to creates rounds to be played in the archery.
 *
 * @author vijaykumar02
 * @version $Revision: 1.10 $
 */
public class ArcheryRoundFactory implements SportRoundFactory {

	/** 
	 * {@inheritDoc} 
	 */
	@Override
	public Map<String, ArcheryRound> getRounds(final SportSubCategory subCategory) {

		Map<String, ArcheryRound> roundsMap = null;
		if (SportSubCategory.ARCHERY_WATERMELON.equals(subCategory)) {
			roundsMap = createArcheryRounds();
		}
		return roundsMap;
	}

	/**
	 * Creates rounds for ARCHERY_WATERMELON sport.
	 * 
	 * @return Map<String, Round> map of rounds.
	 */
	private Map<String, ArcheryRound> createArcheryRounds() {

		final Map<String, ArcheryRound> roundsMap = new HashMap<String, ArcheryRound>();
		roundsMap.put("r1", new ArcheryRound("r1", "round 1", 1, 2, 10));
		roundsMap.put("r2", new ArcheryRound("r2", "round 2", 1, 2, 10));
		roundsMap.put("r3", new ArcheryRound("r3", "round 3", 1, 2, 10));
		roundsMap.put("r4", new ArcheryRound("r4", "round 4", 1, 2, 10));
		roundsMap.put("r5", new ArcheryRound("r5", "round 5", 1, 2, 10));
		roundsMap.put("r6", new ArcheryRound("r6", "round 6", 1, 2, 10));
		roundsMap.put("r7", new ArcheryRound("r7", "round 7", 1, 2, 10));
		roundsMap.put("r8", new ArcheryRound("r8", "round 8", 1, 2, 10));
		roundsMap.put("r9", new ArcheryRound("r9", "round 9", 1, 2, 10));
		roundsMap.put("r10", new ArcheryRound("r10", "round 10", 1, 3, 30));
		return roundsMap;
	}

}
