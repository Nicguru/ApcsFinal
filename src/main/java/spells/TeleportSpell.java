package spells;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

/**
 * Class that represents a castable spell, teleporting the player where they are facing
 * @author Gurdev
 *
 */
public class TeleportSpell extends Spell {
	
	/**
	 * Initializes the spell's name and description
	 * @param name
	 * @param desc
	 */
	public TeleportSpell(){
		super("Teleport" , "Teleports the player");
	}
	
	/**
	 * Makes given player cast the spell, teleporting the player where they are facing
	 * @param p - player to cast spell
	 */
	public void cast(Player p){
		Location loc = p.getEyeLocation();
		Vector dir = loc.getDirection().normalize();
		for (int i = 0; i <= 200; i++) {
			Block b = loc.add(dir).getBlock();
			if (b.getType().isSolid()) {
				while (loc.add(0, 1, 0).getBlock().getType().isSolid()) {
					
				}
				p.teleport(loc);
				break;
			}
		}
	}
	
	

}
