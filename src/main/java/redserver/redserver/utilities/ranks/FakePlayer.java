package redserver.redserver.utilities.ranks;

import java.util.UUID;

public class FakePlayer {

	private Ranks rank;
	private final UUID uuid;
	
	public FakePlayer(Ranks rank, UUID uuid) {
		this.rank = rank;
		this.uuid = uuid;
	}
	
	public Ranks getPlayerRank() { return rank; }
	
	public void setRank(Ranks ranks) { this.rank = ranks; }
	
	public UUID getUUID() { return uuid; }
}
