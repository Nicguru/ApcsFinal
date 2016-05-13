package buildings;

import org.bukkit.Location;
import org.bukkit.block.Block;

public class Cylinder extends Building {
	
	public Cylinder(int radius, int height, Location loc, String mat) {
		super(radius, radius, height, loc, mat);
		
	}

	@Override
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
	
	public int calculateDistance(int x, int z) {
		return x*x + z*z;
	}


}
