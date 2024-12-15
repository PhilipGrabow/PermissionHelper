package de.philipgrabow.permissionhelper;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Inventory {

	public static void openInventory(Player p) {
		org.bukkit.inventory.Inventory inv = Bukkit.createInventory(null, 54, "PermissionHelper");
		loadItems(inv);
		p.openInventory(inv);
	}

//	@SuppressWarnings("deprecation")
	public static void loadItems(org.bukkit.inventory.Inventory inv) {
		//ItemStacks laden
//		ItemStack goldenapple = Inventory.GoldenApple();
//		ItemStack goldencarrot = Inventory.GoldenCarrot();
//		ItemStack tnt = Inventory.TnT();
//		ItemStack dayclock = Inventory.DC();
//		ItemStack nightclock = Inventory.NC();
//		ItemStack book = Inventory.hbook();
//		ItemStack paper = Inventory.infoblatt();
//		ItemStack steve = Inventory.skull1();
//		ItemStack steve2 = Inventory.skull2();
//		ItemStack wc = Inventory.WC();
//		ItemStack wr = Inventory.WR();
		
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
		
		// Player-MEN�
		// ///////////////////////////////////////////////////////////////////////////////////
		int slot = 27;//Anfangsslot
		for (Player p : Bukkit.getOnlinePlayers()) {
			ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
			ItemMeta meta =  skull.getItemMeta();
//			meta.setOwner(p.getName());
			meta.setDisplayName(p.getName());
			ArrayList<String> list = new ArrayList<String>();
			list.add(ChatColor.YELLOW + p.getName() + "`s Permission-Menü");
			meta.setLore(list);
			skull.setItemMeta(meta);
//			p.sendMessage(p.getName() + " : " + slot);
			inv.setItem(slot, skull);
			slot++;
		}
		//////////////////////////////////////////////////////////////////////////////////////////////////
		
	}
	public static ItemStack redglasspane() {
//		@SuppressWarnings("deprecation")
		ItemStack redglass = new ItemStack(Material.RED_STAINED_GLASS_PANE);
		ItemMeta meta = redglass.getItemMeta();
		meta.setDisplayName(ChatColor.RED + "Keine Funktion!");
		redglass.setItemMeta(meta);
		return redglass;
	}
	public static ItemStack GoldenApple() {
		ItemStack goldenapple = new ItemStack(Material.GOLDEN_APPLE);
		ItemMeta metaapple = goldenapple.getItemMeta();
		metaapple.setDisplayName(ChatColor.RED + "Heilen!");
		goldenapple.setItemMeta(metaapple);
		return goldenapple;
	}
	public static ItemStack GoldenCarrot() {
		ItemStack goldencarrot = new ItemStack(Material.GOLDEN_CARROT);
		ItemMeta metacarrot = goldencarrot.getItemMeta();
		metacarrot.setDisplayName(ChatColor.GOLD + "Deinen Hunger stillen!");
		goldencarrot.setItemMeta(metacarrot);
		return goldencarrot;
	}
	public static ItemStack TnT() {
		ItemStack tnt = new ItemStack(Material.TNT);
		ItemMeta metatnt = tnt.getItemMeta();
		metatnt.setDisplayName(ChatColor.RED + "Sterben!");
		tnt.setItemMeta(metatnt);
		return tnt;
	}
	public static ItemStack DC() {
		ItemStack dayclock = new ItemStack(Material.CLOCK);
//		ItemStack dayclock = new ItemStack(Material.getMaterial("WATCH"));
		ItemMeta metaday = dayclock.getItemMeta();
		ArrayList<String> descriptionday = new ArrayList<String>();
		descriptionday.add("Setzt die");
		descriptionday.add("Zeit auf Tag!");
		metaday.setLore(descriptionday);
		metaday.setDisplayName(ChatColor.YELLOW + "Zeit: Tag!");
		dayclock.setItemMeta(metaday);
		return dayclock;
	}

	public static ItemStack NC() {
		ItemStack nightclock = new ItemStack(Material.CLOCK);
		ItemMeta metanight = nightclock.getItemMeta();
		ArrayList<String> descriptionnight = new ArrayList<String>();
		descriptionnight.add("Setzt die");
		descriptionnight.add("Zeit auf Nacht!");
		metanight.setLore(descriptionnight);
		metanight.setDisplayName(ChatColor.BLUE + "Zeit: Nacht!");
		nightclock.setItemMeta(metanight);
		return nightclock;
	}

	public static ItemStack infoblatt() {
		ItemStack paper = new ItemStack(Material.PAPER);
		ItemMeta metapaper = paper.getItemMeta();
		ArrayList<String> descriptionpaper = new ArrayList<String>();
		descriptionpaper.add("Du benutzt das Plugin 'HelpItem'!");
		descriptionpaper.add("Autor: Philip_Grabow");
		descriptionpaper.add("Du kannst nur die vorhandenen Items nutzen mit Linksklick!");
		descriptionpaper.add("Manche Items benoetigen bestimmte Rechte!");
		descriptionpaper.add("Viel Spass beim Erforschen!");
		metapaper.setLore(descriptionpaper);
		metapaper.setDisplayName(ChatColor.GREEN + "Über dieses Plugin!");
		metapaper.addEnchant(Enchantment.UNBREAKING, 1, true);
		metapaper.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		paper.setItemMeta(metapaper);
		return paper;
	}

	public static ItemStack skull1() {
		ItemStack steve = new ItemStack(Material.PLAYER_HEAD);
		ItemMeta metakopf = steve.getItemMeta();
		ArrayList<String> descriptionkopf = new ArrayList<String>();
		descriptionkopf.add("Setzt den Spieler auf Rang: MITGLIED!");
		descriptionkopf.add("Deoppt den Spieler!");
		descriptionkopf.add("NUR FueR ADMINS!");
		metakopf.setLore(descriptionkopf);
		metakopf.setDisplayName(ChatColor.GREEN + "Dich zum Mitglied machen!");
		steve.setItemMeta(metakopf);
		return steve;
	}

	public static ItemStack skull2() {
		ItemStack steve2 = new ItemStack(Material.PLAYER_HEAD);
		ItemMeta metakopf2 = steve2.getItemMeta();
		ArrayList<String> descriptionkopf2 = new ArrayList<String>();
		descriptionkopf2.add("Setzt den Spieler auf Rang: Owner!");
		descriptionkopf2.add("Oppt den Spieler!");
		descriptionkopf2.add("NUR F�R ADMINS!");
		metakopf2.setLore(descriptionkopf2);
		metakopf2.setDisplayName(ChatColor.RED + "Dich zum Owner machen!");
		steve2.setItemMeta(metakopf2);
		return steve2;
	}
	public static ItemStack WC() {
		ItemStack weatherclear = new ItemStack(Material.SUNFLOWER);
		ItemMeta metaday = weatherclear.getItemMeta();
		ArrayList<String> descriptionday = new ArrayList<String>();
		descriptionday.add("Ändert das");
		descriptionday.add("Wetter zu Sonnig!");
		metaday.setLore(descriptionday);
		metaday.setDisplayName(ChatColor.YELLOW + "Wetter: Sonnig/Klar!");
		weatherclear.setItemMeta(metaday);
		return weatherclear;
	}
	public static ItemStack WR() {
		ItemStack weatherclear = new ItemStack(Material.WATER);
		ItemMeta metaday = weatherclear.getItemMeta();
		ArrayList<String> descriptionday = new ArrayList<String>();
		descriptionday.add("Ändert das");
		descriptionday.add("Wetter zu Regnerisch!");
		metaday.setLore(descriptionday);
		metaday.setDisplayName(ChatColor.YELLOW + "Wetter: Regen/Sturm!");
		weatherclear.setItemMeta(metaday);
		return weatherclear;
	}
}
