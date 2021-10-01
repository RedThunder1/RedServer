package redserver.redserver.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import redserver.redserver.RedMain;
import redserver.redserver.utilities.Messages;

public class PVPTPCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        if (!(sender instanceof Player)) {
            sender.sendMessage(Messages.CONSOLECANTUSE);
            return false;
        }
        Player player = (Player) sender;
        World world = Bukkit.getWorld("pvp");
        Location location = new Location(world, -125.5, 69, 249.5);

        if (player.getWorld() == world) {
            player.sendMessage(ChatColor.RED + "You are already in this World!");
            return false;
        }

        player.teleport(location);

        return false;
    }
}
