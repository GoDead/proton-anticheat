package eu.drham.checks;

import eu.drham.Check;
import eu.drham.CheckType;
import eu.drham.info.Profile;

public class KillAura extends Check {

    public KillAura( Profile profile) {
        super(CheckType.FLY, profile);
    }
}
