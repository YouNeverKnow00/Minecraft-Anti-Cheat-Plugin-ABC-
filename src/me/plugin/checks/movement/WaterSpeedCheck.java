package me.plugin.checks.movement;

import org.bukkit.Location;
import org.bukkit.Material;

import me.plugin.checks.CheckResult;
import me.plugin.checks.CheckType;
import me.plugin.checks.Level;
import me.plugin.util.Distance;
import me.plugin.util.Settings;
import me.plugin.util.User;

public class WaterSpeedCheck {

	private static final CheckResult PASS = new CheckResult(Level.PASSED, null, CheckType.WATERSPEED); 
	
	public static CheckResult runCheck(Distance d, User u){
		if (u.getPlayer().isFlying()) return PASS;
		Double xz_speed = (d.getxDiff() > d.getzDiff() ? d.getxDiff() : d.getzDiff());
		Location loc = u.getPlayer().getLocation();
		if (loc.getBlock().getType() == Material.WATER || loc.getBlock().getType() == Material.STATIONARY_WATER){
			if(xz_speed > Settings.MAX_XZ_WATERSPEED) 
				return new CheckResult(Level.DEFINITELY, "tried to move faster than normal, water speed=(" + xz_speed.toString() + "), max(" + Settings.MAX_XZ_WATERSPEED, CheckType.WATERSPEED);
		}
		return PASS;
	}
}
