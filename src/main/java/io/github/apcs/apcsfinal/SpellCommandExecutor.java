package io.github.apcs.apcsfinal;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import spells.BoostSpell;
import spells.FireballSpell;
import spells.ForcePullSpell;
import spells.ForcePushSpell;
import spells.LightningSpell;
import spells.Spell;

public class SpellCommandExecutor implements CommandExecutor {
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
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length < 1) {
			return false;
		}
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (args[0].equalsIgnoreCase("set")) {
				for (Spell s : spellList) {
					if (s.getName().equalsIgnoreCase(args[1])) {
						spell = s;
					}
				}
				player.sendMessage("Spell set to " + spell.getName());
			}
			else if (args[0].equalsIgnoreCase("cast")) {
				spell.cast(player);
				player.sendMessage("Cast " + spell.getName());
			}
			else if (args[0].equalsIgnoreCase("list")) {
				for (Spell s: spellList) {
					player.sendMessage(s.getName());
				}
			}
			else if (args[0].equalsIgnoreCase("active")) {
				player.sendMessage(spell.getName() + " is the active spell");
			}
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

}
