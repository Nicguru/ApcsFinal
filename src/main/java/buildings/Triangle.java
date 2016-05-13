package buildings;

import org.bukkit.Location;
import org.bukkit.block.Block;

public class Triangle extends Building {

	public Triangle(int length, int width, Location loc, String mat) {
		super(length, width, length, loc, mat);
	}

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
