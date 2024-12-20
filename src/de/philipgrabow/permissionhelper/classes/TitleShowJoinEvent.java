package de.philipgrabow.permissionhelper.classes;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.philipgrabow.permissionhelper.Main;

public class TitleShowJoinEvent {

	public void TitleShow_onJoinEvent(Player p, Main plugin) {
		File file_config = new File("plugins/PermissionHelper", "config.yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file_config);
		// Anzeige OnlineTime in Title
		int delay_title = config.getInt("Title.Tick.Delay");
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

			@Override
			public void run() {
				int fadein = config.getInt("Title.Tick.FadeIn");
				int fadeout = config.getInt("Title.Tick.FadeOut");
				int timeperiod = config.getInt("Title.Tick.Time");
				String title_line1 = config.getString("Title.Text.MainTitle");
				String title_line2 = config.getString("Title.Text.SubTitle");
				String onlinetime_player = "";

				if (config.getBoolean("Title.Enabled")) {
					if (title_line2.contains("%onlinetime%")) {
						File file2 = new File("plugins/PermissionHelper", "OnlineTime.yml");
						FileConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
						onlinetime_player = cfg2.getString("OnlineTime." + p.getName() + ".Time");
						if (onlinetime_player.length() > 0) {
							title_line2 = title_line2.replace("%onlinetime%", onlinetime_player);
						}
					}

					p.sendTitle(title_line1, title_line2, fadein, timeperiod, fadeout);

				}
			}

		}, delay_title);
	}

}
