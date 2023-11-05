package com.saveapis.inventoryplugin;

import com.saveapis.inventoryplugin.commands.InventoryCommand;
import com.saveapis.inventoryplugin.manager.InventoryManager;
import com.saveapis.inventoryplugin.manager.UpdateManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class InventoryPlugin extends JavaPlugin {

    public static final TextComponent PREFIX = Component.text("[Inventory] ").color(NamedTextColor.BLUE);
    public static final ConsoleCommandSender CONSOLE = Bukkit.getConsoleSender();
    public static InventoryPlugin INSTANCE;

    @Override
    public void onLoad() {
        INSTANCE = this;
        this.saveDefaultConfig();
        UpdateManager.checkForUpdate(this);
        TextComponent message = PREFIX.append(Component.text("Plugin loaded!").color(NamedTextColor.GOLD));
        CONSOLE.sendMessage(message);
    }

    @Override
    public void onEnable() {
        Objects.requireNonNull(this.getCommand("inventory")).setExecutor(new InventoryCommand());

        TextComponent message = PREFIX.append(Component.text("Plugin enabled!").color(NamedTextColor.GREEN));
        CONSOLE.sendMessage(message);
    }

    @Override
    public void onDisable() {
        TextComponent message = PREFIX.append(Component.text("Plugin disabled!").color(NamedTextColor.RED));
        CONSOLE.sendMessage(message);
    }
}
