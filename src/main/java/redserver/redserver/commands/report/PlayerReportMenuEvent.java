package redserver.redserver.commands.report;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import redserver.redserver.RedMain;
import redserver.redserver.commands.report.manager.ReportForm;

import java.util.UUID;

public class PlayerReportMenuEvent implements Listener {

    private RedMain plugin;
    public PlayerReportMenuEvent(RedMain plugin) {this.plugin = plugin;}


    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();
        Inventory openedInventory = event.getInventory();
        ItemStack itemstack = event.getCurrentItem();


        if (event.getView().getTitle().equals(ChatColor.RED + "" + ChatColor.BOLD + "Report Menu")) {
            event.setCancelled(true);
            String toReportName = openedInventory.getItem(0).getItemMeta().getDisplayName();
            String senderName = openedInventory.getItem(1).getItemMeta().getDisplayName();
            Player toReport = plugin.getServer().getPlayer(toReportName);


            if (itemstack.hasItemMeta()) {
                if (itemstack.getItemMeta().getDisplayName().equals(ChatColor.RED + "Cheating/Hacking")) {

                    for (Player p: Bukkit.getOnlinePlayers()) {
                        if (p.isOp()) {
                            p.sendMessage(ChatColor.RED + "[!] " + ChatColor.YELLOW + senderName + " has reported " + ChatColor.RED + "" + toReport.getName() + " for Cheating / Hacking!");
                        }
                    }

                    String reason = "Cheating / Hacking";

                    RedMain.get().getReportManager().addReport(new ReportForm(senderName, toReportName, reason, UUID.randomUUID()));

                    player.closeInventory();
                } else if (itemstack.getItemMeta().getDisplayName().equals(ChatColor.RED + "Harassment / Threats")) {

                    for (Player p: Bukkit.getOnlinePlayers()) {
                        if (p.isOp()) {
                            p.sendMessage(ChatColor.RED + "[!] " + ChatColor.YELLOW + senderName + " has reported " + ChatColor.RED + "" + toReport.getName() + " for Harassment / Threats!");
                        }
                    }
                    String reason = "Harassment / Threats";

                    RedMain.get().getReportManager().addReport(new ReportForm(senderName, toReportName, reason, UUID.randomUUID()));
                    player.closeInventory();
                } else if (itemstack.getItemMeta().getDisplayName().equals(ChatColor.RED + "Swearing / Inappropriate topics")) {
                    for (Player p: Bukkit.getOnlinePlayers()) {
                        if (p.isOp()) {
                            p.sendMessage(ChatColor.RED + "[!] " + ChatColor.YELLOW + senderName + " has reported " + ChatColor.RED + "" + toReport.getName() + " for Swearing / Inappropriate topics!");

                        }
                    }
                    String reason = "Swearing / Inappropriate Topics";

                    RedMain.get().getReportManager().addReport(new ReportForm(senderName, toReportName, reason, UUID.randomUUID()));

                    player.closeInventory();
                }
            }
        }
    }
}
