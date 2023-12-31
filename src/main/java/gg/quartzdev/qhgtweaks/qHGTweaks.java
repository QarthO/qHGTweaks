package gg.quartzdev.qhgtweaks;

import gg.quartzdev.qhgtweaks.listeners.HGGameStart;
import gg.quartzdev.qhgtweaks.listeners.HGPlayerDeathGame;
import gg.quartzdev.qhgtweaks.listeners.PlayerQuitServer;
import gg.quartzdev.qhgtweaks.util.Util;
import org.bukkit.plugin.java.JavaPlugin;

public final class qHGTweaks extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Util.log("Hooking into HungerGames");
        try {
            getServer().getPluginManager().registerEvents(new HGPlayerDeathGame(), this);
            getServer().getPluginManager().registerEvents(new HGGameStart(), this);
            getServer().getPluginManager().registerEvents(new PlayerQuitServer(), this);
        } catch (Exception e){
            Util.error("Failed hooking into HungerGames");
            Util.error(e.getMessage());
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
