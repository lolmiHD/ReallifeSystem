package de.lolmiCastHD.Reallife.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import de.lolmiCastHD.Reallife.Main.Main;
import de.lolmiCastHD.Reallife.Methoden.ItemStack_Methoden;
import de.lolmiCastHD.Reallife.Methoden.Strings_Methoden;


public class CMD_Reward implements CommandExecutor{
	
	private Main instance = Main.getInstance();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		
		if(args.length == 0) {
			
			// Inventar
			String invname = this.instance.getConfig().getString("Archievments.invNameArchievment");
			invname = invname.replaceAll("&", "§");
			
			Inventory reward = Bukkit.createInventory(null, 3*9, invname);
			// Inventar
			
			// Item1
			String itemName1 = this.instance.getConfig().getString("Archievments.Item1.Name");
			itemName1 = itemName1.replaceAll("&", "§");
			
			String loreName1 = this.instance.getConfig().getString("Archievments.Item1.Lore");
			loreName1 = loreName1.replaceAll("&", "§");
			
			Boolean glow = this.instance.getConfig().getBoolean("Archievments.Item1.Glow");
			
			ItemStack archievment1 = ItemStack_Methoden.createItemStack(Material.COBBLESTONE, itemName1, (short) 0, 1, loreName1, "", glow, true);
			// Item1
			
			// Item2
			String itemName2 = this.instance.getConfig().getString("Archievments.Item2.Name");
			itemName2 = itemName2.replaceAll("&", "§");
						
			String loreName2 = this.instance.getConfig().getString("Archievments.Item2.Lore");
			loreName2 = loreName2.replaceAll("&", "§");
						
			Boolean glow2 = this.instance.getConfig().getBoolean("Archievments.Item2.Glow");
						
			ItemStack archievment2 = ItemStack_Methoden.createItemStack(Material.COBBLESTONE, itemName2, (short) 0, 1, loreName2, "", glow2, true);
			// Item2
			
			reward.setItem(0, archievment1);
			reward.setItem(1, archievment2);
			p.openInventory(reward);
		} else {
			String errorArchievment = this.instance.getConfig().getString("Archievments.errorArchievment");
			errorArchievment = errorArchievment.replaceAll("&", "§");
			errorArchievment = errorArchievment.replaceAll("%prefix%", Strings_Methoden.prefix);
			p.sendMessage(errorArchievment);
			return true;
			
		}
		return false;
	}
	

}
