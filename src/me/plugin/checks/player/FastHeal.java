package me.plugin.checks.player;

import org.bukkit.entity.Player;

import me.plugin.checks.CheckResult;
import me.plugin.checks.CheckType;
import me.plugin.checks.Level;
import me.plugin.main.Main;
import me.plugin.util.Settings;
import me.plugin.util.User;

public class FastHeal {
	
	private static final CheckResult PASS = new CheckResult(Level.PASSED, null, CheckType.FASTHEAL);
	
	public static CheckResult runCheck(Player player) {
		User user = Main.getUser(player);
		if (user.getLastRegen() != null){
			if (user.getLastRegen() < Settings.MIN_HEAL_DELAY)
				return new CheckResult(Level.DEFINITELY, "tried to heal too fast, delay=" + (System.currentTimeMillis() - user.getLastRegen()) + ", min=(" + Settings.MIN_HEAL_DELAY + ")", CheckType.FASTHEAL);
		}	
		user.setLastRegen();
		return PASS;
	}

}
