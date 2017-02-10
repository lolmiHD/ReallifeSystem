package de.lolmiCastHD.Reallife.Main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.lolmiCastHD.Reallife.Commands.CMD_Reward;
import de.lolmiCastHD.Reallife.Handy.Handy_Listener;
import de.lolmiCastHD.Reallife.Listener.Cancel_Listener;
import de.lolmiCastHD.Reallife.Listener.PlayerEvent_Listener;


public class Main extends JavaPlugin
{
	
	public static Main instance;
	
	public static Main getInstance() 
	{
		return instance;
	}
	
	@Override
	public void onEnable() 
	{
		Bukkit.getConsoleSender().sendMessage("§d");
        Bukkit.getConsoleSender().sendMessage("§dReallife §8- ##############################################");
        Bukkit.getConsoleSender().sendMessage("§dReallife §8- # §a ReallifeSystem by ChrisByte and Castordog");
        Bukkit.getConsoleSender().sendMessage("§dReallife §8- #      §eDas Plugin wurde aktiviert");
        Bukkit.getConsoleSender().sendMessage("§dReallife §8- #      §a §a §a §a §a §aVersion 1.0.0");
        Bukkit.getConsoleSender().sendMessage("§dReallife §8- ##############################################");
        Bukkit.getConsoleSender().sendMessage("§d");
        
        loadConfig();
		instance = this;
		regCommands();
		regListener();
	}
	
	@Override
	public void onDisable() 
	{
		Bukkit.getConsoleSender().sendMessage("§d");
        Bukkit.getConsoleSender().sendMessage("§dReallife §8- ##############################################");
        Bukkit.getConsoleSender().sendMessage("§dReallife §8- # §a ReallifeSystem by ChrisByte and Castordog");
        Bukkit.getConsoleSender().sendMessage("§dReallife §8- #      §cDas Plugin wurde deaktiviert");
        Bukkit.getConsoleSender().sendMessage("§dReallife §8- #      §a §a §a §a §a §aVersion 1.0.0");
        Bukkit.getConsoleSender().sendMessage("§dReallife §8- ##############################################");
        Bukkit.getConsoleSender().sendMessage("§d");
	}
	
	public void regCommands() 
	{
		getCommand("archievments").setExecutor(new CMD_Reward());
	}
	
	public void regListener() 
	{
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new PlayerEvent_Listener(), this);
		pm.registerEvents(new Cancel_Listener(), this);
		pm.registerEvents(new Handy_Listener(), this);
		
	}
	
	public void loadConfig() 
	{
		
		getConfig().options().header("ReallifeSystem by ChrisByte and Castordog - ReallifeSystem V1.0.0");
		
		getConfig().addDefault("Sprache", "DE");
			    
	    if(this.getConfig().getString("Sprache").equals("DE")) {
	    							
			getConfig().addDefault("Server.Prefix", "&8[&6Reallife&8] &7");
			getConfig().addDefault("Server.Noperm", "%prefix%Dazu hast du keine Rechte");
			getConfig().addDefault("Server.ErrorCode", "%prefix%Dieser Command exisitert nicht");
			getConfig().addDefault("Server.JoinMessage", "%prefix%Der Spieler &6%player% &7hat den Server betreten");
			getConfig().addDefault("Server.QuitMessage", "%prefix%Der Spieler &6%player% &7hat den Server verlassen");
						
			getConfig().addDefault("Archievments.errorArchievment", "%prefix%Syntax: &6/archievments");
			getConfig().addDefault("Archievments.invNameArchievment", "&6Archievments");
			
			getConfig().addDefault("Archievments.Item1.Name", "&6Minenarbeiter - Starter");
			getConfig().addDefault("Archievments.Item1.Lore", "&cFarme insgesamt 100 CobbleBlöcke");
			getConfig().addDefault("Archievments.Item1.Glow", false);
			
			getConfig().addDefault("Archievments.Item2.Name", "&6Bauer - Starter");
			getConfig().addDefault("Archievments.Item2.Lore", "&cFarme 100 Seeds für deine Weizenfarm");
			getConfig().addDefault("Archievments.Item2.Glow", false);
						
			getConfig().addDefault("Handy.Telefon.Name", "&6Telefon");
			getConfig().addDefault("Handy.Telefon.Lore", "&bStartet die Telefon-APP");
			getConfig().addDefault("Handy.Telefon.Glow", false);
			getConfig().addDefault("Handy.Telefon.Item", "ARROW");
			
			getConfig().addDefault("Handy.SMS.Name", "&6SMS");
			getConfig().addDefault("Handy.SMS.Lore", "&bStartet die Messenger-APP");
			getConfig().addDefault("Handy.SMS.Glow", false);
			getConfig().addDefault("Handy.SMS.Item", "PAPER");
			
			getConfig().addDefault("Handy.Amazon.Name", "&6Bestellung");
			getConfig().addDefault("Handy.Amazon.Lore", "&bStartet die Amazon-APP");
			getConfig().addDefault("Handy.Amazon.Glow", false);
			getConfig().addDefault("Handy.Amazon.Item", "CHEST");
			
			getConfig().addDefault("Handy.TPAnfrage.Name", "&6TP-Anfrage");
			getConfig().addDefault("Handy.TPAnfrage.Lore", "&bStartet die Teleport-APP");
			getConfig().addDefault("Handy.TPAnfrage.Glow", false);
			getConfig().addDefault("Handy.TPAnfrage.Item", "SKULL_ITEM");
			
			getConfig().addDefault("Handy.Amazon.Bauer.Item", "HAY_BLOCK");
			getConfig().addDefault("Handy.Amazon.Bauer.Name", "&6Bauer");
			getConfig().addDefault("Handy.Amazon.Bauer.Lore", "&dBeim Bauern kannst du Dinge für dein Feld erwerben");
			getConfig().addDefault("Handy.Amazon.Bauer.Glow", false);
			
			getConfig().addDefault("Handy.Amazon.Schmied.Item", "DIAMOND_SWORD");
			getConfig().addDefault("Handy.Amazon.Schmied.Name", "&6Schmied");
			getConfig().addDefault("Handy.Amazon.Schmied.Lore", "&dBeim Schmied kannst du Rüstungen, Schwerter und weiter Dinge erwerben");
			getConfig().addDefault("Handy.Amazon.Schmied.Glow", false);
			
			getConfig().addDefault("Handy.Amazon.Supermarkt.Item", "APPLE");
			getConfig().addDefault("Handy.Amazon.Supermarkt.Name", "&6Supermarkt");
			getConfig().addDefault("Handy.Amazon.Supermarkt.Lore", "&dBeim Supermarkt kannst du Lebensmittel und vieles mehr erwerben");
			getConfig().addDefault("Handy.Amazon.Supermarkt.Glow", false);
			
			getConfig().addDefault("Handy.Amazon.Pluto.Item", "REDSTONE_BLOCK");
			getConfig().addDefault("Handy.Amazon.Pluto.Name", "&6Pluto");
			getConfig().addDefault("Handy.Amazon.Pluto.Lore", "&dBei Pluto kannst du Technik Gadgets wie z.B. Handys erwerben");
			getConfig().addDefault("Handy.Amazon.Pluto.Glow", false);
			
			getConfig().options().copyDefaults(true);
		    saveConfig();
		    reloadConfig();
	    	
	    } else if(this.getConfig().getString("Sprache").equals("EN")) {
	    				
			getConfig().addDefault("Sprache", "EN");
			
			getConfig().addDefault("Server.Prefix", "&8[&6Reallife&8] &7");
			getConfig().addDefault("Server.Noperm", "%prefix%Sorry, you don't have Permissions for that");
			getConfig().addDefault("Server.ErrorCode", "%prefix%This Command doesn't exists");
			getConfig().addDefault("Server.JoinMessage", "%prefix%The Player &6%player% &7has joined the Server");
			getConfig().addDefault("Server.QuitMessage", "%prefix%The Player &6%player% &7has left the Server");
			
			getConfig().addDefault("Archievments.errorArchievment", "%prefix% Syntax: &6/archievments");
			getConfig().addDefault("Archievments.invNameArchievment", "&6Archievments");
			
			getConfig().addDefault("Archievments.Item1.Name", "&6Miner - Starter");
			getConfig().addDefault("Archievments.Item1.Lore", "&cGet 100 Blocks of Cobble in your Inventory");
			getConfig().addDefault("Archievments.Item1.Glow", true);
			
			getConfig().addDefault("Archievments.Item2.Name", "&6Farmer - Starter");
			getConfig().addDefault("Archievments.Item2.Lore", "&cGet 100 Seeds for your farm");
			getConfig().addDefault("Archievments.Item2.Glow", true);
			
			getConfig().addDefault("Handy.Telefon.Name", "&6Telefon");
			getConfig().addDefault("Handy.Telefon.Lore", "&bstartet die Telefon-APP");
			getConfig().addDefault("Handy.Telefon.Glow", true);
			getConfig().addDefault("Handy.Telefon.Item", "ARROW");
			
			getConfig().addDefault("Handy.SMS.Name", "&6SMS");
			getConfig().addDefault("Handy.SMS.Lore", "&bstartet die Messenger-APP");
			getConfig().addDefault("Handy.SMS.Glow", true);
			getConfig().addDefault("Handy.SMS.Item", "PAPER");
			
			getConfig().addDefault("Handy.Amazon.Name", "&6Telefon");
			getConfig().addDefault("Handy.Amazon.Lore", "&bstartet die Amazon-APP");
			getConfig().addDefault("Handy.Amazon.Glow", true);
			getConfig().addDefault("Handy.Amazon.Item", "CHEST");
			
			getConfig().addDefault("Handy.TPAnfrage.Name", "&6TP-Anfrage");
			getConfig().addDefault("Handy.TPAnfrage.Lore", "&bstartet die Teleport-APP");
			getConfig().addDefault("Handy.TPAnfrage.Glow", true);
			getConfig().addDefault("Handy.TPAnfrage.Item", "SKULL");
			
			getConfig().options().copyDefaults(true);
		    saveConfig();
		    reloadConfig();
	    }

	}
}
