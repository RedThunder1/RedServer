package redserver.redserver.lobby;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GameSelectorMenu {

	public void gameMenu(Player player) {
		Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.AQUA + "" + ChatColor.BOLD + "Games");
        for (int i = 0; i < 54; i++) {
            ItemStack blackGlass = new ItemStack(Material.BLACK_STAINED_GLASS, 1);
            ItemMeta emptyMeta = blackGlass.getItemMeta();
            assert emptyMeta != null;
            emptyMeta.setDisplayName("-");
            blackGlass.setItemMeta(emptyMeta);
            inventory.setItem(i, blackGlass);
        }
        
        ItemStack smp = new ItemStack(Material.GRASS_BLOCK);
        ItemMeta smpMeta = smp.getItemMeta();
        assert smpMeta != null;
        smpMeta.setDisplayName(ChatColor.GREEN + "SMP");
        smp.setItemMeta(smpMeta);
        inventory.setItem(2, smp);
        
        ItemStack duel = new ItemStack(Material.BEDROCK);
        ItemMeta duelMeta = duel.getItemMeta();
        assert duelMeta != null;
        duelMeta.setDisplayName(ChatColor.RED + "(WIP) Duel (WIP)");
        duel.setItemMeta(duelMeta);
        inventory.setItem(4, duel);
        
        ItemStack kitpvp = new ItemStack(Material.BEDROCK);
        ItemMeta kitpvpmeta = kitpvp.getItemMeta();
        assert kitpvpmeta != null;
        kitpvpmeta.setDisplayName(ChatColor.RED + "(WIP) KitPvp (WIP)");
        kitpvp.setItemMeta(kitpvpmeta);
        inventory.setItem(6, kitpvp);
        
        player.openInventory(inventory);
	}
	
}
