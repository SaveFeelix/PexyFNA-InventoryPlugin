package com.saveapis.inventoryplugin.models;

import org.bukkit.Material;

public class ItemInformation {
    private int slot;
    private Material material;
    private int amount;
    private EnchantmentInformation[] enchantment;

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public EnchantmentInformation[] getEnchantment() {
        return enchantment;
    }

    public void setEnchantment(EnchantmentInformation[] enchantment) {
        this.enchantment = enchantment;
    }
}
