package me.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WaitCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("abmov")){
			if(args.length == 0){
				if(!(sender instanceof Player)){
					
				}
			}else if(args.length == 1){
				if(!(sender instanceof Player)){
					if(args[0].equalsIgnoreCase("on")){
						me.plugin.Event.MoveListener.mov = 1;
						System.out.println("Haraket korumaları acik");
					}
				}
				if(args[0].equalsIgnoreCase("off")){
					if(!(sender instanceof Player)){
						me.plugin.Event.MoveListener.mov = 0;
						System.out.println("Haraket korumaları kapali");
					}
				}
			}
		}
		
		return false;
	}
}