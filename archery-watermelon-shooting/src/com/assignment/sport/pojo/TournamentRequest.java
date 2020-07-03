package com.assignment.sport.pojo;

import com.assignment.sport.category.SportCategory;
import com.assignment.sport.category.SportSubCategory;

public class TournamentRequest {
	
	private SportCategory category;
	
	private SportSubCategory subCategory;
	
	private String tournamentId;
	
	private String tournamentName;
	
	
	/**
	 * 
	 * Getter of {@link #category}.
	 * 
	 * @return {@link #category}
	 */
	public SportCategory getCategory() {
		return category;
	}
	/**
	 * 
	 * Setter of {@link #category}.
	 * 
	 * @param category 
	 *            to be set
	 */
	public void setCategory(SportCategory category) {
		this.category = category;
	}
	/**
	 * 
	 * Getter of {@link #subCategory}.
	 * 
	 * @return {@link #subCategory}
	 */
	public SportSubCategory getSubCategory() {
		return subCategory;
	}
	/**
	 * 
	 * Setter of {@link #subCategory}.
	 * 
	 * @param subCategory 
	 *            to be set
	 */
	public void setSubCategory(SportSubCategory subCategory) {
		this.subCategory = subCategory;
	}
	/**
	 * 
	 * Getter of {@link #tournamentId}.
	 * 
	 * @return {@link #tournamentId}
	 */
	public String getTournamentId() {
		return tournamentId;
	}
	/**
	 * 
	 * Setter of {@link #tournamentId}.
	 * 
	 * @param tournamentId 
	 *            to be set
	 */
	public void setTournamentId(String tournamentId) {
		this.tournamentId = tournamentId;
	}
	/**
	 * 
	 * Getter of {@link #tournamentName}.
	 * 
	 * @return {@link #tournamentName}
	 */
	public String getTournamentName() {
		return tournamentName;
	}
	/**
	 * 
	 * Setter of {@link #tournamentName}.
	 * 
	 * @param tournamentName 
	 *            to be set
	 */
	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}
	
}
