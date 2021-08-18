package redserver.redserver.commands.worlds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import redserver.redserver.utilities.Messages;

public class worldTP implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(Messages.CONSOLECANTUSE);
            return false;
        }

        Player player = (Player) sender;
        if (!(player.isOp())) {
            player.sendMessage(Messages.NOPERMS);
            return false;
        }

        if (args == null) {
            player.sendMessage(ChatColor.RED + "Please provide a world to teleport to!");
            return false;
        }

        String w = args[0];
        if (Bukkit.getWorld(w) == null) {
            player.sendMessage(ChatColor.RED + "That is not a available world!");
            return false;
        }

        if (args[1] != null) {
            String p = args[1];
            if (Bukkit.getPlayer(p) != null) {
                World world = Bukkit.getWorld(w);
                Player player1 = Bukkit.getPlayer(p);
                int x = world.getSpawnLocation().getBlockX();
                int y = world.getSpawnLocation().getBlockY();
                int z = world.getSpawnLocation().getBlockZ();
                Location loc = new Location(world, x, y, z);
                player1.teleport(loc);

                return false;

            } else {
                player.sendMessage(ChatColor.RED + "That is not an online player!");
            }
            return false;
        }

        World world = Bukkit.getWorld(w);
        int x = world.getSpawnLocation().getBlockX();
        int y = world.getSpawnLocation().getBlockY();
        int z = world.getSpawnLocation().getBlockZ();
        Location loc = new Location(world, x, y, z);
        player.teleport(loc);

        return false;
    }
}
