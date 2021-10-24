package me.plugin.checks.movement;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

import me.plugin.checks.CheckResult;
import me.plugin.checks.CheckType;
import me.plugin.checks.Level;
import me.plugin.util.Distance;
import me.plugin.util.MovementUtil;
import me.plugin.util.User;

public class Glide {

	public static final CheckResult PASS = new CheckResult(Level.PASSED, null, CheckType.GLIDE);
	
	public static CheckResult runCheck(User u, Distance d) {
		final double oldY = u.oldY;
//		u.wasGoingUp = d.getFrom().getY() > d.getTo().getY();
		u.oldY = d.getyDiff();
		if(d.getFrom().getY() > d.getTo().getY()) {
		if (!(u.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.WEB) || !(u.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.WEB) ) {
			if (oldY >= d.getyDiff() && oldY != 0 && !MovementUtil.shouldNotFlag(d.getTo())){
				return new CheckResult(Level.DEFINITELY, "tried to glide:" + oldY + "<= " + u.oldY, CheckType.GLIDE);
			}
		}
		} else {
			u.oldY = 0;
		}
		return PASS;
	}
}
