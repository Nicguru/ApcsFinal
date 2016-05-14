package spells;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

/**
 * Class that represents a castable spell, pulling all nearby entities toward the player
 * @author Nicholas
 *
 */
public class ForcePullSpell extends Spell {
	
	/**
	 * Initializes the spell's name and description
	 * @param name
	 * @param desc
	 */
	public ForcePullSpell() {
		super("ForcePull" , "Finally, you can reach that remote. Use this spell to pull enemies and objects toward you with the Force.");
	}

	@Override
	/**
	 * Makes given player cast the spell, pulling all nearby entities toward the player
	 * @param p - player to cast spell
	 */
	public void cast(Player p) {
		Location loc = p.getLocation();
		Vector a = p.getLocation().toVector();
        List<Entity> entities = p.getNearbyEntities(20.0, 20.0, 20.0);
        for (Entity entity : entities)
        {
          Vector b = entity.getLocation().toVector();
          b.subtract(a);
          b.setY(1);
          b.normalize();
          b.multiply(-2.0D);
          entity.setVelocity(b);
        }
		// TODO Auto-generated method stub

	}

}
