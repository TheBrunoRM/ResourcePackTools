package me.brunorm.resourcepacks;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;
import org.bukkit.event.player.PlayerResourcePackStatusEvent.Status;

public class Events implements Listener {

	@EventHandler
	void onJoin(PlayerJoinEvent event) {
		String url = ResourcePackTools.config.getString("resourcepack_url");
		if(url == null) return;
		event.getPlayer().setResourcePack(url);
	}
	
	@EventHandler
	void onResource(PlayerResourcePackStatusEvent event) {
		Player player = event.getPlayer();
		Status status = event.getStatus();
		switch(status) {
		case DECLINED:
			player.kickPlayer("You must accept the resource pack!");
			break;
		case ACCEPTED:
			player.sendMessage("Thanks for installing the resource pack.");
			break;
		case FAILED_DOWNLOAD:
			player.sendMessage("Resource pack failed to install, try again.");
			break;
		case SUCCESSFULLY_LOADED:
			player.sendMessage("Resource pack installed successfully.");
			break;
		}
	}
	
}
