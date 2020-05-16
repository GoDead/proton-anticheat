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

    static boolean isFalling;
	static boolean isOnWater;
    
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
    
    @EventHandler
	public void fallEvent(PlayerMoveEvent event) {
		isFalling = event.getTo().getY() + 0.5 < event.getFrom().getY();
        /*returns true if the player is falling*/
		//isGoingUp = event.getTo().getY() > event.getFrom().getY() + 0.2;
		//int underY = event.getPlayer().getLocation().getBlockY() - 1;
		Location location = event.getPlayer().getLocation().clone().add(0, -1, 0);

		if (location.getBlock().getType() == Material.WATER) {
			isOnWater = true;
            /*returns true if the player is on water for liquidwalk*/
		} else {
			isOnWater = false;
		}
	}


}
