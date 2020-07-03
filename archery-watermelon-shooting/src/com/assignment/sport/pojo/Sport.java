package com.assignment.sport.pojo;

import com.assignment.sport.api.ISport;
import com.assignment.sport.category.SportCategory;
import com.assignment.sport.category.SportSubCategory;

/**
 * Defines archery sport.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public class Sport implements ISport {

	/**
	 * Id. of sport that uniquely identify the sport.
	 */
	private String id;

	/**
	 * name of sport.
	 */
	private String name;

	/**
	 * Category of the game.
	 */
	private SportCategory category;

	/**
	 * sub-category of archery.
	 */
	private SportSubCategory subCategory;

	/**
	 * Constructor to create archery sport.
	 *
	 * @param sportId
	 *            id of the sport.
	 * @param sportName
	 *            name of the sport
	 * @param sportCategory
	 *            sport category
	 * @param sportSubCategory
	 *            sport sub-category
	 */
	public Sport(final String sportId, final String sportName, final SportCategory sportCategory,
			final SportSubCategory sportSubCategory) {
		this.id = sportId;
		this.name = sportName;
		this.subCategory = sportSubCategory;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sport other = (Sport) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/** 
	 * {@inheritDoc} 
	 */
	@Override
	public String getId() {

		return this.id;
	}

	/** 
	 * {@inheritDoc} 
	 */
	@Override
	public String getName() {

		return this.name;
	}

	/** 
	 * {@inheritDoc} 
	 */
	@Override
	public SportCategory category() {

		return this.category;
	}

	/** 
	 * {@inheritDoc} 
	 */
	@Override
	public SportSubCategory getSubCategory() {

		return this.subCategory;
	}

	/** 
	 * {@inheritDoc} 
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Sport [id=").append(id).append(", name=").append(name).append(", category=").append(category)
				.append(", subCategory=").append(subCategory).append("]");
		return builder.toString();
	}

}
