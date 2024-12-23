package de.philipgrabow.permissionhelper.classes;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.philipgrabow.permissionhelper.Main;

public class ReloadServer_Events {

	public void TestReload(Main plugin) {
		for (Player p : plugin.getServer().getOnlinePlayers()) {
			File file2 = new File("plugins/PermissionHelper", "OnlineTime.yml");
			File file_config = new File("plugins/PermissionHelper", "config.yml");
			if (file2.exists()) {

			} else {
				try {
					file2.createNewFile();
					Bukkit.getLogger().warning("OnlineTime Datei erstellt!");
				} catch (IOException e1) {
					Bukkit.getLogger().warning("Kann keine OnlineTime Datei erstellen");
				}
			}
			//
			FileConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
			if (cfg2.getBoolean("OnlineTime." + p.getName() + ".Reload")) {
				FileConfiguration config = YamlConfiguration.loadConfiguration(file_config);
				boolean onlinetime_boolean = config.getBoolean("OnlineTime.Enabled");
				if (onlinetime_boolean) {
					// UUID in Datei speichern
					UUID_JoinEvent uje = new UUID_JoinEvent();
					uje.UUIDcreate_onJoin(p);
					//
					// Aufruf OnlineTimeJoinEvent
					OnlineTimeJoinEvent otje = new OnlineTimeJoinEvent();
					otje.onJoin_OnlineTime(p, Main.getInstance());
					//
					// Aufruf Title ShowJoinEvent
					TitleShowJoinEvent tsje = new TitleShowJoinEvent();
					tsje.TitleShow_onJoinEvent(p, Main.getInstance());
					//
					// ACTIONBAR MIT NACHRICHT
					ActionBar_JoinEvent abje = new ActionBar_JoinEvent();
					abje.ActionBar_onJoin(p, Main.getInstance());
					//
				} else {
					return;
				}
			} else {
				return;
			}
		}
	}

//	public void checkReload(Main plugin) {
//		File file2 = new File("plugins/PermissionHelper", "OnlineTime.yml");
//		File file_config = new File("plugins/PermissionHelper", "config.yml");
//		if (file2.exists()) {
//
//		} else {
//			try {
//				file2.createNewFile();
//				Bukkit.getLogger().warning("OnlineTime Datei erstellt!");
//			} catch (IOException e1) {
//				Bukkit.getLogger().warning("Kann keine OnlineTime Datei erstellen");
//			}
//		}
//		FileConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
//		List<String> stringlist = cfg2.getStringList("Reload");
//
////		zahl = 0;
//		for (int i = 0; i < stringlist.size(); i++) {
//			Bukkit.getLogger().info(stringlist.get(i));
//			File file = new File("plugins/PermissionHelper", "UUID.yml");
//			FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
//			String uuid = cfg.getString(stringlist.get(i) + ".UUID");
//			Player p = Bukkit.getServer().getPlayer(UUID.fromString(uuid));
//			FileConfiguration config = YamlConfiguration.loadConfiguration(file_config);
//			if (file2.exists()) {
//			} else {
//				try {
//					file2.createNewFile();
//					Bukkit.getLogger().warning("OnlineTime Datei erstellt!");
//				} catch (IOException e1) {
//					Bukkit.getLogger().warning("Kann keine OnlineTime Datei erstellen");
//				}
//			}
//			boolean onlinetime_boolean = config.getBoolean("OnlineTime.Enabled");
//			if (onlinetime_boolean == true) {
//				cfg2.set("Reload.", "- " + p.getName());
//				try {
//					cfg2.save(file2);
//				} catch (IOException e1) {
//					e1.printStackTrace();
//				}
//			}
//			//
//			// Online Zeit Aufzeichnung
//			new BukkitRunnable() {
//				@Override
//				public void run() {
//					// Onlinezeit Erhöhung jede Minute um 1
//					FileConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
//
//					if (onlinetime_boolean == true) {
//						if (p.isOnline()) {
//							int onlinetime = cfg2.getInt("OnlineTime." + p.getName());
//// 			 				boolean onlinetime_reload = cfg2.getBoolean("Reload." + p.getName());
//							cfg2.set("Reload.", "- " + p.getName());
//							cfg2.set("OnlineTime." + p.getName(), onlinetime + 1);
//							try {
//								cfg2.save(file2);
//							} catch (IOException e1) {
//								e1.printStackTrace();
//							}
//							//
//							// Anzeige der Onlinezeit nach 60 Minuten mit Belohnung und Title
//							if (onlinetime == 60) {
//								int fadein = config.getInt("Title.Tick.FadeIn");
//								int fadeout = config.getInt("Title.Tick.FadeOut");
//								int timeperiod = config.getInt("Title.Tick.Time");
//								p.sendMessage("&c&oDeine OnlineZeit beträgt zurzeit : &f"
//										+ cfg2.getInt("OnlineTime." + p.getName()) + "&c&o Minute/n !");
//								p.sendMessage("&4&oVielen Dank das du bei uns auf dem Server spielst!");
//								p.getInventory().addItem(new ItemStack(Material.DIAMOND, 10));
//								p.sendTitle(ChatColor.YELLOW + "OnlineZeit",
//										ChatColor.RED + "Deine aktuelle Onlinezeit beträgt: "
//												+ cfg2.getInt("OnlineTime." + p.getName()) + ChatColor.RED
//												+ " Minute/n !",
//										fadein, timeperiod, fadeout);
//							}
//							//
//							// Anzeige der Onlinezeit nach 120 Minuten mit Belohnung und Title
//							if (onlinetime == 120) {
//								int fadein = config.getInt("Title.Tick.FadeIn");
//								int fadeout = config.getInt("Title.Tick.FadeOut");
//								int timeperiod = config.getInt("Title.Tick.Time");
//								p.sendMessage("&c&oDeine OnlineZeit beträgt zurzeit : &f"
//										+ cfg2.getInt("OnlineTime." + p.getName()) + "&c&o Minute/n !");
//								p.sendMessage("&4&oVielen Dank das du bei uns auf dem Server spielst!");
//								p.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, 30));
//								p.sendTitle(ChatColor.YELLOW + "OnlineZeit",
//										ChatColor.RED + "Deine aktuelle Onlinezeit beträgt: "
//												+ cfg2.getInt("OnlineTime." + p.getName()) + ChatColor.RED
//												+ " Minute/n !",
//										fadein, timeperiod, fadeout);
//							}
//							//
//						} else {
//							cfg2.set("Reload." + p.getName(), "");
//							try {
//								cfg2.save(file2);
//							} catch (IOException e1) {
//								e1.printStackTrace();
//							}
//							this.cancel();
//						}
//					} else {
//						cfg2.set("Reload." + p.getName(), "");
//						try {
//							cfg2.save(file2);
//						} catch (IOException e1) {
//							e1.printStackTrace();
//						}
//						this.cancel();
//					}
//				}
//				// 1200 Ticks sind 1 Minute
//			}.runTaskTimer(plugin, 1200, 1200);
//		}
//	}
}
