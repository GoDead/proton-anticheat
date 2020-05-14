package eu.drham;

import eu.drham.info.Profile;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public class Check {

    protected CheckType type;
    protected Profile profile;

    public Check(CheckType type, Profile profile){
        this.type = type;
        this.profile = profile;
    }

    public void runCheck(Event event){
    }


    public CheckType getType() {
        return type;
    }
}
