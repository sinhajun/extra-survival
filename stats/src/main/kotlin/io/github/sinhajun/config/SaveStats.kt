package io.github.sinhajun.config

import io.github.sinhajun.`object`.Save
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerQuitEvent
import java.io.File

class SaveStats(private val config: YamlConfiguration, private val file: File) : Listener {
    @EventHandler
    fun onQuit(event: PlayerQuitEvent) {
        Save.save(config, event.player, file)
    }
}