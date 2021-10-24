package me.plugin.checks.movement;

import me.plugin.checks.CheckResult;
import me.plugin.checks.CheckType;
import me.plugin.checks.Level;
import me.plugin.util.Distance;
import me.plugin.util.Settings;
import me.plugin.util.User;

public class FlySpeedCheck {

	private static final CheckResult PASS = new CheckResult(Level.PASSED, null, CheckType.FLYSPEED); 
	
	public static CheckResult runCheck(Distance d, User u){
		if (!u.getPlayer().isFlying()) return PASS;
		if (u.getPlayer().isFlying()){
		Double xz_speeds = (d.getxDiff() > d.getzDiff() ? d.getxDiff() : d.getzDiff());
		if(xz_speeds > Settings.MAX_XZ_FLYSPEED) 
			return new CheckResult(Level.DEFINITELY, "tried to move faster than normal, speed=(" + xz_speeds.toString() + "), max(" + Settings.MAX_XZ_FLYSPEED, CheckType.FLYSPEED);
		}
		return PASS;
	}
	
}
