package me.brunorm.resourcepacks;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MainCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
		if(args.length > 0) {
			switch(args[0].toLowerCase()) {
			case "reload":
				ResourcePackTools.plugin.loadConfig();
				sender.sendMessage(Messager.get("reloaded"));
				break;
			case "enable":
				ResourcePackTools.plugin.enabled = true;
				sender.sendMessage(Messager.get("enabled"));
				break;
			case "disable":
				ResourcePackTools.plugin.enabled = false;
				sender.sendMessage(Messager.get("disabled"));
				break;
			}
		} else {
			sender.sendMessage(Messager.color("&eUse &b/rpt help &eto see the commands."));
		}
		return true;
	}
}
