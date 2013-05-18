package org.mcdynasty.castlewars.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.mcdynasty.castlewars.commands.TeamExecutor;

public class QuitListener implements Listener {

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		String p = e.getPlayer().getName();
		if (TeamExecutor.red.contains(p) || TeamExecutor.blue.contains(p)) {
			TeamExecutor.red.remove(p);
			TeamExecutor.blue.remove(p);
			Bukkit.getServer().broadcastMessage(
					ChatColor.AQUA + e.getPlayer().getName() + ChatColor.GOLD
							+ " left the game");
		} else {
			Bukkit.getServer().broadcastMessage(
					ChatColor.AQUA + e.getPlayer().getName() + ChatColor.GOLD
							+ " disconnected");
		}
	}

}
