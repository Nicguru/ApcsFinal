package io.github.apcs.apcsfinal;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import buildings.Building;
import buildings.Cube;
import buildings.Cylinder;
import buildings.Sphere;
import buildings.Triangle;

/**
 * Handles the execution of the /shape command
 * @author Nicholas
 *
 */
public class BuildingCommandExecutor implements CommandExecutor {
	private final ApcsFinal plugin;
	private static Building struct;

	
	/**
	 * Initializes the plugin
	 * @param plugin
	 */
	public BuildingCommandExecutor(ApcsFinal plugin) {
		this.plugin = plugin;
	}


	@Override
	/**
	 * Handles the execution of the /shape command
	 */
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length < 2) {
			return false;
		}
		if (sender instanceof Player) {
			Player player = (Player)sender;
			//sets the structure to a cube
			if (args[0].equalsIgnoreCase("cube")) {
				int size = Integer.parseInt(args[1]);
				String mat = args[2];
				Location loc = player.getLocation().add(5, 0, 5);
				struct = new Cube(size, loc, mat);
			}
			//sets the structure to a sphere
			else if (args[0].equalsIgnoreCase("sphere")) {
				int size = Integer.parseInt(args[1]);
				String mat = args[2];
				Location loc = player.getLocation().add(size, size, size);
				struct = new Sphere(size, loc, mat);
			}
			//sets the structure to a triangle
			else if (args[0].equalsIgnoreCase("triangle")) {
				int length = Integer.parseInt(args[1]);
				int width = Integer.parseInt(args[2]);
				String mat = args[3];
				Location loc = player.getLocation();
				struct = new Triangle(length, width, loc, mat);
			}
			//sets the structure to a cylinder
			else if (args[0].equalsIgnoreCase("cylinder")) {
				int size = Integer.parseInt(args[1]);
				int height = Integer.parseInt(args[2]);
				String mat = args[3];
				Location loc = player.getLocation();
				struct = new Cylinder(size, height, loc, mat);
				player.teleport(player.getLocation().add(0, height, 0));
			}


			else {
				return false;
			}
			struct.buildStructure();
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

}
