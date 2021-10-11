package redserver.redserver.commands.report;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import redserver.redserver.RedMain;

public class PlayerReportGui implements Listener {

    public static void reportGui(Player player,String toReportName) {

        Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.RED + "" + ChatColor.BOLD + "Report Menu");
        for (int i = 0; i < 54; i++) {
            ItemStack blackGlass = new ItemStack(Material.BLACK_STAINED_GLASS, 1);
            ItemMeta emptyMeta = blackGlass.getItemMeta();
            emptyMeta.setDisplayName("-");
            blackGlass.setItemMeta(emptyMeta);
            inventory.setItem(i, blackGlass);
        }

        ItemStack senderName = new ItemStack(Material.REDSTONE_BLOCK, 1);
        ItemMeta senderNameMeta = senderName.getItemMeta();
        senderNameMeta.setDisplayName(player.getName());
        senderName.setItemMeta(senderNameMeta);
        inventory.setItem(1, senderName);

        ItemStack reportName = new ItemStack(Material.REDSTONE_BLOCK, 1);
        ItemMeta reportNameMeta = reportName.getItemMeta();
        reportNameMeta.setDisplayName(toReportName);
        reportName.setItemMeta(reportNameMeta);
        inventory.setItem(0, reportName);

        ItemStack cheating = new ItemStack(Material.REDSTONE_BLOCK, 1);
        ItemMeta cheatingMeta = cheating.getItemMeta();
        cheatingMeta.setDisplayName(ChatColor.RED + "Cheating/Hacking");
        cheating.setItemMeta(cheatingMeta);
        inventory.setItem(22, cheating);

        ItemStack Harassment = new ItemStack(Material.REDSTONE, 1);
        ItemMeta harassmentMeta = Harassment.getItemMeta();
        harassmentMeta.setDisplayName(ChatColor.RED + "Harassment / Threats");
        Harassment.setItemMeta(harassmentMeta);
        inventory.setItem(24, Harassment);

        ItemStack swearing = new ItemStack(Material.INK_SAC, 1);
        ItemMeta swearingMeta = swearing.getItemMeta();
        swearingMeta.setDisplayName(ChatColor.RED + "Swearing / Inappropriate topics");
        swearing.setItemMeta(swearingMeta);
        inventory.setItem(20, swearing);

        player.openInventory(inventory);
    }

}
