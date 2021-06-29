package redserver.redserver;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class onJoin implements Listener {
    private RedMain plugin;
    public onJoin(RedMain plugin) {this.plugin = plugin;}


    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
            event.setJoinMessage(ChatColor.GREEN + "Welcome " + event.getPlayer().toString() + " to the server!");
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        event.setQuitMessage(ChatColor.RED + event.getPlayer().toString() + " has left the server!");
    }


}
