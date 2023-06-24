package io.github.sinhajun.plugin

import io.github.sinhajun.config.LoadStats
import io.github.sinhajun.config.SaveStats
import io.github.sinhajun.`object`.Save
import org.bukkit.Bukkit
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

lateinit var plugin: JavaPlugin

class Plugin : JavaPlugin() {
    private val configuration = File("plugins/config", "stats.yml")
    override fun onEnable() {
        plugin = this
        server.pluginManager.registerEvents(LoadStats(YamlConfiguration.loadConfiguration(configuration)), this)
        server.pluginManager.registerEvents(SaveStats(YamlConfiguration.loadConfiguration(configuration), configuration), this)
    }

    override fun onDisable() {
        Bukkit.getOnlinePlayers().forEach { player ->
            Save.save(YamlConfiguration.loadConfiguration(configuration), player, configuration)
        }
    }
}