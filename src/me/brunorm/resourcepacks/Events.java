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
		if(!ResourcePackTools.plugin.enabled) return;
		String url = ResourcePackTools.config.getString("resourcepack_url");
		if(url == null) return;
		event.getPlayer().setResourcePack(url);
	}
	
	@EventHandler
	void onResource(PlayerResourcePackStatusEvent event) {
		if(!ResourcePackTools.plugin.enabled) return;
		Player player = event.getPlayer();
		Status status = event.getStatus();
		switch(status) {
		case DECLINED:
			player.kickPlayer(Messager.get("declined"));
			break;
		case ACCEPTED:
			player.sendMessage(Messager.get("accepted"));
			break;
		case FAILED_DOWNLOAD:
			String url = ResourcePackTools.config.getString("resourcepack_url");
			player.sendMessage(Messager.get("failedDownload"));
			event.getPlayer().setResourcePack(url);
			break;
		case SUCCESSFULLY_LOADED:
			player.sendMessage(Messager.get("successfullyLoaded"));
			break;
		}
	}
	
}
