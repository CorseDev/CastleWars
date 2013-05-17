package org.mcdynasty.castlewars;

import java.sql.Connection;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcdynasty.castlewars.database.MySQL;

public class CastleWars extends JavaPlugin implements Listener {
		
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);

	}
	
	public void onDisable() {
		
	}
	
	MySQL MySQL = new MySQL("host.name", port, "user", "pass");
	Connection c = null;
	
}
