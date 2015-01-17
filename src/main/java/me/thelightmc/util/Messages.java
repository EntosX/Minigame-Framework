package me.thelightmc.util;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class Messages {
    private static Messages messages;
    public static Messages getInstance() {
        if (messages == null) {
            messages = new Messages();
        }
        return messages;
    }
    public void sendMessage(Player player,Lang lang) {
        String message = lang.getMessage();
        player.sendMessage(ChatColor.translateAlternateColorCodes('&',message));
    }
    //ToDo Replace this with a more efficient method then creating a new map but with good capabilities
    public void sendMessage(Player player,Lang lang,HashMap<Lang.tag,String> replace) {
        String message = lang.getMessage();
        message = replacements(message,replace);
        player.sendMessage(ChatColor.translateAlternateColorCodes('&',message));
    }
    private String replacements(String msg,HashMap<Lang.tag,String> replacements) {
        String message = msg;
        for (Lang.tag tag : replacements.keySet()) {
            message = message.replaceAll(tag.getValue(),replacements.get(tag));
        }
        return message;
    }
}
