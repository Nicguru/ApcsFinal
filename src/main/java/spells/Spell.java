package spells;

import org.bukkit.entity.Player;

/**
 * Abstract class that represents a castable spell
 * @author Nicholas
 *
 */
public abstract class Spell {
	private String spellName;
	private String description;
	
	/**
	 * Initializes the spell's name and description
	 * @param name
	 * @param desc
	 */
	public Spell(String name, String desc) {
		spellName = name;
		description = desc;
	}
	
	/**
	 * Returns the name of the spell
	 * @return - spellName
	 */
	public String getName() {
		return spellName;
	}
	
	/**
	 * Returns the description of the spell
	 * @return - description
	 */
	public String getDesc() {
		return description;
	}
	
	/**
	 * Makes given player cast the spell
	 * @param p - player to cast spell
	 */
	public abstract void cast(Player p);

}
