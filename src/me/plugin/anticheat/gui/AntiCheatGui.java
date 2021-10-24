package me.plugin.anticheat.gui;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.plugin.main.Main;

public class AntiCheatGui implements Listener{
	
	public static int killaura = 0;
	
	Inventory inv = Bukkit.createInventory(null, 9, "AntiBug");
	public AntiCheatGui(Player player){
		if(player == null){
			return;
			}
			ItemStack reports = new ItemStack(Material.SKULL_ITEM, (short) SkullType.PLAYER.ordinal());
			ItemMeta reportsMeta = reports.getItemMeta();
			reportsMeta.setDisplayName("§cRaporlar");
			reportsMeta.setLore(Arrays.asList("§eOyuncuların raporlarını görürsün."));
			reports.setItemMeta(reportsMeta);
			inv.setItem(7, reports);
			
			ItemStack check = new ItemStack(Material.COMPASS);
			ItemMeta checkMeta = check.getItemMeta();
			checkMeta.setDisplayName("§aAntiCheat Ayarları");
			checkMeta.setLore(Arrays.asList("§eBurdan AntiCheat ayarları yaparsın."));
			check.setItemMeta(checkMeta);
			inv.setItem(1, check);
			
			ItemStack checkList = new ItemStack(Material.TORCH);
			ItemMeta checkListMeta = checkList.getItemMeta();
			checkListMeta.setDisplayName("§bAntiBug Yönetici");
			checkListMeta.setLore(Arrays.asList("§eBurdan AntiBug Yönetim ayarlarını yaparsın."));
			checkList.setItemMeta(checkListMeta);
			inv.setItem(4, checkList);
			
			player.openInventory(inv);
	}	
	
	@EventHandler
	public void onClick(InventoryClickEvent e){
		if(!e.getInventory().getName().equalsIgnoreCase("AntiBug")){
			return;
		}
		Player player = (Player) e.getWhoClicked();
		e.setCancelled(true);
		
		
		if (e.getCurrentItem() == null || e.getCurrentItem().getType() == null || !e.getCurrentItem().hasItemMeta()){
			player.closeInventory();
			return;
		}
		
		switch (e.getCurrentItem().getType()) {
			
		case STAINED_CLAY:
			break;
		
		case COMPASS:
			new CheckGui(player);
			break;
			
		case SKULL_ITEM:
			player.sendMessage(Main.pluginame + "Rapor Sistemi yakında eklenecek.");
			break;
			
		case TORCH:
			player.sendMessage(Main.pluginame + "Yönetim Sistemi yakında eklenecek.");
			break;
		
		default:
			break;
		
		}
	}
	
}
