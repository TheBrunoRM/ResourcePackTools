package me.brunorm.resourcepacks;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ResourcePackTools extends JavaPlugin {

	public static final String prefix = "[ResourcePackTools] ";
	public static YamlConfiguration config;
	
	@Override
	public void onEnable() {
		loadConfig();
		getLogger().info("Plugin loaded.");
	}
	
	void loadConfig() {
		File configFile = new File(getDataFolder(), "config.yml");
		if(!configFile.exists())
			saveResource("config.yml", true);
		
		config = YamlConfiguration.loadConfiguration(configFile);
	}
	
}
