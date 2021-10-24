package me.plugin.anticheat.gui;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AntiCheatGuiCommand implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("abc")) {
			if(args.length == 0 ){
				p.sendMessage("§f[§2§lAnti§a§lBug§3§lCheat§f] §b>" + " §6v§e0.0.5" );
			}else if(args.length == 1){
				if(p.hasPermission("abc.*")){
					if(args[0].equalsIgnoreCase("menu")){
						Player player = (Player) sender;
						new AntiCheatGui(player);
					}
				}
			}
		 }
		return false;
	}


}
