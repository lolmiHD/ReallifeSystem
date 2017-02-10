package de.lolmiCastHD.Reallife.Handy;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import de.lolmiCastHD.Reallife.Main.Main;
import de.lolmiCastHD.Reallife.Methoden.ItemStack_Methoden;

public class Handy_Listener implements Listener{
	
	private Main instance = Main.getInstance();
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
			if(e.getInventory().getTitle().equals("§6Handy")) {
				e.setCancelled(true);
			}
			
			// █████ BESTELLUNGEN █████
			
			String nameBestellung = this.instance.getConfig().getString("Handy.Amazon.Name");
			nameBestellung = nameBestellung.replaceAll("&", "§");
			
			String itemBauer = this.instance.getConfig().getString("Handy.Amazon.Bauer.Item");
			
			String nameBauer = this.instance.getConfig().getString("Handy.Amazon.Bauer.Name");
			nameBauer = nameBauer.replaceAll("&", "§");
			
			String loreBauer = this.instance.getConfig().getString("Handy.Amazon.Bauer.Lore");
			loreBauer = loreBauer.replaceAll("&", "§");
			
			Boolean glowBauer = this.instance.getConfig().getBoolean("Handy.Amazon.Bauer.Glow");
			
			String itemSchmied = this.instance.getConfig().getString("Handy.Amazon.Schmied.Item");
			
			String nameSchmied = this.instance.getConfig().getString("Handy.Amazon.Schmied.Name");
			nameSchmied = nameSchmied.replaceAll("&", "§");
			
			String loreSchmied = this.instance.getConfig().getString("Handy.Amazon.Schmied.Lore");
			loreSchmied = loreSchmied.replaceAll("&", "§");
			
			Boolean glowSchmied = this.instance.getConfig().getBoolean("Handy.Amazon.Schmied.Glow");
			
			String itemSuper = this.instance.getConfig().getString("Handy.Amazon.Supermarkt.Item");
			
			String nameSuper = this.instance.getConfig().getString("Handy.Amazon.Supermarkt.Name");
			nameSuper = nameSuper.replaceAll("&", "§");
			
			String loreSuper = this.instance.getConfig().getString("Handy.Amazon.Supermarkt.Lore");
			loreSuper = loreSuper.replaceAll("&", "§");
			
			Boolean glowSuper = this.instance.getConfig().getBoolean("Handy.Amazon.Supermarkt.Glow");
			
			String itemPluto = this.instance.getConfig().getString("Handy.Amazon.Pluto.Item");
			
			String namePluto = this.instance.getConfig().getString("Handy.Amazon.Pluto.Name");
			namePluto = namePluto.replaceAll("&", "§");
			
			String lorePluto = this.instance.getConfig().getString("Handy.Amazon.Pluto.Lore");
			lorePluto = lorePluto.replaceAll("&", "§");
			
			Boolean glowPluto = this.instance.getConfig().getBoolean("Handy.Amazon.Pluto.Glow");
			
			// █████ BESTELLUNGEN █████
			
				
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(nameBestellung)) {
					
				Player p = (Player) e.getWhoClicked();
				Inventory inv = Bukkit.createInventory(null, 3*9, nameBestellung);
				
				ItemStack Bauer = ItemStack_Methoden.createItemStack(Material.getMaterial(itemBauer), nameBauer, (short) 0, 1, loreBauer, "", glowBauer, true);
				ItemStack Schmied = ItemStack_Methoden.createItemStack(Material.getMaterial(itemSchmied), nameSchmied, (short) 0, 1, loreSchmied, "", glowSchmied, true);
				ItemStack Supermarkt = ItemStack_Methoden.createItemStack(Material.getMaterial(itemSuper), nameSuper, (short) 0, 1, loreSuper, "", glowSuper, true);
				ItemStack Pluto = ItemStack_Methoden.createItemStack(Material.getMaterial(itemPluto), namePluto, (short) 0, 1, lorePluto, "", glowPluto, true);
				
				inv.setItem(9, Bauer);
				inv.setItem(10, Schmied);
				inv.setItem(11, Supermarkt);
				inv.setItem(12, Pluto);

				
				p.openInventory(inv);
			}
		}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Handy")) {
				
				Inventory inv = Bukkit.createInventory(null, 3*9, "§6Handy");
				
				// █████ TELEFON █████
				
				String name = this.instance.getConfig().getString("Handy.Telefon.Name");
				name = name.replaceAll("&", "§");
				
				String lore = this.instance.getConfig().getString("Handy.Telefon.Lore");
				lore = lore.replaceAll("&", "§");
				
				Boolean glow = this.instance.getConfig().getBoolean("Handy.Telefon.Glow");
				
				ItemStack Telefon = ItemStack_Methoden.createItemStack(Material.getMaterial(this.instance.getConfig().getString("Handy.Telefon.Item")), name, (short) 0, 1, lore, "", glow, true);
				
				// █████ TELEFON █████
				
				// █████ EMAIL █████
				
				String name1 = this.instance.getConfig().getString("Handy.SMS.Name");
				name1 = name1.replaceAll("&", "§");
				
				String lore1 = this.instance.getConfig().getString("Handy.SMS.Lore");
				lore1 = lore1.replaceAll("&", "§");
				
				Boolean glow1 = this.instance.getConfig().getBoolean("Handy.SMS.Glow");

				ItemStack SMS = ItemStack_Methoden.createItemStack(Material.getMaterial(this.instance.getConfig().getString("Handy.SMS.Item")), name1, (short) 0, 1, lore1, "", glow1, true);
				
				// █████ EMAIL █████
				
				// █████ AMAZON █████
				
				String name2 = this.instance.getConfig().getString("Handy.Amazon.Name");
				name2 = name2.replaceAll("&", "§");
							
				String lore2 = this.instance.getConfig().getString("Handy.Amazon.Lore");
				lore2 = lore2.replaceAll("&", "§");
							
				Boolean glow2 = this.instance.getConfig().getBoolean("Handy.Amazon.Glow");

				ItemStack Amazon = ItemStack_Methoden.createItemStack(Material.getMaterial(this.instance.getConfig().getString("Handy.Amazon.Item")), name2, (short) 0, 1, lore2, "", glow2, true);
							
				// █████ AMAZON █████
				
				// █████ TPANFRAGE █████
				
				String name3 = this.instance.getConfig().getString("Handy.TPAnfrage.Name");
				name3 = name3.replaceAll("&", "§");
										
				String lore3 = this.instance.getConfig().getString("Handy.TPAnfrage.Lore");
				lore3 = lore3.replaceAll("&", "§");
										
				Boolean glow3 = this.instance.getConfig().getBoolean("Handy.TPAnfrage.Glow");

				ItemStack Tpanfrage = ItemStack_Methoden.createItemStack(Material.getMaterial(this.instance.getConfig().getString("Handy.TPAnfrage.Item")), name3, (short) 0, 1, lore3, "", glow3, true);
										
				// █████ TPANFRAGE █████


				inv.setItem(9, Telefon);
				inv.setItem(10, SMS);
				inv.setItem(11, Amazon);
				inv.setItem(12, Tpanfrage);
				
				p.openInventory(inv);
				
			}
		}
	}
		
}

