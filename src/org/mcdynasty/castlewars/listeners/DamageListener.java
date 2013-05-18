package org.mcdynasty.castlewars.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.mcdynasty.castlewars.commands.TeamExecutor;

public class DamageListener implements Listener {

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerDamage(EntityDamageByEntityEvent event) {
		if (event.getEntity() instanceof Player) {
			Player damaged = (Player) event.getEntity();
			if (event.getDamager() instanceof Player) {
				Player damager = (Player) event.getDamager();

				if (TeamExecutor.blue.contains(damager.getName())
						&& TeamExecutor.blue.contains(damaged.getName())) {
					event.setCancelled(true);
					damager.sendMessage(ChatColor.GOLD + "Hold your fire!");
				}

				if (TeamExecutor.red.contains(damager.getName())
						&& TeamExecutor.red.contains(damaged.getName())) {
					event.setCancelled(true);
					damager.sendMessage(ChatColor.GOLD + "Hold your fire!");
					damager.setHealth(damager.getHealth() - 1);
				}
			}
		}
	}

}
