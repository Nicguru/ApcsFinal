package buildings;

import org.bukkit.Location;
import org.bukkit.block.Block;
/**
 * Class representing a triangular prism
 * @author Nicholas
 *
 */
public class Triangle extends Building {

	/**
	 * Initializes the length, width, location and material of the triangle to the given values
	 * @param length - length of the triangle
	 * @param width - width of the triangle
	 * @param loc - location of the triangle's origin
	 * @param mat - material of the triangle
	 */
	public Triangle(int length, int width, Location loc, String mat) {
		super(length, width, length, loc, mat);
	}

	/**
	 * Generates the ArrayList for triangle
	 */
	public void generate() {
		Location origin = this.getLocation();
		for (int y = 0; y < getHeight(); y++) {
			for (int x = 0; x < getLength() - 2 * y; x++) {
				for (int z = 0; z < getWidth(); z++) {
					addLoc(origin.clone().add(x + y, y, z));
				}
			}
		}
	}

}
