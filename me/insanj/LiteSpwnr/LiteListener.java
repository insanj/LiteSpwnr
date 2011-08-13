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
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.inventory.ItemStack;

public class LiteListener extends PlayerListener{
	
	public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event){
		
		//Let's try to decode what the user sent in.
		String[] message = event.getMessage().split(" ");

		//If the command (minus the slash) is less than four letters long (highest length of an id is four numbers (records))
		if( message[0].substring(1).length() <= 4 ){

			//Here, I wanted to implement the getServer().dispatchCommand() event, but, if there was no command found,
			//the server would always print out the "no command found" message... pretty sure that shouldn't happen,
			//but let me know if it was me that was doing it wrong.
			//First, we'll try dispatching the command any other plugins. If this clears, we're here.
			//Then, we try parsing the integer. If that clears out, I'm betting thecommand is probably for us. 
			//Otherwise, instead of giving an error message, we'll just let the server handle the no command found situation.
			try{ 
				if(event.getPlayer().getServer().getPluginCommand(message[0].substring(1)) != null)
					return;
				else
					Integer.parseInt(message[0].substring(1));
				
			} catch(Exception e){ return; }

			//Okay, so all is good, looks like we're using this plugin.
			try{
				//Tests if the item id is valid.
				if( ((Integer.parseInt(message[0].substring(1)) != 0)) && (Material.getMaterial(Integer.parseInt(message[0].substring(1))) != null) ){
				
					//If the command sent had no arguments whatsoever (spaces), and the only thing sent in was a four or less character
					//string, then the plugin will try to decode the message. If the following if executes successfully, then there was
					//no error plopping the direct items into the user inventory. If there was an error, we'll catch it below.
					if(message.length == 1 ){
						event.getPlayer().getInventory().addItem(new ItemStack(Integer.parseInt(message[0].substring(1)), 64));
						event.getPlayer().sendMessage( ChatColor.GREEN +  "A stack of " + ChatColor.YELLOW + "" + 
								Material.getMaterial(Integer.parseInt(message[0].substring(1))).name() + "" + ChatColor.GREEN + 
						" were added to your inventory!");
					}
				
					//If there were arguments found for the command...
					else if( message.length == 2 ){
						event.getPlayer().getInventory().addItem(new ItemStack(Integer.parseInt(message[0].substring(1)), Integer.parseInt(message[1])));
						event.getPlayer().sendMessage( "" + ChatColor.GREEN + Integer.parseInt(message[1]) + " blocks of " + ChatColor.YELLOW + "" + 
								Material.getMaterial(Integer.parseInt(message[0].substring(1))).name() + "" + ChatColor.GREEN + 
						" were added to your inventory!");
					}//end else if
					
					//If the parameters were too large, probably not for this plugin.
					else
						return;
				}
				else
					event.getPlayer().sendMessage(ChatColor.RED + "Excuse me, LiteSpwnr here, your item id number was faulty!");

			} catch(Exception e){
				event.getPlayer().sendMessage(ChatColor.RED + "If you were trying to use the LiteSpwnr plugin, the amount was invalid!");
			}

			//Making sure the "Command not found" message doesn't show up.
			event.setCancelled(true);
			
		}//end length if

		//If the initial command is MORE four letters long, it couldn't be part of this plugin, and even if it is, the id
		//is way too far off to call it reasonable. Just ignore it, don't overcomplicate.
		else
			return;

	}//end onPlayerCommandPreprocess()	
}//end LiteListener