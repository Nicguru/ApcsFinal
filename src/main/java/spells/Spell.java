package spells;

import org.bukkit.entity.Player;

public abstract class Spell {
	private String spellName;
	
	public Spell(String name) {
		spellName = name;
	}
	
	public String getName() {
		return spellName;
	}
	public abstract void cast(Player p);

}
