package fr.enzokms;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import fr.enzokms.events.PlayerJoin;



/*
 * 
 * Main.java, de base
 * Pour les plugins de Netha avec Gourou.
 * 
 */

public class Main extends JavaPlugin implements Listener {
	public static Main plugin;
	
    @Override
    public void onEnable() {
    	
    	instance = this;
    	
    	System.out.println("Plugin OnEnable");
    	
    	plugin = this;
        this.getServer().getPluginManager().registerEvents(this, this);
        
        
        getCommand("sethome").setExecutor(new Commands()); 
        getCommand("home").setExecutor(new Commands()); 
        getCommand("delhome").setExecutor(new Commands()); 
        getCommand("test").setExecutor(new Commands()); 
        getCommand("spawn").setExecutor(new Commands()); 
        getCommand("tpa").setExecutor(new Commands());
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
        Bukkit.getPluginManager().registerEvents(new Commands(), this);
        
        
        
    }
     
    public static Main instance;
    
    public static Main getInstance() {
    	return instance;
    }

    
    @Override
    public void onDisable() {
        System.out.print("Plugin off");
    }
    
    
        
        
}