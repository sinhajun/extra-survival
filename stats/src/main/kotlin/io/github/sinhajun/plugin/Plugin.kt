package io.github.sinhajun.plugin

import io.github.sinhajun.config.load.LoadConfig
import io.github.sinhajun.config.save.Save
import io.github.sinhajun.config.save.SaveConfig
import io.github.sinhajun.stats.change.climate.ChangeClimate
import io.github.sinhajun.stats.change.damage.Damage
import io.github.sinhajun.stats.change.item.DrinkWater
import io.github.sinhajun.stats.change.item.UseTorchlight
import io.github.sinhajun.stats.default.SetDefault
import io.github.sinhajun.stats.showStats.ShowStats
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

lateinit var configuration: File
lateinit var plugin: JavaPlugin

class Plugin : JavaPlugin() {
    override fun onEnable() {
        plugin = this
        configuration = File("plugins\\ExtraSurvival", "stats.yml")

        server.pluginManager.registerEvents(SaveConfig(), this)
        server.pluginManager.registerEvents(LoadConfig(), this)
        server.pluginManager.registerEvents(ShowStats(), this)
        server.pluginManager.registerEvents(SetDefault(), this)
        server.pluginManager.registerEvents(ChangeClimate(), this)
        server.pluginManager.registerEvents(DrinkWater(), this)
        server.pluginManager.registerEvents(UseTorchlight(), this)
        server.pluginManager.registerEvents(Damage(), this)
    }

    override fun onDisable() {
        Bukkit.getOnlinePlayers().forEach { player ->
            Save.save(player)
        }
    }
}