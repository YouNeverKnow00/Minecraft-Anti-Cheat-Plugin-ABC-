package me.plugin.checks.movement;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

import me.plugin.checks.CheckResult;
import me.plugin.checks.CheckType;
import me.plugin.checks.Level;
import me.plugin.util.Distance;
import me.plugin.util.Settings;
import me.plugin.util.User;

public class SoulSandSpeedCheck {

	private static final CheckResult PASS = new CheckResult(Level.PASSED, null, CheckType.SOULSANDSPEED); 
	
	public static CheckResult runCheck(Distance d, User u){
		Double xz_speed = (d.getxDiff() > d.getzDiff() ? d.getxDiff() : d.getzDiff());
		if (u.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SOUL_SAND) {
			if(xz_speed > Settings.MAX_XZ_SOULSANDSPEED) 
				return new CheckResult(Level.DEFINITELY, "tried to move faster than normal, Ice speed=(" + xz_speed.toString() + "), max(" + Settings.MAX_XZ_SOULSANDSPEED, CheckType.SOULSANDSPEED);
		}
		return PASS;
	}
	
}
