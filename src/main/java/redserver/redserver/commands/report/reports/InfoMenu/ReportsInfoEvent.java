package redserver.redserver.commands.report.reports.InfoMenu;

import redserver.redserver.RedMain;
import redserver.redserver.commands.report.manager.ReportForm;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class ReportsInfoEvent implements Listener {

    @EventHandler
    public void invClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack item = event.getCurrentItem();
        Inventory inv = event.getClickedInventory();

        if (event.getView().getTitle().equals(ChatColor.RED + "Player Report!")) {
            String id = ChatColor.stripColor(inv.getItem(0).getItemMeta().getLore().toString().substring(4));
            ReportForm reportForms = RedMain.get().getReportManager().getReportFormByID(UUID.fromString(ChatColor.stripColor(id.substring(4))));
            if (item != null && item.getType() != Material.AIR) {
                if (item.hasItemMeta()) {
                    if (item.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Accept!")) {
                        RedMain.get().getReportManager().removeReport(new ReportForm(reportForms.getReporterName(), reportForms.getReporterName(), reportForms.getReason(), reportForms.getReportId()));

                    }
                }
            }
        }
    }
}
