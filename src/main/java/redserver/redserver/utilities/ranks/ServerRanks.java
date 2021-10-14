package redserver.redserver.utilities.ranks;

import java.util.ArrayList;

import net.md_5.bungee.api.ChatColor;

public class ServerRanks {
	
	public ArrayList<Ranks> ranks;
	
	public void serverRanks() {
		ranks.add(new Ranks("owner", 4, ChatColor.DARK_RED + "[" + ChatColor.BOLD + "Owner" + ChatColor.RESET + ChatColor.DARK_RED + "] "));
		ranks.add(new Ranks("admin", 3, ChatColor.RED + "[" + ChatColor.BOLD + "Owner" + ChatColor.RESET + ChatColor.RED + "] "));
		ranks.add(new Ranks("mod", 2, ChatColor.GOLD + "[" + ChatColor.BOLD + "Owner" + ChatColor.RESET + ChatColor.GOLD + "] "));
		ranks.add(new Ranks("trial mod", 1, ChatColor.YELLOW + "[" + ChatColor.BOLD + "Owner" + ChatColor.RESET + ChatColor.YELLOW + "] "));
	}
	
	public ArrayList<Ranks> getRanks() {
		return ranks;
	}
	public Ranks getRank(String name) {
		for (Ranks pranks : ranks) {
			if (pranks.name.equals(name)) {
				return pranks;
			}
		}
		return null;
	}
}
