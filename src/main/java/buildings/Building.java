package buildings;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public abstract class Building {
	private int height;
	private int length;
	private int width;
	private Location loc;
	private Material mat;
	private ArrayList<Location> locs;
	
	public Building(int length, int width, int height, Location loc, String mat) {
		this.length = length;
		this.width = width;
		this.height = height;
		this.loc = loc;
		this.mat = Material.getMaterial(mat);
		locs = new ArrayList<Location>();
		this.generate();
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getLength() {
		return length;
	}
	
	public int getWidth() {
		return width;
	}
	public Location getLocation() {
		return loc;
	}
	public Material getMaterial() {
		return mat;
	}
	
	public ArrayList<Location> getLocs() {
		return locs;
	}
	
	public void addLoc(Location loc) {
		locs.add(loc);
	}
	
	public void buildStructure() {
		for (Location loc : locs) {
			Block b = loc.getBlock();
			b.setType(getMaterial());
		}
	}
	
	public abstract void generate();

}
