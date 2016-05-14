package spells;

import org.bukkit.Material;
import org.bukkit.entity.Player;
/**
 * Class that represents a castable spell, launching the player
 * @author Nicholas
 *
 */
public class BoostSpell extends Spell {

	/**
	 * Initializes the spell's name and description
	 * @param name
	 * @param desc
	 */
	public BoostSpell() {
		super("Boost", "Wheeee! Use this spell to launch in the direction you are facing. Just... watch the landing.");
	}

	@Override
	/**
	 * Makes given player cast the spell, launching the player in the direction they are facing if the player is on the ground.
	 * @param p - player to cast spell
	 */
	public void cast(Player p) {
		if (p.getLocation().add(0, -2, 0).getBlock().getType() != Material.AIR) {
			p.setVelocity(p.getEyeLocation().getDirection().multiply(10.0));
			p.getWorld().createExplosion(p.getLocation(), 0);
		}

	}

}
