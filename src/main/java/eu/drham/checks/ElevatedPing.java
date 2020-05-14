package eu.drham.checks;

import eu.drham.Check;
import eu.drham.CheckType;
import eu.drham.Proton;
import eu.drham.info.Profile;
import org.bukkit.event.Event;

public class ElevatedPing extends Check {

    private static final CheckType type = CheckType.PING;
    public ElevatedPing(Profile profile) {
        super(type, profile);
    }

    @Override
    public void runCheck(Event event) {
        //TEMP. Kick instead
        if(profile.getPing() > 200){
            profile.addVL(Proton.ADDVL, type);
        }
    }
}
