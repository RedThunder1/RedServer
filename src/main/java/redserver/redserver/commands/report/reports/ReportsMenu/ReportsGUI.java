package redserver.redserver.commands.report.reports.ReportsMenu;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import redserver.redserver.RedMain;
import redserver.redserver.commands.report.Manager.ReportForm;

import java.util.ArrayList;
import java.util.List;

public class ReportsGUI implements Listener {

    private RedMain plugin;
    public ReportsGUI(RedMain plugin) { this.plugin = plugin; }
    private String id;

    public void Reports(Player player) {
        Inventory inventory = plugin.getServer().createInventory(null, 54, ChatColor.RED + "" + ChatColor.BOLD + "Reports Menu");

        for(ReportForm reportform : RedMain.get().getReportManager().reportForms) {
            ItemStack itemStack = new ItemStack(Material.REDSTONE_BLOCK);
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Player Report!");
            List<String> lore = new ArrayList<>();
            lore.add("Reporter: " + reportform.getReporterName());
            lore.add("Reported: " + reportform.getReportedName());
            lore.add("Reason: " + reportform.getReason());
            lore.add("ID: " + reportform.getReportId());
            itemMeta.setLore(lore);
            itemStack.setItemMeta(itemMeta);
            inventory.addItem(itemStack);
        }

        player.openInventory(inventory);
    }
}
