package com.assignment.sport.service.impl;

import com.assignment.sport.category.SportSubCategory;
import com.assignment.sport.pojo.ArcheryAttempt;
import com.assignment.sport.pojo.ArcheryScorecard;
import com.assignment.sport.pojo.ArcheryTournament;
import com.assignment.sport.pojo.ScorecardHolder;
import com.assignment.sport.rule.chain.AbstractRule;
import com.assignment.sport.rule.chain.ArcheryRuleChainBuilder;
import com.assignment.sport.service.TournamentManager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Archery tournament manager.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public class ArcheryTournamentManager implements TournamentManager<ArcheryTournament, ArcheryAttempt> {

	/**
	 * Tournament holder.
	 */
	private static Map<String, ArcheryTournament> tournamentHolder = new ConcurrentHashMap<>();

	/**
	 * Chain of rules holder.
	 */
	private static Map<String, AbstractRule<ArcheryTournament, ArcheryAttempt>> ruleChainHolder = new ConcurrentHashMap<>();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addTournament(final ArcheryTournament tournament) {

		boolean flag = false;
		if (tournamentHolder.containsKey(tournament.getId())) {
			System.out.println("Tournament already created. Invalid request.");
		} else {
			tournamentHolder.put(tournament.getId(), tournament);
			final AbstractRule<ArcheryTournament, ArcheryAttempt> ruleChain = new ArcheryRuleChainBuilder()
					.buildRuleChain(SportSubCategory.ARCHERY_WATERMELON);
			ruleChainHolder.put(tournament.getId(), ruleChain);
			flag = true;
		}
		return flag;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArcheryTournament getTournament(final String tournamentId) {

		return tournamentHolder.get(tournamentId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public  boolean updateScorecard(final ArcheryAttempt attempt) {
		
		final String tournamentId = attempt.getTournamentId();
		final ArcheryTournament tournament = tournamentHolder.get(tournamentId);
		boolean flag = false;
		if(tournament!=null ) {
		final AbstractRule<ArcheryTournament, ArcheryAttempt> ruleChain = ruleChainHolder.get(tournamentId);
		synchronized (tournament) {
			ruleChain.processRule(tournament, attempt);	
		}
		flag = true;
		}else {
			System.out.println("There is no tournament available for this attempt: "+ attempt);
		}
		return flag;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ScorecardHolder getScorecard(final String tournamentId) {
		ScorecardHolder scorecardHolder = null;
		if (tournamentHolder.containsKey(tournamentId)) {
			scorecardHolder = tournamentHolder.get(tournamentId).getScorecardHolder();
		}
		return scorecardHolder;
	}

}
