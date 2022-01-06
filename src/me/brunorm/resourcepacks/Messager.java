package me.brunorm.resourcepacks;

import org.bukkit.ChatColor;

public class Messager {
	
	public static final char ALT_COLOR_CHAR = '&';
	
	public static String color(String string) {
		return ChatColor.translateAlternateColorCodes(ALT_COLOR_CHAR, string);
	}

	public static String get(String string) {
		String text = ResourcePackTools.langConfig.getString(string);
		if(text == null) text = string;
		return color(text);
	}
	
}
