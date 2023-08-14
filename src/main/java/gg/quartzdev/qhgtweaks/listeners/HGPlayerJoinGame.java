package gg.quartzdev.qhgtweaks.listeners;

import gg.quartzdev.qhgtweaks.util.Util;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import tk.shanebee.hg.events.PlayerJoinGameEvent;

public class HGPlayerJoinGame implements Listener {

    @EventHandler
    public void onPlayerJoinGame(PlayerJoinGameEvent event){
        Player player = event.getPlayer();
        Util.log("<aqua>" + player.getName() + " <green> joined the arena");
//        String defaultKitName = event.getGame().getKitManager().getKitList().get(0);
//        event.getGame().getKitManager().setKit(player, defaultKitName);
    }
}
