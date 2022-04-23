package redserver.redserver.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import net.md_5.bungee.api.ChatColor;
import redserver.redserver.RedMain;
import redserver.redserver.utilities.ranks.Ranks;

public class ScoreboardCreator {

	public void scoreboard(Player player) {
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		Objective objective = board.registerNewObjective("dummy", ChatColor.RED + "" + ChatColor.BOLD + "Red's Server");
		
		Team rank = board.registerNewTeam("rank");
		String rankPrefix;
		if (RedMain.get().getRanks().containsKey(player.getName())) {
			rankPrefix = RedMain.get().getRankManager().getRank(player).getName();
		}
		
		
		
	}
	
}
