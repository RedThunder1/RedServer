package redserver.redserver.smp.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HomeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command!");
            return false;
        }
        Player player = (Player) sender;
        World world = Bukkit.getWorld("smp");

        if (!(player.getWorld() == world || player.getWorld() == Bukkit.getWorld("world_nether") || player.getWorld() == Bukkit.getWorld("world_end"))) {
            player.sendMessage(ChatColor.RED + "This command can only be used in the smp world!!");
            return false;
        }
        if (player.getBedSpawnLocation() == null) {
            player.sendMessage(ChatColor.RED + "You dont have a bed spawn yet!");
        }
        Location location1 = player.getBedSpawnLocation();
        player.teleport(location1);

        return false;
    }
}
