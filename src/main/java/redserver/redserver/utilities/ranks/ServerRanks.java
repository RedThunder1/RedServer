package redserver.redserver.utilities.ranks;


import java.util.List;
import org.bukkit.entity.Player;
import net.md_5.bungee.api.ChatColor;

public class ServerRanks {
	
	public List<Ranks> ranks;
	public List<FakePlayer> fakePlayers;
	
	public void serverRanks() {
		ranks.add(new Ranks("owner", 4, ChatColor.DARK_RED + "[" + ChatColor.BOLD + "Owner" + ChatColor.RESET + ChatColor.DARK_RED + "] "));
		ranks.add(new Ranks("admin", 3, ChatColor.RED + "[" + ChatColor.BOLD + "Admin" + ChatColor.RESET + ChatColor.RED + "] "));
		ranks.add(new Ranks("mod", 2, ChatColor.GOLD + "[" + ChatColor.BOLD + "Mod" + ChatColor.RESET + ChatColor.GOLD + "] "));
		ranks.add(new Ranks("trial mod", 1, ChatColor.YELLOW + "[" + ChatColor.BOLD + "Trial Mod" + ChatColor.RESET + ChatColor.YELLOW + "] "));
		ranks.add(new Ranks("member", 0, ChatColor.DARK_GRAY + "[" + ChatColor.BOLD + "Member" + ChatColor.RESET + ChatColor.DARK_GRAY + "]"));
	}
	
	public List<Ranks> getPlayerRanks() {
		return ranks;
	}

	public List<Ranks> getRanks() {
		return ranks;
	}

	public Ranks getRankByName(String name) {

		for (Ranks pRanks : ranks) {
			if (pRanks.name.equals(name)) {
				return pRanks;
			}
		}
		return null;
	}
	
	public Ranks getRank(Player player) {
		for (FakePlayer fakePlayer : fakePlayers) {
			if (fakePlayer.getUUID().equals(player.getUniqueId())) {
				return fakePlayer.getPlayerRank();
			}
		}
		return null;
	}
	
	public FakePlayer getFakePlayer(Player player) {
		for (FakePlayer fakePlayer : fakePlayers) {
			if (fakePlayer.getUUID().equals(player.getUniqueId())) {
				return fakePlayer;
			}
		}
		return null;
	}
	public void createFakePlayer(Player player, String rank) {
		fakePlayers.add(new FakePlayer(getRankByName(rank), player.getUniqueId()));
	}
}
