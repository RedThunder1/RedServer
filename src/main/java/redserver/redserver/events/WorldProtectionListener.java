package redserver.redserver.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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
import redserver.redserver.commands.staffcommands.BuildCommand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorldProtectionListener implements Listener {

    private static List<Player> builder = BuildCommand.build;
    private static final List<String> worlds = new ArrayList<>(Arrays.asList("world", "kitpvp"));

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        World world = event.getBlock().getWorld();
        for (String s : worlds) {
            if (world.equals(Bukkit.getWorld(s))) {
                if (!(builder.contains(player))) {
                    player.sendMessage(ChatColor.RED + "You can't break that block!");
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onPlace (BlockPlaceEvent event) {
        Player player = event.getPlayer();
        World world = event.getBlock().getWorld();
        for (String s : worlds) {
            if (world.equals(Bukkit.getWorld(s))) {
                if (!(builder.contains(player))) {
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onItemDamage(PlayerItemDamageEvent event) {
        World world = event.getPlayer().getWorld();
        for (String s : worlds) {
            if (world.equals(Bukkit.getWorld(s))) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void entityDamageByEntity(EntityDamageByEntityEvent event) {
        if(event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
            if (event.getDamager().getWorld() == Bukkit.getWorld("world")) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void pickUp(PlayerPickupItemEvent event) {
        World world = event.getPlayer().getWorld();
        for (String s : worlds) {
            if (world.equals(Bukkit.getWorld(s))) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void creatureSpawnEvent(CreatureSpawnEvent event) {
        World world = event.getEntity().getWorld();
        for (String s : worlds) {
            if (world.equals(Bukkit.getWorld(s))) {
                event.setCancelled(true);
            }
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