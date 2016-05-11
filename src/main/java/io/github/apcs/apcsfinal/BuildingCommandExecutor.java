package io.github.apcs.apcsfinal;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import buildings.Cube;
import buildings.Sphere;

public class BuildingCommandExecutor implements CommandExecutor {
	private final ApcsFinal plugin;

	
	public BuildingCommandExecutor(ApcsFinal plugin) {
		this.plugin = plugin;
	}


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length < 2) {
			return false;
		}
		if (sender instanceof Player) {
			Player player = (Player)sender;
			if (args[0].equalsIgnoreCase("cube")) {
				int size = Integer.parseInt(args[1]);
				String mat = args[2];
				Location loc = player.getLocation().add(5, 0, 5);
				new Cube(size, loc, mat);
			}
			else if (args[0].equalsIgnoreCase("sphere")) {
				int size = Integer.parseInt(args[1]);
				String mat = args[2];
				Location loc = player.getLocation().add(size, size, size);
				new Sphere(size, loc, mat);
			}
			else {
				return false;
			}
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

}
