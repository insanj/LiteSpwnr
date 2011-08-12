/*
 Created by Julian Weiss (insanj), updates frequent on Google+ (and sometimes Twitter)!

 Please do not modify or decompile at any date, but feel free to distribute with credit.
 Designed and created entirely on Friday, August 12th, 2011.
 Last edited on: 8/12/11

 LiteSpwnr 1.0!	
 Works with the current CraftBukkit Build (#1000).
 All other information should be available at bukkit.org under LiteSpwnr.

 THIS VERSION CURRENT HAS TWO CLASSES:
			LiteSpwnr.java
			LiteListener.java

*/

package me.insanj.LiteSpwnr;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.inventory.ItemStack;

public class LiteListener extends PlayerListener{
	public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event){
		try{
			String[] message = event.getMessage().split(" ");
			
			if( message[0].length() > 3 )
				return;
			if( message.length > 1 )
				event.getPlayer().getInventory().addItem(new ItemStack(Integer.parseInt(message[0].substring(1)), Integer.parseInt(message[1])));
			else
				event.getPlayer().getInventory().addItem(new ItemStack(Integer.parseInt(message[0].substring(1)), 64));
			
			event.setCancelled(true);
		}catch(Exception e){}
	}
}