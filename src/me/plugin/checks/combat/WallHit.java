package me.plugin.checks.combat;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import me.plugin.checks.CheckResult;
import me.plugin.checks.CheckType;
import me.plugin.checks.Level;
import me.plugin.util.Distance2;
import me.plugin.util.User;

public class WallHit {
	
	private static final CheckResult PASS = new CheckResult(Level.PASSED, null, CheckType.WALLHIT); 
		
	public static CheckResult runCheck(User user, Entity entity){
		Distance2 distance2 = new Distance2(user.getPlayer().getLocation(), entity.getLocation());
		double x = distance2.getxDiff();
		double z = distance2.getzDiff();
		Player p = user.getPlayer();
		
		if (x == 0 || z == 0){
			return PASS;
		}
		
		if (distance2.getyDiff() >= .6)
			return PASS;
		
		Location l = null;
		
		if(x <= .5 && z >= 1){
			if(p.getLocation().getZ() > entity.getLocation().getZ()){
				l = p.getLocation().clone().add(0, 0, -1);
			} else {
				 l = p.getLocation().clone().add(0, 0, 1);
			}
		} else if(z <= .5 && x >= 1){
			if(p.getLocation().getX() > entity.getLocation().getX()){
				l = p.getLocation().clone().add(-1, 0, 0);
			} else {
				 l = p.getLocation().clone().add(-1, 0, 1);
			}
		}
		boolean failed = false;
		
		if (l != null)
			failed = l.getBlock().getType().isSolid() && l.clone().add(0, 1, 0).getBlock().getType().isSolid();
		
		
		return failed ? new CheckResult(Level.DEFINITELY, "tried to hit " 
		+ (entity.getType() != EntityType.PLAYER ? "a" : "") + " " + " §e" + entity.getName() + "§7" + " through a wall", 
		CheckType.WALLHIT) : PASS ;
	}
}
