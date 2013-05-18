package org.mcdynasty.castlewars;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcdynasty.castlewars.commands.TeamExecutor;
import org.mcdynasty.castlewars.listeners.DamageListener;
import org.mcdynasty.castlewars.listeners.JoinListener;
import org.mcdynasty.castlewars.listeners.QuitListener;
import org.mcdynasty.castlewars.utils.BlockProtection;

public class CastleWars extends JavaPlugin implements Listener {
	
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new BlockProtection(), this);
        getServer().getPluginManager().registerEvents(new QuitListener(), this);
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new DamageListener(), this);
		getCommand("join").setExecutor(new TeamExecutor());
		getCommand("info").setExecutor(new TeamExecutor());
		
	}
	
	public void onDisable() {
		
	}
	
}
