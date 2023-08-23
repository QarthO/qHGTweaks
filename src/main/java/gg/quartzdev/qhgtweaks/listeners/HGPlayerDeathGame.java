package gg.quartzdev.qhgtweaks.listeners;

import gg.quartzdev.qhgtweaks.util.Util;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import tk.shanebee.hg.events.PlayerDeathGameEvent;

public class HGPlayerDeathGame implements Listener {

    public void onHGPlayerDeath(PlayerDeathGameEvent event){
        Player player = event.getPlayer();
        Util.log("<aqua>" + player.getName() + " <green>died in the arena");
        PlayerInventory inv = player.getInventory();
        for(ItemStack item : inv.getContents()){
            if(item == null) continue;
            Util.log("- Item: <blue>" + item.getI18NDisplayName());
        }
        player.getInventory().clear();
    }
}
