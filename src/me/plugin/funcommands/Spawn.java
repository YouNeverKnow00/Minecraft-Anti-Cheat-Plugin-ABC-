package me.plugin.funcommands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import me.plugin.main.Main;

public class Spawn implements CommandExecutor {

	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		String prefix = Main.pluginame;
		if(cmd.getName().equalsIgnoreCase("abspawn")){
			if(args.length == 0){
				if(p.hasPermission("antibug.spawn.use")){
					p.sendMessage(prefix + Main.spawnuse);
					p.sendMessage(Main.bosstring);
					p.sendMessage(prefix + Main.spawnlist);
				}else {
					p.sendMessage(prefix + Main.yetkinyok);
				}
			}else if(args.length  == 1){
				if(args[0].equalsIgnoreCase("zombie")) {
					if(p.hasPermission("antibug.spawn.zombie")) {
						if(sender instanceof Player){
							Location loc = p.getLocation();
							p.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
							p.sendMessage(Main.pluginame + Main.spawntroll);
						}
					}
					
				}
				if(args[0].equalsIgnoreCase("skeleton")) {
					if(p.hasPermission("antibug.spawn.skeleton")) {
						if(sender instanceof Player){
							Location loc = p.getLocation();
							p.getWorld().spawnEntity(loc, EntityType.SKELETON);
							p.sendMessage(Main.pluginame + Main.spawntroll);
						}
					}
					
				}
				if(args[0].equalsIgnoreCase("creeper")) {
					if(p.hasPermission("antibug.spawn.creeper")) {
						if(sender instanceof Player){
							Location loc = p.getLocation();
							p.getWorld().spawnEntity(loc, EntityType.CREEPER);
							p.sendMessage(Main.pluginame + Main.spawntroll);
						}
					}
					
				}
				if(args[0].equalsIgnoreCase("spider")) {
					if(p.hasPermission("antibug.spawn.spider")) {
						if(sender instanceof Player){
							Location loc = p.getLocation();
							p.getWorld().spawnEntity(loc, EntityType.SPIDER);
							p.sendMessage(Main.pluginame + Main.spawntroll);
						}
					}
					
				}
				if(args[0].equalsIgnoreCase("ghast")) {
					if(p.hasPermission("antibug.spawn.zombiepigman")) {
						if(sender instanceof Player){
							Location loc = p.getLocation();
							p.getWorld().spawnEntity(loc, EntityType.GHAST);
							p.sendMessage(Main.pluginame + Main.spawntroll);
						}
					}
					
				}
				if(args[0].equalsIgnoreCase("enderdragon")) {
					if(p.hasPermission("antibug.spawn.enderdragon")) {
						if(sender instanceof Player){
							Location loc = p.getLocation();
							p.getWorld().spawnEntity(loc, EntityType.ENDER_DRAGON);
							p.sendMessage(Main.pluginame + Main.spawntroll);
						}
					}
					
				}
				
				  
			}
		}
		
		
		
		return false;
		
	}

}

