package buildings;

import org.bukkit.Location;
import org.bukkit.block.Block;

/**
 * Class representing a Sphere
 * @author Nicholas
 *
 */
public class Sphere extends Building {
	
	/**
	 * Initializes the size, location, and material of the sphere
	 * @param size
	 * @param loc
	 * @param mat
	 */
	public Sphere(int size, Location loc, String mat) {
		super(size, size, size, loc, mat);
	}

	@Override
	/**
	 * Generates the ArrayList for a sphere
	 */
	public void generate() {
		Location origin = this.getLocation();
		int rsq = getWidth() * getWidth();
		for (int x = -getLength()+1; x < getLength(); x++) {
			for (int y = -getHeight()+1; y < getHeight(); y++) {
				for (int z = -getWidth()+1; z < getWidth(); z++) {
					if (calculateDistance(x,y,z) <= rsq) {
						addLoc(origin.clone().add(x, y, z));
					}
				}
			}
		}
		// TODO Auto-generated method stub

	}
	
	/**
	 * Returns the sum of the squares of x, y, and z
	 * @param x
	 * @param y
	 * @param z
	 * @return - the sum of the squares of x, y, and z
	 */
	public int calculateDistance(int x, int y, int z) {
		return x*x + y*y + z*z;
	}

}
