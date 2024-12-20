package de.philipgrabow.permissionhelper.executor;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;


public class OnlineTimeCommand implements CommandExecutor {
	
	File playerfile = new File("plugins/PermissionHelper", "OnlineTime.yml");
	FileConfiguration cfg = YamlConfiguration.loadConfiguration(playerfile);

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("onlinetime")) {
			if(sender instanceof Player) {
				if(args.length == 0) {
					//OnlineZeit von dir angezeigt
					FileConfiguration cfg = YamlConfiguration.loadConfiguration(playerfile);
					if(cfg.contains("OnlineTime." + sender.getName() + ".Time")) {
					int onlinezeit = cfg.getInt("OnlineTime." + sender.getName() + ".Time");
					sender.sendMessage(ChatColor.YELLOW + "Deine OnlineZeit beträgt: " + onlinezeit + " Minuten auf diesem Server");
					sender.sendMessage(ChatColor.BLUE + "Das sind etwa " + onlinezeit/60 + " Stunde/n die du hier verbracht hast!");
					sender.sendMessage(ChatColor.RED + "VIELEN DANK FÜR DEINE ANWESENHEIT!!!");
					Player p = (Player) sender;
					p.sendTitle(ChatColor.YELLOW + "OnlineZeit", ChatColor.RED + "Deine aktuelle Onlinezeit beträgt: " + 
							onlinezeit + ChatColor.RED + " Minute/n !", 40, 100, 40);
					return true;
					} else {
						sender.sendMessage("Du besitzt keine OnlineZeit auf diesem Server");
						if (!playerfile.exists()) {
							try {
								playerfile.createNewFile();
							} catch (IOException e) {
								Bukkit.getLogger().warning("Kann keine OnlineTime Datei erstellen");
							}
							
						}
						cfg.set("OnlineTime." + sender.getName() + ".Time", 0);
						try {
							cfg.save(playerfile);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return true;
					}
				}
				if(args.length == 1) {
					if (sender.hasPermission("PermissionHelper.OnlineTime.other")) {
						FileConfiguration cfg = YamlConfiguration.loadConfiguration(playerfile);
						if(cfg.contains("OnlineTime." + args[0])) {
							int OnlineZeit = cfg.getInt("OnlineTime." + args[0] + ".Time");
							sender.sendMessage(ChatColor.YELLOW + "Der Spieler " + args[0] + " hat " + OnlineZeit + " Minuten hier verbracht.");
							sender.sendMessage(ChatColor.BLUE + "Das sind " + OnlineZeit/60 + " Stunde/n!");
							
							return true;
						} else {
							sender.sendMessage("Der Spieler" + args[0] + " besitzt keine OnlineZeit auf diesem Server. Wende dich an ein Admin!");
							return true;
						}
					} else {
						sender.sendMessage("Du hast keine Berechtigung dafür");
						return true;
					}
				}
				if(args.length >1) {
					return false;
				}
			} else {
				return false;
			}
		}
		return false;
	}

}
