package redserver.redserver.lobby;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

import java.util.Objects;

public class GameSelector implements Listener{
	
	public static ItemStack getGameSelector() {
		ItemStack compass = new ItemStack(Material.COMPASS);
		ItemMeta meta = compass.getItemMeta();
		assert meta != null;
		meta.setDisplayName(ChatColor.GREEN + "Game Selector");
		compass.setItemMeta(meta);
		return compass;
	}
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent event) {
		ItemStack item = event.getItemDrop().getItemStack();
		if (Objects.requireNonNull(item.getItemMeta()).getDisplayName().equals(ChatColor.GREEN + "Game Selector")) {
			event.setCancelled(true);
		}
	}

	
	@EventHandler
	public void onUse(PlayerInteractEvent event) {
		ItemStack item = event.getItem();
		assert item != null;
		if (Objects.requireNonNull(item.getItemMeta()).getDisplayName().equals(ChatColor.GREEN + "Game Selector")) {
			GameSelectorMenu gameSelector = new GameSelectorMenu();
			gameSelector.gameMenu(event.getPlayer());
		}
	}
}
