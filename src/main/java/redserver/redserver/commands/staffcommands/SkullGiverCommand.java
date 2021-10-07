package redserver.redserver.commands.staffcommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import redserver.redserver.utilities.Messages;

public class SkullGiverCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Messages.CONSOLECANTUSE);
            return false;
        }
        Player player = (Player) sender;
        if (!(player.isOp())) {
            sender.sendMessage(Messages.NOPERMS);
            return false;
        }

        if(args.length == 0) {
            player.getInventory().addItem(getPlayerHead(player.getName()));
            return false;
        }

        for (Player p : Bukkit.getOnlinePlayers()) {
            if (args[0].equals(p.getName())) {
                player.getInventory().addItem(getPlayerHead(args[0]));
            }
        }
        return false;
    }

    public ItemStack getPlayerHead(String player) {
        Material type = Material.PLAYER_HEAD;
        ItemStack item = new ItemStack(type, 1);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setOwner(player);
        item.setItemMeta(meta);

        return item;
    }
}
