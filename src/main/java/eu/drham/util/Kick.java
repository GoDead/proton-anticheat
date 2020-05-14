package eu.drham.util;

import eu.drham.Proton;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Kick {

    public static void kickPlayer(Player p, int VL){
        Plugin pl = Proton.getPlugin(Proton.class);
        StaffMessage.sendMessage(p.getName() + pl.getConfig().getString("messages.staff.kick").replace("%VL%", VL+""));
        p.kickPlayer(Proton.PREFIX + "\n" + ChatColor.GOLD +  pl.getConfig().getString("messages.player.kick").replace("%VL%", VL+""));
    }

}
