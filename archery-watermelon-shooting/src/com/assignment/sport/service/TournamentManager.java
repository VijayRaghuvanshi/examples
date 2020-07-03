package com.assignment.sport.service;

import com.assignment.sport.api.IAttempt;
import com.assignment.sport.api.ITournament;
import com.assignment.sport.pojo.ScorecardHolder;

/**
 * Api to manage a tournament of a sport. Provide various operations like create
 * a tournament, get a tournament, update scorecard in the tournament and return
 * the compelete scorecard of a tournament.
 *
 * @author vijaykumar02
 * @version $Revision: 1.10 $
 */
public interface TournamentManager<T extends ITournament, E extends IAttempt> {

	/**
	 * Create a new tournament.
	 * 
	 * @param t generic tournament object.
	 * @return boolean 
	 */
	public boolean addTournament(T t);

 
	/**
	 * Returns a tournament.
	 * 
	 * @param tournamentId
	 * @return T tournament object
	 */
	public T getTournament(String tournamentId);

	/**
	 * Update a scorecard of a tournament.
	 * 
	 * @param e scorecard to be updated.
	 * @return boolean flag.
	 */
	public boolean updateScorecard(E e);

	/**
	 * Fetch a a complete scorecard of a tournament.
	 * 
	 * @param tournamentId tournament Id
	 * @return ScorecardHolder contains scores.
	 */
	public ScorecardHolder getScorecard(final String tournamentId);

}
