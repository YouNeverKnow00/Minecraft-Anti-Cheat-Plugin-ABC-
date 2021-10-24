package me.plugin.checks.combat;

import org.bukkit.entity.Entity;

import me.plugin.checks.CheckResult;
import me.plugin.checks.CheckType;
import me.plugin.checks.Level;
import me.plugin.util.Settings;
import me.plugin.util.User;

public class HitSpeed {

	private static final CheckResult PASS = new CheckResult(Level.PASSED, null, CheckType.HITSPEEDD); 
	
	public static CheckResult runCheck(User user, Entity entity) {
		user.addHit();
		int hits = user.getHits() * 2;
		// Fix later ...
		
		if(hits > Settings.COMBAT_MAX_CPS)
			return new CheckResult(Level.DEFINITELY, "tried to hit " + user.getHits() + " times per second!", CheckType.HITSPEEDD);
		return PASS;
	}

}
