package eu.drham;

import eu.drham.commands.AcReport;
import eu.drham.commands.PingCommand;
import eu.drham.listener.DetectionListener;
import eu.drham.util.Distance;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import java.awt.*;

public class Proton extends JavaPlugin {
    public static final int ADDVL = 5;
    public static final String PREFIX = ChatColor.DARK_RED + "" + ChatColor.BOLD + "[AntiCheat] " + ChatColor.GREEN + "";

    @Override
    public void onEnable() {
        this.getCommand("ping").setExecutor(new PingCommand());
        this.getCommand("acreport").setExecutor(new AcReport());
        this.getServer().getPluginManager().registerEvents(new DetectionListener(), this);
        this.saveConfig();

    }

}
