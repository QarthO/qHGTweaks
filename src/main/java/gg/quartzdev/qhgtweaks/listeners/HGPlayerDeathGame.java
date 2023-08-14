package gg.quartzdev.qhgtweaks.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import tk.shanebee.hg.events.PlayerDeathGameEvent;

public class HGPlayerDeathGame implements Listener {

    public void onHGPlayerDeath(PlayerDeathGameEvent event){
        Player player = event.getPlayer();
        player.getInventory().clear();
    }
}
