package me.plugin.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;

public class Settings {
	
	/** Other Settings... **/
	
	// 200 is the amount of ticks between cleanups.
	// We clean things up, so the memory doesn't overloded etc. so 200 ticks = 10 seconds.
	
	public static final int CLEAN_UP_DELAY = 200;
	
	/** **/
	
	/** Combat settings... **/
	
	public static final double COMBAT_MAX_REACH_SURVIVAL = 3.7;
	public static final double COMBAT_MAX_REACH_CREATIVE = 5.25;
	
	public static final int COMBAT_MAX_CPS = 15;
	
	public static final int MAX_ENTITIES = 6;
	
	/** **/
	
	/** Movement Settings **/
	
	public static final Double MAX_XZ_SPEED = 0.65D;
	public static final Double MAX_XZ_FLYSPEED = 0.90D;
	public static final Double MAX_XZ_EATING_SPEED = 0.10177D;
	public static final double MAX_XZ_BLOCKING_SPEED = 0.25D;
	public static final double MAX_XZ_BOW_SPEED = 0.20D;
	public static final Double MAX_XZ_WATERSPEED = 0.47D;
	public static final Double MAX_XZ_ICESPEED = 0.569D;
	public static final Double MAX_XZ_SOULSANDSPEED = 0.41D;
	
	// Fix later
	public static final Double MAX_XZ_WEBSPEED = 0.10D;
	
	public static final Double MAX_JUMP_SECOND = 0.33319999363422426D;
	public static final Double MAX_JUMP_FIRST = 0.41999998688697815D;
	
	public static final int MAX_JUMP = 5;
	
	public static final String NOTIFY = "bac.notify";
	public static final String CRINGE = "cringed";
	
	// Change later...
	public static final Integer MAX_WARNINGS = 30;
	
	public static final Integer MAX_ENDWARNINGS = 10;
	
	public static final Double MAX_XZ_BLOCK_SPEED = 0.6714D;
	public static final Long FOOD_MIN = 1000L;
	public static final Long BOW_MIN = 100L;
	public static final Long MIN_HEAL_DELAY = 4500L;
	
	public static final int ROUNDING_PLACES = 6;
	
	/** **/
	
	public static final List<Material> FOODS;
	static {
		FOODS = new ArrayList<Material>();
		FOODS.add(Material.RAW_CHICKEN);
		FOODS.add(Material.RAW_BEEF);
		FOODS.add(Material.RAW_FISH);
		FOODS.add(Material.PORK);
		
		FOODS.add(Material.MILK_BUCKET);
		
		FOODS.add(Material.COOKED_FISH);
		FOODS.add(Material.GRILLED_PORK);
		FOODS.add(Material.COOKED_MUTTON);
		FOODS.add(Material.COOKED_CHICKEN);
		FOODS.add(Material.COOKED_RABBIT);
		FOODS.add(Material.COOKED_BEEF);
		
		FOODS.add(Material.GOLDEN_CARROT);
		FOODS.add(Material.GOLDEN_APPLE);
		
		FOODS.add(Material.CARROT);
		FOODS.add(Material.APPLE);
		FOODS.add(Material.POTATO);
		FOODS.add(Material.POTATO_ITEM);
		FOODS.add(Material.POISONOUS_POTATO);
		FOODS.add(Material.BAKED_POTATO);
		
		FOODS.add(Material.MUSHROOM_SOUP);
		FOODS.add(Material.COOKIE);
		FOODS.add(Material.BREAD);
		
		// Potion
		
		FOODS.add(Material.POTION);
	}

	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
	
	public static double round(double value) {
		return round(value, ROUNDING_PLACES);
	}
	
}
