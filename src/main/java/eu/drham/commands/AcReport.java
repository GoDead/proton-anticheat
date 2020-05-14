package eu.drham.commands;

import eu.drham.Proton;
import eu.drham.info.Profile;
import eu.drham.util.StaffMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.awt.*;

public class AcReport implements CommandExecutor {

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Plugin pl = Proton.getPlugin(Proton.class);

        if(commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (strings.length > 0) {
                Player suspect = Bukkit.getPlayer(strings[0]);
                if(suspect.isOnline()){
                   Profile profile =  Profile.getProfile(suspect.getUniqueId());
                   if(profile.getVL() > 30){
                       StaffMessage.sendMessage(Proton.PREFIX + pl.getConfig().getString( "messages.staff.report")
                               .replace("%player%", suspect.getName())
                               .replace("%VL%", profile.getVL()+"")
                                .replace("%ping%", profile.getPing()+""));
                       p.sendMessage(Proton.PREFIX +pl.getConfig().getString("messages.player.report.maybe"));
                   }else {
                       p.sendMessage(Proton.PREFIX +pl.getConfig().getString("messages.player.report.notsure"));
                   }
                }else{
                    p.sendMessage(Proton.PREFIX +pl.getConfig().getString("messages.player.report.notonline"));
                }

            }else{
                p.sendMessage(Proton.PREFIX + pl.getConfig().getString("messages.player.report.wrong"));

            }
        }
        return true;
    }
}
