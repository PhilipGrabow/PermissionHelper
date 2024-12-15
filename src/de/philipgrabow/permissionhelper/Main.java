package de.philipgrabow.permissionhelper;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import de.philipgrabow.permissionhelper.executor.PermsCommand;
import de.philipgrabow.permissionhelper.listener.InventoryClickE;
import de.philipgrabow.permissionhelper.listener.PlayerJoinE;
import net.luckperms.api.LuckPerms;	

public class Main extends JavaPlugin{
	public static LuckPerms luckpermss = null;
	
	@Override
	public void onDisable() {
		Bukkit.getLogger().info("disabled!");
	}
	
	@Override
	public void onEnable() {
		if (Bukkit.getPluginManager().getPlugin("LuckPerms") != null) {
			setupLP();
		}
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new InventoryClickE(), this);
		pm.registerEvents(new PlayerJoinE(), this);
		
		getCommand("permshelper").setExecutor(new PermsCommand());
		
		Bukkit.getLogger().info("enabled!");
	}
	private static void setupLP() {
		RegisteredServiceProvider<LuckPerms> rsp = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
		if (rsp != null) {
			luckpermss = rsp.getProvider();
		}
	}
	public static String getGroup(String p) {
		String per = "Keine Gruppe";
		  per = luckpermss.getUserManager().getUser(p).getPrimaryGroup().toString();
		  return per;
	}
	public static void setAdminGroup(String p) {
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p + " promote");
		Bukkit.getPlayer(p).sendMessage("Der Rang von dir wurde auf Admin geändert!");
		Bukkit.getLogger().info("Der Rang von " + p + " wurde zu Admin geändert!");

	}
	public static void setUserGroup(String p) {
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p + " demote");
		Bukkit.getPlayer(p).sendMessage("Der Rang von dir wurde auf Mitglied geändert!");
		Bukkit.getLogger().info("Der Rang von " + p + " wurde zu Mitglied geändert!");
	}
}
