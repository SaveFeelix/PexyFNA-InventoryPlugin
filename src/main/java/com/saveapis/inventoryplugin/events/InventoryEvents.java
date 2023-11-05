package com.saveapis.inventoryplugin.events;

import com.saveapis.inventoryplugin.manager.InventoryManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class InventoryEvents implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInventoryClose(InventoryCloseEvent event) {
        if (event.getPlayer() instanceof Player player)
            if (event.getInventory() == InventoryManager.getInventory())
                InventoryManager.saveInventory();
    }
}
