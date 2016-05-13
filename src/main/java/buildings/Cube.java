package buildings;

import org.bukkit.Location;
import org.bukkit.block.Block;

public class Cube extends Building {
	
	public Cube(int size, Location loc, String mat) {
		super(size, size, size, loc, mat);
	}

	@Override
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
