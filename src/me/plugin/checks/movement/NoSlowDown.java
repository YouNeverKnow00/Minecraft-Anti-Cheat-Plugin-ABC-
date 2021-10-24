package me.plugin.checks.movement;

import me.plugin.checks.CheckResult;
import me.plugin.checks.CheckType;
import me.plugin.checks.Level;
import me.plugin.util.Distance;
import me.plugin.util.Settings;
import me.plugin.util.User;

public class NoSlowDown {

	private static final CheckResult PASS = new CheckResult(Level.PASSED, null, CheckType.NOSLOW); 
	
	public static void registerMove(Distance d, User u) {
		double xzDist = (d.getxDiff() > d.getzDiff() ? d.getxDiff() : d.getzDiff());
		if(xzDist > Settings.MAX_XZ_EATING_SPEED && u.getFoodStarting() != null && System.currentTimeMillis() - u.getFoodStarting() > 1200){
			u.addInvaildFoodEateableCount();
		}
        if(me.plugin.commands.DebugCommand.devmodetkin > 1){
    		u.getPlayer().sendMessage("§6Hızın: §e" + String.valueOf(xzDist));
        }
	}
	
	public static CheckResult runCheck(Distance d, User u){
		double xzDist = (d.getxDiff() > d.getzDiff() ? d.getxDiff() : d.getzDiff());
		if (u.getPlayer().isBlocking()){
			if(xzDist > Settings.MAX_XZ_BLOCKING_SPEED){
				
			}
		}
		return PASS;
	}

}
