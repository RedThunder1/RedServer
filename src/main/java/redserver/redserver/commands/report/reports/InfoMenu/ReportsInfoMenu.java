package redserver.redserver.commands.report.reports.InfoMenu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import redserver.redserver.RedMain;
import redserver.redserver.commands.report.Manager.ReportForm;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ReportsInfoMenu implements Listener {

    private RedMain plugin;
    public ReportsInfoMenu(RedMain plugin) { this.plugin = plugin; }



    public void playereport(String lore3, Player player) {

        ReportForm reportForms = plugin.getReportManager().getReportFormByID(UUID.fromString(lore3.substring(4)));

        Inventory reports = Bukkit.createInventory(null, 54, ChatColor.RED + "Player Report!");

        ItemStack reporter = new ItemStack(Material.EMERALD_BLOCK);
        ItemMeta reporterItemMeta = reporter.getItemMeta();
        reporterItemMeta.setDisplayName(ChatColor.GREEN + reportForms.getReporterName());
        reporter.setItemMeta(reporterItemMeta);
        reports.setItem(11, reporter);

        ItemStack reported = new ItemStack(Material.REDSTONE_BLOCK);
        ItemMeta reportedMeta = reported.getItemMeta();
        reportedMeta.setDisplayName(ChatColor.RED + reportForms.getReportedName());
        reported.setItemMeta(reportedMeta);
        reports.setItem(13, reported);

        ItemStack reason = new ItemStack(Material.GOLD_BLOCK);
        ItemMeta reasonMeta = reason.getItemMeta();
        reasonMeta.setDisplayName(ChatColor.GOLD + reportForms.getReason());
        reason.setItemMeta(reasonMeta);
        reports.setItem(15, reason);

        ItemStack accept = new ItemStack(Material.EMERALD);
        ItemMeta acceptMeta = accept.getItemMeta();
        acceptMeta.setDisplayName(ChatColor.GREEN + "Accept!");
        accept.setItemMeta(acceptMeta);
        reports.setItem(30, accept);

        ItemStack decline = new ItemStack(Material.BARRIER);
        ItemMeta declineMeta= decline.getItemMeta();
        declineMeta.setDisplayName(ChatColor.RED + "Decline!");
        decline.setItemMeta(declineMeta);
        reports.setItem(32, decline);

        plugin.getLogger().info(lore3);


        ItemStack id = new ItemStack(Material.WHITE_WOOL);
        ItemMeta idMeta = id.getItemMeta();
        idMeta.setDisplayName(ChatColor.BLUE + "ID");
        List<String> itemlore = new ArrayList<>();
        itemlore.add(lore3);
        idMeta.setLore(itemlore);
        id.setItemMeta(idMeta);
        reports.setItem(0, id);

        player.openInventory(reports);
    }

    @EventHandler
    public void InventoryClickEvent(InventoryClickEvent event) {
        ItemStack item = event.getCurrentItem();
        Inventory inv = event.getClickedInventory();
        //if (event.getClickedInventory().get)

        if (inv.equals(ChatColor.RED + "Player Report!")) {
            if (item != null || item.getType() != Material.AIR) {
                event.setCancelled(true);
            }
        }
    }
}
