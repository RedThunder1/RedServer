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

public class CreateWorldCommand implements CommandExecutor {

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

        switch (type) {
            case "normal":
                wc.environment(World.Environment.NORMAL);
                wc.type(WorldType.NORMAL);
                wc.createWorld();
                player.sendMessage(ChatColor.GREEN + "You have created a new normal world named " + name + "!");
                break;
            case "flat":
                wc.environment(World.Environment.NORMAL);
                wc.type(WorldType.FLAT);
                wc.createWorld();
                player.sendMessage(ChatColor.GREEN + "You have created a new flat world named " + name + "!");
                break;
            case "void":
                wc.generator(new EmptyChunkGenerator());
                wc.createWorld();
                player.sendMessage(ChatColor.GREEN + "You have created a new empty world named " + name + "!");
                break;
            default:
                player.sendMessage(ChatColor.RED + "World types can only be normal or flat!");
                break;
        }
        return false;
    }
}
