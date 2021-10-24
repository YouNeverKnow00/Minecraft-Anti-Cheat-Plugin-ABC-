package me.plugin.Event;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import net.md_5.bungee.api.ChatColor;

public class ChatListener implements Listener{
	
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		File data = new File(Bukkit.getPluginManager().getPlugin("AntiBug").getDataFolder() , File.separator + "userdata");
		File f = new File(data, File.separator + p.getName() + ".yml");
		FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
		
		e.setMessage(ChatColor.valueOf(playerData.getString("AntiBugChatColor")) + e.getMessage());
	}

}
