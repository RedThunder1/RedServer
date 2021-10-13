package redserver.redserver.commands.teleport;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;

import java.util.HashMap;

import org.jetbrains.annotations.NotNull;
import redserver.redserver.RedMain;
import redserver.redserver.utilities.Messages;

public class TPACommand implements CommandExecutor {

	public HashMap<Player, Player> map = new HashMap<>();
	public boolean tped = false;
	@Override
	public boolean onCommand(@NotNull CommandSender sender,@NotNull Command cmd, @NotNull String label,@NotNull String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Messages.CONSOLECANTUSE);
			return false;
		}
		
		Player player = (Player) sender;
		
		if (args.length == 0) {
			player.sendMessage("Please provide a player name to teleport too!");
			return false;
		}

		if (args[0].equals(player.getName())) {
			player.sendMessage(ChatColor.RED + "You cant tp to yourself!");
			return false;
		}
		
		for (Player p : Bukkit.getOnlinePlayers()) {
			
			if (args[0].toLowerCase().equals("accept")) {
				player.sendMessage(ChatColor.GREEN + "Teleporting you to " + p.getName());
				p.sendMessage(ChatColor.GREEN + "You accepted the tpa request!");
				player.teleport(p);
				map.remove(player, p);
				tped = true;
				return false;
			} else if (args[0].toLowerCase().equals("deny")) {
				player.sendMessage(ChatColor.RED + p.getName() + " has denied your tpa request.");
				p.sendMessage(ChatColor.RED + "You have denied " + player.getName() + " tpa request!");
				map.remove(player, p);
				return false;
			}
			
			if (map.get(player) != null) {
			player.sendMessage("You have already sent a tp request!");
			return false;
		}
			
			if (!(args[0].equals(p.getName()))) {
				player.sendMessage(Messages.NOTAPLAYER);
				return false;
			} else if (args[0].equals(p.getName())) {
				
				TextComponent accept = new TextComponent(ChatColor.GREEN + "ACCEPT");
				TextComponent deny = new TextComponent(ChatColor.RED + "DENY");
				accept.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpa accept"));
				deny.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpa deny"));
				p.sendMessage(ChatColor.GOLD + player.getName() + " has sent you a tpa request! " + accept + " / " + deny);
				map.put(player, p);
				final int[] time = {60};

				time[0] = 60;
				new BukkitRunnable() {
					@Override
					public void run() {
						if (tped) {
							map.remove(player, p);
							cancel();
						}
						if (time[0] == 0) {
							time[0] = 60;
							map.remove(player, p);
							cancel();
						} else if (time[0] < 61 && time[0] > 0) {
                            time[0]--;
                        }
					}
				}.runTaskTimer(RedMain.plugin, 0, 20);
			}
		}
		
		return false;
	}

}
