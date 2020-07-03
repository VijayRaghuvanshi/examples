package com.assignment.sport.rule.chain;

import com.assignment.sport.api.IAttempt;
import com.assignment.sport.api.ITournament;

/**
 * Abstract to define a rule that should be applied to an attempt performed by a
 * player and update his/her score card of accordingly.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public abstract class AbstractRule<T extends ITournament, E extends IAttempt > {

	/**
	 * Reference to next rule to be executed.
	 */
	private AbstractRule<T, E> next;

	/**
	 * Set the next rule to be executed.
	 * 
	 * @param next
	 */
	protected void setNext(final AbstractRule<T, E> next) {
		this.next = next;
	}
	
	/**
	 * Checks if next rule should called or not.
	 * 
	 * @param tournament Tournament refer.
	 */
	protected void checkNext(final T t, final E e) {
		
		if(this.next !=null) {
			this.next.processRule(t, e);
		} 
		
	}

	/**
	 * abstract method to Process a rule for a tournament. The concrete class should
	 * implement the method.
	 * 
	 * @param tournament tournament object
	 * @param scorecard scorecard to be updated.
	 */
	public abstract void processRule(final T t, final E e);

}
