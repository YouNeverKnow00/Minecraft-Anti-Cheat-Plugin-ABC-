package me.plugin.util;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import me.plugin.checks.CheckType;

public class User {

	public double oldY = 0;
	private Player player;
	private Long foodStart, bowStart;
	private Location foodStartLocation;
	private int invaildFoodEateableCount = 0;
	private HashMap<CheckType, Integer> warnings = new HashMap<>();
	private boolean bow = false;
	private int kicks = 0;
	private Long lastRegen;
	private ArrayList<Long> hits = new ArrayList<>();
	private HashMap<Long, Integer> entities = new HashMap<>();
	public int Jump = 0;
	private long lastTimeHitsCleaned = 0, lastTimeEntitiesCleaned = 0;
	public boolean wasGoingUp = false;
	public int oldYModifier = 0, ticksUp = 0, oldTicksUp = 0;
	
	public User(Player player){
		this.player = player;
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public void setFoodStarting(){
		this.foodStart = System.currentTimeMillis();
		this.foodStartLocation = player.getLocation();
	}
	
	public Long getFoodStarting() {
		return foodStart;
	}
	
	public boolean isFoodStarted() {
		return foodStart != null;
	}
	
	public int addInvaildFoodEateableCount(){
		return this.invaildFoodEateableCount++;
	}
	
	public int getInvaildFoodEateableCount(){
		return this.invaildFoodEateableCount;
	}

	public Location getFoodStartLocation() {
		return foodStartLocation;
	}
	
	public void resetgetInvaildFoodEateableCount(){
		this.invaildFoodEateableCount = 0;
	}
	
	public int getWarnings(CheckType type){
		warnings.putIfAbsent(type, 0);
		return warnings.get(type);
	}
	
	public void addWarning(CheckType type){
		getWarnings(type);
		warnings.put(type, warnings.get(type)+1);
	}
		
	public boolean isBow(){
		return bow;
	}
	
	public void setBow(boolean bow){
		this.bow = bow;
	}
	
	public boolean isBlockAboveSolid(boolean x, Location loc){
		return x;
	}
	
	public boolean isBlockAboveSolid(Location loc){
		return isBlockAboveSolid(true, loc) || isBlockAboveSolid(false, loc);
	}
	
	public Long getBowStart(){
		return bowStart;
	}
	
	public int getKicks(){
		return kicks;
	}
	
	public void setKicks(int kicks){
		this.kicks = kicks;
	}
	
	@SuppressWarnings({ "unchecked" })
	public void setWarnings(HashMap<CheckType, Integer> warnings){
		this.warnings = (HashMap<CheckType, Integer>) warnings.clone();
	}
	
	public void setBowStart(Long bowStart){
		this.bowStart = bowStart;
	}

	public void setLastRegen() {
		this.lastRegen = System.currentTimeMillis();
	}
	
	public Long getLastRegen(){
		return lastRegen;
	}

	public void addHit() {
		hits.add(System.currentTimeMillis());
	}
	
	public int getHits(){
		long start = System.currentTimeMillis();
		ArrayList<Long> toRemove = new ArrayList<>();
		int result = 0;
		for (long l : hits)
			if(start - l > 1000L)
				toRemove.add((long) 1);
			else
				result++;
		hits.removeAll(toRemove);
		toRemove.clear();
		lastTimeHitsCleaned = start;
		return result;
	}
	
	public void addEntity(int i) {
		entities.put(System.currentTimeMillis(), i);
	}
	
	public int getEntities(){
		long start = System.currentTimeMillis();
		ArrayList<Long> toRemove = new ArrayList<>();
		ArrayList<Integer> res = new ArrayList<>();
		int result = 0;
		for (long l : entities.keySet()){
			int entityId = entities.get(l);
			if(start - l > 1000L)
				toRemove.add((long) 1);
			else if (!res.contains(entityId)){
				result++;
				res.add(entityId);
			}
		}
		hits.removeAll(toRemove);
		toRemove.clear();
		res.clear();
		lastTimeEntitiesCleaned = start;
		return result;
	}
	
	public long getLastTimeCleaned() {
		return lastTimeHitsCleaned;
	}
	
	public long getlastTimeEntitiesCleaned() {
		return lastTimeEntitiesCleaned;
	}
	
}
