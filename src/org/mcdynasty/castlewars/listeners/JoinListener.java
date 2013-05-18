package org.mcdynasty.castlewars.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		World world = Bukkit.getWorld("world_nether");
		Player p = e.getPlayer();
		Bukkit.getServer().broadcastMessage(ChatColor.AQUA + p.getName() + ChatColor.GOLD + " joined");
		p.teleport(world.getSpawnLocation());
	}

}
