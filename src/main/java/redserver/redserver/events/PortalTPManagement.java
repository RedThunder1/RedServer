package redserver.redserver.events;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;

public class PortalTPManagement implements Listener {

    @EventHandler
    public void onPlayerPortal(PlayerPortalEvent event) {
        World fromWorld = event.getFrom().getWorld();
        switch (event.getCause()) {
            case NETHER_PORTAL:
                switch (fromWorld.getEnvironment()) {
                    case NORMAL:
                        event.getTo().setWorld(Bukkit.getWorld("world_nether"));
                        break;
                    case NETHER:
                        event.getTo().setWorld(Bukkit.getWorld("smp"));
                        break;
                    default:

                }
        }
    }

}
