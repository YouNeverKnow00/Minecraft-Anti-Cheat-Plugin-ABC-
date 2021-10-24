package me.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.Note.Tone;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.regex.Pattern;

import me.plugin.main.Main;

public class CommandBlocker implements Listener{

	  private final Pattern commandPattern = Pattern.compile("^(\\/ept|\\/pt|\\/powertool|\\/epowertool|\\/epowertool|\\/epowertool|\\/epowertool|\\/epowertool|\\/epowertool|\\/epowertool|\\/\\epowertool|\\/epowertool\\epowertool|\\/epowertool$|\\/epowertool|\\/epowertool|\\/epowertool|\\/epowertool|\\/epowertool\\epowertool|\\/epowertool|\\/epowertool|\\/epowertool|\\/epowertool|\\/epowertool|\\/epowertool|\\/epowertool|\\/epowertool)");
	  
	  @EventHandler
	  public void onCommand(PlayerCommandPreprocessEvent event)
	  {
	 if(Main.bugkomutengelleme == 1){
	    String command = event.getMessage();
	    Player player = event.getPlayer();
	    if (this.commandPattern.matcher(command).find())
	    {
	     if(!player.isOp()){
	    	 event.setCancelled(true);
	    	 player.sendMessage("§aYou do not have access to that command.");
	 			for (Player p : Bukkit.getOnlinePlayers()){
	 				if(p.isOp()){
	 				p.sendMessage(Main.pluginame + "§8--------------------------------------------------------------- ");
	 				p.sendMessage(Main.pluginame + " §e§k! " + "§6Uyarı" + " §e§k!!!");
	 				p.sendMessage(Main.pluginame + " ");
	 				p.sendMessage(Main.pluginame + " §9Komutu kullan kişinin yetkisi §byok!");
	 				p.sendMessage(Main.pluginame + " ");
					p.sendMessage(Main.pluginame + "§eŞüpheli komut kullanımı tespit ettim! " + "\n" + Main.pluginame +
							"§6Zararlı komutu kullanan kişi: §d" + player.getName() + "\n" + Main.pluginame + "§aDenediği komut: " + "§eEpt(PowerTool) komutlarını denedi!");
	 				p.sendMessage(Main.pluginame + "§8--------------------------------------------------------------- ");
					p.playNote(p.getLocation(), Instrument.PIANO, Note.flat(1, Tone.B));
					p.playNote(p.getLocation(), Instrument.BASS_DRUM, Note.flat(1, Tone.B));
					p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.flat(1, Tone.B));
					p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.flat(1, Tone.B));
					p.playNote(p.getLocation(), Instrument.STICKS, Note.flat(1, Tone.B));
	 				}
	 			}
//	      player.sendMessage(Main.pluginame + "§c§nGeçersiz komut!" + "\n" + Main.pluginame + "\n" + Main.pluginame + "§eBu komut sadece yönetici tarafından kullanabilir!");
	     }else{
	    	 if(player.isOp() && player.hasPermission("*") && player.hasPermission("essentials.*")){
	 			for (Player p : Bukkit.getOnlinePlayers()){
	 				if(p.isOp()){
	 				p.sendMessage(Main.pluginame + "§7--------------------------------------------------------------- ");
	 				p.sendMessage(Main.pluginame + " §c§k!!! " + "§4§lDikkat" + " §c§k!!!");
	 				p.sendMessage(Main.pluginame + " ");
	 				p.sendMessage(Main.pluginame + " §9Komutu kullan kişi §3yetkiye §9sahip! §7/ (§bYani op!§7)");
	 				p.sendMessage(Main.pluginame + " ");
					p.sendMessage(Main.pluginame + "§eŞüpheli komut kullanımı tespit ettim! " + "\n" + Main.pluginame +
							"§6Zararlı komutu kullanan kişi: §d" + player.getName() + "\n" + Main.pluginame + "§aDenediği komut: " + "§eEpt(PowerTool) komutlarını denedi!");
	 				p.sendMessage(Main.pluginame + "§7--------------------------------------------------------------- ");
					p.playNote(p.getLocation(), Instrument.PIANO, Note.flat(1, Tone.B));
					p.playNote(p.getLocation(), Instrument.BASS_DRUM, Note.flat(1, Tone.B));
					p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.flat(1, Tone.B));
					p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.flat(1, Tone.B));
					p.playNote(p.getLocation(), Instrument.STICKS, Note.flat(1, Tone.B));
	 				}
				}
	    		 event.setCancelled(true);
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage("");
	    		 player.sendMessage(Main.pluginame + " §cBeni korkutmaya başlıyorsun!" + "\n" + Main.pluginame +
	    		    	  " §6Plugin yapımcısı bu komutları kullanmaz. §eNiyemi?" + "\n" + 
	    		    	 Main.pluginame + " §7§nÇünkü engelli :)");
	    	 }
	     }
	     
	    }
	  }
	}
	
}
