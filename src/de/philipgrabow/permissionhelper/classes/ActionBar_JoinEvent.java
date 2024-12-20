package de.philipgrabow.permissionhelper.classes;

import java.io.File;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import de.philipgrabow.permissionhelper.Main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class ActionBar_JoinEvent {
	int zahl = 0;


	public void ActionBar_onJoin(Player p, Main plugin) {
		File file_config = new File("plugins/PermissionHelper", "config.yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file_config);
		// ACTIONBAR MIT NACHRICHT
		int delay_actionbar = config.getInt("Actionbar.Tick.Delay");
		int period_actionbar = config.getInt("Actionbar.Tick.Period");
		// ActionBar Text aus Config laden
		List<String> stringlist = config.getStringList("Actionbar.Text");
		zahl = 0;
		//
		new BukkitRunnable() {
			@Override
			public void run() {
				if (config.getBoolean("Actionbar.Enabled")) {
					if (p.isOnline()) {
						p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(stringlist.get(zahl)));
						zahl++;
						if (zahl == stringlist.size()) {
							zahl = 0;
							return;
						}
					} else {
						this.cancel();
					}
				} else {
					this.cancel();
				}
			}
		}.runTaskTimer(plugin, delay_actionbar, period_actionbar);
	}

}
