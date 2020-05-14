package eu.drham.checks;


import eu.drham.Check;
import eu.drham.CheckType;
import eu.drham.Proton;
import eu.drham.info.Profile;
import eu.drham.util.Distance;
import org.bukkit.Location;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;

import java.awt.*;

public class Reach extends Check {

    private static final CheckType type = CheckType.REACH;


    public Reach(Profile profile) {
        super(type, profile);
    }

    
    @Override
    public void runCheck(Event event) {
        if(event instanceof EntityDamageByEntityEvent) {
            EntityDamageByEntityEvent hitEvent = (EntityDamageByEntityEvent) event;

            Vector hit = hitEvent.getEntity().getLocation().toVector();
            Vector susp = hitEvent.getDamager().getLocation().toVector();
            Profile suspect = Profile.getProfile(hitEvent.getDamager().getUniqueId());
            Distance dist = new Distance(susp, hit);


            if (dist.getDistance() > (double)5 ) {
                System.out.println(dist.getDistance() + "m");
                suspect.addVL(Proton.ADDVL, type);
            }
        }

    }
}
