package eu.drham.listener;

import eu.drham.CheckType;
import eu.drham.checks.ElevatedPing;
import eu.drham.info.Profile;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class DetectionListener implements Listener {

    @EventHandler
    public void onHit(EntityDamageByEntityEvent e){
      //  if(e.getDamager() instanceof Player) {
            Player suspect = (Player) e.getDamager();
            Profile.getProfile(suspect.getUniqueId()).getCheck(CheckType.REACH).runCheck(e);
      //  }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Profile.getProfile(e.getPlayer().getUniqueId()).getCheck(CheckType.SPEED).runCheck(e);
    }


}
