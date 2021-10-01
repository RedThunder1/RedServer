package redserver.redserver.smp.commands;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import redserver.redserver.RedMain;
import redserver.redserver.utilities.Messages;

public class SMPTeleportCommand implements CommandExecutor {
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
        Location loc = new Location(smp, 0, 77, 0);
        if (player.getGameMode() == GameMode.ADVENTURE) {
            player.setGameMode(GameMode.SURVIVAL);
        }
        player.teleport(loc);

        return false;
    }
}
