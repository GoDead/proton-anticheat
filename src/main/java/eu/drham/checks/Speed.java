package eu.drham.checks;

import eu.drham.Check;
import eu.drham.CheckType;
import eu.drham.Proton;
import eu.drham.info.Profile;
import eu.drham.util.Distance;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class Speed extends Check {

    private static final CheckType type = CheckType.SPEED;


    public Speed(Profile profile) {
        super(type, profile);
    }


    @Override
    public void runCheck(Event event) {
        if(event instanceof PlayerMoveEvent) {

            PlayerMoveEvent moveEvent = (PlayerMoveEvent) event;

            /*
            * We want to compare them in a 2D plane
            *  Like:
            *           A
            *         ^ ^
            *    B ^
            */
            Vector from = moveEvent.getFrom().toVector().clone().setY(0);
            Vector to = moveEvent.getTo().toVector().clone().setY(0);
            double sped = to.distanceSquared(from);
            Profile suspect = Profile.getProfile(moveEvent.getPlayer().getUniqueId());



            if (sped*10 > 4 ) {
                System.out.println(sped*10+"");
                suspect.addVL(Proton.ADDVL, type);
            }
        }

    }
}
