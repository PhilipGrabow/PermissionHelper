package de.philipgrabow.permissionhelper.classes;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import de.philipgrabow.permissionhelper.Main;
import net.md_5.bungee.api.ChatColor;

public class OnlineTimeJoinEvent {
	public void onJoin_OnlineTime(Player p, Main plugin) {
		File file_config = new File("plugins/PermissionHelper", "config.yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file_config);
		File file2 = new File("plugins/PermissionHelper", "OnlineTime.yml");
		if (file2.exists()) {
		} else {
			try {
				file2.createNewFile();
				Bukkit.getLogger().warning("OnlineTime Datei erstellt!");
			} catch (IOException e1) {
				Bukkit.getLogger().warning("Kann keine OnlineTime Datei erstellen");
			}
		}
		FileConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
		boolean onlinetime_boolean = config.getBoolean("OnlineTime.Enabled");
		if (onlinetime_boolean) {
			cfg2.set("OnlineTime." + p.getName() + ".Reload", true);
			try {
				cfg2.save(file2);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		//
		// Online Zeit Aufzeichnung
		new BukkitRunnable() {
			@Override
			public void run() {
				// Onlinezeit Erhöhung jede Minute um 1

				boolean onlinetime_boolean = config.getBoolean("OnlineTime.Enabled");
				if (onlinetime_boolean) {
					if (p.isOnline()) {

						FileConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
						int onlinetime = cfg2.getInt("OnlineTime." + p.getName() + ".Time");
//		 				boolean onlinetime_reload = cfg2.getBoolean("Reload." + p.getName());
//		 				cfg2.set("Reload.", "- "  + p.getName().toString());
						cfg2.set("OnlineTime." + p.getName() + ".Time", onlinetime + 1);
						try {
							cfg2.save(file2);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						//
						// Anzeige der Onlinezeit nach 60 Minuten mit Belohnung und Title
						if (onlinetime == 60) {
							int fadein = config.getInt("Title.Tick.FadeIn");
							int fadeout = config.getInt("Title.Tick.FadeOut");
							int timeperiod = config.getInt("Title.Tick.Time");
							p.sendMessage("&c&oDeine OnlineZeit beträgt zurzeit : &f"
									+ cfg2.getInt("OnlineTime." + p.getName()) + ".Time" + "&c&o Minute/n !");
							p.sendMessage("&4&oVielen Dank das du bei uns auf dem Server spielst!");
							p.getInventory().addItem(new ItemStack(Material.DIAMOND, 10));
							p.sendTitle(ChatColor.YELLOW + "OnlineZeit",
									ChatColor.RED + "Deine aktuelle Onlinezeit beträgt: "
											+ cfg2.getInt("OnlineTime." + p.getName() + ".Time") + ChatColor.RED
											+ " Minute/n !",
									fadein, timeperiod, fadeout);
						}
						//
						// Anzeige der Onlinezeit nach 120 Minuten mit Belohnung und Title
						if (onlinetime == 120) {
							int fadein = config.getInt("Title.Tick.FadeIn");
							int fadeout = config.getInt("Title.Tick.FadeOut");
							int timeperiod = config.getInt("Title.Tick.Time");
							p.sendMessage("&c&oDeine OnlineZeit beträgt zurzeit : &f"
									+ cfg2.getInt("OnlineTime." + p.getName() + ".Time") + "&c&o Minute/n !");
							p.sendMessage("&4&oVielen Dank das du bei uns auf dem Server spielst!");
							p.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, 30));
							p.sendTitle(ChatColor.YELLOW + "OnlineZeit",
									ChatColor.RED + "Deine aktuelle Onlinezeit beträgt: "
											+ cfg2.getInt("OnlineTime." + p.getName() + ".Time") + ChatColor.RED
											+ " Minute/n !",
									fadein, timeperiod, fadeout);
						}
						//
					} else {
						FileConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
						cfg2.set("OnlineTime." + p.getName() + ".Reload", false);
						try {
							cfg2.save(file2);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						this.cancel();
					}
				} else {
					FileConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
					cfg2.set("OnlineTime." + p.getName() + ".Reload", false);
					try {
						cfg2.save(file2);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					this.cancel();
				}
			}
			// 1200 Ticks sind 1 Minute
		}.runTaskTimer(plugin, 1200, 1200);
	}
}
