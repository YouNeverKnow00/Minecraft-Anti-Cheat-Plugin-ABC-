package me.plugin.checks.movement;

import me.plugin.checks.CheckResult;
import me.plugin.checks.CheckType;
import me.plugin.checks.Level;
import me.plugin.util.Distance;
import me.plugin.util.Settings;
import me.plugin.util.User;

public class SpeedCheck {

	private static final CheckResult PASS = new CheckResult(Level.PASSED, null, CheckType.SPEED); 
	
	public static CheckResult runCheck(Distance d, User u){
		if (u.getPlayer().isFlying()) return PASS;
		Double xz_speed = (d.getxDiff() > d.getzDiff() ? d.getxDiff() : d.getzDiff());
		if(xz_speed > Settings.MAX_XZ_SPEED) 
			return new CheckResult(Level.DEFINITELY, "tried to move faster than normal, speed=(" + xz_speed.toString() + "), max(" + Settings.MAX_XZ_SPEED, CheckType.SPEED);
		return PASS;
	}
	
}
