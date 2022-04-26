package redserver.redserver.commands.report.reports;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import redserver.redserver.RedMain;
import redserver.redserver.commands.report.reports.ReportsMenu.ReportsGUI;
import redserver.redserver.utilities.Messages;

public class Reports implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {	return false; }
        Player player = (Player) sender;
        if (!(RedMain.get().opCheck(player))) {
            player.sendMessage(Messages.NOPERMS);
            return false;
        }

        ReportsGUI.reports((Player) sender);

        return false;
    }

}
