package spells;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

/**
 * Class that represents a castable spell, teleporting the player where they are facing
 * @author Gurdev
 *
 */
public class TeleportSpell extends Spell {
	
	/**
	 * Initializes the spell's name and description
	 * @param name
	 * @param desc
	 */
	public TeleportSpell(){
		super("Teleport" , "Teleports the player");
	}
	
	/**
	 * Makes given player cast the spell, teleporting the player where they are facing
	 * @param p - player to cast spell
	 */
	public void cast(Player p){
		Location loc = p.getEyeLocation();
		Entity player = (Entity)p;
		player.teleport(loc);
		//write warning if place has a drop/no blocks
	}
	
	

}
