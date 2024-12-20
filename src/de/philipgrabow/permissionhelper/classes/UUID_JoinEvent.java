package de.philipgrabow.permissionhelper.classes;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class UUID_JoinEvent {

	public void UUIDcreate_onJoin(Player p) {
		File file = new File("plugins/PermissionHelper", "UUID.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

		String uid = p.getUniqueId().toString();
		if (file.exists()) {
		} else {
			try {
				cfg.save(file);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (cfg.contains(p.getName() + ".UUID")) {
			if (cfg.getString(p.getName() + ".UUID").equalsIgnoreCase(uid)) {
			}
		}
		cfg.set(p.getName() + ".UUID", uid);
		try {
			cfg.save(file);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
