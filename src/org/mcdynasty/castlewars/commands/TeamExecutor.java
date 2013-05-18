package org.mcdynasty.castlewars.commands;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class TeamExecutor implements Listener, CommandExecutor {

	public static ArrayList<String> red = new ArrayList<String>();
	public static ArrayList<String> blue = new ArrayList<String>();

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		Player player = ((Player) sender);
		String p = player.getName();
		if (cmd.getName().equalsIgnoreCase("join")) {

			if (red.contains(p) || blue.contains(p)) {
				player.sendMessage(ChatColor.GOLD + "You are already on a team");
				return true;
			}
			else if (blue.size() < red.size()) {
					blue.add(p);
					player.sendMessage(ChatColor.GOLD + "You joined " + ChatColor.BLUE + "Blue");
					return true;
			}
			else if(red.size() < blue.size()) {
					red.add(p);
					player.sendMessage(ChatColor.GOLD + "You joined " + ChatColor.RED + "Red");
					return true;
			}else if(red.size() == blue.size()) {
				blue.add(p);
				player.sendMessage(ChatColor.GOLD + "You joined " + ChatColor.BLUE + "Blue");
			}
 
		}
		return false;
	}

}
