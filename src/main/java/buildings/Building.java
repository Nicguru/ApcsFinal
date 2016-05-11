package buildings;

import org.bukkit.Location;
import org.bukkit.Material;

public abstract class Building {
	private int height;
	private int length;
	private int width;
	private Location loc;
	private Material mat;
	
	public Building(int length, int width, int height, Location loc, String mat) {
		this.length = length;
		this.width = width;
		this.height = height;
		this.loc = loc;
		this.mat = Material.getMaterial(mat);
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
	
	public abstract void generate();

}
