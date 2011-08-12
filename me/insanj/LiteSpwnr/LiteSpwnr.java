/*
 Created by Julian Weiss (insanj), updates frequent on Google+ (and sometimes Twitter)!

 Please do not modify or decompile at any date, but feel free to distribute with credit.
 Designed and created entirely on Friday, August 12th, 2011.
 Last edited on: 8/12/11

 LiteSpwnr 1.0!	
 Works with the current CraftBukkit Build (#1000).
 All other information should be available at bukkit.org under LiteSpwnr.

 THIS VERSION CURRENT HAS ONE CLASS:
			LiteSpwnr.java

*/

package me.insanj.LiteSpwnr;

import org.bukkit.event.Event;
import org.bukkit.plugin.java.JavaPlugin;

public class LiteSpwnr extends JavaPlugin{

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvent(Event.Type.PLAYER_COMMAND_PREPROCESS, new LiteListener(), Event.Priority.Normal, this);
		System.out.println("{LiteSpwnr} by insanj enabled.");
	}
	
	@Override
	public void onDisable() {
		System.out.println("{LiteSpwnr} by insanj disabled.");
	}

}
