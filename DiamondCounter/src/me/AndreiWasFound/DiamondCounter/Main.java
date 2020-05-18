package me.AndreiWasFound.DiamondCounter;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.AndreiWasFound.DiamondCounter.Files.DataManager;

public class Main extends JavaPlugin implements Listener {
	
	public DataManager data;
	
	@Override
	public void onEnable() {
		this.data = new DataManager(this);
		
		this.getServer().getPluginManager().registerEvents(this, this);;
	}

	@Override
	public void onDisable() {
		
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent DiamondOreBlockEvent) {
		if (DiamondOreBlockEvent.getBlock().getType().equals(Material.DIAMOND_ORE)) {
			Player player = DiamondOreBlockEvent.getPlayer();
			int amount = 0;
			
			if (this.data.getConfig().contains("players." + player.getUniqueId().toString() + ".total"))
				amount = this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".total");
			
			data.getConfig().set("players." + player.getUniqueId().toString() + ".total", (amount + 1));
			data.saveConfig();
		}
	}

	
	

}













