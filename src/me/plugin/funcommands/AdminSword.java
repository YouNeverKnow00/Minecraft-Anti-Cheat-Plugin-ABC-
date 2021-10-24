package me.plugin.funcommands;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.plugin.main.Main;
import net.md_5.bungee.api.ChatColor;

public class AdminSword implements CommandExecutor {
	
	@EventHandler
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("abadminsword")){
			if(args.length == 0) {
				if(p.hasPermission("antibug.fun.adminsword")){
					ItemStack sword = new ItemStack(Material.GOLD_SWORD);
					
					ItemMeta swordMeta = sword.getItemMeta();
					
					swordMeta.setDisplayName(ChatColor.GREEN + Main.adminsword);
					
					ArrayList<String> lore = new ArrayList<String>();
					lore.add(Main.adminswordlore1);
					lore.add(Main.adminswordlore2);
					swordMeta.setLore(lore);
					
					swordMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, false);
					swordMeta.addEnchant(Enchantment.DAMAGE_UNDEAD, 5, false);
					swordMeta.addEnchant(Enchantment.DURABILITY, 3, false);
					swordMeta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 5, false);
					swordMeta.addEnchant(Enchantment.KNOCKBACK, 2, false);
					swordMeta.addEnchant(Enchantment.FIRE_ASPECT, 2, false);
					
					sword.setItemMeta(swordMeta);
					
					p.getInventory().addItem(sword);
					
					p.sendMessage(Main.adminswordkomutunuyazinca);
			}else{
				p.sendMessage(Main.pluginame + Main.yetkinyok);
			}
			
		}
	}
		return false;
	}
}
