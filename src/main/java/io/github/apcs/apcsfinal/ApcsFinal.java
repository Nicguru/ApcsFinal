package io.github.apcs.apcsfinal;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main class for the plugin
 * @author Nicholas
 *
 */
public class ApcsFinal extends JavaPlugin{
	
	/**
	 * Enables the command executors for the commands when the plugin is enabled
	 */
	@Override
	public void onEnable() {
		this.getCommand("maze").setExecutor(new MazeCommandExecutor(this));
		this.getCommand("shape").setExecutor(new BuildingCommandExecutor(this));
		this.getCommand("spell").setExecutor(new SpellCommandExecutor(this));
		getServer().getPluginManager().registerEvents(new SpellCommandExecutor(this), this);

	}
	
	@Override
	public void onDisable() {
		
	}
	

	


}
