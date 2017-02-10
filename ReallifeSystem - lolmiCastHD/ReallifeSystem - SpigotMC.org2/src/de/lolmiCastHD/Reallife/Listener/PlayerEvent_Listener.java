package de.lolmiCastHD.Reallife.Listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.lolmiCastHD.Reallife.Main.Main;

public class PlayerEvent_Listener implements Listener {

	private Main instance = Main.getInstance();

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();

		String pr = this.instance.getConfig().getString("Server.Prefix");
		pr = pr.replaceAll("&", "§");

		String msg = this.instance.getConfig().getString("Server.JoinMessage");

		msg = msg.replaceAll("&", "§");
		msg = msg.replaceAll("%prefix%", pr);
		msg = msg.replaceAll("%player%", p.getName());

		e.setJoinMessage(msg);

		p.setFlying(false);
		p.setFireTicks(0);
		
		ItemStack Handy = new ItemStack(Material.STONE);
		ItemMeta im = Handy.getItemMeta();
		im.setDisplayName("§6Handy");
		Handy.setItemMeta(im);
		
		p.getInventory().setItem(0, Handy);
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		
		String pr = this.instance.getConfig().getString("Server.Prefix");
		pr = pr.replaceAll("&", "§");

		String msg = this.instance.getConfig().getString("Server.QuitMessage");

		msg = msg.replaceAll("&", "§");
		msg = msg.replaceAll("%prefix%", pr);
		msg = msg.replaceAll("%player%", p.getName());
		
		e.setQuitMessage(msg);
	}

}
