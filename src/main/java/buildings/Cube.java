package buildings;

import org.bukkit.Location;
import org.bukkit.block.Block;
/**
 * Class representing a cube
 * @author Nicholas
 *
 */
public class Cube extends Building {
	
	/**
	 * Initializes the size, location, and material of the cube
	 * @param size - size of the length, width, and height of the cube
	 * @param loc - location of the origin of the cube
	 * @param mat - material of the cube
	 */
	public Cube(int size, Location loc, String mat) {
		super(size, size, size, loc, mat);
	}

	@Override
	/**
	 * Generates the ArrayList for a cube
	 */
	public void generate() {
		Location origin = this.getLocation();
		for (int x = 0; x < getLength(); x++) {
			for (int y = 0; y < getHeight(); y++) {
				for (int z = 0; z < getWidth(); z++) {
					addLoc(origin.clone().add(x, y, z));
				}
			}
		}
			
	}

}
