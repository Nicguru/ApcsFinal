package spells;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

/**
 * Class representing a Lightning spell, striking lightning
 * @author Nicholas
 *
 */
public class LightningSpell extends Spell {

	/**
	 * Initializes the spell's name and description
	 * @param name
	 * @param desc
	 */
	public LightningSpell() {
		super("Lightning" , "Who needs Thor? Just use this spell to smite thine enemies.");
	}

	@Override
	/**
	 * Makes given player cast the spell, striking lightning where the player is facing
	 * @param p - player to cast spell
	 */
	public void cast(Player p) {
		Location loc = p.getEyeLocation();
		Vector dir = loc.getDirection().normalize();
		for (int i = 0; i <= 200; i++) {
			Block b = loc.add(dir).getBlock();
			if (b.getType() != Material.AIR){
				p.getWorld().strikeLightning(loc);
				break;
			}

			// TODO Auto-generated method stub

		}

	}
}
