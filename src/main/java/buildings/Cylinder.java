package buildings;

import org.bukkit.Location;
import org.bukkit.block.Block;

/**
 * Class representing a cylinder
 * @author Nicholas
 *
 */
public class Cylinder extends Building {
	
	/**
	 * Initializes the radius, height, location and material of the cylinder
	 * @param radius - radius of the cylinder
	 * @param height - height of the cylinder
	 * @param loc - location of the cylinder origin
	 * @param mat - material of the cylinder
	 */
	public Cylinder(int radius, int height, Location loc, String mat) {
		super(radius, radius, height, loc, mat);
		
	}

	@Override
	/**
	 * Generates the ArrayList for a cylinder
	 */
	public void generate() {
		Location origin = this.getLocation();
		int rsq = getWidth() * getWidth();
		for (int y = 0; y < getHeight(); y++) {
			for (int x = -getLength()+1; x < getLength(); x++) {
				for (int z = -getWidth()+1; z < getWidth(); z++) {
					if (calculateDistance(x, z) <= rsq) {
						addLoc(origin.clone().add(x, y, z));
					}
					
					
				}
			}
		}
		// TODO Auto-generated method stub

	}
	
	/**
	 * Returns the sum of the squares of x and z
	 * @param x
	 * @param z
	 * @return - sum of the squares of x and z
	 */
	public int calculateDistance(int x, int z) {
		return x*x + z*z;
	}


}
