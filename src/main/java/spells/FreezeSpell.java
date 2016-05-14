package spells;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import buildings.Cylinder;
/**
 * Class that represents a castable spell, freezing nearby entities
 * @author Nicholas
 *
 */
public class FreezeSpell extends Spell {

	/**
	 * Initializes the spell's name and description
	 * @param name
	 * @param desc
	 */
	public FreezeSpell() {
		super("Freeze", "Chilling. Use this spell to generate snow, freezing nearby players.");
	}

	@Override
	/**
	 * Makes given player cast the spell, creating a layer of snow, and freezing nearby entities
	 * @param p - player to cast spell
	 */
	public void cast(Player p) {

		ArrayList<Location> area = new Cylinder(10, 10, p.getLocation().clone().subtract(0, 5, 0), "SNOW").getLocs();
		for (Location loc : area) {
			if (loc.getBlock().getType() == Material.AIR
					&& loc.clone().subtract(0, 1, 0).getBlock().getType() != Material.AIR
					&& loc.clone().subtract(0, 1, 0).getBlock().getType() != Material.SNOW) {
				Block b = loc.getBlock();
				b.setType(Material.SNOW);
			}
		}
		PotionEffect pe = new PotionEffect(PotionEffectType.SLOW, 200, 10);
		List<Entity> entities = p.getNearbyEntities(10.0, 10.0, 10.0);
		for (Entity entity : entities) {
			if ((entity instanceof LivingEntity)) {
				LivingEntity le = (LivingEntity) entity;
				le.addPotionEffect(pe);
			}
		}

		// TODO Auto-generated method stub

	}

}
