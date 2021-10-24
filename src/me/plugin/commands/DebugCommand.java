package me.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.plugin.main.Main;

public class DebugCommand implements CommandExecutor {

    public static int devmodetkin;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("abdebug")) {
			if(args.length == 0 ){
				if(p.hasPermission("antibug.admin.panic.use")){
					p.sendMessage(Main.pluginame + "§2Kullanımı§7: §6/abdebug §e<§aon§e/§coff§e>");
				}else {
					p.sendMessage(Main.pluginame + Main.yetkinyok);
				}
			}else if(args.length == 1){
			  if(p.hasPermission("antibug.admin.panic.use")){
				if(args[0].equalsIgnoreCase("on")) {
					if(me.plugin.commands.DebugCommand.devmodetkin < 1){
						me.plugin.commands.DebugCommand.devmodetkin = 2;
						p.sendMessage(Main.pluginame + "Devlog mod etkin!");
					}else{
						if(me.plugin.commands.DebugCommand.devmodetkin > 1){
							p.sendMessage(Main.pluginame + "Devlog Mod zaten aktif!");
						}
					}
					
				}
				if(args[0].equalsIgnoreCase("off")) {
					if(me.plugin.commands.DebugCommand.devmodetkin > 1){
						me.plugin.commands.DebugCommand.devmodetkin = 0;
						p.sendMessage(Main.pluginame + "Devlog mod devredışı bırakıldı");
					}else{
						if(me.plugin.commands.DebugCommand.devmodetkin < 1){
							p.sendMessage(Main.pluginame + "Devlog mod zaten devredışı!");
						}
					}
				}

			}
		}
		
		}
		return false;
	}
	
}
