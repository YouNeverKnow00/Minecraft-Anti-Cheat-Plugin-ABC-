package me.plugin.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import me.plugin.main.Main;

public class CommandEvent implements Listener{

	@EventHandler
	public void OnCommandUse(PlayerCommandPreprocessEvent e){
		Player p = e.getPlayer();
		for(Player all : Main.getCommandLogger().cmdplayers){
			if(Main.getCommandLogger().cmdplayers.contains(all)){
				all.sendMessage(Main.pluginame + "§3" + p.getName() + Main.commandlogger_log + e.getMessage() );
			}
		}
	}
	
}
