package me.plugin.main;

import org.bukkit.scheduler.BukkitRunnable;

import me.plugin.util.User;

public class Cleaner extends BukkitRunnable {

	@Override
	public void run() {
		for (User user : Main.USERS.values()){
			user.getHits();
			user.getEntities();
		}
	}

}
