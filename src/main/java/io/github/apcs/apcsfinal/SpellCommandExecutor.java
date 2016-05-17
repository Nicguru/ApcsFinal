package io.github.apcs.apcsfinal;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import spells.AimAndGainSpell;
import spells.DeathBlossomSpell;
import spells.BoostSpell;
import spells.FireballSpell;
import spells.ForcePullSpell;
import spells.ForcePushSpell;
import spells.FreezeSpell;
import spells.LightningSpell;
import spells.Spell;
import spells.TeleportSpell;

/**
 * Handles the execution of the /spell command
 * @author Nicholas
 *
 */
public class SpellCommandExecutor implements CommandExecutor, Listener {
	private ApcsFinal plugin;
	private static Spell spell = new FireballSpell();
	private static ArrayList<Spell> spellList;
	
	public SpellCommandExecutor(ApcsFinal plugin) {
		this.plugin = plugin;
		spellList = new ArrayList<Spell>();
		spellList.add(new FireballSpell());
		spellList.add(new LightningSpell());
		spellList.add(new ForcePushSpell());
		spellList.add(new ForcePullSpell());
		spellList.add(new BoostSpell());
		spellList.add(new FreezeSpell());
		spellList.add(new TeleportSpell());
		spellList.add(new AimAndGainSpell());
		spellList.add(new DeathBlossomSpell());

	}

	@Override
	/**
	 * Handles the execution of the command
	 */
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length < 1) {
			return false;
		}
		if (sender instanceof Player) {
			Player player = (Player) sender;
			//sets the spell type to spell with given name
			if (args[0].equalsIgnoreCase("set")) {
				for (Spell s : spellList) {
					if (s.getName().equalsIgnoreCase(args[1])) {
						spell = s;
					}
				}
				player.sendMessage("Spell set to " + ChatColor.BLUE + "" + ChatColor.BOLD + spell.getName());
			}
			//casts the set spell
			else if (args[0].equalsIgnoreCase("cast")) {
				spell.cast(player);
				player.sendMessage("Cast " + spell.getName());
			}
			//prints a list of all spells and spell descriptions
			else if (args[0].equalsIgnoreCase("list")) {
				for (Spell s: spellList) {
					player.sendMessage("");
					player.sendMessage(ChatColor.BOLD + "" + ChatColor.BLUE + s.getName());
					player.sendMessage(ChatColor.AQUA + s.getDesc());
				}
			}
			//prints the active spell
			else if (args[0].equalsIgnoreCase("active")) {
				player.sendMessage(spell.getName() + " is the active spell");
				player.sendMessage(spell.getDesc());
			}
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}
	
	@EventHandler
	public void onPlayerInteractBlock(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if (player.getItemInHand().getType() == Material.STICK) {
			spell.cast(player);
		}
		
	}

	

	

}
