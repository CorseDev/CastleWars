package org.mcdynasty.castlewars;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class TeamExecutor implements Listener, CommandExecutor {

	ScoreboardManager manager = Bukkit.getScoreboardManager();
	Scoreboard board = manager.getNewScoreboard();
	Team blue = board.registerNewTeam("blue");
	Team red = board.registerNewTeam("red");
	Objective kills = board.registerNewObjective("Kills", "totalKillCount");
	Objective deaths = board.registerNewObjective("Deaths", "totalKillCount");

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		Player p = (Player) sender;

		if ((sender instanceof Player) && cmd.equals("join")) {

			if (blue.getSize() < red.getSize()) {
				blue.addPlayer(p);

				if (blue.hasPlayer(p)) {
					p.sendMessage(ChatColor.GOLD + "You joined "
							+ ChatColor.BLUE + "Blue");
					Bukkit.getServer().broadcastMessage(ChatColor.GOLD + sender.getName() + "joined " + ChatColor.BLUE + "Blue");
					return true;
				}
			}

			if (red.getSize() < blue.getSize()) {
				red.addPlayer(p);

				if (red.hasPlayer(p)) {
					p.sendMessage(ChatColor.GOLD + "You joined "
							+ ChatColor.RED + "Red");
					Bukkit.getServer().broadcastMessage(ChatColor.GOLD + sender.getName() + "joined " + ChatColor.RED + "Red");
					return true;
				}

			}
			return true; // swag
		} else {
			if(!(sender instanceof Player)) {
				p.sendMessage(ChatColor.RED + "Error: " + ChatColor.DARK_RED + "You must be a player to use this command.");
				return true;	
			}
			
		}
		return false;
	}
}
