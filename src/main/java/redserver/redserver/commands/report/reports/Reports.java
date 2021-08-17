package redserver.redserver.commands.report.reports;



import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import redserver.redserver.RedMain;
import redserver.redserver.commands.report.reports.ReportsMenu.ReportsGUI;
import redserver.redserver.utilities.Messages;

public class Reports implements CommandExecutor {

    private RedMain plugin;
    public Reports(RedMain plugin) {this.plugin = plugin;}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)){
            sender.sendMessage(Messages.CONSOLECANTUSE);
            return false;
        }
        Player player = (Player) sender;
        if (!(player.isOp())) {
            player.sendMessage(Messages.NOPERMS);
            return false;
        }

        ReportsGUI reportsGui = new ReportsGUI(plugin);
        reportsGui.Reports((Player) sender);

        return false;
    }

}
