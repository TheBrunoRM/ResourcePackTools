package me.brunorm.resourcepacks;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ResourcePackTools extends JavaPlugin {

	public static final String prefix = "[ResourcePackTools] ";
	public static YamlConfiguration config;
	
	@Override
	public void onEnable() {
		loadConfig();
	}
	
	void loadConfig() {
		
	}
	
}
