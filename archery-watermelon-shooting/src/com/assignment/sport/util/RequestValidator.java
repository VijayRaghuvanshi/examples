package com.assignment.sport.util;

import com.assignment.sport.pojo.ArcheryAttempt;
import com.assignment.sport.pojo.TournamentRequest;

/**
 * Utility class to validate request.
 *
 * @author vijaykumar02
 * @version $Revision: 1.10 $
 */
public class RequestValidator {

	/**
	 * Validate tournament request.
	 * 
	 * @param req
	 *            TournamentRequest object.
	 * @return boolean
	 */
	public static boolean tournamentRequestValidator(final TournamentRequest req) {

		return (req != null && req.getCategory() != null && req.getSubCategory() != null
				&& (req.getTournamentName() != null && !req.getTournamentName().isEmpty())
				&& (req.getTournamentId() != null && !req.getTournamentId().isEmpty()));

	}

	/**
	 * Validate ArcheryAttempt object data.
	 * 
	 * @param attempt
	 * @return boolean flag
	 */
	public static boolean attemptValidator(final ArcheryAttempt attempt) {

		return (attempt.getTournamentId() != null && !attempt.getTournamentId().isEmpty() && attempt.getBowNumber() > 0
				&& attempt.getPlayerId() != null && !attempt.getPlayerId().isEmpty() && attempt.getRoundId() != null
				&& !attempt.getRoundId().isEmpty());

	}

}
