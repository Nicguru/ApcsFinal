package spells;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Class that represents a castable spell, slowly damaging nearby entities
 * @author Gurdev
 *
 */
public class DeathBlossomSpell extends Spell {
	
	/**
	 * Initializes the spell's name and description
	 * @param name
	 * @param desc
	 */
	public DeathBlossomSpell(){
		super("DeathBlossom" , "Die, die, die! Use this spell to kill nearby enemies.");
	}
	
	/**
	 * Makes given player cast the spell, slowly damaging nearby entities
	 * @param p - player to cast spell
	 */
	public void cast(Player p){
		List<Entity> entities = p.getNearbyEntities(10.0, 10.0, 10.0);
		PotionEffect pe = new PotionEffect(PotionEffectType.WITHER, 200, 50);
		for(Entity entity : entities){
			if (entity instanceof LivingEntity) {
				LivingEntity le = (LivingEntity) entity;
				le.addPotionEffect(pe);
			}
		}
		p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "DIE, DIE, DIE!!!");
	}
}
