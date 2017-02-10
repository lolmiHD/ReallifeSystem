package de.lolmiCastHD.Reallife.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;

public class Cancel_Listener implements Listener{
	
	@EventHandler
	public void onReward(PlayerAchievementAwardedEvent e) 
	{
		e.setCancelled(true);
	}
	
	
}
