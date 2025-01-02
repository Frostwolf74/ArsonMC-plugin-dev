package me.frostwolf74.fWWeapons.listeners;

import me.frostwolf74.fWWeapons.FWWeapons;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class SwordUseListener implements Listener{
    @EventHandler
    public void EntityDamageByEntityEvent(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player p){
            ItemStack heldItem = p.getInventory().getItemInMainHand();
            if(heldItem.getItemMeta() == null){
                return;
            }
            if(Boolean.TRUE.equals(heldItem.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(FWWeapons.getPlugin(), "isArsonSword"), PersistentDataType.BOOLEAN))){
                for(int i = 0; i < 1; ++i) {
                    p.getWorld().strikeLightning(e.getEntity().getLocation());
                }
            }
        }
    }

    @EventHandler
    public void onBlockIgnite(BlockIgniteEvent event) {
        if (event.getCause() == BlockIgniteEvent.IgniteCause.LIGHTNING) {
            event.setCancelled(true);
        }
    }
}
