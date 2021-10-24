package me.plugin.checks.combat;

import org.bukkit.GameMode;
import org.bukkit.entity.Entity;

import me.plugin.checks.CheckResult;
import me.plugin.checks.CheckType;
import me.plugin.checks.Level;
import me.plugin.util.Distance2;
import me.plugin.util.Settings;
import me.plugin.util.User;

public class Reach {

	private static final CheckResult PASS = new CheckResult(Level.PASSED, null, CheckType.REACH); 
	
	public static CheckResult runCheck(User user, Entity entity){
		Distance2 distance2 = new Distance2(user.getPlayer().getLocation(), entity.getLocation());
		double x = distance2.getxDiff();
		double z = distance2.getzDiff();
		
		double max = user.getPlayer().getGameMode() == GameMode.CREATIVE ? Settings.COMBAT_MAX_REACH_CREATIVE : Settings.COMBAT_MAX_REACH_SURVIVAL;
		
		if (x > max || z > max)
			return new CheckResult(Level.DEFINITELY, ", " + (x > z ? z > max ? "both are" : x + " is" : z + "is") + " greather than " + max, CheckType.REACH);
		
		return PASS;
	}
	
}
