package me.plugin.Event;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;

public class TPBow implements Listener {

    public static int oketkin;
	
	@EventHandler
	public void okAtinca(ProjectileLaunchEvent event){
	 if( oketkin > 1){
		if(event.getEntity() instanceof Arrow && event.getEntity().getShooter() instanceof Player){
			Projectile p = event.getEntity();
			Player oyuncu = (Player) event.getEntity().getShooter();
			if(!oyuncu.isInsideVehicle()){
				p.setPassenger(oyuncu);
			}
		}
	 }
   }
}
