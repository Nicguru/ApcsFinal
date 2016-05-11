package spells;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class LightningSpell extends Spell {

	public LightningSpell() {
		super("Lightning");
	}

	@Override
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
