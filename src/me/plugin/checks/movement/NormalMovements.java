package me.plugin.checks.movement;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.plugin.checks.CheckResult;
import me.plugin.checks.CheckType;
import me.plugin.checks.Level;
import me.plugin.util.Distance;
import me.plugin.util.MovementUtil;
import me.plugin.util.Settings;
import me.plugin.util.User;
import me.plugin.util.YMap;

public class NormalMovements {

	private static final CheckResult PASS = new CheckResult(Level.PASSED, null, CheckType.NORMALMOVEMENTS);
	
	public static  double maxFirst = 0.0, maxSecond = 0.0;
		
	public static CheckResult runCheck(User u, Distance d) {
		if (u.getPlayer().isFlying()) return PASS;
		Location f = d.getFrom();
		Location t = d.getTo();
		if (t.getY() > f.getY() && !f.getBlock().isLiquid() && !t.getBlock().isLiquid()){
			if (u.Jump == 0) {
				u.Jump++;
				maxFirst = (maxFirst > d.getyDiff() ? maxFirst : d.getyDiff());
				
				// Merdivenden cikinca atiyor sorun cozulunene kadar kapali :/
				if(!(u.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.FENCE || u.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.FENCE)) {
				  if(!u.getPlayer().hasPotionEffect(PotionEffectType.JUMP)){
					if (d.getyDiff() > Settings.MAX_JUMP_FIRST){
						if (isCollidingWithSteppableBlock(f) || isCollidingWithSteppableBlock(t))
							u.Jump =0;
						else return new CheckResult(Level.DEFINITELY, "tried to jump higher than usual, first, yDiff" + d.getyDiff() + ", max(" + Settings.MAX_JUMP_FIRST + ")", CheckType.NORMALMOVEMENTS);
					}
				  }
				}
				double diff = Math.abs(Settings.MAX_JUMP_FIRST - d.getyDiff());
				if (diff == 0.07699999213218689D){
					return new CheckResult(Level.DEFINITELY, "tried to jump slower than usual, first, diff" + diff, CheckType.NORMALMOVEMENTS);
				}
				double diff2 = Math.abs(Settings.MAX_JUMP_FIRST - d.getyDiff());
				if (diff2 == 0.009999986886978007D){
					return new CheckResult(Level.DEFINITELY, "tried to jump slower than usual, first, diff" + diff2, CheckType.NORMALMOVEMENTS);
				}
				double diff3 = Math.abs(Settings.MAX_JUMP_FIRST - d.getyDiff());
				if (diff3 == 0.020999986886978128D){
					return new CheckResult(Level.DEFINITELY, "tried to jump slower than usual, first, diff" + diff3, CheckType.NORMALMOVEMENTS);
				}
				double diff4 = Math.abs(Settings.MAX_JUMP_FIRST - d.getyDiff());
				if (diff4 == 0.0149999868869779D){
					return new CheckResult(Level.DEFINITELY, "tried to jump slower than usual, first, diff" + diff4, CheckType.NORMALMOVEMENTS);
				}
				double diff5 = Math.abs(Settings.MAX_JUMP_FIRST - d.getyDiff());
				if (diff5 == 0.03479998688697794D){
					return new CheckResult(Level.DEFINITELY, "tried to jump slower than usual, first, diff" + diff5, CheckType.NORMALMOVEMENTS);
				}
				double diff7 = Math.abs(Settings.MAX_JUMP_FIRST - d.getyDiff());
				if (diff7 == 0.08679999325275478D){
					return new CheckResult(Level.DEFINITELY, "tried to jump slower than usual, first, diff" + diff7, CheckType.NORMALMOVEMENTS);
				}
				double diff8 = Math.abs(Settings.MAX_JUMP_FIRST - d.getyDiff());
				if (diff8 == 0.02059999108314514D){
					return new CheckResult(Level.DEFINITELY, "tried to jump slower than usual, first, diff" + diff8, CheckType.NORMALMOVEMENTS);
				}
				// Altaki yport hilesini engellemek icin yazildi fakat calismiyor :/
//				double diff6 = Math.abs(Settings.MAX_JUMP_FIRST - d.getyDiff());
//				if (diff6 == 0.020639986886978434D){
//					return new CheckResult(Level.DEFINITELY, "tried to jump slower than usual, first, diff" + diff6, CheckType.NORMALMOVEMENTS);
//				}
//				System.out.println("First : " + diff);
			}else {
				if(!u.getPlayer().hasPotionEffect(PotionEffectType.JUMP)){
				if (d.getyDiff() > Settings.MAX_JUMP_SECOND)
					return new CheckResult(Level.DEFINITELY, "tried to jump higher than usual, yDiff" + d.getyDiff() + ", max(" + Settings.MAX_JUMP_SECOND + ")", CheckType.NORMALMOVEMENTS);
				// Merdivene cikinca atiyor duzeltilmeli
				// ||||||||||||||||| O N E M L I ||||||||||||||||||||||||| //
//				if (u.Jump > Settings.MAX_JUMP)
//					return new CheckResult(Level.DEFINITELY, "tried to jump longer than usual, time=" + u.Jump + ", max(" + Settings.MAX_JUMP + ")", CheckType.NORMALMOVEMENTS);
				maxSecond = (maxSecond > d.getyDiff() ? maxSecond : d.getyDiff());
//				System.out.println("Second : " + Math.abs(Settings.MAX_JUMP_SECOND - d.getyDiff()));
				u.Jump++;
				}
			}
		} else 
			u.Jump = 0;
		
		if (!d.isGoingUp() || d.getyDiff() == 0) {
//			if (user.wasGoingUp && user.oldTicksUp != YMap.get(user.oldYModifier).size())
//				return new CheckResult(true, CheckType.NORMALMOVEMENTS, "reason: early, ticks: " + user.oldTicksUp + ", exp: " + YMap.get(user.oldYModifier).size());
			u.wasGoingUp = false;
			u.oldYModifier = 0;
			u.ticksUp = 0;
			return PASS;
		}
		
		u.wasGoingUp = true;
		int ticksUp = u.ticksUp;
		u.ticksUp++;
		u.oldTicksUp = ticksUp;
		
		final double speed = Settings.round(d.getyDiff());
		
		int id = getYModifier(u);
		if (id > u.oldYModifier)
			u.oldYModifier = id;
		id = u.oldYModifier;
		YMap map = YMap.get(id);
		
		if (d.isGoingUp() && d.isMovingHorizontally()) {
			boolean step = MovementUtil.isStepping(d.getFrom()) || MovementUtil.isStepping(d.getTo());
			boolean yMap = map != null && map.contains(speed);
			debug(yMap);
			if (step) {
				if (speed > .5) 
					return new CheckResult(Level.DEFINITELY, "reason: step, type: " + (speed > .5 ? "high" : "low") + ", y: " + speed, CheckType.NORMALMOVEMENTS2);
				return PASS;
			}
		}
		
		
		
		if (map == null) {
			Bukkit.getLogger().warning("Modifier '" + id + "' has no contents!");
			return PASS;
		}
		if (!map.hasSpeed(ticksUp)) {
			return new CheckResult(Level.DEFINITELY, "reason: long, s: " + ticksUp + ", m: " + map.size(), CheckType.NORMALMOVEMENTS2);
		}
		
		if (map.size() <= ticksUp) 
			if (!(id != 0 && d.isMovingHorizontally() && map.size() == ticksUp && speed == map.getSpeed(ticksUp)))
						new CheckResult(Level.DEFINITELY, "reason: too high (ticksUp: " + ticksUp + ", max: " + (map.size()-1), CheckType.NORMALMOVEMENTS2);
		if (map.size() < ticksUp)
			return PASS; // TODO Bug
		double expected = map.getSpeed(ticksUp);
		
		if (expected != speed) {
			//debug(ticksUp);
			return new CheckResult(Level.DEFINITELY, "reason: normal, type: " + (expected < speed ? "high" : "low") + " (speed: " + speed + ", expected: " + expected, CheckType.NORMALMOVEMENTS2);
		}
		
//		System.out.println(u.Jump);
		return PASS;
	}
	
	private static void debug(boolean yMap) {
		
	}

	private static String[] steppable = new String[]{"step", "stairs"};
	
	private static boolean isCollidingWithSteppableBlock(Location loc){
		
		return isSteppableBlock(loc.clone().add(1, 0, 0).getBlock().getType())
				|| isSteppableBlock(loc.clone().add(-1, 0, 0).getBlock().getType())
				|| isSteppableBlock(loc.clone().add(0, 0, 1).getBlock().getType())
				|| isSteppableBlock(loc.clone().add(0, 0, -1).getBlock().getType())
				|| isSteppableBlock(loc.clone().add(1, 0, 1).getBlock().getType())
				|| isSteppableBlock(loc.clone().add(-1, 0, 1).getBlock().getType())
				|| isSteppableBlock(loc.clone().add(-1, 0, -1).getBlock().getType())
				|| isSteppableBlock(loc.clone().add(1, 0, -1).getBlock().getType())
				|| isSteppableBlock(loc.getBlock().getType())
				|| isSteppableBlock(loc.clone().add(1, 0, 0).getBlock().getType())
				|| isSteppableBlock(loc.clone().add(1, 0, 1).getBlock().getType())
		        || isSteppableBlock(loc.clone().add(-1, 0, -1).getBlock().getType())		
		        || isSteppableBlock(loc.clone().add(1, 0, -1).getBlock().getType())
		        || isSteppableBlock(loc.clone().add(-1, 0, 1).getBlock().getType())
				|| isSteppableBlock(loc.clone().add(0, 0, -1).getBlock().getType())
				|| isSteppableBlock(loc.clone().add(0, 0, 1).getBlock().getType());
	} 
	
	public static boolean isSteppableBlock(Material mat){
		for (String s : steppable)
			if (mat.toString().toLowerCase().contains(s))
				return true;
		return false;
	}
	
	@EventHandler
	public void VehicleEnterEvent(VehicleMoveEvent e){
		System.out.println("sa");
	}
	
	public static int getYModifier(User user) {
		if (user.getPlayer().hasPotionEffect(PotionEffectType.JUMP))
			for (PotionEffect pe : user.getPlayer().getActivePotionEffects()) 
//				debug(pe.getAmplifier() + " // " + pe.getType());
				if (pe.getType().equals(PotionEffectType.JUMP)) 
					return pe.getAmplifier() + 1;
		return 0;
	}

}
