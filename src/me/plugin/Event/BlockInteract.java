package me.plugin.Event;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import me.plugin.main.Main;

public class BlockInteract implements Listener {

	private Main plugin;
	public BlockInteract(Main plugin){
		this.plugin = plugin;
	}
	
	
	@EventHandler
	public void onBlockTouch(PlayerInteractEvent event){
		Player player = event.getPlayer();
	 if(player.hasPermission("antibug.admin.gravityblock.use")){
		if(plugin.toggleList.contains(player.getName())) {
			ItemStack itemInHand = player.getItemInHand();
			Block clickedBlock = event.getClickedBlock();
			if(event.getAction() == Action.RIGHT_CLICK_BLOCK && clickedBlock.getType() != Material.AIR) {
				if(itemInHand.getType() == Material.BLAZE_ROD) {
					@SuppressWarnings("deprecation")
					FallingBlock fallBlock = player.getWorld().spawnFallingBlock(clickedBlock.getLocation(),
							clickedBlock.getType(), clickedBlock.getData());
					Vector velocity = new Vector(0, 2, 0);
					fallBlock.setVelocity(velocity);
					clickedBlock.setType(Material.AIR);
				}
			}
		}
	  }
	}
}
