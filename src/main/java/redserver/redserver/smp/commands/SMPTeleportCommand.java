package redserver.redserver.smp.commands;

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

public class SMPTeleportCommand implements CommandExecutor {

    private RedMain plugin;
    public SMPTeleportCommand(RedMain plugin) {this.plugin = plugin;}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

        if (!(sender instanceof Player)) {
            sender.sendMessage(Messages.CONSOLECANTUSE);
            return false;
        }
        Player player = (Player) sender;
        World world = player.getWorld();
        if (player.getWorld().getName().equals("smp")) {
            player.sendMessage(ChatColor.RED + "You are already in this World!");
            return false;
        }

        player.teleport(world.getSpawnLocation());
        World smp = Bukkit.getWorld("smp");
        int x = world.getSpawnLocation().getBlockX();
        int y = world.getSpawnLocation().getBlockY();
        int z = world.getSpawnLocation().getBlockZ();
        Location loc = new Location(smp, x, y, z);
        player.teleport(loc);

        return false;
    }
}
