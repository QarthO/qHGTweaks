package gg.quartzdev.qhgtweaks.listeners;

import gg.quartzdev.qhgtweaks.util.Util;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import tk.shanebee.hg.events.PlayerLeaveGameEvent;

public class HGPlayerLeaveGame {

    @EventHandler
    public void onPlayerLeaveGame(PlayerLeaveGameEvent event){
        Player player = event.getPlayer();
        Util.log("<aqua>" + player.getName() + " <green> left the game");

    }
}
