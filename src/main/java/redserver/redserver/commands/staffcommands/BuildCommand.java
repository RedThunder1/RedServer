package redserver.redserver.commands.staffcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import org.jetbrains.annotations.NotNull;
import redserver.redserver.RedMain;
import redserver.redserver.utilities.Messages;

import java.util.ArrayList;
import java.util.List;

public class BuildCommand implements CommandExecutor, Listener {

    public static List<Player> build = new ArrayList<>();

    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + Messages.CONSOLECANTUSE);
            return false;
        }

        Player player = (Player) sender;
        if (!(player.isOp())) {
            player.sendMessage(ChatColor.RED + Messages.NOPERMS);
        }

        if (build.contains(player)) {
            build.remove(player);
            player.sendMessage(ChatColor.RED + "Build mode Disabled");
            return false;
        }

        build.add(player);
        player.sendMessage(ChatColor.RED + "Build mode Enabled");
        return false;
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if (build.contains(player)) {
            build.remove(player);
        }
    }
}
