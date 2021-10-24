package me.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.plugin.main.Main;

public class CommandLogger implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("abcommandlogger")) {
			if(args.length == 0 ){
				if(p.hasPermission("antibug.commandlogger.use")){
					p.sendMessage(Main.pluginame + Main.CommandloggerKullanimi);
				}else {
					p.sendMessage(Main.pluginame + Main.yetkinyok);
				}
			}else if(args.length == 1){
			  if(p.hasPermission("antibug.commandlogger.use")){
				if(args[0].equalsIgnoreCase("on")) {
					if(Main.getCommandLogger().cmdplayers.contains(p)){
						p.sendMessage(Main.pluginame + Main.CommandloggerAcik);
					}else {
						Main.getCommandLogger().cmdplayers.add(p);
						p.sendMessage(Main.pluginame + Main.CommandloggerAcik);
					}
				}
				if(args[0].equalsIgnoreCase("off")) {
					if(Main.getCommandLogger().cmdplayers.contains(p)){
						p.sendMessage(Main.pluginame + Main.CommandloggerKapali);
						Main.getCommandLogger().cmdplayers.remove(p);
					}else {
						Main.getCommandLogger().cmdplayers.remove(p);
						p.sendMessage(Main.pluginame + Main.CommandloggerKapali);
					}
				}

			}
		 }
		}	
		return false;
	}

}
