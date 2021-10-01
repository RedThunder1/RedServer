package redserver.redserver.commands.staffcommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class StaffChat implements Listener {

    @EventHandler
    public void onMsg(AsyncPlayerChatEvent event) {
        String msg = event.getMessage();
        Player player = event.getPlayer();
        if (msg.charAt(0) == '#') {
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
