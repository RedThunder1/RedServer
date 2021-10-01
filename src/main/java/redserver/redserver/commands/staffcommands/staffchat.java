package redserver.redserver.commands.staffcommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class staffchat implements Listener {
    public void onMsg(AsyncPlayerChatEvent event) {
        String msg = event.getMessage();
        Player player = event.getPlayer();
        if (msg.substring(0,1) == "#") {
            if (player.isOp()) {
                String msg1 = msg.substring(1);
                event.setCancelled(true);
                for (Player staff : Bukkit.getOnlinePlayers()) {
                    if (staff.isOp()) {
                        staff.sendMessage(ChatColor.RED + "[STAFF CHAT] " + player.getName() + msg1);
                    }
                }
            }
        }
    }
}
