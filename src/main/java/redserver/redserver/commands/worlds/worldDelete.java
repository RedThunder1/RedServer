package redserver.redserver.commands.worlds;

import org.apache.commons.lang.reflect.FieldUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.FileUtil;
import redserver.redserver.utilities.Messages;

import java.io.File;

public class worldDelete implements CommandExecutor {

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
            player.sendMessage(ChatColor.RED + "Please provide a world to delete!");
            return false;
        }

        String name = args[0];
        if (Bukkit.getWorld(name) == null) {
            player.sendMessage(ChatColor.RED + "That is not a world!");
            return false;
        }

        Bukkit.unloadWorld(name, false);
        Bukkit.getWorld(name).getWorldFolder().delete();
        player.sendMessage(ChatColor.RED + "The world " + name + " was deleted!");

        return false;
    }
}
