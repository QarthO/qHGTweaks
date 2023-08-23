package gg.quartzdev.qhgtweaks.listeners;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import tk.shanebee.hg.HG;
import tk.shanebee.hg.data.Config;
import tk.shanebee.hg.data.KitEntry;
import tk.shanebee.hg.events.GameStartEvent;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class HGGameStart implements Listener {

    private String leaveGameItemName;
    private Material leaveGameItem;
    private boolean enableLeaveGameItem;
    private String forceStartItemName;
    private Material forceStartItem;
    private boolean enableForceStartItem;



    @EventHandler
    public void onGameStart(GameStartEvent event){
        if(Bukkit.getServer().getPluginManager().isPluginEnabled("HungerGames")){
            HG hg = (HG) Bukkit.getServer().getPluginManager().getPlugin("HungerGames");
            leaveGameItemName = hg.getLang().leave_game;
            leaveGameItem = Material.getMaterial(Config.leaveitemtype);
            enableLeaveGameItem = Config.enableleaveitem;
            forceStartItemName = hg.getLang().force_start;
            forceStartItem = Material.getMaterial(Config.forcestartitem);
            enableForceStartItem = Config.enableforcestartitem;
        }


//        gets all kits
        HashMap<String, KitEntry> kitList = event.getGame().getKitManager().getKits();
//        does nothing if there are no kits
        if(kitList.isEmpty()) return;

//        sets the first kit as the default
        String defaultKitName = event.getGame().getKitManager().getKitList().get(0);
//        gets the first kits name (only used for debugging)
        KitEntry defaultKit = event.getGame().getKitManager().getKits().get(defaultKitName);
//        gets list of players uuids in the game
        List<UUID> playerList = event.getGame().getGamePlayerData().getPlayers();
//        loops thru all the players uuids
        for(UUID playerID : playerList){
//            gets the player tied to the uuid
            Player player = Bukkit.getPlayer(playerID);
//            if player not found, goes to next player
            if(player == null) continue;
//            if players doesn't have a kit
            if(!hasKit(player)) {
//                Util.sendMessage(player, "<yellow> Assigned kit: <aqua>" + defaultKitName);
//                Util.sendMessage(player, "<click:suggest_command:/hg kit ><yellow> Use <red>/hg kit <kit-name> <yellow> to choose a different kit</click>");
//                sets player inventory to the default kit content
                player.getInventory().setContents(defaultKit.getInventoryContents());
//                sets players armor to the default kit armor
                player.getInventory().setHelmet(defaultKit.getHelmet());
                player.getInventory().setChestplate(defaultKit.getChestplate());
                player.getInventory().setLeggings(defaultKit.getLeggings());
                player.getInventory().setBoots(defaultKit.getBoots());
            }
        }

    }


    /**
     * Checks if the player has the leave game item
     * @param player
     * @return boolean
     */
    public boolean hasKit(Player player){
        for(ItemStack item : player.getInventory().getContents()){
//            if no item
            if(item == null) continue;
//            if neither are same item type of one of the leave/start items
            if(!item.getType().equals(leaveGameItem) && !item.getType().equals(forceStartItem)) continue;
//            if the item has no meta
            if(!item.hasItemMeta()) continue;
//            if the item has no display name
            if(!item.getItemMeta().hasDisplayName()) continue;
//            get the item name
            Component displayName = item.getItemMeta().displayName();
            String rawDisplayName = PlainTextComponentSerializer.plainText().serialize(displayName);
//            check if it's the same as the name from the hg config
            if(rawDisplayName.equals(forceStartItemName) || rawDisplayName.equals(leaveGameItemName)) return false;
        }
//        will only return true if it didn't find one of the pre-kit items
        return true;
    }
}
