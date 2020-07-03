package com.assignment.sport.rule.chain;

import com.assignment.sport.category.SportSubCategory;
import com.assignment.sport.pojo.ArcheryAttempt;
import com.assignment.sport.pojo.ArcheryTournament;

/**
 * Concrete implementation of RuleChainBuilder api and responsible to create
 * rule's chain for archery sport.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public class ArcheryRuleChainBuilder implements RuleChainBuilder<ArcheryTournament, ArcheryAttempt> {

	/** 
	 * {@inheritDoc} 
	 */
	@Override
	public AbstractRule<ArcheryTournament, ArcheryAttempt> buildRuleChain(final SportSubCategory sportSubCategory) {

		AbstractRule<ArcheryTournament, ArcheryAttempt> chainRef = null;
		if(SportSubCategory.ARCHERY_WATERMELON.equals(sportSubCategory)) {
			System.out.println("Building Rule chain for Archery watermelon shooting.");
			final AbstractRule<ArcheryTournament, ArcheryAttempt> rule2 = new ArcheryWaterMelonShootRuleTwo(null);
			chainRef = new ArcheryWaterMelonShootRuleOne(rule2);
		}
		return chainRef;
	}

}
