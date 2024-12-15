package de.philipgrabow.permissionhelper;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;



public class PermissionMenue {
	
	public static String group = null;
	static String playname;
	static Player playerp;
	
	
	public static void openInventory(Player p, String name) {
		p.closeInventory();
		group = null;
		playerp = p;
		org.bukkit.inventory.Inventory inv = Bukkit.createInventory(p, 54, name);
		loadItems(inv, name);
		p.openInventory(inv);
		
	}
	public static void reloadinv() {
		
		openInventory(playerp, playname);
	}
	public static void loadItems(org.bukkit.inventory.Inventory inv, String name) {
		playname = name;
		ItemStack skull = skull(name);
		ItemStack userhead = setUserHead(name);
		ItemStack ownerhead = setOwnerHead(name);
	

		inv.setItem(0, skull);
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
		inv.setItem(47, userhead);
		inv.setItem(48, ownerhead);
		inv.setItem(49, redglasspane());
		inv.setItem(50, redglasspane());
		inv.setItem(51, redglasspane());
		inv.setItem(52, redglasspane());
		inv.setItem(53, redglasspane());
	}
	public static ItemStack redglasspane() {
		ItemStack redglass = new ItemStack(Material.RED_STAINED_GLASS_PANE);
		ItemMeta meta = redglass.getItemMeta();
		meta.setDisplayName(ChatColor.RED + "Keine Funktion!");
		redglass.setItemMeta(meta);
		return redglass;
	}
	public static ItemStack skull(String name) {
		ItemStack skullis = new ItemStack(Material.PLAYER_HEAD);
		File file = new File("plugins/PermissionHelper", "UUID.yml");
		FileConfiguration cfg2 = YamlConfiguration.loadConfiguration(file);
		if (cfg2.contains(name)) {
			String uid = cfg2.getString(name + ".UUID");
			Player p = Bukkit.getPlayer(UUID.fromString(uid));
			ItemMeta meta =  skullis.getItemMeta();
			meta.setDisplayName(p.getName());
			ArrayList<String> list = new ArrayList<String>();
			list.add("§aLeben: §c§l" + p.getHealth() + "§a von §c§l20.0 §aLebenspunkten");
			list.add("§aHunger: §c§l" + p.getFoodLevel() + "§a von §c§l20 §aHungerpunkten");
			list.add("§aGamemode: §c§l" + p.getGameMode());
			list.add("§aFliegen erlaubt: §c§l" + p.getAllowFlight());
			list.add("§aOperator: §c§l" + p.isOp());
			list.add("§aWelt: §c§l" + p.getWorld().getName());
			list.add("§aUUID: §c§l" + p.getUniqueId().toString());
			list.add("§cRANG: §c§l" + Main.getGroup(p.getName()));
			meta.setLore(list);
			skullis.setItemMeta(meta);
		}
		return skullis;
	}
	public static ItemStack setOwnerHead(String name) {
		ItemStack dia = new ItemStack(Material.DIAMOND_BLOCK);
		ItemMeta meta = dia.getItemMeta();
		meta.setDisplayName("Macht den Spieler zum Admin!");
		dia.setItemMeta(meta);
		return dia;
	}
	public static ItemStack setUserHead(String name) {
		ItemStack dia = new ItemStack(Material.IRON_BLOCK);
		ItemMeta meta = dia.getItemMeta();
		meta.setDisplayName("Macht den Spieler zum Mitglied!");
		dia.setItemMeta(meta);
		return dia;
	}
}