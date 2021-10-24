package me.plugin.sistem;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.plugin.main.Main;

public class PanicSystem implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("abpanic")) {
			if(args.length == 0 ){
				if(p.hasPermission("antibug.admin.panic.use")){
					p.sendMessage(Main.pluginame + Main.panicmodkullanım);
					p.sendMessage(Main.pluginame + Main.panicmoduyari);
				}else {
					p.sendMessage(Main.pluginame + Main.yetkinyok);
				}
			}else if(args.length == 1){
			  if(p.hasPermission("antibug.admin.panic.use")){
				if(args[0].equalsIgnoreCase("on")) {
					if(me.plugin.oyuncueventleri.OyuncuEventler.etkin < 1){
						me.plugin.oyuncueventleri.OyuncuEventler.etkin = 2;
						p.sendMessage(Main.pluginame + Main.panicmodaktif);
					}else{
						if(me.plugin.oyuncueventleri.OyuncuEventler.etkin > 1){
							p.sendMessage(Main.pluginame + Main.panicmodzatenaktif);
						}
					}
					
				}
				if(args[0].equalsIgnoreCase("off")) {
					if(me.plugin.oyuncueventleri.OyuncuEventler.etkin > 1){
						me.plugin.oyuncueventleri.OyuncuEventler.etkin = 0;
						p.sendMessage(Main.pluginame + Main.panicmoddeaktif);
					}else{
						if(me.plugin.oyuncueventleri.OyuncuEventler.etkin < 1){
							p.sendMessage(Main.pluginame + Main.panicmodzatendeaktif);
						}
					}
				}

			}
		}
		
		}
		return false;
	}

}


/** 					me.plugin.oyuncueventleri.OyuncuEventler.etkin = 0; **/
