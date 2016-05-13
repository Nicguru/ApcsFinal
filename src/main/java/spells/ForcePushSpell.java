package spells;

import java.util.List;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class ForcePushSpell extends Spell {
	
	public ForcePushSpell() {
		super("ForcePush", "Screw Jedi Training. Use this spell to push enemies away with the Force.");
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
          b.multiply(5.0D);
          entity.setVelocity(b);
        }
        p.getWorld().playEffect(p.getLocation(), Effect.BLAZE_SHOOT, 1);
		// TODO Auto-generated method stub

	}

}
