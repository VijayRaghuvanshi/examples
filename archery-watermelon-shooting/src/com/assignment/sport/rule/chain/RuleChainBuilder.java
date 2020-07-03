package com.assignment.sport.rule.chain;

import com.assignment.sport.api.IAttempt;
import com.assignment.sport.api.ITournament;
import com.assignment.sport.category.SportSubCategory;

/**
 * Generic api to build a rule chain and return its reference to caller.
 * SportCategory is used, in order to identify which rule's chain needs to be
 * built. The chain needs to be executed for a player's attempt performed in a
 * round of a tournament based the sport category passed in. in.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public interface RuleChainBuilder<T extends ITournament, E extends IAttempt > {

	/**
	 * Api responsible to build a chain and return the reference to chain.
	 * 
	 * @param sportSubCategory
	 *            sports sub-category
	 * @return AbstractRule<T, E> first object of the chain.
	 */
	public AbstractRule<T, E> buildRuleChain(SportSubCategory sportSubCategory);

}
