package redserver.redserver.skyblock.commands.SkyblockGUI;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import redserver.redserver.RedMain;
import redserver.redserver.commands.report.manager.ReportForm;

public class SkyblockCreateGUI implements Listener{
	public static void reports(Player player) {
        Inventory inventory = RedMain.get().getServer().createInventory(null, 54, ChatColor.RED + "" + ChatColor.BOLD + "Reports Menu");

        for(ReportForm reportform : RedMain.get().getReportManager().reportForms) {
            //Menu code
        }

        player.openInventory(inventory);
	}
}
	
