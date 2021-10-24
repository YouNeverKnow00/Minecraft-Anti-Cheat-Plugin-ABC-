package me.plugin.oyuncueventleri;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import me.plugin.main.Main;

public class OyuncuEventler implements Listener {

    public static int etkin;

    // Haraket Etme Eventi
	@EventHandler
    public void onPlayerMove(PlayerMoveEvent e){
      if(etkin > 1){
    	  Player p = e.getPlayer();
    	  Location from = e.getFrom();
    	  Location to = e.getTo();
    	  double fromx = from.getX();
    	  double fromy = from.getY();
    	  double fromz = from.getZ();
    	  double tox = to.getX();
    	  double toy = to.getY();
    	  double toz = to.getZ();
    	  if(fromx > tox || fromy > toy || fromz > toz || fromx < tox || fromy < toy || fromz < toz){
    		  p.teleport(from);
    	  }
          }
      }
	
	// Konusma Eventi
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e){
		Player player = e.getPlayer();
		if(etkin > 1){
			e.setCancelled(true);
			player.sendMessage(Main.pluginame);
			player.sendMessage(Main.pluginame + Main.panicmodchatkapali);
		}
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e){
		Player player = e.getPlayer();
		if(etkin > 1){
			e.setCancelled(true);
			player.sendMessage(Main.pluginame);
			player.sendMessage(Main.pluginame + Main.panicmodblokkoymakapali);
		}
	}
	
	  @EventHandler
	  public void onBlockBreakEvent(BlockBreakEvent e)
	  {
	  if(etkin > 1){
	    Player p = e.getPlayer();
	      e.setCancelled(true);
		  p.sendMessage(Main.pluginame);
	      p.sendMessage(Main.pluginame + Main.panicmodblokkirmakapali);
	  	}
	  } 
	  
}
