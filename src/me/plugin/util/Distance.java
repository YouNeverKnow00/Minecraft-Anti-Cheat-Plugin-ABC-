package me.plugin.util;

import org.bukkit.Location;
import org.bukkit.event.player.PlayerMoveEvent;

public class Distance {

	private Location from, to;
	
	private Double xDiff, yDiff, zDiff;
	
	private boolean goingUp, goingDown;
	
	public Distance(PlayerMoveEvent e){
		this.from = e.getFrom();
		this.to = e.getTo();
		this.xDiff = (from.getX() > to.getX() ? from.getX() : to.getX()) - (from.getX() < to.getX() ? from.getX() : to.getX());
		this.yDiff = (from.getY() > to.getY() ? from.getY() : to.getY()) - (from.getY() < to.getY() ? from.getY() : to.getY());
		this.zDiff = (from.getZ() > to.getZ() ? from.getZ() : to.getZ()) - (from.getZ() < to.getZ() ? from.getZ() : to.getZ());
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
	
	public boolean isGoingDown() {
		return goingDown;
	}
	
	public boolean isGoingUp() {
		return goingUp;
	}

	public boolean isMovingHorizontally() {
		return xDiff != 0 || zDiff != 0;
	}
	
}
