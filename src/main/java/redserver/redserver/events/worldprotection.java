package redserver.redserver.events;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import redserver.redserver.commands.staffcommands.build;

import java.util.ArrayList;


public class worldprotection implements Listener {

    public static ArrayList<Player> builder = build.build;


    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (player.getWorld() == Bukkit.getWorld("world")) {
            event.setCancelled(true);
            if (builder.contains(player)) {
                event.setCancelled(false);
            }
        }
    }

    @EventHandler
    public void onPlace (BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (player.getWorld() == Bukkit.getWorld("world")) {
            event.setCancelled(true);
            if (builder.contains(player)) {
                event.setCancelled(false);
            }
        }
    }

    @EventHandler
    public void onItemDamage(PlayerItemDamageEvent event) {
        Player player = event.getPlayer();
        if (player.getWorld() == Bukkit.getWorld("world")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void OnDamage(EntityDamageByEntityEvent event) {

        if(event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
            if (event.getDamager().getWorld() == Bukkit.getWorld("world")) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void pickUp(PlayerPickupItemEvent event) {
        Player player = event.getPlayer();
        if (player.getWorld() == Bukkit.getWorld("world")) {
            event.setCancelled(true);
            if (builder.contains(player)) {
                event.setCancelled(false);
            }
        }
    }

    @EventHandler
    public void Mobs(CreatureSpawnEvent event) {
        if (event.getEntity().getWorld() == Bukkit.getWorld("world")) {
            event.setCancelled(true);
        }

    }

    @EventHandler
    public void damage(EntityDamageEvent event) {
        World world = event.getEntity().getWorld();
        if (world == Bukkit.getWorld("world")) {
            event.setCancelled(true);
        }
    }

}
