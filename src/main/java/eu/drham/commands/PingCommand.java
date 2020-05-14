package eu.drham.commands;

import eu.drham.checks.KillAura;
import eu.drham.info.Profile;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PingCommand implements CommandExecutor {


    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(commandSender instanceof Player) {
            Player p = (Player) commandSender;
                if(strings.length > 0){
                    p.sendMessage(strings[0] + "->" + Profile.getProfile(Bukkit.getPlayer(strings[0]).getUniqueId()).getPing() + "ms" );
                }else{
                    p.sendMessage(p.getName() + "->" + Profile.getProfile(p.getUniqueId()).getPing() + "ms");
                }
        }
        return true;
    }
}
