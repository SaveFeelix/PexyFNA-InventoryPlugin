package com.saveapis.inventoryplugin.manager;

import com.saveapis.inventoryplugin.InventoryPlugin;
import com.saveapis.inventoryplugin.models.EnchantmentInformation;
import com.saveapis.inventoryplugin.models.ItemInformation;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InventoryManager {
    private static Inventory inventory;

    public static void initInventory() {
        String inventoryName = InventoryPlugin.INSTANCE.getConfig().getString("inventory.name");
        int inventorySize = InventoryPlugin.INSTANCE.getConfig().getInt("inventory.size");
        inventory = Bukkit.createInventory(null, 9 * inventorySize);

        List<ItemInformation> items = (List<ItemInformation>) InventoryPlugin.INSTANCE.getConfig().getList("items");
        for (ItemInformation item : items) {
            ItemStack stack = new ItemStack(item.getMaterial(), item.getAmount());
            for (EnchantmentInformation enchantmentInfo : item.getEnchantment())
                stack.addEnchantment(Objects.requireNonNull(Enchantment.getByKey(NamespacedKey.fromString(enchantmentInfo.getEnchantmentKey()))),
                        enchantmentInfo.getLevel());
            inventory.setItem(item.getSlot(), stack);
        }
    }

    public static void saveInventory() {
        List<ItemInformation> list = new ArrayList<>();
        for (ItemStack item : inventory.getContents()) {
            ItemInformation itemInfo = new ItemInformation();
            itemInfo.setAmount(item.getAmount());
            itemInfo.setMaterial(item.getType());
            itemInfo.setSlot(inventory.first(item));

            List<EnchantmentInformation> enchantments = new ArrayList<>();
            for (Enchantment enchantment : item.getEnchantments().keySet()) {
                EnchantmentInformation enchantmentInfo = new EnchantmentInformation();
                enchantmentInfo.setEnchantmentKey(enchantment.getKey().toString());
                enchantmentInfo.setLevel(item.getEnchantmentLevel(enchantment));
                enchantments.add(enchantmentInfo);
            }
            itemInfo.setEnchantment(enchantments.toArray(new EnchantmentInformation[0]));
            list.add(itemInfo);
        }
        InventoryPlugin.INSTANCE.getConfig().set("items", list);
    }

    public static void updatePlayers() {
        Bukkit.getOnlinePlayers().forEach(it -> {
            if (it.getOpenInventory().getTopInventory() == inventory)
                it.updateInventory();
        });
    }

    public static Inventory getInventory() {
        return inventory;
    }
}
