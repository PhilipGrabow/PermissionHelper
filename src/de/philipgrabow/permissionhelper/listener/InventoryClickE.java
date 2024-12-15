package de.philipgrabow.permissionhelper.listener;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.ItemMeta;

import de.philipgrabow.permissionhelper.Main;
import de.philipgrabow.permissionhelper.PermissionMenue;

public class InventoryClickE implements Listener {

	@EventHandler(priority = EventPriority.HIGH)
	public void onInvClick(InventoryClickEvent e) {
		String invname = e.getView().getTitle();
//		e.getWhoClicked().sendMessage(invname);
		if (invname.equalsIgnoreCase("PermissionHelper")) {
			if (e.getCurrentItem().getType() == Material.PLAYER_HEAD) {
					ArrayList<String> list = new ArrayList<String>();
					for (Player p : Bukkit.getOnlinePlayers()) {
						list.add(p.getName());
					}
					ItemMeta meta = e.getCurrentItem().getItemMeta();
//					e.getWhoClicked().sendMessage(meta.getDisplayName());
//					e.getWhoClicked().sendMessage(list.get(0));
					if (list.contains(meta.getDisplayName())) {
						if (e.getClick().isLeftClick()) {
							if (e.getWhoClicked().hasPermission("PermissionHelper.Player")) {
								PermissionMenue.openInventory((Player) e.getWhoClicked(), meta.getDisplayName());
								e.setCancelled(true);
							} else {
								e.getWhoClicked().sendMessage("Du hast keine Berechtigung dafür");
								e.setCancelled(true);
							}
						} else {
							e.getWhoClicked().sendMessage("§cNur Linksklick erlaubt!");
							e.setCancelled(true);
						}
					}
			} else {
//				e.getWhoClicked().sendMessage(ChatColor.RED + "Dieses Item hat noch keine Funktion!");
				e.setCancelled(true);
			}
		}
		///////////////////////////////////////// Player-Men§//////////////////////////////////////////////////////////////////////////////////
//		ArrayList<String> list = new ArrayList<String>();
//		for (Player p : Bukkit.getOnlinePlayers()) {
//			list.add(p.getName());
//		}
		if (e.getCurrentItem().getType() == Material.DIAMOND_BLOCK) {
//			Player p = (Player) e.getWhoClicked();
//			ItemStack is = PlayerMenue.setOwnerHead(invname);
//			ItemMeta meta = is.getItemMeta();
			ItemMeta meta2 = e.getCurrentItem().getItemMeta();
			if (meta2.getDisplayName().equalsIgnoreCase("Macht den Spieler zum Admin!")) {
				if (e.getClick().isLeftClick()) {
					Main.setAdminGroup(e.getWhoClicked().getName());
					PermissionMenue.reloadinv();
				} else {
					e.getWhoClicked().sendMessage("§cNur Linksklick erlaubt!");
					e.setCancelled(true);
				}
			}
		} else if (e.getCurrentItem().getType() == Material.IRON_BLOCK) {
			ItemMeta meta2 = e.getCurrentItem().getItemMeta();
			if (meta2.getDisplayName().equalsIgnoreCase("Macht den Spieler zum Mitglied!")) {
				if (e.getClick().isLeftClick()) {						
					Main.setUserGroup(e.getWhoClicked().getName());
					PermissionMenue.reloadinv();
					e.setCancelled(true);
				} else {
					e.getWhoClicked().sendMessage("§cNur Linksklick erlaubt!");
					e.setCancelled(true);
				}
			}
		} else {
//			e.getWhoClicked().sendMessage(ChatColor.RED + "Dieses Item hat noch keine Funktion!");
			e.setCancelled(true);
		}
	}
}
