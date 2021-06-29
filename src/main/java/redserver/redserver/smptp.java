package redserver.redserver;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class smptp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command!");
            return false;
        }
        Player player = (Player) sender;
        if (args.length == 0) {
            player.sendMessage(ChatColor.RED + "Please enter a world to teleport to!");
            return false;
        }


        World world = Bukkit.getWorld("smp");
        Location location = new Location(world, 0.5, 77, 0.5);

        if (player.getWorld() == world) {
            player.sendMessage(ChatColor.RED + "You are already in this World!");
            return false;
        }

        player.teleport(location);

        return false;
    }
}
