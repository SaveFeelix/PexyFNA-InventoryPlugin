package com.saveapis.inventoryplugin.manager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.saveapis.inventoryplugin.InventoryPlugin;
import com.saveapis.inventoryplugin.models.GithubGetDto;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class UpdateManager {
    public static void checkForUpdate(JavaPlugin plugin) {
        String repoUser = "SaveFeelix";
        String repoName = "PexyFNA-InventoryPlugin";
        String apiUrl = "https://api.github.com/repos/" + repoUser + "/" + repoName + "/tags";

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/vnd.github.v3+json");
            conn.setRequestProperty("User-Agent", "SaveApis - InventoryPlugin");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();
            Gson gson = builder.create();
            JsonArray array = gson.fromJson(new InputStreamReader(conn.getInputStream()), JsonArray.class);

            List<GithubGetDto> list = new ArrayList<>();
            array.forEach(it -> {
                GithubGetDto dto = gson.fromJson(it, GithubGetDto.class);
                list.add(dto);
            });
            GithubGetDto dto = list.get(0);
            if (!dto.getName().equalsIgnoreCase(plugin.getPluginMeta().getVersion())) {
                InventoryPlugin.CONSOLE.sendMessage(InventoryPlugin.PREFIX.append(Component.text("Eine neue Version ist verfügbar!").color(NamedTextColor.RED)));
                InventoryPlugin.CONSOLE.sendMessage(InventoryPlugin.PREFIX.append(Component.text("Aktuelle Version: " + plugin.getPluginMeta().getVersion()).color(NamedTextColor.RED)));
                InventoryPlugin.CONSOLE.sendMessage(InventoryPlugin.PREFIX.append(Component.text("Neue Version: " + dto.getName()).color(NamedTextColor.RED)));
                InventoryPlugin.CONSOLE.sendMessage(InventoryPlugin.PREFIX.append(Component.text("Download Link: https://github.com/SaveFeelix/PexyFNA-InventoryPlugin/releases").color(NamedTextColor.RED)));
            }
            conn.disconnect();
        } catch (Exception e) {
            InventoryPlugin.CONSOLE.sendMessage(InventoryPlugin.PREFIX.append(Component.text("Fehler beim überprüfen auf Updates!").color(NamedTextColor.RED)));
            InventoryPlugin.CONSOLE.sendMessage(InventoryPlugin.PREFIX.append(Component.text(e.getMessage()).color(NamedTextColor.RED)));
        }
    }
}
