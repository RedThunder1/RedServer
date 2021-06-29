package redserver.redserver;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class hub implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command!");
            return false;
        }
        Player player = (Player) sender;
        World world = Bukkit.getWorld("world");
        Location location = new Location(world, -125.5, 69, 251.5);

        if (player.getWorld() == world) {
            player.sendMessage(ChatColor.RED + "You are already in this World!");
            return false;
        }

        player.teleport(location);

        return false;
    }
}
