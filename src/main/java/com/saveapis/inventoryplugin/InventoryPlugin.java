package com.saveapis.inventoryplugin;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class InventoryPlugin extends JavaPlugin {

    /**
     * The prefix for all messages sent by the plugin.
     */
    public static final TextComponent PREFIX =
            Component.text("[Inventory] ").color(NamedTextColor.BLUE);

    /**
     * The console
     */
    public static final ConsoleCommandSender CONSOLE =
            Bukkit.getConsoleSender();

    @Override
    public void onLoad() {
        TextComponent message =
                PREFIX.append(Component.text("Plugin loaded!")
                        .color(NamedTextColor.GOLD));
        CONSOLE.sendMessage(message);
    }

    @Override
    public void onEnable() {
        TextComponent message =
                PREFIX.append(Component.text("Plugin enabled!")
                        .color(NamedTextColor.GREEN));
        CONSOLE.sendMessage(message);
    }

    @Override
    public void onDisable() {
        TextComponent message =
                PREFIX.append(Component.text("Plugin disabled!")
                        .color(NamedTextColor.RED));
        CONSOLE.sendMessage(message);
    }
}
