/**
 * 
 */
package com.assignment.sport.pojo;

import com.assignment.sport.api.IPlayer;

/**
 * Defines a player.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public class Player implements IPlayer {

	/**
	 * id of a player.
	 */
	private String id;

	/**
	 * player name;
	 */
	private String name;

	/**
	 * player number;
	 */
	private String number;

	/**
	 * player nationality;
	 */
	private String nationality;
	
	/**
	 * Palyer's current tournament id.
	 */
	private String currentTournament;

	/**
	 * Creates a player.
	 *
	 * @param playerId unique id of the player.
	 * @param playerName name of the player.
	 * @param playerNumber number of the player.
	 * @param playerNationality player nationality.
	 * @param currentTournament player's current tournament.
	 */
	public Player(final String playerId, final String playerName, final String playerNumber,
			final String playerNationality, final String currentTournament) {
		this.id = playerId;
		this.name = playerName;
		this.number = playerNumber;
		this.nationality = playerNationality;
		this.currentTournament = currentTournament;
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
	public String getNumber() {
		 return this.number;
	}



	/** 
	 * {@inheritDoc} 
	 */
	@Override
	public String getNationality() {

		return this.nationality;
	}



	@Override
	public String getCurrentTournament() {
		 
		return null;
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
		Player other = (Player) obj;
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
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("ArcheryPlayer [id=").append(id).append(", name=").append(name).append(", number=")
				.append(number).append(", nationality=").append(nationality).append(", currentTournament=")
				.append(currentTournament).append("]");
		return builder.toString();
	}
 

 


	
}
