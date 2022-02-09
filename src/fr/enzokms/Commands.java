package fr.enzokms;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Commands implements Listener, CommandExecutor {

    public boolean onCommand(CommandSender p, Command command, String label, String[] args) {
        
    	Player player = (Player) p;
    	
    	if(label.equalsIgnoreCase("test")) {
    		if (p.isOp()) {
    			p.sendMessage(ChatColor.RED + "Ceci est une commande de base");
    		}
    	}
    	
    	
    	
    	if(label.equalsIgnoreCase("Spawn")) {
    		player.teleport(new Location(player.getWorld(), 95.0, 68.0, 266.0));
    		p.sendMessage("Spawn has been effectued");
    	}
    	
    	if(label.equalsIgnoreCase("tpa")) {
    		if(p instanceof Player) {
    			
    			if(args.length != 3) {
    				
    				p.sendMessage("veuiller mettre les cordonnees");
    				return false;
    				}
    			
    			double x = Double.parseDouble(args[0]);
                double y = Double.parseDouble(args[1]);
                double z = Double.parseDouble(args[2]);
                
                if(y <= 0) {return false;}                
    			player.teleport(new Location(player.getWorld(), x, y, z));
        		p.sendMessage("Tp has been effectued");
    		}
    		
    	}
    	
    	if(label.equalsIgnoreCase("sethome")) {
    		if(p instanceof Player) {
    			
    			if(args.length == 0) {
    				p.sendMessage("§c Erreur : /sethome <nom du home>");
    				return false;
    			}
    			if(args.length == 1) {
    				
    				Main.getInstance().getConfig().set("home."+  player.getName().toString() +"."+ args[0] +".world", player.getLocation().getWorld().getName());
    				Main.getInstance().getConfig().set("home."+  player.getName().toString() +"."+ args[0] +".x", player.getLocation().getX());
    				Main.getInstance().getConfig().set("home."+  player.getName().toString() +"."+ args[0] +".y", player.getLocation().getY());
    				Main.getInstance().getConfig().set("home."+  player.getName().toString() +"."+ args[0] +".z", player.getLocation().getZ());
    				Main.getInstance().getConfig().set("home."+  player.getName().toString() +"."+ args[0] +".pitch", player.getEyeLocation().getPitch());
    				Main.getInstance().getConfig().set("home."+  player.getName().toString() +"."+ args[0] +".yaw", player.getEyeLocation().getYaw());
    				Main.getInstance().saveConfig();
    				
    				p.sendMessage("§a Votre home "+ args[0] +" à été sauvegardé !");
    				
    				return false;
    			}
    			if(args.length >= 2) {
    				
    				p.sendMessage("§c Erreur : /sethome <nom du home>");
    				return false;
    			}
    			
    			
    			
    		}
    	}
    	
    	if(label.equalsIgnoreCase("home")) {
    		if(p instanceof Player) {
    			
    			
    			if(args.length == 0) {
    				
    				p.sendMessage("§c Erreur : /home <nom du home>");
    				return false;
    			}
    			
    			if(args.length == 1) {
    				
    				if(Main.getInstance().getConfig().contains("home."+  player.getName().toString() +"."+ args[0])) {
    					
    					World w = Bukkit.getServer().getWorld(Main.getInstance().getConfig().getString("home."+  player.getName().toString() +"."+ args[0] +".world"));
    					double x = Main.getInstance().getConfig().getDouble("home."+  player.getName().toString() +"."+ args[0] +".x");
    					double y = Main.getInstance().getConfig().getDouble("home."+  player.getName().toString() +"."+ args[0] +".y");
    					double z = Main.getInstance().getConfig().getDouble("home."+  player.getName().toString() +"."+ args[0] +".z");
    					double pitch = Main.getInstance().getConfig().getDouble("home."+  player.getName().toString() +"."+ args[0] +".pitch");
    					double yaw = Main.getInstance().getConfig().getDouble("home."+  player.getName().toString() +"."+ args[0] +".yaw");
    					
    					player.teleport(new Location(w, x, y, z, (float) yaw, (float) pitch));
    					p.sendMessage("§a Vous avez été téléporté à votre home "+ args[0]);
    					return false;
    				
    				}else {
    					
    					p.sendMessage("§c Le home "+ args[0] +" n'existe pas !");
    					return false;
    				}
    			}
    			
    			if(args.length >= 2) {
    				
    				p.sendMessage("§c Erreur : /home <nom du home>");
    				return false;
    			}
    		}
    	}
    	
    	if(label.equalsIgnoreCase("delhome")) {
    		if(p instanceof Player) {
    			
    			if(args.length == 0) {
    				p.sendMessage("§c Erreur : /delhome <nom du home>");
    				return false;
    			}
    			
    			if(args.length == 1) {
    				if(Main.getInstance().getConfig().contains("home."+  player.getName().toString() +"."+ args[0])) {
    					Main.getInstance().getConfig().set("home."+  player.getName().toString() +"."+ args[0], null);
    					p.sendMessage("§a Votre home "+ args[0] +" à bien été supprimé");
    					return false;
    					
    				}else {
    					p.sendMessage("§c Le home "+ args[0] +" n'existe pas !");
    					return false;
    				}
    			}
    			
    			if(args.length >= 2) {
    				p.sendMessage("§c Erreur : /delhome <nom du home>");
    				return false;
    			}
    			
    		}
    	}
    	

    	
    	return false;
    }
}