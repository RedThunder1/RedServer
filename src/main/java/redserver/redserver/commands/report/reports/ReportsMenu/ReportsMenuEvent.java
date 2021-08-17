package redserver.redserver.commands.report.reports.ReportsMenu;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import redserver.redserver.RedMain;
import redserver.redserver.commands.report.reports.InfoMenu.ReportsInfoMenu;

import java.util.List;
import java.util.UUID;

public class ReportsMenuEvent implements Listener {

    private RedMain plugin;
    public ReportsMenuEvent(RedMain plugin) {this.plugin = plugin;}

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack itemstack = event.getCurrentItem();
        if(itemstack != null && itemstack.getType() != Material.AIR) {
            if (itemstack.hasItemMeta()) {
                if (itemstack.getItemMeta().hasLore()) {
                    List<String> lore = itemstack.getItemMeta().getLore();
                    if (lore.get(3) != null) {
                        String lore3 = lore.get(3).substring(4);
                        if (event.getView().getTitle().equals(ChatColor.RED + "" + ChatColor.BOLD + "Reports Menu")) {
                            if (itemstack.getItemMeta().hasLore()) {
                                //ReportForm reportForms = plugin.getReportManager().getReportFormByID(UUID.fromString(lore3.substring(4)));
                                if(plugin.getReportManager().getReportFormByID(UUID.fromString(lore3.substring(4))) != null) {
                                    ReportsInfoMenu reportsInfo = new ReportsInfoMenu(plugin);
                                    reportsInfo.playereport(lore3, player);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
