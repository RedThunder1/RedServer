package redserver.redserver.smp.saveloc;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

import redserver.redserver.RedMain;

public class SaveSMPLocation implements Listener, Runnable {

	public void run() {
		for (Player player : Bukkit.getWorld("smp").getPlayers()) {
			if (RedMain.get().homeMap.containsKey(player.getUniqueId())) {
				RedMain.get().homeMap.replace(player.getUniqueId(), player.getLocation());
			} else {
				RedMain.get().homeMap.put(player.getUniqueId(), player.getLocation());
			}
		}
	}
	
	@EventHandler
	public void smpLeave(PlayerChangedWorldEvent event) {
		//Should save the players location after leaving the smp world
		World fromWorld = event.getFrom();
		Player player = event.getPlayer();
		if (fromWorld.equals(Bukkit.getWorld("smp"))) {
			Location location = player.getLocation();
			if (RedMain.get().homeMap.containsKey(player.getUniqueId())) {
				RedMain.get().homeMap.replace(player.getUniqueId(), location);
			} else {
			RedMain.get().homeMap.put(player.getUniqueId(), location);
			}
		}
	}
}
