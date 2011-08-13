/*
 Created ENTIRELY and COMPLETLY by Julian Weiss (insanj) updates frequent on Google+ (and sometimes Twitter)!

 Please do not modify or decompile at any date, but feel free to distribute with credit.
 Designed and created entirely on Friday, August 12th, 2011.
 Last edited on: 8/12/11

 LiteSpwnr 1.1!	
 Works with the current CraftBukkit Build (#1000).
 All other information should be available at bukkit.org under LiteSpwnr.

 THIS VERSION CURRENT HAS TWO CLASSES:
			LiteSpwnr.java
			LiteListener.java

*/

package me.insanj.LiteSpwnr;

import org.bukkit.event.Event;
import org.bukkit.plugin.java.JavaPlugin;

public class LiteSpwnr extends JavaPlugin{
	
	//The reason there isn't an onCommand() or other methods here is because I wanted to just use the
	//preprocess event instead. For me, it just makes it all simpler detecting if the command was correct,
	//and I don't like fooling around with onCommand() if the YAML is blank for commands. That's just me, though.
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvent(Event.Type.PLAYER_COMMAND_PREPROCESS, new LiteListener(), Event.Priority.Normal, this);
		System.out.println("{LiteSpwnr} by insanj enabled.");
	}
	
	@Override
	public void onDisable() {
		System.out.println("{LiteSpwnr} by insanj disabled.");
	}

}//end LiteSpwnr
