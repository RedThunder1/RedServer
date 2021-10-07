package redserver.redserver.kitpvp;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import redserver.redserver.utilities.Messages;

public class KitPvpTPCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Messages.CONSOLECANTUSE);
            return false;
        }
        Player player = (Player) sender;
        World world = Bukkit.getWorld("kitpvp");
        Location location = new Location(world, 0.5, 9, 0.5);
        if (player.getWorld().equals(world)) {
            player.sendMessage(ChatColor.RED + "You are already in this world!");
            return false;
        }
        player.teleport(location);
        return false;
    }
}
