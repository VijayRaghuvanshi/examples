package com.assignment.sport.pojo;

import com.assignment.sport.api.IArcheryRound;
import com.assignment.sport.api.IArcheryTournament;
import com.assignment.sport.api.ISport;

import java.util.Map;

/**
 * Contains various information for a tournament.
 *
 * @author vijaykumar
 * @version $Revision: 1.10 $
 */
public class ArcheryTournament implements IArcheryTournament {

	/**
	 * Tournament id.
	 */
	private String id;

	/**
	 * Tournament name.
	 */
	private String name;

	/**
	 * Tournament sport
	 */
	private ISport sport;

	/**
	 * Set of player participating in tournament.
	 */
	private Map<String, Player> players;

	/**
	 * rounds.
	 */
	private Map<String, ArcheryRound> rounds;

	/**
	 * Contains the score
	 */
	private ScorecardHolder scorecardHolder;

	/**
	 * Creates a tournament.
	 * 
	 */
	public ArcheryTournament(final String tournamentId, final String tournamentName, final Map<String, Player> players,
			final Map<String, ArcheryRound> rounds, final ScorecardHolder scorecardHolder) {

		this.id = tournamentId;
		this.name = tournamentName;
		this.players = players;
		this.rounds = rounds;
		this.scorecardHolder = scorecardHolder;
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
		ArcheryTournament other = (ArcheryTournament) obj;
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
	public ISport getSport() {

		return this.sport;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Player> getPlayers() {
		return this.players;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, ArcheryRound> getRounds() {
		return this.rounds;
	}

	/** 
	 * {@inheritDoc} 
	 */
	@Override
	public ScorecardHolder getScorecardHolder() {
		 
		return this.scorecardHolder;
	}
}
