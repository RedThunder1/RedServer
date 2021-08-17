package redserver.redserver;

import com.google.gson.Gson;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import redserver.redserver.commands.*;
import redserver.redserver.commands.report.Manager.ReportManager;
import redserver.redserver.commands.report.PlayerReport;
import redserver.redserver.commands.report.PlayerReportMenuEvent;
import redserver.redserver.commands.report.reports.InfoMenu.ReportsInfoEvent;
import redserver.redserver.commands.report.reports.Reports;
import redserver.redserver.commands.report.reports.ReportsMenu.ReportsMenuEvent;
import redserver.redserver.commands.staffcommands.build;
import redserver.redserver.commands.staffcommands.heal;
import redserver.redserver.commands.staffcommands.launch;
import redserver.redserver.commands.staffcommands.skull;
import redserver.redserver.commands.staffcommands.vanish.*;
import redserver.redserver.events.worldprotection;
import redserver.redserver.gson.gsonmanager;
import redserver.redserver.smp.commands.home;
import redserver.redserver.smp.commands.smptp;
import redserver.redserver.events.onJoinEvent;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

public final class RedMain extends JavaPlugin {
    public static RedMain plugin;
    public static RedMain getInstance() {return plugin;}
    public static RedMain get() {return plugin;}
    private Gson gson = new Gson();
    public ReportManager reportmanager;
    HashMap<UUID, Location> homeMap = new HashMap<>();

    /**
     * TODO:
     * Fix reports menu
     * Create world commands
     * work on minigames
     * tp players to last pos on smp world
     */


    @Override
    public void onEnable() {
        loadCommands();
        loadEvents();
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[!] RedSpigot Has been ENABLED [!]");
        loadHomes();
        loadManagers();
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[!] RedSpigot Has been DISABLED [!]");
        saveHomes();
    }

    @Override
    public void onLoad() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[!] RedSpigot Has been LOADED [!]");
    }

    public void loadCommands() {
        this.getCommand("smp").setExecutor(new smptp(this));
        this.getCommand("hub").setExecutor(new hub(this));
        this.getCommand("home").setExecutor(new home());
        this.getCommand("build").setExecutor(new build());
        this.getCommand("vanish").setExecutor(new vanish(this));
        this.getCommand("heal").setExecutor(new heal());
        this.getCommand("launch").setExecutor(new launch());
        this.getCommand("skull").setExecutor(new skull());
        this.getCommand("report").setExecutor(new PlayerReport(this));
        this.getCommand("reports").setExecutor(new Reports(this));
    }

    public void loadEvents() {
        PluginManager pluginManager = this.getServer().getPluginManager();
        pluginManager.registerEvents(new onJoinEvent(this), this);
        pluginManager.registerEvents(new worldprotection(), this);
        pluginManager.registerEvents(new vanish(this), this);
        pluginManager.registerEvents(new ReportsMenuEvent(this), this);
        pluginManager.registerEvents(new ReportsInfoEvent(this), this);
        pluginManager.registerEvents(new ReportsMenuEvent(this), this);
        pluginManager.registerEvents(new PlayerReportMenuEvent(this), this);
    }

    public void loadHomes() {
        File file = new File("HomeStorage.json");
        String content = gsonmanager.readFile(file);
        homeMap = gson.fromJson(content, HashMap.class);
    }

    public void saveHomes() {
        String toPut = gson.toJson(homeMap);
        gsonmanager.writeFile(new File("HomeStorage.json"), toPut);
    }

    public void loadManagers() {
        reportmanager = new ReportManager();
    }

    public ReportManager getReportManager() {
        return reportmanager;
    }

}
