package spells;

import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;

public class FireballSpell extends Spell {
	
	public FireballSpell() {
		super("Fireball");
	}

	@Override
	public void cast(Player p) {
		p.launchProjectile(Fireball.class);
		
		// TODO Auto-generated method stub

	}

}
