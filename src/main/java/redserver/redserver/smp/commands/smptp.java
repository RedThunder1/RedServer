package redserver.redserver.smp.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import redserver.redserver.RedMain;
import redserver.redserver.utilities.Messages;

public class smptp implements CommandExecutor {

    private RedMain plugin;
    public smptp(RedMain plugin) {this.plugin = plugin;}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

        if (!(sender instanceof Player)) {
            sender.sendMessage(Messages.CONSOLECANTUSE);
            return false;
        }
        Player player = (Player) sender;
        World world = player.getWorld();
        if (player.getWorld().getName() == "smp") {
            player.sendMessage(ChatColor.RED + "You are already in this World!");
            return false;
        }

        player.teleport(world.getSpawnLocation());

        plugin.getServer().dispatchCommand(console, "mv tp " + player.getName() + " smp");

        return false;
    }
}
