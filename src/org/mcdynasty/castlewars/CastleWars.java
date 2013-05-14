package org.mcdynasty.castlewars;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class CastleWars extends JavaPlugin implements Listener {
	
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(new TeamExecutor(), this);
		getCommand("join").setExecutor(new TeamExecutor());

	}
	
	public void onDisable() {
		
	}

}
