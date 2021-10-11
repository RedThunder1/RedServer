package redserver.redserver.kitpvp.kitpvpmenu;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import redserver.redserver.kitpvp.Kits;

public class KitPvpMenuAction implements Listener {

    @EventHandler
    public void onClickEvent(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Inventory openedInventory = event.getInventory();
        ItemStack itemstack = event.getCurrentItem();

        if (openedInventory.equals(ChatColor.BLUE + "" + ChatColor.BOLD + "Kit Menu")) {
            if (itemstack.getItemMeta().getDisplayName().equals("Iron Kit")) {
                //give player kit
                for (ItemStack item : Kits.IronKit()) {
                    if (item.getType().equals(Material.IRON_HELMET)) {
                        player.getInventory().setHelmet(item);
                    } else if (item.getType().equals(Material.IRON_CHESTPLATE)) {
                        player.getInventory().setChestplate(item);
                    } else if (item.getType().equals(Material.IRON_LEGGINGS)) {
                        player.getInventory().setLeggings(item);
                    } else if (item.getType().equals(Material.IRON_BOOTS)) {
                        player.getInventory().setBoots(item);
                    } else {
                        player.getInventory().setItem(player.getInventory().firstEmpty(), item);
                    }
                }
                event.setCancelled(true);
                player.closeInventory();
            }
        }
    }

}
