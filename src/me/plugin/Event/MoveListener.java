package me.plugin.Event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.plugin.checks.CheckResult;
import me.plugin.checks.CheckType;
import me.plugin.checks.movement.FlySpeedCheck;
import me.plugin.checks.movement.Glide;
import me.plugin.checks.movement.IceSpeedCheck;
import me.plugin.checks.movement.NoSlowDown;
import me.plugin.checks.movement.NoWebCheck;
import me.plugin.checks.movement.NormalMovements;
import me.plugin.checks.movement.SoulSandSpeedCheck;
import me.plugin.checks.movement.SpeedCheck;
import me.plugin.checks.movement.WaterSpeedCheck;
import me.plugin.main.Main;
import me.plugin.util.Distance;
import me.plugin.util.User;

public class MoveListener implements Listener {
	
	public static int mov = 1;
	
	@EventHandler
	public void onMove(PlayerMoveEvent e){
	if(Main.iplisans2 == 1){
		User u = Main.USERS.get(e.getPlayer().getUniqueId());
		Distance d = new Distance(e);
		CheckResult speed = SpeedCheck.runCheck(d, u);
		CheckResult noSlow = NoSlowDown.runCheck(d, u);
		CheckResult waterSpeed = WaterSpeedCheck.runCheck(d, u);
		CheckResult IceSpeed = IceSpeedCheck.runCheck(d, u);
		CheckResult SoulSandSpeed = SoulSandSpeedCheck.runCheck(d, u);
		CheckResult normalMovements = NormalMovements.runCheck(u, d);
		CheckResult FlySpeed = FlySpeedCheck.runCheck(d, u);
		@SuppressWarnings("unused")
		CheckResult glide = Glide.runCheck(u, d);
		@SuppressWarnings("unused")
		CheckResult noWeb = NoWebCheck.runCheck(d, u);
		NoSlowDown.registerMove(d, u);	
	 if(mov == 1){
	  if(Main.ftplisans == 1){
		if (speed.failed()){
			e.setTo(e.getFrom()); // Yes, this is a better lag-back
			Main.log(speed, u);
			u.addWarning(CheckType.SPEED);
		}
		if (noSlow.failed()){
			e.setTo(e.getFrom()); // Yes, this is a better lag-back
			Main.log(noSlow, u);
			u.addWarning(CheckType.NOSLOW);
		}
		if (waterSpeed.failed()){
			e.setTo(e.getFrom());
			Main.log(waterSpeed, u);
			u.addWarning(CheckType.WATERSPEED);
		}
		if (IceSpeed.failed()){
			e.setTo(e.getFrom());
			Main.log(IceSpeed, u);
			u.addWarning(CheckType.ICESPEED);
		}
		if (SoulSandSpeed.failed()){
			e.setTo(e.getFrom());
			Main.log(SoulSandSpeed, u);
			u.addWarning(CheckType.SOULSANDSPEED);
		}
		if(FlySpeed.failed()){
			e.setTo(e.getFrom());
			Main.log(FlySpeed, u);
			u.addWarning(CheckType.FLYSPEED);
		}
		if (normalMovements.failed()) {
			e.setTo(e.getFrom());
			Main.log(normalMovements, u);
			u.Jump = 0;
			u.addWarning(CheckType.NORMALMOVEMENTS);
		 }
	   }
	  }
	 }
		/** Fix later **/ 
//		if(glide.failed()){
//			e.setTo(e.getFrom());
//			Main.log(glide, u);
//			u.addWarning(CheckType.GLIDE);
//		}
//		if (noWeb.failed()){
//			e.setTo(e.getFrom());
//			Main.log(noWeb, u);
//			u.addWarning(CheckType.NOWEB);
//		}
		
		
	}
	
}
