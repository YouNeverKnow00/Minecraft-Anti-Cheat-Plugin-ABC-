package me.plugin.funcommands;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.permissions.Permission;

import me.plugin.main.Main;
import net.md_5.bungee.api.ChatColor;

public class Toggle implements CommandExecutor{

	private Main plugin;
	public Toggle(Main plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
	if(p.hasPermission("antibug.admin.gravityblock.use")){
		if(!(sender instanceof Player)){
			sender.sendMessage(Main.pluginame + Main.bukomutsadeceoyuncukullanabilir);
			return false;
		}
		
		Player player = (Player) sender;
		
		if(!player.hasPermission(new Permission("antibug.admin.gravityblock.use"))){
			player.sendMessage(Main.pluginame + Main.yetkinyok);
		}
		
		if(plugin.toggleList.contains(player.getName())){
			plugin.toggleList.remove(player.getName());
			
			ItemStack rod = new ItemStack(Material.BLAZE_ROD);
			
			ItemMeta rodMeta = rod.getItemMeta();
			
			rodMeta.setDisplayName(ChatColor.GREEN + Main.gravityropename);
			
			ArrayList<String> lore = new ArrayList<String>();
			lore.add(Main.gravityropelore1);
			lore.add(Main.gravityropelore2);
			rodMeta.setLore(lore);
			
			rodMeta.addEnchant(Enchantment.DURABILITY, 1, false);
			
			rod.setItemMeta(rodMeta);
			
			p.getInventory().removeItem(rod);
			
			player.sendMessage(Main.pluginame + Main.gravityropename + Main.toggledevredisi);
			return true;
		}
		
		ItemStack rod = new ItemStack(Material.BLAZE_ROD);
		
		ItemMeta rodMeta = rod.getItemMeta();
		
		rodMeta.setDisplayName(ChatColor.GREEN + Main.gravityropename);
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(Main.gravityropelore1);
		lore.add(Main.gravityropelore2);
		rodMeta.setLore(lore);
		
		rodMeta.addEnchant(Enchantment.DURABILITY, 1, false);
		
		rod.setItemMeta(rodMeta);
		
		p.getInventory().addItem(rod);
		
		plugin.toggleList.add(player.getName());
		player.sendMessage(Main.pluginame + Main.gravityropename + Main.toggleaktif);
		
	}else{
		p.sendMessage(Main.pluginame + Main.yetkinyok);
	}
		return true;
	}

}
