package io.github.apcs.apcsfinal;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import amazeing.MazeGen;
import amazeing.MazeGenDF;
import amazeing.MazeGenKruskal;

/**
 * Handles the execution of the /maze command
 * 
 * @author Nicholas
 *
 */
public class MazeCommandExecutor implements org.bukkit.command.CommandExecutor {
	private final ApcsFinal plugin;
	private final MazeGen MAZE_GEN_DF = new MazeGenDF();
	private final MazeGen MAZE_GEN_KRUSKAL = new MazeGenKruskal();

	/**
	 * Initializes the plugin
	 * 
	 * @param plugin
	 */
	public MazeCommandExecutor(ApcsFinal plugin) {
		this.plugin = plugin;
	}

	@Override
	/**
	 * Handles the execution of the /maze command
	 */
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length < 4) {
			return false;
		}
		if (sender instanceof Player) {
			Player player = (Player) sender;
			try {
				int width = (Integer.parseInt(args[1]) - 1) / 2;
				int height = (Integer.parseInt(args[2]) - 1) / 2;
				int depth = Integer.parseInt(args[3]);
				Material mat = Material.getMaterial(args[4].toUpperCase());
				boolean traps = false;
				int chance = 2;
				if (args.length > 5 && args[5].equalsIgnoreCase("traps")) {
					traps = true;
					chance = Integer.parseInt(args[6]);
				}

				MazeGen mazegen;
				// Sets the maze generator to "depth first"
				if (args[0].equalsIgnoreCase("DF")) {
					mazegen = MAZE_GEN_DF;
				}
				// Sets the maze generator to "kruskal"
				else if (args[0].equalsIgnoreCase("Kruskal")) {
					mazegen = MAZE_GEN_KRUSKAL;
				} else {
					return false;
				}
				// Generates the maze array, places the blocks
				boolean[][] maze = mazegen.generateMaze(width, height);
				Location origin = player.getLocation().add(1, -1, 1);
				for (int x = 0; x < maze.length; x++) {
					for (int z = 0; z < maze[x].length; z++) {
						Location loc = origin.clone().add(x, 0, z);
						Block b;
						for (int y = 0; y < 1 + depth; y++) {
							loc.add(0, 1, 0);
							b = loc.getBlock();
							Material m;
							if (y == 0) {
								m = Material.DIRT;
							} else if (maze[x][z]) {
								m = Material.AIR;
							} else {
								m = mat;
							}
							b.setType(m);

						}
						// Determines trap placement
						if (traps && maze[x][z] && x > 0 && x < maze.length - 1 && z > 0 && z < maze[x].length - 1) {
							loc.subtract(0, depth, 0);
							b = loc.getBlock();
							TrapGenerator.randomTrap(b, chance);
						}
					}
				}

				player.sendMessage("[APCS Final] " + args[0].toUpperCase() + " maze of size " + width + " x " + height
						+ " x " + depth + " made of " + mat.name() + " generated!");
				return true;
			} catch (Exception e) {
				player.sendMessage("Failed to generate maze. Maybe check the command usage?");
				return false;
			}
		}
		sender.sendMessage("Failed to generate maze");
		return false;
	}

}
