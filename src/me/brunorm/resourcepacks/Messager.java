package me.brunorm.resourcepacks;

import org.bukkit.ChatColor;

public class Messager {
	
	public static final char ALT_COLOR_CHAR = '&';
	
	public static String color(String text) {
		return ChatColor.translateAlternateColorCodes(ALT_COLOR_CHAR, text);
	}

	public static String get(String string) {
		return color(ResourcePackTools.langConfig.getString(string));
	}
	
}
