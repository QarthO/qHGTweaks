package gg.quartzdev.qhgtweaks.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import tk.shanebee.hg.events.PlayerJoinGameEvent;

public class HGPlayerJoinGame implements Listener {

    @EventHandler
    public void onPlayerJoinGame(PlayerJoinGameEvent event){
        Player player = event.getPlayer();
        String defaultKitName = event.getGame().getKitManager().getKitList().get(0);
        event.getGame().getKitManager().setKit(player, defaultKitName);
    }
}
