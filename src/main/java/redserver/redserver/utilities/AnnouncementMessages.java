package redserver.redserver.utilities;

import redserver.redserver.RedMain;

public class AnnouncementMessages implements Runnable {

    private RedMain plugin;
    public AnnouncementMessages(RedMain plugin) {this.plugin = plugin;}

    public int messageNumber = 0;

    @Override
    public void run() {
        messageNumber++;
        switch (messageNumber) {
            case 1:
                plugin.getServer().spigot().broadcast(Messages.Discord());
                break;
            case 2:
                plugin.getServer().broadcastMessage(Messages.RULES);
                break;
            case 3:
                plugin.getServer().spigot().broadcast(Messages.Tebex());
                break;
            case 4:
                plugin.getServer().broadcastMessage(Messages.WELCOME);
                messageNumber = 0;
                break;
        }



    }

}
