package de.philipgrabow.permissionhelper.executor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.philipgrabow.permissionhelper.Inventory;

public class PermsCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("permshelper")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (p.hasPermission("PermissionHelper.GUI")) {
					Inventory.openInventory(p);
					return true;
				} else {
					p.sendMessage("Du hast keine Berechtigung dafür");
					return true;
				}
			} else {
				sender.sendMessage("Du musst ein Spieler sein!");
				return true;
			}
				
		}
		return false;
	}

}
