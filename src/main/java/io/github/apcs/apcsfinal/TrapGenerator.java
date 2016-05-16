package io.github.apcs.apcsfinal;

import java.awt.Point;
import java.util.Random;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
/**
 * class designed to generate a randomly chosen trap to be implemented in a structure
 */
public class TrapGenerator {
	
	private static Random r = new Random();
/**
 * method to decide whether to generate a trap at selected block. There is a
 * 50/50 chance there will be a trap generated
 * @param b - Block chosen to have a trap generated at
 * @return true if a trap is generated, false if not
 */
	public static boolean randomTrap(Block b, int chance){
		int num = r.nextInt(chance);
		if(num == 0){
			createTrap(b);
			return true;
		}
		return false;
	}
/**
 * method to randomly choose what type of trap will be generated at a certain block
 * Depending on what number is chosen, the correlating trap will be generated.
 * Lava will be generated if 0 is chosen.
 * Fire will be generated if 1 is chosen.
 * Soul Sand will be generated if 2 is chosen.
 * Stationary Lava will be generated if 3 is chosen.
 * @param b - Block chosen to have a trap generated at
 * 
 */
	public static void createTrap(Block b){
		int num = r.nextInt(3);
		if(num == 0){
			b.setType(Material.LAVA);
			b.getLocation().clone().subtract(0, 1, 0).getBlock().setType(Material.DIRT);
		}
		else if(num == 1){
			b.setType(Material.NETHERRACK);
			b.getLocation().clone().add(0, 1, 0).getBlock().setType(Material.FIRE);
		}
		else if(num == 2){
			b.setType(Material.SOUL_SAND);
		}
		else if(num == 3){
			b.setType(Material.STATIONARY_LAVA);
			b.getLocation().clone().subtract(0, 1, 0).getBlock().setType(Material.DIRT);

		}
		
	}

}
