package redserver.redserver.commands.worlds;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import redserver.redserver.utilities.Messages;

public class worldCreate implements CommandExecutor {

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
            player.sendMessage(ChatColor.RED + "Please provide a name and a world type like Normal, Flat, ");
            return false;
        }

        if (args[1] == null) {
            player.sendMessage(ChatColor.RED + "Please provide a name for the world!");
            return false;
        }

        String name = args[0].toLowerCase();
        String type = args[1].toLowerCase();
        WorldCreator wc = new WorldCreator(name);

        if (type == "normal") {

            wc.environment(World.Environment.NORMAL);
            wc.type(WorldType.NORMAL);
            wc.createWorld();

            return false;

        } else if (type == "flat") {

            wc.environment(World.Environment.NORMAL);
            wc.type(WorldType.FLAT);
            wc.createWorld();

            return false;

        } else {
            player.sendMessage(ChatColor.RED + "World types can only be Normal or Flat.");
        }

        return false;
    }
}
