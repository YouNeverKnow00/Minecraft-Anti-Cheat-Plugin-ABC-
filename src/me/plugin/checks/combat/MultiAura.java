package me.plugin.checks.combat;

import org.bukkit.entity.Entity;

import me.plugin.checks.CheckResult;
import me.plugin.checks.CheckType;
import me.plugin.checks.Level;
import me.plugin.util.Settings;
import me.plugin.util.User;

public class MultiAura {
	
	private static final CheckResult PASS = new CheckResult(Level.PASSED, null, CheckType.MULTIAURA);

	public static CheckResult runCheck(User user, Entity entity) {
		user.addEntity(entity.getEntityId());
		int entities = user.getEntities();
		
		return entities > Settings.MAX_ENTITIES ? new CheckResult(Level.DEFINITELY, "tried to hit: " + entities + " different entities max(" + Settings.MAX_ENTITIES + ")", 
				CheckType.MULTIAURA) : PASS ;
	}

}
