package org.mcdynasty.castlewars.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockProtection implements Listener {
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		String plocation = e.getPlayer().getName();
		Player p = e.getPlayer();
		Location l = p.getLocation();
        	if(!p.isOp()) {
        		p.sendMessage(ChatColor.RED + "You're not allowed to break blocks here.");
        		Bukkit.getPlayer(plocation).getWorld().playSound(l,Sound.ENDERDRAGON_HIT,1, 0);
            e.setCancelled(true);
        }
	}

}
