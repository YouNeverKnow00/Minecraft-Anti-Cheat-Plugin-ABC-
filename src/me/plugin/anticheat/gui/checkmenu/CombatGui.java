package me.plugin.anticheat.gui.checkmenu;

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

import me.plugin.anticheat.gui.CheckGui;
import me.plugin.main.Main;

public class CombatGui implements Listener{
	
	public static int hitspeed = 1;
	
	public static int multiaura = 1;
	
	public static int reach = 1;
	
	public static int wallhit = 1;
			
	Inventory inv = Bukkit.createInventory(null, 27, "CombatSettings");
	public CombatGui(Player player){
		if (player == null){
			return;
		}
		
		/** Hitspeed **/
		
		ItemStack Killauracheck = new ItemStack(Material.GOLD_SWORD);
		ItemMeta KillauracheckMeta = Killauracheck.getItemMeta();
		KillauracheckMeta.setDisplayName("§7HitSpeed");
		ArrayList<String> killauracheck = new ArrayList<String>();
		killauracheck.add("§8Description:");
		killauracheck.add("");
		killauracheck.add("§7A player's unfair advantage has");
		killauracheck.add("§7prevented macro or killaura.");
		killauracheck.add("");
		killauracheck.add("§8Status:");
		killauracheck.add("");
		if(hitspeed == 1){
			killauracheck.add("§7Protection is now " + "§aEnabled");
		}else{
			killauracheck.add("§7Protection is now " + "§cDisabled");
		}
		killauracheck.add("");
		KillauracheckMeta.setLore(killauracheck);
		Killauracheck.setItemMeta(KillauracheckMeta);
		inv.setItem(10, Killauracheck);
		
		// On komutu (Killaura)
		
		ItemStack chat = new ItemStack(Material.EMERALD_BLOCK);
		ItemMeta chatMeta = chat.getItemMeta();
		chatMeta.setDisplayName("§7Enable §eHitSpeed");
		ArrayList<String> lore3 = new ArrayList<String>();
		lore3.add("§8Info:");
		lore3.add("");
		lore3.add("§7Activates §aHitSpeed");
		lore3.add("");
		chatMeta.setLore(lore3);
		chat.setItemMeta(chatMeta);
		inv.setItem(1, chat);
		
		// Off komutu (Killaura)
		
		ItemStack onkil = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta onkilMeta = chat.getItemMeta();
		chatMeta.setDisplayName("§7Disable §eHitSpeed");
		ArrayList<String> lore5 = new ArrayList<String>();
		lore5.add("§8Info:");
		lore5.add("");
		lore5.add("§7Deactivates §cHitSpeed");
		lore5.add("");
		onkilMeta.setLore(lore5);
		onkil.setItemMeta(onkilMeta);
		inv.setItem(19, onkil);
		
		/** MultiAura (Killaura) **/
		
		ItemStack Multiauracheck = new ItemStack(Material.STONE_SWORD);
		ItemMeta MultiauracheckMeta = Killauracheck.getItemMeta();
		MultiauracheckMeta.setDisplayName("§7MultiAura");
		ArrayList<String> multiauracheck1 = new ArrayList<String>();
		multiauracheck1.add("§8Description:");
		multiauracheck1.add("");
		multiauracheck1.add("§7By opening a player multiaura trick, it is");
		multiauracheck1.add("§7prevented from hitting more people than any other player.");
		multiauracheck1.add("");
		multiauracheck1.add("§8Status:");
		multiauracheck1.add("");
		if(multiaura == 1){
			multiauracheck1.add("§7Protection is now " + "§aEnabled");
		}else{
			multiauracheck1.add("§7Protection is now " + "§cDisabled");
		}
		multiauracheck1.add("");
		MultiauracheckMeta.setLore(multiauracheck1);
		Multiauracheck.setItemMeta(MultiauracheckMeta);
		inv.setItem(12, Multiauracheck);
		
		// MultiAura on
		
		ItemStack multionn = new ItemStack(Material.PRISMARINE);
		ItemMeta multionnMeta = multionn.getItemMeta();
		multionnMeta.setDisplayName("§7Enable §eMultiAura");
		ArrayList<String> loret = new ArrayList<String>();
		loret.add("§8Info:");
		loret.add("");
		loret.add("§7Activates §aMultiaura");
		loret.add("");
		multionnMeta.setLore(loret);
		multionn.setItemMeta(multionnMeta);
		inv.setItem(3, multionn);
		
		// MultiAura off
		
		
		ItemStack offmul = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 14);
		ItemMeta offmulMeta = offmul.getItemMeta();
		offmulMeta.setDisplayName("§7Disable §eMultiAura");
		ArrayList<String> lorep = new ArrayList<String>();
		lorep.add("§8Info:");
		lorep.add("");
		lorep.add("§7Deactivates §cMultiAura");
		lorep.add("");
		offmulMeta.setLore(lorep);
		offmul.setItemMeta(offmulMeta);
		inv.setItem(21, offmul);
		
		/** Reach **/
		
		ItemStack Reachcheck = new ItemStack(Material.IRON_SWORD);
		ItemMeta ReachcheckMeta = Reachcheck.getItemMeta();
		ReachcheckMeta.setDisplayName("§7Reach");
		ArrayList<String> Reachcheck1 = new ArrayList<String>();
		Reachcheck1.add("§8Description:");
		Reachcheck1.add("");
		Reachcheck1.add("§7By using a player Hack prevents the advantage of");
		Reachcheck1.add("§7allowing the enemy to strike remotely.");
		Reachcheck1.add("");
		Reachcheck1.add("§8Status:");
		Reachcheck1.add("");
		if(reach == 1){
			Reachcheck1.add("§7Protection is now " + "§aEnabled");
		}else{
			Reachcheck1.add("§7Protection is now " + "§cDisabled");
		}
		Reachcheck1.add("");
		ReachcheckMeta.setLore(Reachcheck1);
		Reachcheck.setItemMeta(ReachcheckMeta);
		inv.setItem(14, Reachcheck);
		
		// Reach on
		
		ItemStack reachonn = new ItemStack(Material.DIAMOND_BLOCK);
		ItemMeta reachonnMeta = reachonn.getItemMeta();
		reachonnMeta.setDisplayName("§7Enable §eReach");
		ArrayList<String> lorets = new ArrayList<String>();
		lorets.add("§8Info:");
		lorets.add("");
		lorets.add("§7Activates §aReach");
		lorets.add("");
		reachonnMeta.setLore(lorets);
		reachonn.setItemMeta(reachonnMeta);
		inv.setItem(5, reachonn);
		
		// Reach Off

		ItemStack offreach = new ItemStack(Material.STAINED_GLASS, 1, (byte) 14);
		ItemMeta offreachMeta = offreach.getItemMeta();
		offreachMeta.setDisplayName("§7Disable §eReach");
		ArrayList<String> lorerea = new ArrayList<String>();
		lorerea.add("§8Info:");
		lorerea.add("");
		lorerea.add("§7Deactivates §cReach");
		lorerea.add("");
		offreachMeta.setLore(lorerea);
		offreach.setItemMeta(offreachMeta);
		inv.setItem(23, offreach);
		
		/** WallHit **/
		
		ItemStack Wallhitcheck = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta WallhitcheckMeta = Wallhitcheck.getItemMeta();
		WallhitcheckMeta.setDisplayName("§7Wallhit");
		ArrayList<String> loresssa = new ArrayList<String>();
		loresssa.add("§8Description:");
		loresssa.add("");
		loresssa.add("§7Prevents a player from hitting");
		loresssa.add("§7the wall using trick.");
		loresssa.add("");
		loresssa.add("§8Status:");
		loresssa.add("");
		if(wallhit == 1){
			loresssa.add("§7Protection is now " + "§aEnabled");
		}else{
			loresssa.add("§7Protection is now " + "§cDisabled");
		}
		loresssa.add("");
		WallhitcheckMeta.setLore(loresssa);
		Wallhitcheck.setItemMeta(WallhitcheckMeta);
		inv.setItem(16, Wallhitcheck);
		
		// Wallhit on
		
		ItemStack wallhiton = new ItemStack(Material.PACKED_ICE);
		ItemMeta wallhitonMeta = wallhiton.getItemMeta();
		wallhitonMeta.setDisplayName("§7Enable §eWallhit");
		ArrayList<String> loresaad = new ArrayList<String>();
		loresaad.add("§8Info:");
		loresaad.add("");
		loresaad.add("§7Activates §aMultiaura");
		loresaad.add("");
		wallhitonMeta.setLore(loresaad);
		wallhiton.setItemMeta(wallhitonMeta);
		inv.setItem(7, wallhiton);
		
		// Wallhit off
		
		ItemStack offwallhit = new ItemStack(Material.RED_SANDSTONE);
		ItemMeta offwallhitMeta = offwallhit.getItemMeta();
		offwallhitMeta.setDisplayName("§7Disable §eWallhit");
		ArrayList<String> dsa = new ArrayList<String>();
		dsa.add("§8Info:");
		dsa.add("");
		dsa.add("§7Deactivates §cReach");
		dsa.add("");
		offwallhitMeta.setLore(dsa);
		offwallhit.setItemMeta(offwallhitMeta);
		inv.setItem(25, offwallhit);
		
		
		
		// Geri donme
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
		if(!e.getInventory().getName().equalsIgnoreCase("CombatSettings")){
			return;
		}
		Player player = (Player) e.getWhoClicked();
		e.setCancelled(true);
		
		
		if (e.getCurrentItem() == null || e.getCurrentItem().getType() == null || !e.getCurrentItem().hasItemMeta()){
			player.closeInventory();
			return;
		}
		
		switch (e.getCurrentItem().getType()) {
			
		/** HitSpeed koruması **/
		
		case EMERALD_BLOCK:
			if(hitspeed == 1){
				player.sendMessage(Main.pluginname_anticheatname + "§eZaten HitSpeed koruması açık.");
			}else{
				hitspeed = 1;
				player.sendMessage(Main.pluginname_anticheatname + "§aHitSpeed koruması başarıyla aktif edildi!");
			}
			break;
		
		case REDSTONE_BLOCK:
			if(hitspeed == 0){
				player.sendMessage(Main.pluginname_anticheatname + "§eZaten HitSpeed koruması kapalı.");
			}else{
				hitspeed = 0;
				player.sendMessage(Main.pluginname_anticheatname + "§cHitSpeed koruması başarıyla devre dışı bırakıldı!");
			}
			break;
			
		/** Multiaura koruması **/
			
		case PRISMARINE:
			if(multiaura == 1){
				player.sendMessage(Main.pluginname_anticheatname + "§eZaten MultiAura koruması açık.");
			}else{
				multiaura = 1;
				player.sendMessage(Main.pluginname_anticheatname + "§aMultiAura koruması başarıyla aktif edildi!");
			}
			break;
			
		case STAINED_GLASS_PANE:
			if(multiaura == 0){
				player.sendMessage(Main.pluginname_anticheatname + "§eZaten MultiAura koruması kapalı.");
			}else{
				multiaura = 0;
				player.sendMessage(Main.pluginname_anticheatname + "§cMultiAura koruması başarıyla devre dışı bırakıldı!");
			}
			break;
			
		/** Reach koruması **/
			
		case DIAMOND_BLOCK:
			if(reach == 1){
				player.sendMessage(Main.pluginname_anticheatname + "§eZaten Reach koruması açık.");
			}else{
				reach = 1;
				player.sendMessage(Main.pluginname_anticheatname + "§aReach koruması başarıyla aktif edildi!");
			}
			break;
			
		case STAINED_GLASS:
			if(reach == 0){
				player.sendMessage(Main.pluginname_anticheatname + "§eZaten Reach koruması kapalı.");
			}else{
				reach = 0;
				player.sendMessage(Main.pluginname_anticheatname + "§cReach koruması başarıyla devre dışı bırakıldı!");
			}
			break;
			
		/** WallHit Koruması **/	
			
		case PACKED_ICE:
			if(wallhit == 1){
				player.sendMessage(Main.pluginname_anticheatname + "§eZaten Wallhit koruması açık.");
			}else{
				wallhit = 1;
				player.sendMessage(Main.pluginname_anticheatname + "§aWallhit koruması başarıyla aktif edildi!");
			}
			break;
			
		case RED_SANDSTONE:
			if(wallhit == 0){
				player.sendMessage(Main.pluginname_anticheatname + "§eZaten Reach koruması kapalı.");
			}else{
				wallhit = 0;
				player.sendMessage(Main.pluginname_anticheatname + "§cReach koruması başarıyla devre dışı bırakıldı!");
			}
			break;
		
			
		case BARRIER:
			new CheckGui(player);
			break;
			
		default:
			break;
		
		}
	}
	
}
