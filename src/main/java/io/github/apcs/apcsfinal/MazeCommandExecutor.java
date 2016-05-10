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


public class MazeCommandExecutor implements org.bukkit.command.CommandExecutor {
	private final ApcsFinal plugin;
	private final MazeGen MAZE_GEN_DF = new MazeGenDF();
	private final MazeGen MAZE_GEN_KRUSKAL = new MazeGenKruskal();

	public MazeCommandExecutor(ApcsFinal plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length < 4) {
			return false;
		}
		if (sender instanceof Player) {
			Player player = (Player) sender;
			int width = Integer.parseInt(args[1]);
			int height = Integer.parseInt(args[2]);
			int depth = Integer.parseInt(args[3]);
			Material mat = Material.getMaterial(args[4].toUpperCase());
			
			MazeGen mazegen;
			if (args[0].equalsIgnoreCase("DF")) {
				mazegen = MAZE_GEN_DF;
			}
			else if (args[0].equalsIgnoreCase("Kruskal")) {
				mazegen = MAZE_GEN_KRUSKAL;
			}
			else {
				return false;
			}
			
			boolean[][] maze = mazegen.generateMaze(width, height);
			Location origin = player.getLocation().add(1, -1, 1);
			for (int x = 0; x < maze.length; x++) {
				for (int z = 0; z < maze[x].length; z++) {
					Location loc = origin.clone().add(x, 0, z);
					for (int y = 0; y < 1 + depth; y++) {
						loc.add(0, 1, 0);
						Block b = loc.getBlock();
						Material m;
						if (y == 0) {
							m = Material.DIRT;
						}
						else if (maze[x][z]) {
							m = Material.AIR;
						} 
						else {
							m = mat;
						}
						b.setType(m);


					}
				}
			}
			player.sendMessage("[APCS Final] " + args[0].toUpperCase() +" maze of size " + width + " x " + height + " x " + depth
					+ " made of " + mat.name() + " generated!");
			return true;
		}
		sender.sendMessage("Failed to generate maze");
		return false;
	}

}
