package me.plugin.checks;

import org.bukkit.Bukkit;
import org.bukkit.permissions.Permission;

public enum CheckType {

	SPEED("Speed", new Permission("abc.bypass.speed")),
	NOSLOW("NoSlowDown", new Permission("abc.bypass.noslow")),
	FASTUSE("FastUse", new Permission("abc.bypass.fastuse")),
	WATERSPEED("WaterSpeed", new Permission("abc.bypass.waterspeed")),
	ICESPEED("IceSpeed", new Permission("abc.bypass.icespeed")),
	SOULSANDSPEED("SoulSandSpeed", new Permission("abc.bypass.soulsandspeed")),
	FASTHEAL("FastHeal", new Permission("abc.bypass.fastheal")),
	NORMALMOVEMENTS("NormalMovements", new Permission("abc.bypass.normalmovements")),
	GLIDE("Glide", new Permission("abc.bypass.glide")),
	REACH("Reach", new Permission("abc.bypass.reach")),
	WALLHIT("WallHit", new Permission("abc.bypass.wallhit")),
	HITSPEEDD("HitSpeed", new Permission("abc.bypass.hitspeed")),
	MULTIAURA("MultiAura", new Permission("abc.bypass.multiaura")),
	FLYSPEED("FlySpeed", new Permission("abc.bypass.flyspeed")),
	NORMALMOVEMENTS2("NormalMovements2", new Permission("abc.bypass.normalmovements2")),
	NOWEB("NoWeb", new Permission("abc.bypass.noweb"));
	
	private String name;
	private Permission perm;
	
	private CheckType(String name, Permission perm){
		this.name = name;
		this.perm = perm;
		Bukkit.getPluginManager().addPermission(perm);
	}

	public String getName() {
		return name;
	}

	public Permission getPerm() {
		return perm;
	}
	
}
