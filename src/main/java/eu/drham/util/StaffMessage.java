package eu.drham.util;

import eu.drham.Proton;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class StaffMessage {


    public static void sendMessage(String msg){
        for(Player p : Bukkit.getOnlinePlayers()){
            if(p.hasPermission("ac.staff")) {
                p.sendMessage(Proton.PREFIX + ChatColor.GREEN + msg);
            }
        }
    }
}
