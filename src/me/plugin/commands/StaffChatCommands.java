package me.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.plugin.main.Main;

public class StaffChatCommands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("abstaffchat")){
			if(p.hasPermission("antibug.staffchat.use")) {
				if(args.length == 0) {
					p.sendMessage(Main.pluginame + Main.staffchatkullanim);
				}else {
					String message = "";
					for(int i = 0; i < args.length; i++) {
						message = message + args[i] + " ";
						
						
					}
					String staffchatMessage = Main.staffchatprefix  + "" + p.getDisplayName() + " §7: " + "§8§r " + message.replace("&", "§");
					for(Player all : Bukkit.getOnlinePlayers()) {
						if(all.hasPermission("antibug.staffchat.admin")) {
							all.sendMessage(staffchatMessage);
						}
					}
				}
			}else{
				p.sendMessage(Main.pluginame + Main.yetkinyok);

			}
		}
		return false;
	}

}
