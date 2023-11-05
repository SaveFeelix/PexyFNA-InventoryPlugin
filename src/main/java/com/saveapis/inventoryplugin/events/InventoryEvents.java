package com.saveapis.inventoryplugin.events;

import com.saveapis.inventoryplugin.manager.InventoryManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;

public class InventoryEvents implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInventoryClose(InventoryCloseEvent event) {
        if (event.getInventory() == InventoryManager.getInventory()) {
            InventoryManager.saveInventory();
            InventoryManager.updatePlayers();
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getInventory() == InventoryManager.getInventory()) {
            InventoryManager.saveInventory();
            InventoryManager.updatePlayers();
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInventoryDrag(InventoryDragEvent event) {
        if (event.getInventory() == InventoryManager.getInventory()) {
            InventoryManager.saveInventory();
            InventoryManager.updatePlayers();

        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInventoryInteract(InventoryInteractEvent event) {
        if (event.getInventory() == InventoryManager.getInventory()) {
            InventoryManager.saveInventory();
            InventoryManager.updatePlayers();
        }
    }
}