package spells;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.util.Vector;
/**
 * Class that represents a castable spell, adding a solid block the player is looking at into their inventory 
 * @author Gurdev
 *
 */

public class AimAndGainSpell extends Spell {
	
	/**
	 * Initializes the spell's name and description
	 * @param name
	 * @param desc
	 */
	public AimAndGainSpell() {
		super("Gain", "Add targeted block to inventory");
	}
	
	/**
	 * Makes given player cast the spell, adding a solid block the player is looking at into their inventory.
	 * @param p - player to cast spell
	 */
	public void cast(Player p) {
		Location loc = p.getEyeLocation();
		Vector dir = loc.getDirection().normalize();
		for (int i = 0; i <= 200; i++) {
			Block b = loc.add(dir).getBlock();
			if (b.getType().isSolid()) {
				PlayerInventory inventory = p.getInventory();
				ItemStack item = new ItemStack(b.getType(), 1);
				inventory.addItem(item);
				p.sendMessage("Gained " + item.getType().name());
				break;
			}
		}
	}
}
