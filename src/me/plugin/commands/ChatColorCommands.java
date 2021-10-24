package me.plugin.commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.plugin.main.Main;

public class ChatColorCommands implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		File data = new File(Bukkit.getPluginManager().getPlugin("AntiBug").getDataFolder() , File.separator + "userdata");
		File f = new File(data, File.separator + p.getName() + ".yml");
		FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
		String prefix = Main.pluginame;
		if(cmd.getName().equalsIgnoreCase("abcolor")){
			if(args.length == 0){
				if(p.hasPermission("antibug.color.use")){
					p.sendMessage(prefix + Main.chatcoloruse);
					p.sendMessage(prefix + Main.chatcolorlist);
				}else {
					p.sendMessage(prefix + Main.yetkinyok);
				}
			}else if(args.length  == 1){
				if(args[0].equalsIgnoreCase("red")) {
					if(p.hasPermission("antibug.color.red")) {
						playerData.set("AntiBugChatColor" , "RED");
						try {
							playerData.save(f);
						}catch(IOException ex){
							ex.printStackTrace();
						}
						p.sendMessage(prefix + Main.chatcolorred );
					}
					
				}
				if(args[0].equalsIgnoreCase("yellow")) {
					if(p.hasPermission("antibug.color.yellow")) {
						playerData.set("AntiBugChatColor" , "YELLOW");
						try {
							playerData.save(f);
						}catch(IOException ex){
							ex.printStackTrace();
						}
						p.sendMessage(prefix + Main.chatcoloryellow );
					}
					
				}
				if(args[0].equalsIgnoreCase("blue")) {
					if(p.hasPermission("antibug.color.blue")) {
						playerData.set("AntiBugChatColor" , "BLUE");
						try {
							playerData.save(f);
						}catch(IOException ex){
							ex.printStackTrace();
						}
						p.sendMessage(prefix + Main.chatcolorblue );
					}
					
				}
				if(args[0].equalsIgnoreCase("aqua")) {
					if(p.hasPermission("antibug.color.aqua")) {
						playerData.set("AntiBugChatColor" , "AQUA");
						try {
							playerData.save(f);
						}catch(IOException ex){
							ex.printStackTrace();
						}
						p.sendMessage(prefix + Main.chatcoloraqua );
					}
					
				}
				if(args[0].equalsIgnoreCase("green")) {
					if(p.hasPermission("antibug.color.green")) {
						playerData.set("AntiBugChatColor" , "GREEN");
						try {
							playerData.save(f);
						}catch(IOException ex){
							ex.printStackTrace();
						}
						p.sendMessage(prefix + Main.chatcolorgreen );
					}
					
				}
				if(args[0].equalsIgnoreCase("reset")) {
					if(p.hasPermission("antibug.color.reset")) {
						playerData.set("AntiBugChatColor" , "WHITE");
						try {
							playerData.save(f);
						}catch(IOException ex){
							ex.printStackTrace();
						}
						p.sendMessage(prefix + Main.chatcolorreset );
					}
					
				}
				
				  
			}
		}
		
		
		
		return false;
		
	}

}
