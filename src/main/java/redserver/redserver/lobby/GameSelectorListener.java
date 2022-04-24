package redserver.redserver.lobby;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class GameSelectorListener implements Listener {

	
	@EventHandler
	public void invClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		ItemStack item = event.getCurrentItem();
		if (event.getView().getTitle().equals(ChatColor.AQUA + "" + ChatColor.BOLD + "Games")) {
			assert item != null;
			if (Objects.requireNonNull(item.getItemMeta()).getDisplayName().equals(ChatColor.GREEN + "SMP")) {
				player.performCommand("smp");
				event.setCancelled(true);
			} else if (item.getItemMeta().getDisplayName().equals(ChatColor.RED + "(WIP) Duel (WIP)")) {
				player.sendMessage(ChatColor.RED + "Unfortunately these game are not finished yet! \nIn our discord you can see updates on the server!");
				event.setCancelled(true);
			} else {
				event.setCancelled(true);
			}
		}
	}
	
}
