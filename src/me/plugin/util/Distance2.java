package me.plugin.util;

import org.bukkit.Location;
import org.bukkit.event.player.PlayerMoveEvent;

public class Distance2 {

	private Location from, to;
	
	private Double xDiff, yDiff, zDiff;
	
	public Distance2(PlayerMoveEvent e){
		this(e.getFrom(), e.getTo());
	}
	
	public Distance2(Location a, Location b){
		this.from = a;
		this.to = b;
		
		this.xDiff =  Math.abs(a.getX() - b.getX());
		this.yDiff =  Math.abs(a.getY() - b.getY());
		this.zDiff =  Math.abs(a.getZ() - b.getZ());
	}

	public Location getFrom() {
		return from;
	}

	public Location getTo() {
		return to;
	}

	public Double getxDiff() {
		return xDiff;
	}

	public Double getyDiff() {
		return yDiff;
	}

	public Double getzDiff() {
		return zDiff;
	}
	
}
