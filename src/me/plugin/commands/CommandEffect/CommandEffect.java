package me.plugin.commands.CommandEffect;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.plugin.main.Main;

public class CommandEffect implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
			Player p = (Player) sender;
			if(p.hasPermission("antibug.commandeffect.tp")){
			if(args.length == 0){
				p.sendMessage(Main.pluginame + Main.commandeffectuse);
				p.sendMessage(Main.pluginame + Main.commandeffectlist);
			}
			if(args.length == 1){
				if(args[0].equals("tp")){
					Location loc = p.getLocation();
					p.getWorld().playEffect(loc, Effect.ENDER_SIGNAL, 0);
					p.getWorld().playEffect(loc, Effect.ENDER_SIGNAL, 0);
					p.getWorld().playEffect(loc, Effect.ENDER_SIGNAL, 0);
					p.getWorld().playEffect(loc, Effect.ENDER_SIGNAL, 0);
					p.sendMessage(Main.bosstring);
					p.sendMessage(Main.pluginame + Main.commandeffectuygulandi);
				}
			}
			return true;
			}else{
				p.sendMessage(Main.pluginame + Main.yetkinyok);
			}
		}
		return false;
	}

}
