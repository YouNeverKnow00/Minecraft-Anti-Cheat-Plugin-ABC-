package me.plugin.anticheat.gui;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.plugin.anticheat.gui.checkmenu.CombatGui;

public class CheckGui implements Listener{

	Inventory inv = Bukkit.createInventory(null, 27, "AntiCheatSettings");
	public CheckGui(Player player){
		if (player == null){
			return;
		}
		
		ItemStack killaura = new ItemStack(Material.IRON_SWORD);
		ItemMeta killauraMeta = killaura.getItemMeta();
		killauraMeta.setDisplayName("§7Combat Checks");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("§8Category contains:");
		lore.add("");
		lore.add("§eHitSpeed§7: Checks for killaura");
		lore.add("§eMultiAura§7: Checks for multiaura");
		lore.add("§eReach§7: Checks for reach");
		lore.add("§eWallHit§7: Checks for wallhit");
		lore.add("");
		killauraMeta.setLore(lore);
		killaura.setItemMeta(killauraMeta);
		inv.setItem(10, killaura);
		
		ItemStack movement = new ItemStack(Material.IRON_BOOTS);
		ItemMeta movementMeta = movement.getItemMeta();
		movementMeta.setDisplayName("§7Movement Checks");
		ArrayList<String> lore1 = new ArrayList<String>();
		lore1.add("§8Category contains:");
		lore1.add("");
		lore1.add("§eSpeed§7: Checks for speed");
		lore1.add("§eIceSpeed§7: Checks for icespeed");
		lore1.add("§eSoulSandSpeed§7: Checks for soulsandspeed");
		lore1.add("§eWaterSpeed§7: Checks for waterspeed");
		lore1.add("§eNoSlow§7: Checks for noSlow");
		lore1.add("§eNormalMovements§7: Checks for normalmovements");
		lore1.add("");
		movementMeta.setLore(lore1);;
		movement.setItemMeta(movementMeta);
		inv.setItem(12, movement);
		
		ItemStack glass = new ItemStack(Material.DIRT);
		ItemMeta glassMeta = glass.getItemMeta();
		glassMeta.setDisplayName("§7World Checks");
		ArrayList<String> lore2 = new ArrayList<String>();
		lore2.add("§8Category contains:");
		lore2.add("");
		lore2.add("§eFastPlace§7: Checks for block place speed");
		lore2.add("");
		glassMeta.setLore(lore2);
		glass.setItemMeta(glassMeta);
		inv.setItem(14, glass);
		
		ItemStack chat = new ItemStack(Material.WEB);
		ItemMeta chatMeta = chat.getItemMeta();
		chatMeta.setDisplayName("§7Chat Checks");
		ArrayList<String> lore3 = new ArrayList<String>();
		lore3.add("§8Category contains:");
		lore3.add("");
		lore3.add("§eSpam§7: Checks for block place speed");
		lore3.add("");
		chatMeta.setLore(lore3);
		chat.setItemMeta(chatMeta);
		inv.setItem(16, chat);
		
		ItemStack geridon = new ItemStack(Material.BARRIER);
		ItemMeta geridonMeta = geridon.getItemMeta();
		geridonMeta.setDisplayName("§cGeriye Dön.");
		geridonMeta.setLore(Arrays.asList("§eMenüye geri dönersin."));
		geridon.setItemMeta(geridonMeta);
		inv.setItem(22, geridon);
		
		player.openInventory(inv);
		
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e){
		if(!e.getInventory().getName().equalsIgnoreCase("AntiCheatSettings")){
			return;
		}
		Player player = (Player) e.getWhoClicked();
		e.setCancelled(true);
		
		
		if (e.getCurrentItem() == null || e.getCurrentItem().getType() == null || !e.getCurrentItem().hasItemMeta()){
			player.closeInventory();
			return;
		}
		
		switch (e.getCurrentItem().getType()) {
			
		case IRON_SWORD:
			new CombatGui(player);
			break;
		
		case IRON_BOOTS:
			/* Eskiden buraları yapmamışım burayı kendin ekleyebilirsin :) */
			player.sendMessage("Speed");
			break;
			
		case DIRT:
			/* Eskiden buraları yapmamışım burayı kendin ekleyebilirsin :) */
			player.sendMessage("World");
			break;
			
		case BARRIER:
			new AntiCheatGui(player);
			break;
			
		case WEB:
			/* Eskiden buraları yapmamışım burayı kendin ekleyebilirsin :) */
			player.sendMessage("Chat");
			break; 
			
		default:
			break;
		
		}
	}
	
}
