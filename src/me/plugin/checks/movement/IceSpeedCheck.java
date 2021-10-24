package me.plugin.checks.movement;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

import me.plugin.checks.CheckResult;
import me.plugin.checks.CheckType;
import me.plugin.checks.Level;
import me.plugin.util.Distance;
import me.plugin.util.Settings;
import me.plugin.util.User;

public class IceSpeedCheck {

	private static final CheckResult PASS = new CheckResult(Level.PASSED, null, CheckType.ICESPEED); 
	
	public static CheckResult runCheck(Distance d, User u){
		Double xz_speed = (d.getxDiff() > d.getzDiff() ? d.getxDiff() : d.getzDiff());
		if (u.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.ICE || u.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.PACKED_ICE ) {
			if(xz_speed > Settings.MAX_XZ_ICESPEED) 
				return new CheckResult(Level.DEFINITELY, "tried to move faster than normal, Ice speed=(" + xz_speed.toString() + "), max(" + Settings.MAX_XZ_ICESPEED, CheckType.ICESPEED);
		}
		return PASS;
	}
	
}
