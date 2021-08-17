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

public class onJoinEvent implements Listener {
    private RedMain plugin;
    public onJoinEvent(RedMain plugin) {this.plugin = plugin;}

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(ChatColor.GREEN + "Welcome " + player.getName() + " to the server!");
        World world = Bukkit.getWorld("world");
        Location location = new Location(world, -125.5, 70, 249.5);
        player.teleport(location);
        player.setHealth(20);
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
