package redserver.redserver;

import com.google.gson.Gson;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import redserver.redserver.commands.*;
import redserver.redserver.commands.report.manager.ReportManager;
import redserver.redserver.commands.report.PlayerReport;
import redserver.redserver.commands.report.PlayerReportMenuEvent;
import redserver.redserver.commands.report.reports.InfoMenu.ReportsInfoEvent;
import redserver.redserver.commands.report.reports.Reports;
import redserver.redserver.commands.report.reports.ReportsMenu.ReportsMenuEvent;
import redserver.redserver.commands.staffcommands.BuildCommand;
import redserver.redserver.commands.staffcommands.HealCommand;
import redserver.redserver.commands.staffcommands.LaunchCommand;
import redserver.redserver.commands.staffcommands.SkullGiverCommand;
import redserver.redserver.commands.staffcommands.vanish.*;
import redserver.redserver.commands.worlds.CreateWorldCommand;
import redserver.redserver.commands.worlds.DeleteWorldCommand;
import redserver.redserver.commands.worlds.WorldTPCommand;
import redserver.redserver.events.PortalTPManagement;
import redserver.redserver.events.WorldProtectionListener;
import redserver.redserver.gson.GSONManager;
import redserver.redserver.smp.commands.HomeCommand;
import redserver.redserver.smp.commands.SMPTeleportCommand;
import redserver.redserver.events.PlayerJoinActions;
import redserver.redserver.utilities.AnnouncementMessages;

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

    //TODO: Fix reports menu.
    //TODO: Create world commands.
    //TODO: work on other minigames like kitpvp and duels.
    //TODO: tp players to their last pos in smp world.


    @Override
    public void onEnable() {
        loadCommands();
        loadEvents();
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[!] RedSpigot Has been ENABLED [!]");
        loadHomes();
        loadManagers();
        loadRunnables();
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
        this.getCommand("smp").setExecutor(new SMPTeleportCommand(this));
        this.getCommand("hub").setExecutor(new HubTPCommand(this));
        this.getCommand("home").setExecutor(new HomeCommand());
        this.getCommand("build").setExecutor(new BuildCommand());
        this.getCommand("vanish").setExecutor(new VanishCommand(this));
        this.getCommand("heal").setExecutor(new HealCommand());
        this.getCommand("launch").setExecutor(new LaunchCommand());
        this.getCommand("skull").setExecutor(new SkullGiverCommand());
        this.getCommand("report").setExecutor(new PlayerReport(this));
        this.getCommand("reports").setExecutor(new Reports(this));
        this.getCommand("wtp").setExecutor(new WorldTPCommand());
        this.getCommand("wcreate").setExecutor(new CreateWorldCommand());
        this.getCommand("wdelete").setExecutor(new DeleteWorldCommand());
    }

    public void loadEvents() {
        PluginManager pluginManager = this.getServer().getPluginManager();
        pluginManager.registerEvents(new PlayerJoinActions(this), this);
        pluginManager.registerEvents(new WorldProtectionListener(), this);
        pluginManager.registerEvents(new VanishCommand(this), this);
        pluginManager.registerEvents(new ReportsMenuEvent(this), this);
        pluginManager.registerEvents(new ReportsInfoEvent(this), this);
        pluginManager.registerEvents(new ReportsMenuEvent(this), this);
        pluginManager.registerEvents(new PlayerReportMenuEvent(this), this);
        pluginManager.registerEvents(new PortalTPManagement(), this);
    }

    public void loadHomes() {
        File file = new File("HomeStorage.json");
        String content = GSONManager.readFile(file);
        homeMap = gson.fromJson(content, HashMap.class);
    }

    public void saveHomes() {
        String toPut = gson.toJson(homeMap);
        GSONManager.writeFile(new File("HomeStorage.json"), toPut);
    }

    public void loadManagers() {
        reportmanager = new ReportManager();
    }

    public ReportManager getReportManager() {
        return reportmanager;
    }

    public void loadRunnables() {
        int sec = 20;
        int minute = sec*60;
        BukkitScheduler scheduler = this.getServer().getScheduler();
        scheduler.runTaskTimer(this, new AnnouncementMessages(this), 0, minute*5);
    }

}
