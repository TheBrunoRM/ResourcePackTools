package me.brunorm.resourcepacks;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ResourcePackTools extends JavaPlugin {

	public static final String prefix = "[ResourcePackTools] ";
	public static YamlConfiguration config;
	public static YamlConfiguration langConfig;
	
	public static ResourcePackTools plugin;
	public boolean enabled = true;
	
	@Override
	public void onEnable() {
		plugin = this;
		loadConfig();
		loadEvents();
		loadCommands();
		getLogger().info("Plugin loaded.");
	}
	
	void loadConfig() {
		File configFile = new File(getDataFolder(), "config.yml");
		if(!configFile.exists())
			saveResource("config.yml", true);
		config = YamlConfiguration.loadConfiguration(configFile);
		
		enabled = config.getBoolean("enabled");
		
		File langConfigFile = new File(getDataFolder(), "lang.yml");
		if(!langConfigFile.exists())
			saveResource("lang.yml", true);
		langConfig = YamlConfiguration.loadConfiguration(langConfigFile);
	}
	
	void loadEvents() {
		Bukkit.getServer().getPluginManager().registerEvents(new Events(), this);
	}
	
	void loadCommands() {
		this.getCommand("resourcepacktools").setExecutor(new MainCommand());
	}
	
}
