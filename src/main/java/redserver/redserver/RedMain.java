package redserver.redserver;

import com.google.gson.Gson;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import redserver.redserver.commands.HubTPCommand;
import redserver.redserver.commands.report.PlayerReport;
import redserver.redserver.commands.report.PlayerReportMenuEvent;
import redserver.redserver.commands.report.reports.InfoMenu.ReportsInfoEvent;
import redserver.redserver.commands.report.reports.Reports;
import redserver.redserver.commands.report.reports.ReportsMenu.ReportsMenuEvent;
import redserver.redserver.commands.report.manager.*;
import redserver.redserver.commands.staffcommands.*;
import redserver.redserver.commands.staffcommands.vanish.VanishCommand;
import redserver.redserver.commands.teleport.TPACommand;
import redserver.redserver.commands.worlds.CreateWorldCommand;
import redserver.redserver.commands.worlds.DeleteWorldCommand;
import redserver.redserver.commands.worlds.WorldTPCommand;
import redserver.redserver.events.PlayerJoinActions;
import redserver.redserver.events.WorldProtectionListener;
import redserver.redserver.gson.GSONManager;
import redserver.redserver.kitpvp.KitPvpTPCommand;
import redserver.redserver.kitpvp.kitpvpmenu.KitCommand;
import redserver.redserver.kitpvp.kitpvpmenu.KitPvpMenuAction;
import redserver.redserver.lobby.*;
import redserver.redserver.smp.commands.HomeCommand;
import redserver.redserver.smp.commands.SMPTeleportCommand;
import redserver.redserver.utilities.AnnouncementMessages;
import redserver.redserver.utilities.ranks.FakePlayer;
import redserver.redserver.utilities.ranks.Ranks;
import redserver.redserver.utilities.ranks.ServerRanks;
import redserver.redserver.smp.saveloc.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public final class RedMain extends JavaPlugin {
    public static RedMain plugin;
    public static RedMain get() {return plugin;}
    private final Gson gson = new Gson();
    public ReportManager reportmanager;
    public ServerRanks rankManager;
    public HashMap<UUID, Ranks>pRanks = new HashMap<>();
    public HashMap<UUID, Location> homeMap = new HashMap<>();
    
    //Temporary fix for ranks until i get Json files to work
    public HashMap<String, String> ranks = new HashMap<>();

    //TODO: Fix reports menu.
    //TODO: Create TP Commands
    //TODO: work on other minigames like kitpvp and duels.
    //TODO: Teleport players to their last position in smp world.
    //TODO: Finish saving homes and locations in smp.


    @Override
    public void onEnable() {
        loadCommands();
        loadEvents();
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[!] RedSpigot Has been ENABLED [!]");
        loadHomes();
        loadManagers();
        loadRunnables();
        loadRanks();
        WorldProtectionListener.setWorlds();
        loadWorlds();
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[!] RedSpigot Has been DISABLED [!]");
        saveHomes();
        saveRanks();
    }

    @Override
    public void onLoad() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[!] RedSpigot Has been LOADED [!]");
    }

    public void loadCommands() {
        Objects.requireNonNull(this.getCommand("smp")).setExecutor(new SMPTeleportCommand());
        Objects.requireNonNull(this.getCommand("hub")).setExecutor(new HubTPCommand());
        Objects.requireNonNull(this.getCommand("home")).setExecutor(new HomeCommand());
        Objects.requireNonNull(this.getCommand("build")).setExecutor(new BuildCommand());
        Objects.requireNonNull(this.getCommand("vanish")).setExecutor(new VanishCommand());
        Objects.requireNonNull(this.getCommand("heal")).setExecutor(new HealCommand());
        Objects.requireNonNull(this.getCommand("launch")).setExecutor(new LaunchCommand());
        Objects.requireNonNull(this.getCommand("skull")).setExecutor(new SkullGiverCommand());
        Objects.requireNonNull(this.getCommand("report")).setExecutor(new PlayerReport());
        Objects.requireNonNull(this.getCommand("reports")).setExecutor(new Reports());
        Objects.requireNonNull(this.getCommand("wtp")).setExecutor(new WorldTPCommand());
        Objects.requireNonNull(this.getCommand("wcreate")).setExecutor(new CreateWorldCommand());
        Objects.requireNonNull(this.getCommand("wdelete")).setExecutor(new DeleteWorldCommand());
        Objects.requireNonNull(this.getCommand("kitpvp")).setExecutor(new KitPvpTPCommand());
        Objects.requireNonNull(this.getCommand("kit")).setExecutor(new KitCommand());
        Objects.requireNonNull(this.getCommand("tpa")).setExecutor(new TPACommand());
    }

    public void loadEvents() {
        PluginManager pluginManager = this.getServer().getPluginManager();
        pluginManager.registerEvents(new PlayerJoinActions(), this);
        pluginManager.registerEvents(new WorldProtectionListener(), this);
        pluginManager.registerEvents(new VanishCommand(), this);
        pluginManager.registerEvents(new ReportsMenuEvent(), this);
        pluginManager.registerEvents(new ReportsInfoEvent(), this);
        pluginManager.registerEvents(new ReportsMenuEvent(), this);
        pluginManager.registerEvents(new PlayerReportMenuEvent(), this);
        pluginManager.registerEvents(new StaffChat(), this);
        pluginManager.registerEvents(new KitPvpMenuAction(), this);
        pluginManager.registerEvents(new GameSelector(), this);
        pluginManager.registerEvents(new GameSelectorListener(), this);
    }

    public void loadHomes() {
        File file = new File("HomeStorage.json");
        String content = GSONManager.readFile(file);
        homeMap = gson.fromJson(content, HashMap.class);
    }
     
    public void saveHomes() {
    	for (Player player : Bukkit.getWorld("smp").getPlayers()) {
    		if (homeMap.containsKey(player.getUniqueId())) {
    			homeMap.replace(player.getUniqueId(), player.getLocation());
    		} else {
    			homeMap.put(player.getUniqueId(), player.getLocation());
    		}
    		
    	}
    	
        String toPut = gson.toJson(homeMap);
        GSONManager.writeFile(new File("HomeStorage.json"), toPut);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[!] Saved player locations [!]");
    }
    
    public void saveRanks() {
    	String toPut = gson.toJson(pRanks);
    	GSONManager.writeFile(new File("PlayerRanks.json"), toPut);
    	getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[!] Saved player ranks [!]");
    }
    
    public void loadManagers() {
        reportmanager = new ReportManager();
        rankManager = new ServerRanks();
    }

    public ReportManager getReportManager() {
        return reportmanager;
    }

    public void loadRunnables() {
        int sec = 20;
        int minute = sec * 60;
        BukkitScheduler scheduler = this.getServer().getScheduler();
        scheduler.runTaskTimer(this, new AnnouncementMessages(this), 0, minute*10);
        scheduler.runTaskTimer(this, new SaveSMPLocation(), 0, minute*5);
    }

    public void loadWorlds() {
        ArrayList<String> worlds = new ArrayList<>();
        worlds.add("smp");
        worlds.add("kitpvp");
        worlds.add("pvp");
        for (String world : worlds) {
            WorldCreator worldCreator = new WorldCreator(world);
            worldCreator.createWorld();
        }

    }
    
    public ServerRanks getRankManager() {
    	return rankManager;
    }
    
    public boolean isStaff(Player player) { 
    	boolean staff = false;
    	String rank = ranks.get(player.getName());
    	FakePlayer fakePlayer = getRankManager().getFakePlayer(player);
    	if (fakePlayer.getPlayerRank().getPermLevel() >= 1) {
    		staff = true;
    	}
    	return staff;
    }
    
    
    
    
    //Temporary solution until i get Json files to work
    public void loadRanks() {
    	ranks.put("RedThunder117", "owner");
    }
    
    
}



