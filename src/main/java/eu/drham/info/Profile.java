package eu.drham.info;

import eu.drham.Check;
import eu.drham.CheckType;
import eu.drham.checks.ElevatedPing;
import eu.drham.checks.Reach;
import eu.drham.checks.Speed;
import eu.drham.util.Kick;
import eu.drham.util.StaffMessage;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public class Profile {

    public static ArrayList<Profile> profiles = new ArrayList<Profile>();
    public static ArrayList<Check> checks = new ArrayList<Check>();

    private void addChecks(){
        checks.add(new ElevatedPing(this));
        checks.add(new Reach(this));
        checks.add(new Speed(this));
    }

    public Check getCheck(CheckType check){
        for(Check check1 : checks){
            if( check == check1.getType()){
                return check1;
            }
        }
        return null;
    }
    public static Profile getProfile(UUID uuid){
        for(Profile p : profiles){
            if(p.getUuid() == uuid){
                return p;
            }
        }

        Profile pr = new Profile(uuid);
        profiles.add(pr);

        return pr;
    }




    private final UUID uuid;
    private int VL;

    public Profile(UUID uuid){
        this.uuid = uuid;
        int VL = 0;
        addChecks();
    }

    public UUID getUuid() {
        return uuid;
    }

    public void addVL(int VL2, CheckType checkType) {
        this.VL = VL+VL2;
        StaffMessage.sendMessage(getPlayer().getName() + ":" + checkType + " - " + "+" +VL2 + "(VL:" + VL + ") - " + getPing() + "ms");
        if(VL > 100){
            Kick.kickPlayer(getPlayer(), VL);
        }
    }

    public int getVL() {
        return VL;
    }

    public Player getPlayer(){
        return Bukkit.getPlayer(uuid);
    }

    public int getPing(){
        CraftPlayer cp = (CraftPlayer) getPlayer();
        return cp.getHandle().ping;

    }
}
