package me.plugin.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.plugin.checks.CheckResult;
import me.plugin.checks.CheckType;
import me.plugin.checks.combat.HitSpeed;
import me.plugin.checks.combat.MultiAura;
import me.plugin.checks.combat.Reach;
import me.plugin.checks.combat.WallHit;
import me.plugin.main.Main;
import me.plugin.util.User;

public class CombatListener implements Listener {

	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e){
	 if(Main.iplisans2 == 1){
		Player p = (Player) e.getDamager();
		User user = Main.getUser(p);
	  if(Main.ftplisans == 1){
		if (e.getDamager() instanceof Player){
			
			CheckResult reach = Reach.runCheck(user, e.getEntity());
			
		if(me.plugin.anticheat.gui.checkmenu.CombatGui.reach == 1){
			if (reach.failed()){
				e.setCancelled(true); // Remove this line for slient checks
				Main.log(reach, user);
				user.addWarning(CheckType.REACH);
				return;
			}
		}
			
			CheckResult wallHit = WallHit.runCheck(user, e.getEntity());
			
		if(me.plugin.anticheat.gui.checkmenu.CombatGui.wallhit == 1){	
			if (wallHit.failed()){
				e.setCancelled(true); // Remove this line for slient checks
				Main.log(wallHit, user);
				user.addWarning(CheckType.WALLHIT);
				return;
			}
		}
			
			CheckResult hitSpeed = HitSpeed.runCheck(user, e.getEntity());
			
		if(me.plugin.anticheat.gui.checkmenu.CombatGui.hitspeed == 1){
			if (hitSpeed.failed()){
				e.setCancelled(true); // Remove this line for slient checks
				Main.log(hitSpeed, user);
				user.addWarning(CheckType.HITSPEEDD);
				return;
			}
		}
			
			CheckResult multiAura = MultiAura.runCheck(user, e.getEntity());
			
		if(me.plugin.anticheat.gui.checkmenu.CombatGui.multiaura == 1){	
			if (multiAura.failed()){
				e.setCancelled(true); // Remove this line for slient checks
				Main.log(multiAura, user);
				user.addWarning(CheckType.MULTIAURA);
				return;
			}
		   }
		 }
		}
	  }
	 }

}
