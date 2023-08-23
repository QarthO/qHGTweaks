package gg.quartzdev.qhgtweaks.util;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Util {
    private static String PREFIX = "<gray>[<red>q<aqua>HG<dark_aqua>Tweaks<gray>]<reset>";

    /**
     * Logs a general message
     * @param msg
     */
    @SuppressWarnings("deprecation")
    public static void log(String msg){
        MiniMessage mm = MiniMessage.miniMessage();
        Component parse = mm.deserialize(PREFIX + " " + msg);
//        String rawMsg = LegacyComponentSerializer.legacySection().serialize(parse);
        Bukkit.getConsoleSender().sendMessage(parse);     // Paper forks only
    }

    public static void log(Component msg){
        Bukkit.getConsoleSender().sendMessage(msg);
    }

    /**
     * Logs a warning
     * @param msg
     */
    public static void warning(String msg){
        MiniMessage mm = MiniMessage.miniMessage();
        Component parse = mm.deserialize(PREFIX + " <yellow>" + msg);
        Bukkit.getConsoleSender().sendMessage(parse);
//        TODO: log warnings to a file
    }

    /**
     * Logs error
     * @param msg
     */
    public static void error(String msg){
        MiniMessage mm = MiniMessage.miniMessage();
        Component parse = mm.deserialize(PREFIX + " <red>" + msg);
        Bukkit.getConsoleSender().sendMessage(parse);
//        TODO: log errors to a file
    }

    public static void error(String msg, boolean stderr){
        MiniMessage mm = MiniMessage.miniMessage();
        Component parse = mm.deserialize(PREFIX + " <red>" + msg);
        Bukkit.getConsoleSender().sendMessage(parse);
//        TODO: log errors to a file
    }

    public static void error(StackTraceElement[] stackTrace){
        for(StackTraceElement element : stackTrace){
            MiniMessage mm = MiniMessage.miniMessage();
            Component parse = mm.deserialize(PREFIX + " <red>" + element.toString());
            Bukkit.getConsoleSender().sendMessage(parse);

        }
    }

    /**
     * Sends a message to the player
     * Supports MiniMessage format
     * @param player The player to send the message to
     * @param msg The message to send to the player
     */
    public static void sendMessage(Player player, String msg){
        MiniMessage mm = MiniMessage.miniMessage();
        Component parse = mm.deserialize(PREFIX + " " + msg);
        player.sendMessage(parse);
    }

    /**
     * Sends a message to the player
     * Supports MiniMessage format
     * @param player The player to send the message to
     * @param msg The message to send to the player
     * @param prefix Whether the plugin prefix should be sent
     */
    public static void sendMessage(Player player, String msg, boolean prefix){
        MiniMessage mm = MiniMessage.miniMessage();
        Component parse = mm.deserialize((prefix ? PREFIX : "") + " " + msg);
        player.sendMessage(parse);
    }
}
