package spells;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class ForcePullSpell extends Spell {
	public ForcePullSpell() {
		super("ForcePull");
	}

	@Override
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
