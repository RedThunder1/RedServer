package redserver.redserver.commands.report;



import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import redserver.redserver.RedMain;

public class PlayerReportGui implements Listener {

    private RedMain plugin;
    public PlayerReportGui(RedMain plugin) {
        this.plugin = plugin;
    }

    public void reportGui(Player player,String toReportName) {

        Inventory inventory = plugin.getServer().createInventory(null, 54, ChatColor.RED + "" + ChatColor.BOLD + "Report Menu");
        for (int i = 0; i < 54; i++) {
            ItemStack blackGlass = new ItemStack(Material.GRAY_STAINED_GLASS, 1, (byte) 15);
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

        ItemStack swearing = new ItemStack(Material.INK_SAC, 1, (byte) 1);
        ItemMeta swearingMeta = swearing.getItemMeta();
        swearingMeta.setDisplayName(ChatColor.RED + "Swearing / Inappropriate topics");
        swearing.setItemMeta(swearingMeta);
        inventory.setItem(20, swearing);

        player.openInventory(inventory);
    }

}
