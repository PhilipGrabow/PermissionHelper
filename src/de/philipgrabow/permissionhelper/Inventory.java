package de.philipgrabow.permissionhelper;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Inventory {
	public static void openInventory(Player p) {
		
		org.bukkit.inventory.Inventory inv = Bukkit.createInventory(null, 54, "PermissionHelper");
		loadItems(inv);
		p.openInventory(inv);
	}
	public static void loadItems(org.bukkit.inventory.Inventory inv) {
	
		inv.setItem(0, redglasspane());
		inv.setItem(1, redglasspane());
		inv.setItem(2, redglasspane());
		inv.setItem(3, redglasspane());
		inv.setItem(4, redglasspane());
		inv.setItem(5, redglasspane());
		inv.setItem(6, redglasspane());
		inv.setItem(7, redglasspane());
		inv.setItem(8, redglasspane());
		inv.setItem(9, redglasspane());
		inv.setItem(10, redglasspane());
		inv.setItem(11, redglasspane());
		inv.setItem(12, redglasspane());
		inv.setItem(13, redglasspane());
		inv.setItem(14, redglasspane());
		inv.setItem(15, redglasspane());
		inv.setItem(16, redglasspane());
		inv.setItem(17, redglasspane());
		inv.setItem(18, redglasspane());
		inv.setItem(19, redglasspane());
		inv.setItem(20, redglasspane());
		inv.setItem(21, redglasspane());
		inv.setItem(22, redglasspane());
		inv.setItem(23, redglasspane());
		inv.setItem(24, redglasspane());
		inv.setItem(25, redglasspane());
		inv.setItem(26, redglasspane());
		inv.setItem(27, redglasspane());
		inv.setItem(28, redglasspane());
		inv.setItem(29, redglasspane());
		inv.setItem(30, redglasspane());
		inv.setItem(31, redglasspane());
		inv.setItem(32, redglasspane());
		inv.setItem(33, redglasspane());
		inv.setItem(34, redglasspane());
		inv.setItem(35, redglasspane());
		inv.setItem(36, redglasspane());
		inv.setItem(37, redglasspane());
		inv.setItem(38, redglasspane());
		inv.setItem(39, redglasspane());
		inv.setItem(40, redglasspane());
		inv.setItem(41, redglasspane());
		inv.setItem(42, redglasspane());
		inv.setItem(43, redglasspane());
		inv.setItem(44, redglasspane());
		inv.setItem(45, redglasspane());
		inv.setItem(46, redglasspane());
		inv.setItem(47, redglasspane());
		inv.setItem(48, redglasspane());
		inv.setItem(49, redglasspane());
		inv.setItem(50, redglasspane());
		inv.setItem(51, redglasspane());
		inv.setItem(52, redglasspane());
		inv.setItem(53, redglasspane());
		
		int slot = 27;//Anfangsslot
		for (Player p : Bukkit.getOnlinePlayers()) {
			ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
			ItemMeta meta =  skull.getItemMeta();
			meta.setDisplayName(p.getName());
			ArrayList<String> list = new ArrayList<String>();
			list.add(ChatColor.YELLOW + p.getName() + "`s Permission-Menü");
			meta.setLore(list);
			skull.setItemMeta(meta);
			inv.setItem(slot, skull);
			slot++;
		}
	}
	public static ItemStack redglasspane() {
//		@SuppressWarnings("deprecation")
		ItemStack redglass = new ItemStack(Material.RED_STAINED_GLASS_PANE);
		ItemMeta meta = redglass.getItemMeta();
		meta.setDisplayName(ChatColor.RED + "Keine Funktion!");
		redglass.setItemMeta(meta);
		return redglass;
	}
}
