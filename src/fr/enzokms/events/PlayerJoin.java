package fr.enzokms.events;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class PlayerJoin implements Listener {
	
	   @EventHandler
	   public void onJoin(PlayerJoinEvent event) {
		   Player player = event.getPlayer();
		   
		   event.setJoinMessage(ChatColor.DARK_GREEN + "Bonjour " + player.getName());
		   
		   ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
		   
		   item.addEnchantment(Enchantment.KNOCKBACK, 1);
		   item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 999);
		   
		   ItemMeta meta = item.getItemMeta();
		   meta.setDisplayName("§e épée de §6" + player.getName());
		   
		   item.setItemMeta(meta);
		   
		   player.getInventory().setItem(0, item);
		   
				   }
	
}
