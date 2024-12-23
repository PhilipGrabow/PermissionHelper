package de.philipgrabow.permissionhelper.classes;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

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
				int onlinetime_player = 0;
				if (config.getBoolean("Title.Enabled")) {
					if (title_line2.contains("%onlinetime%")) {
						File file2 = new File("plugins/PermissionHelper", "OnlineTime.yml");
						FileConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
						onlinetime_player = cfg2.getInt("OnlineTime." + p.getName() + ".Time");
						if (onlinetime_player > 0 && onlinetime_player <= 60) {
							title_line2 = title_line2.replace("%onlinetime%",Integer.toString(onlinetime_player));
						}else if (onlinetime_player > 60) {
							//Ab 61
							onlinetime_player = (onlinetime_player / 60);
							title_line2 = title_line2.replace("%onlinetime%", Integer.toString(onlinetime_player));
							title_line2 = title_line2.replace("Minute/n", "Stunde/n");
						}
					}

					p.sendTitle(title_line1, title_line2, fadein, timeperiod, fadeout);
					PotionEffect pe = new PotionEffect(PotionEffectType.DARKNESS, 60, 200);
					p.addPotionEffect(pe);
				}
			}

		}, delay_title);
	}

}
