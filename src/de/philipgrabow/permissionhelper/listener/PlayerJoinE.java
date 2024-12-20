package de.philipgrabow.permissionhelper.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.philipgrabow.permissionhelper.Main;
import de.philipgrabow.permissionhelper.classes.ActionBar_JoinEvent;
import de.philipgrabow.permissionhelper.classes.OnlineTimeJoinEvent;
import de.philipgrabow.permissionhelper.classes.TitleShowJoinEvent;
import de.philipgrabow.permissionhelper.classes.UUID_JoinEvent;

public class PlayerJoinE implements Listener {
	int zahl = 0;

	@EventHandler(priority = EventPriority.NORMAL)
	public void onJoin(PlayerJoinEvent e) {
		// UUID in Datei speichern
		UUID_JoinEvent uje = new UUID_JoinEvent();
		uje.UUIDcreate_onJoin(e.getPlayer());
		//
		// Aufruf OnlineTimeJoinEvent
		OnlineTimeJoinEvent otje = new OnlineTimeJoinEvent();
		otje.onJoin_OnlineTime(e.getPlayer(), Main.getInstance());
		//
		// Aufruf Title ShowJoinEvent
		TitleShowJoinEvent tsje = new TitleShowJoinEvent();
		tsje.TitleShow_onJoinEvent(e.getPlayer(), Main.getInstance());
		//
		// ACTIONBAR MIT NACHRICHT
		ActionBar_JoinEvent abje = new ActionBar_JoinEvent();
		abje.ActionBar_onJoin(e.getPlayer(), Main.getInstance());
		//
	}
}
