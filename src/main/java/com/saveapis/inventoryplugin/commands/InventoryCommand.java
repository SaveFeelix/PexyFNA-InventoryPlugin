package com.saveapis.inventoryplugin.commands;

import com.saveapis.inventoryplugin.InventoryPlugin;
import com.saveapis.inventoryplugin.manager.InventoryManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class InventoryCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player player) {
            String permission = InventoryPlugin.INSTANCE.getConfig().getString("inventory.permission");
            if (player.hasPermission(permission)) {
                player.openInventory(InventoryManager.getInventory());
            } else {
                TextComponent component = InventoryPlugin.PREFIX.append(Component.text("Du hast keine Berechtigung für diesen Command!").color(NamedTextColor.RED));
                commandSender.sendMessage(component);
            }
        } else {
            TextComponent component = InventoryPlugin.PREFIX.append(Component.text("Dieser Command kann nur von einem Spiele ausgeführt werden!").color(NamedTextColor.RED));
            commandSender.sendMessage(component);
        }
        return true;
    }
}
