package buildings;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
/**
 * Class representing a building with 3 dimensions
 * @author Nicholas
 *
 */
public abstract class Building {
	private int height;
	private int length;
	private int width;
	private Location loc;
	private Material mat;
	private ArrayList<Location> locs;
	
	/**
	 * Initializes the length, width, height, and location to given values, and generates an ArrayList of Location objects
	 * @param length - length of the building
	 * @param width - width of the building
	 * @param height - height of the building
	 * @param loc - location of the building's origin
	 * @param mat - material of the building
	 */
	public Building(int length, int width, int height, Location loc, String mat) {
		this.length = length;
		this.width = width;
		this.height = height;
		this.loc = loc;
		this.mat = Material.getMaterial(mat);
		locs = new ArrayList<Location>();
		this.generate();
	}
	
	/**
	 * Returns the height of the structure
	 * @return - height
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Returns the length of the structure
	 * @return - length
	 */
	public int getLength() {
		return length;
	}
	
	/**
	 * Returns the width of the structure
	 * @return - width
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Returns the Location of the structure
	 * @return - loc
	 */
	public Location getLocation() {
		return loc;
	}
	
	/**
	 * Returns the material of the structure
	 * @return
	 */
	public Material getMaterial() {
		return mat;
	}
	
	/**
	 * Returns an ArrayList of Locations of the structure's blocks
	 * @return
	 */
	public ArrayList<Location> getLocs() {
		return locs;
	}
	
	/**
	 * Add a given Location to the list
	 * @param loc
	 */
	public void addLoc(Location loc) {
		locs.add(loc);
	}
	
	/**
	 * Builds the structure based on the Locations in the ArrayList
	 */
	public void buildStructure() {
		for (Location loc : locs) {
			Block b = loc.getBlock();
			b.setType(getMaterial());
		}
	}
	
	/**
	 * Generates the ArrayList of locations
	 */
	public abstract void generate();

}
