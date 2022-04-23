package redserver.redserver.utilities;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;

public class Messages {

    public static TextComponent Discord() {
        TextComponent discord = new TextComponent(ChatColor.BLUE + "You can join our discord at https://discord.gg/syVRwcn");
        discord.setClickEvent( new ClickEvent( ClickEvent.Action.OPEN_URL, "https://discord.gg/syVRwcn"));
        discord.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder( "Join our Discord!" ).create()));
		return discord;
    }

    public static TextComponent Tebex() {
        TextComponent tebex = new TextComponent(ChatColor.AQUA + "Currently there is no ranks but our store is at https://reds-server.tebex.io/");
        tebex.setClickEvent( new ClickEvent( ClickEvent.Action.OPEN_URL, "https://reds-server.tebex.io/"));
        tebex.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder( "Click to go to the Tebex Website!" ).create()));
        return tebex;
    }

    public static final String NOPERMS = ChatColor.RED + "You do not have permissions to use this command!";
    public static final String CONSOLECANTUSE = ChatColor.RED + "Console cant use this command!";
    public static final String NOTAPLAYER = ChatColor.RED + "That is not a Player!";

    
    public static final String RULES = ChatColor.RED + "Please make sure to read our rules in the discord server!";
    public static final String WELCOME = ChatColor.GREEN + "Welcome to Red's Server! Here we will have many mini games like Smp, Duels, and Kitpvp.";
}
