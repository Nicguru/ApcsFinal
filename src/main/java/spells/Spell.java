package spells;

import org.bukkit.entity.Player;

public abstract class Spell {
	private String spellName;
	private String description;
	
	public Spell(String name, String desc) {
		spellName = name;
		description = desc;
	}
	
	public String getName() {
		return spellName;
	}
	
	public String getDesc() {
		return description;
	}
	
	public abstract void cast(Player p);

}
