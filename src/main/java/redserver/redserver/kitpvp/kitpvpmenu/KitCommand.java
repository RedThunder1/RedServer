package redserver.redserver.kitpvp.kitpvpmenu;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import redserver.redserver.utilities.Messages;

public class KitCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(Messages.CONSOLECANTUSE);
            return false;
        }
        Player player = (Player) sender;
        KitPvpMenu.kitpvpMenu(player);
        return false;
    }
}
