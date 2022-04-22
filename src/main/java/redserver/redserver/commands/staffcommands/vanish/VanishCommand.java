package redserver.redserver.commands.staffcommands.vanish;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import redserver.redserver.RedMain;
import redserver.redserver.utilities.Messages;

import java.util.ArrayList;

public class VanishCommand implements CommandExecutor, Listener {
    public GameMode gamemode;

    public static ArrayList<Player> vanished = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {


        Player player = (Player) sender;
        if (RedMain.get().playerCheck(player) == false) {
             player.sendMessage(Messages.NOTAPLAYER);
             return false;
         }
        if (RedMain.get().opCheck(player) == false) {
            player.sendMessage(Messages.NOPERMS);
            return false;
        }


        if (vanished.contains(player)) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.showPlayer(RedMain.get(), player);
                player.setGameMode(gamemode);
            }
            vanished.remove(player);
            player.sendMessage(ChatColor.RED + "You have Unvanished!");
        } else {
            for (Player p: Bukkit.getOnlinePlayers()) {
                gamemode = player.getGameMode();
                p.hidePlayer(RedMain.plugin, player);
                player.setGameMode(GameMode.CREATIVE);
            }
            vanished.add(player);
            player.sendMessage(ChatColor.RED + "You have Vanished!");
        }
        return false;
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        for(Player player : Bukkit.getOnlinePlayers()) {
            if(vanished.contains(player)) {
                event.getPlayer().hidePlayer(RedMain.get(), player);
            }
        }
    }
    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if (vanished.contains(player)) {
            vanished.remove(player);
        }
    }

}
