package gg.quartzdev.qhgtweaks.listeners;

import gg.quartzdev.qhgtweaks.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import tk.shanebee.hg.HG;
import tk.shanebee.hg.game.Game;

public class PlayerQuitServer implements Listener {


    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event){
        if(!Bukkit.getServer().getPluginManager().isPluginEnabled("HungerGames")) return;

        HG hg = (HG) Bukkit.getServer().getPluginManager().getPlugin("HungerGames");
        if(hg == null || hg.getGames() == null || hg.getGames().isEmpty()) return;

        for(Game game : hg.getGames()){
            if (!game.getGamePlayerData().getSpectators().contains(event.getPlayer().getUniqueId())) {
                Util.log("<aqua>" + event.getPlayer().getName() + "<green> is not spectating");
                continue;
            }
            try {
//                Tries to kick the player from spectating
                game.getGamePlayerData().leaveSpectate(event.getPlayer());
                return;
            } catch (Exception e){
                Util.error(e.getStackTrace());
            }
        }
    }
}
