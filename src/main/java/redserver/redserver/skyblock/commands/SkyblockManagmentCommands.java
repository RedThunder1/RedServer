package redserver.redserver.skyblock.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import redserver.redserver.RedMain;
import redserver.redserver.utilities.Messages;

public class SkyblockManagmentCommands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (RedMain.get().playerCheck(sender)) {
			sender.sendMessage(Messages.CONSOLECANTUSE);
			return false;
		}
		Player player = (Player) sender;
		
		if (args.length == 0) {
			//Enter Gui
			return false;
		}
		
		String command = args[1].toLowerCase();
		
		switch (command) {
			case "create":
				//create world gui
				break;
			case "delete":
				//delete world gui
				break;
			case "join":
				//join world
				break;
			default:
				player.sendMessage(ChatColor.RED + "That is not a avalible command.  Use create, delete, or join!");
				break;
				
		}
		
		return false;
	}

}
