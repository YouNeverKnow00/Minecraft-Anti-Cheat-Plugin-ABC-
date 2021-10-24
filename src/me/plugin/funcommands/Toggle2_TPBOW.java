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

import me.plugin.main.Main;

public class Toggle2_TPBOW implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(p.hasPermission("antibug.fun.bowtp.use")){
			if(cmd.getName().equalsIgnoreCase("abtpbow")){
				if(args.length == 0){
					if(p.hasPermission("antibug.fun.bowtp.use")){
						p.sendMessage(Main.pluginame + Main.bowtpname + Main.bowtpuse);
						p.sendMessage(Main.pluginame + Main.bowtpaktifuyari);
						p.sendMessage(Main.pluginame + Main.bowtpaktifuyari2);
					}
				}else if(args.length == 1){
					if(p.hasPermission("antibug.fun.bowtp.use")){
						if(args[0].equalsIgnoreCase("on")){
							
							me.plugin.Event.TPBow.oketkin = 2;
							p.sendMessage(Main.pluginame + Main.bowtpname + Main.bowtpaktif);
							
							ItemStack bow = new ItemStack(Material.BOW);
							ItemStack arrow = new ItemStack(Material.ARROW);
												
							ItemMeta bowMeta = bow.getItemMeta();
							
							ItemMeta arrowMeta = arrow.getItemMeta();
							
							bowMeta.setDisplayName(Main.bowtpname);
							
							arrowMeta.setDisplayName(Main.arrowtpname);
							
							ArrayList<String> lore = new ArrayList<String>();
							lore.add(Main.tpbowlore1);
							lore.add(Main.tpbowlore2);
							bowMeta.setLore(lore);
							
							bowMeta.addEnchant(Enchantment.DURABILITY, 1, false);
							bowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
							
							ArrayList<String> loree = new ArrayList<String>();
							loree.add("");
							loree.add("");
							arrowMeta.setLore(loree);
							
							bow.setItemMeta(bowMeta);
							
							arrow.setItemMeta(arrowMeta);
							
							p.getInventory().addItem(bow);
							p.getInventory().addItem(arrow);
						}
					}
					if(args[0].equalsIgnoreCase("off")) {
						if(p.hasPermission("antibug.fun.bowtp.use")){
							me.plugin.Event.TPBow.oketkin = 0;
							p.sendMessage(Main.pluginame + Main.bowtpname + Main.bowtpdeaktif);
							
							ItemStack bow = new ItemStack(Material.BOW);
							ItemStack arrow = new ItemStack(Material.ARROW);
												
							ItemMeta bowMeta = bow.getItemMeta();
							
							ItemMeta arrowMeta = arrow.getItemMeta();
							
							bowMeta.setDisplayName(Main.bowtpname);
							
							arrowMeta.setDisplayName(Main.arrowtpname);
							
							ArrayList<String> lore = new ArrayList<String>();
							lore.add(Main.tpbowlore1);
							lore.add(Main.tpbowlore2);
							bowMeta.setLore(lore);
							
							bowMeta.addEnchant(Enchantment.DURABILITY, 1, false);
							bowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
							
							ArrayList<String> loree = new ArrayList<String>();
							loree.add("");
							loree.add("");
							arrowMeta.setLore(loree);
							
							bow.setItemMeta(bowMeta);
							
							arrow.setItemMeta(arrowMeta);

							p.getInventory().removeItem(bow);
							p.getInventory().removeItem(arrow);
						}
					}
				}
			}
		}
		return false;
	}

}
