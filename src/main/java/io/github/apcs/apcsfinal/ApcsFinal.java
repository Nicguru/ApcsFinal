package io.github.apcs.apcsfinal;

import org.bukkit.plugin.java.JavaPlugin;

public class ApcsFinal extends JavaPlugin {
	
	public void onEnable() {
		this.getCommand("maze").setExecutor(new MazeCommandExecutor(this));
	}

}
