package redserver.redserver.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import redserver.redserver.RedMain;
import redserver.redserver.scoreboard.ScoreboardCreator;
import redserver.redserver.utilities.ranks.FakePlayer;

public class PlayerJoinActions implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();

		if (!(player.hasPlayedBefore())) {
			event.setJoinMessage(ChatColor.GREEN + "Welcome " + player.getName() + " to the server!");
		} else {
			event.setJoinMessage(ChatColor.GREEN + player.getName() + " has joined the server for the first time!");
		}

		/*
		if (!(RedMain.get().ranks.containsKey(player.getName()))) {
			RedMain.get().rankManager.createFakePlayer(player, "member");
			RedMain.get().ranks.put(player.getName(), "member");
		}
		 */

		World world = Bukkit.getWorld("world");
		Location location = new Location(world, -125.5, 70, 249.5);
		player.teleport(location);
		player.setHealth(20);
		player.setPlayerListName(RedMain.get().rankManager.getRank(player).getName() + " " + player.getName());
		ScoreboardCreator scoreboard = new ScoreboardCreator();
		scoreboard.scoreboard(player);
	}

	@EventHandler
	public void onLeave(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		event.setQuitMessage(ChatColor.RED + "" + player.getName() + " has left the server!");
	}

	@EventHandler
	public void onDeath(PlayerDeathEvent event) {
		Player player = event.getEntity();
		World world = Bukkit.getWorld("world");
		Location location = new Location(world, -125.5, 70, 249.5);
		if (player.getWorld() == Bukkit.getWorld("world")) {
			player.teleport(location);
		}
	}

}
