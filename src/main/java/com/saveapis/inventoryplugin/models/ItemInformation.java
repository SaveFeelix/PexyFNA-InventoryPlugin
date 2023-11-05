package com.saveapis.inventoryplugin.models;

public class ItemInformation {
    private int slot;
    private String material;
    private int amount;
    private EnchantmentInformation[] enchantment;

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
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
