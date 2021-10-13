package redserver.redserver.smp.saveloc;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

import redserver.redserver.RedMain;

public class SaveSMPLocation implements Listener{

	@EventHandler
	public void smpLeave(PlayerChangedWorldEvent event) {
		//Should save the players location after leaving the smp world
		World fromWorld = event.getFrom();
		Player player = event.getPlayer();
		if (fromWorld.equals(Bukkit.getWorld("smp"))) {
			Location location = player.getLocation();
			RedMain.get().homeMap.put(player.getUniqueId(), location);
		}
	}
	
	public void onRestart(ServerRestartEvent event)

}
