/**
 * 
 */
package com.assignment.sport.rule.chain;

import com.assignment.sport.pojo.ArcheryAttempt;
import com.assignment.sport.pojo.ArcheryRound;
import com.assignment.sport.pojo.ArcheryScorecard;
import com.assignment.sport.pojo.ArcheryTournament;
import com.assignment.sport.pojo.ScorecardHolder;

import java.util.Map;

/**
 * Concrete implementation of Rule2 of Archery Water melon shooting tournament.
 * This rule will be applied for round 10. Which is the special round of the
 * tournament.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public class ArcheryWaterMelonShootRuleOne extends AbstractRule<ArcheryTournament, ArcheryAttempt> {

	/**
	 * ArcheryWaterMelonShootRuleOne Constructor.
	 *
	 * @param rule
	 */
	public ArcheryWaterMelonShootRuleOne(final AbstractRule<ArcheryTournament, ArcheryAttempt> rule) {
		setNext(rule);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void processRule(final ArcheryTournament tournament, final ArcheryAttempt attempt) {
		applyRule(tournament, attempt);
		checkNext(tournament, attempt);
	}

	/**
	 * Apply the rule and update the score card of the player.
	 * 
	 * @param tournament
	 *            tournament object.
	 * @param attempt
	 *            ArcheryAttempt object
	 */
	private void applyRule(final ArcheryTournament tournament, final ArcheryAttempt attempt) {

		// check is a valid round number for rule one
		final ArcheryRound round = tournament.getRounds().get(attempt.getRoundId());
		if (isValidRounNum(attempt) && isValidBowNum(round, attempt)) {

			final ArcheryScorecard scorecard = getScorecard(tournament, attempt, round);
			if (scorecard.getRemainingArrow() >= 1 && round.getMaxNoOfArrow() >= attempt.getBowNumber()) {
				int hits = attempt.getHits();
				int points = hits >= scorecard.remainingTarget() ? scorecard.remainingTarget() : hits;
				scorecard.updatePoint(attempt.getBowNumber(), points);
				scorecard.updateRemainingArrow();
				scorecard.updateRemainingTarget(points);
			}
			tournament.getScorecardHolder().updateScorecard(scorecard);
		}
	}

	/**
	 * validate the bow number for an attempt.
	 * 
	 * @param round
	 * @param attempt
	 * @return boolean flag.
	 */
	private boolean isValidBowNum(final ArcheryRound round, final ArcheryAttempt attempt) {

		return (attempt.getBowNumber() >= round.getMinNoOfArrow() && attempt.getBowNumber() <= round.getMaxNoOfArrow());
	}

	/**
	 * Validate the bow number.
	 * 
	 * @param round
	 * @param attempt
	 * @return boolean
	 */
	private boolean isValidRounNum(final ArcheryAttempt attempt) {
		final int roundNum = Integer.parseInt(attempt.getRoundId().substring(1));
		return (roundNum >= 1 && roundNum <= 9);
	}

	/**
	 * Get current scorecard of a tournament of a player and a round.
	 * 
	 * @param tournament
	 * @param round
	 * @return ArcheryScorecard
	 */
	private ArcheryScorecard getScorecard(final ArcheryTournament tournament, final ArcheryAttempt attempt,
			final ArcheryRound round) {

		ScorecardHolder holder = tournament.getScorecardHolder();
		Map<String, ArcheryScorecard> scorecardMap = holder != null ? holder.getScorecards() : null;
		ArcheryScorecard scorecard = null;
		if (scorecardMap != null) {
			scorecard = scorecardMap.get(getScorecardKey(attempt));
		}
		return scorecard != null ? scorecard
				: new ArcheryScorecard(tournament.getId(), attempt.getPlayerId(), attempt.getRoundId(),
						round.getMaxNoOfArrow(), round.getMaxTarget());
	}

	/**
	 * Creates scorecard key.
	 * 
	 * @param attempt
	 * @return String key
	 */
	private String getScorecardKey(final ArcheryAttempt attempt) {

		return new StringBuilder().append(attempt.getTournamentId()).append(attempt.getPlayerId())
				.append(attempt.getRoundId()).toString();
	}

}
