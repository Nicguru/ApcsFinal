package spells;

import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;

/**
 * Class representing a Fireball spell, launches fireballs
 * @author Nicholas
 *
 */
public class FireballSpell extends Spell {
	
	/**
	 * Initializes the spell's name and description
	 * @param name
	 * @param desc
	 */
	public FireballSpell() {
		super("Fireball", "Burn baby burn. Use this spell to launch a fireball that incinerates enemies.");
	}

	@Override
	/**
	 * Makes given player cast the spell, launching a fireball in the direction the player is facing.
	 * @param p - player to cast spell
	 */
	public void cast(Player p) {
		p.launchProjectile(Fireball.class);
		
		// TODO Auto-generated method stub

	}

}
