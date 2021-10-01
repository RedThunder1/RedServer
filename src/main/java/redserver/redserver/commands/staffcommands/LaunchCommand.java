package redserver.redserver.commands.staffcommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import redserver.redserver.utilities.Messages;

public class LaunchCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("launch")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(Messages.CONSOLECANTUSE);
                return false;
            }
            Player player = (Player) sender;
            if (!(player.isOp())) {
                sender.sendMessage(Messages.NOPERMS);
                return false;
            }
            if (args.length == 0) {
                player.sendMessage(ChatColor.BLUE + "ZOOOOOOOOOOOM!");
                player.setVelocity(player.getLocation().getDirection().multiply(2).setY(2));
                return false;
            }
            Player player1 = Bukkit.getPlayer(args[0]);
            sender.sendMessage(ChatColor.BLUE + "You Launched " + player1.getName() + "!");
            player1.setVelocity(player1.getLocation().getDirection().multiply(2).setY(2));
        }
        return false;
    }
}
