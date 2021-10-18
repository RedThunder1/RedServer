package redserver.redserver.utilities.ranks;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class ServerRanks {
	
	public ArrayList<Ranks> ranks;
	public ArrayList<FakePlayer> fakePlayers;
	
	public void serverRanks() {
		ranks.add(new Ranks("owner", 4, ChatColor.DARK_RED + "[" + ChatColor.BOLD + "Owner" + ChatColor.RESET + ChatColor.DARK_RED + "] "));
		ranks.add(new Ranks("admin", 3, ChatColor.RED + "[" + ChatColor.BOLD + "Owner" + ChatColor.RESET + ChatColor.RED + "] "));
		ranks.add(new Ranks("mod", 2, ChatColor.GOLD + "[" + ChatColor.BOLD + "Owner" + ChatColor.RESET + ChatColor.GOLD + "] "));
		ranks.add(new Ranks("trial mod", 1, ChatColor.YELLOW + "[" + ChatColor.BOLD + "Owner" + ChatColor.RESET + ChatColor.YELLOW + "] "));
		ranks.add(new Ranks("Member", 0, ChatColor.DARK_GRAY + "[" + ChatColor.BOLD + "Member" + ChatColor.RESET + ChatColor.DARK_GRAY + "]"));
	}
	
	public ArrayList<Ranks> getRanks() {
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
	
	public FakePlayer getRank(Player player) {
		for (FakePlayer fakePlayer : fakePlayers) {
			if (fakePlayer.getUUID().equals(player.getUniqueId())) {
				return fakePlayer;
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
}
