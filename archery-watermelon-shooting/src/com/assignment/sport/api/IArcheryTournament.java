package com.assignment.sport.api;

import com.assignment.sport.pojo.ArcheryRound;
import com.assignment.sport.pojo.ScorecardHolder;

import java.util.Map;

/**
 * API to provide archery tournament information.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public interface IArcheryTournament extends ITournament {

	/**
	 * Get rounds to be played in Archery tournament.
	 * 
	 * @return IArcheryRound
	 */
	Map<String, ArcheryRound> getRounds();

	/**
	 * Returns score card holder.
	 * 
	 * @return ScorecardHolder ScorecardHolder object.
	 */
	ScorecardHolder getScorecardHolder();

}
