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
            player.sendMessage(ChatColor.RED + "Please specify a player to get the skull of!");
            return false;
        }

        for (Player p : Bukkit.getOnlinePlayers()) {
            if (args[0].equals(p.getName())) {
                ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
                SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
                skullMeta.setOwningPlayer(p);

                p.getInventory().addItem(skull);
            }
        }
        return false;
    }

}
