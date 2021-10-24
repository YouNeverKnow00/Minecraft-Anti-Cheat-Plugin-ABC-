package me.plugin.Event;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import me.plugin.checks.CheckResult;
import me.plugin.checks.CheckType;
import me.plugin.checks.Level;
import me.plugin.checks.player.FastHeal;
import me.plugin.main.Main;
import me.plugin.util.Settings;
import me.plugin.util.User;

public class PlayerListener implements Listener {

	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		User u = Main.getUser(e.getPlayer());
		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK &&
			  	e.getPlayer().getItemInHand() != null && Settings.FOODS.contains(e.getPlayer().getItemInHand().getType())){
			u.setFoodStarting();
			u.resetgetInvaildFoodEateableCount();
		}
	}
	
	@EventHandler
	public void onFoodLevelChange(FoodLevelChangeEvent e){
		User u = Main.USERS.get(e.getEntity().getUniqueId());
		if (u.getPlayer().getItemInHand() != null && Settings.FOODS.contains(u.getPlayer().getItemInHand().getType())){
			if(u.getInvaildFoodEateableCount() != 0){
				e.setCancelled(true);
				u.getPlayer().teleport(u.getFoodStartLocation());
				Main.log(new CheckResult(Level.DEFINITELY, "tried to move too fast whilst eating " + u.getInvaildFoodEateableCount() + " times in a row, max=(0)" , CheckType.NOSLOW), u);
			}
		}
	}
	
	@EventHandler
	public void onRegen(EntityRegainHealthEvent e){
		if (e.getEntityType() == EntityType.PLAYER){
			CheckResult result = FastHeal.runCheck((Player) e.getEntity());
			if(result.failed()) {
				e.setCancelled(true);
				e.setAmount(0);
				Main.log(result, Main.getUser((Player) e));
			}
		}
	}
	
	
}
