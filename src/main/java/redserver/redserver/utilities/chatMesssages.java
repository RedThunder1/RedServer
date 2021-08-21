package redserver.redserver.utilities;

import redserver.redserver.RedMain;

public class chatMesssages  implements Runnable {

    private RedMain plugin;
    public chatMesssages(RedMain plugin) {this.plugin = plugin;}

    public int messageNumber = 0;

    @Override
    public void run() {
        messageNumber++;
        switch (messageNumber) {
            case 1:
                plugin.getServer().broadcastMessage(Messages.DISCORD);
                break;
            case 2:
                plugin.getServer().broadcastMessage(Messages.RULES);
                break;
            case 3:
                plugin.getServer().broadcastMessage(Messages.TEBEX);
                break;
            case 4:
                plugin.getServer().broadcastMessage(Messages.WELCOME);
                messageNumber = 0;
                break;
        }



    }

}
