package redserver.redserver.kitpvp.kitpvpmenu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitPvpMenu {

    public static void kitpvpMenu(Player player) {
        //Inventory inventory = RedMain.get().getServer().createInventory(null, 54, ChatColor.BLUE + "" + ChatColor.BOLD + "Kit Menu");
        Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.BLUE + "" + ChatColor.BOLD + "Kit Menu");


        ItemStack ironkit = new ItemStack(Material.IRON_CHESTPLATE);
        ItemMeta ironkitmeta = ironkit.getItemMeta();
        ironkitmeta.setDisplayName("Iron Kit");
        ironkit.setItemMeta(ironkitmeta);
        inventory.setItem(0, ironkit);

        player.openInventory(inventory);
    }

}
