package redserver.redserver;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class RedMain extends JavaPlugin {
    public static RedMain plugin;
    public static RedMain getInstance() {return plugin;}


    @Override
    public void onEnable() {
        loadCommands();
        loadEvents();
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[!] RedSpigot Has been ENABLED [!]");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[!] RedSpigot Has been DISABLED [!]");
    }

    public void onLoad() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[!] RedSpigot Has been LOADED [!]");
    }

    public void loadCommands() {
        this.getCommand("smp").setExecutor(new smptp());
        this.getCommand("hub").setExecutor(new hub());
    }

    public void loadEvents() {
        getServer().getPluginManager().registerEvents(new onJoin(this), this);
    }

}
