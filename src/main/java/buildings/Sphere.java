package buildings;

import org.bukkit.Location;
import org.bukkit.block.Block;

public class Sphere extends Building {
	
	public Sphere(int size, Location loc, String mat) {
		super(size, size, size, loc, mat);
	}

	@Override
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
	
	public int calculateDistance(int x, int y, int z) {
		return x*x + y*y + z*z;
	}

}
