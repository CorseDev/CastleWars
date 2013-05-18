package org.mcdynasty.castlewars;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.mcdynasty.castlewars.commands.TeamExecutor;

public class RoundStart implements Listener {

	public static ArrayList<String> round = new ArrayList<String>();

	public void roundStart() {
		boolean roundOn = true;
		World w = Bukkit.getWorld("world");
		if (w == null) {
			System.out
					.println("[CastleWars] Something went wrong whilst loading the world.");
			return;
		} else {
			System.out
					.println("[CastleWars] World successfully found, and loaded.");
			if (roundOn == true) {
				for (Player player : Bukkit.getOnlinePlayers()) {
					if (TeamExecutor.red.contains(Bukkit.getServer().getPlayer(null)) || TeamExecutor.blue.contains(Bukkit.getServer().getPlayer(null))) {
						player.teleport(w.getSpawnLocation());
					} else {
						player.sendMessage(ChatColor.GOLD
								+ "The round started without you. Use "
								+ ChatColor.AQUA + "/join " + ChatColor.GOLD
								+ "to play");
					}
				}
			}
		}
	}

}
