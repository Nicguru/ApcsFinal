package spells;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public class BoostSpell extends Spell {

	public BoostSpell() {
		super("Boost", "Wheeee! Use this spell to launch in the direction you are facing. Just... watch the landing.");
	}

	@Override
	public void cast(Player p) {
		if (p.getLocation().add(0, -2, 0).getBlock().getType() != Material.AIR) {
			p.setVelocity(p.getEyeLocation().getDirection().multiply(10.0));
			p.getWorld().createExplosion(p.getLocation(), 0);
		}

	}

}
