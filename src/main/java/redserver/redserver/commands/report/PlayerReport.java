package redserver.redserver.commands.report;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import redserver.redserver.RedMain;
import redserver.redserver.utilities.Messages;


public class PlayerReport implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage(Messages.CONSOLECANTUSE);
            return false;
        }

        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Usage is /report PlayerName");
            return false;
        }

        if (RedMain.get().getServer().getPlayer(args[0]) == null) {
            sender.sendMessage(ChatColor.RED + "That isn't an online player!");
            return false;
        }

        Player toReport = RedMain.get().getServer().getPlayer(args[0]);

        PlayerReportGui.reportGui((Player) sender, toReport.getPlayer().getName());

        sender.sendMessage(ChatColor.RED + "You have reported " + args[0] + "!");



        return false;
    }
}
