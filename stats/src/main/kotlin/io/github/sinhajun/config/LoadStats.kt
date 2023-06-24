package io.github.sinhajun.config

import io.github.sinhajun.`object`.HashMap
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class LoadStats(private val config: YamlConfiguration) : Listener {
    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        val player = event.player
        if (config[player.name] == null) config[player.name] = arrayListOf(0, 0, 0)

        HashMap.hot[player] = config.getList(player.name)!![0] as Int
        HashMap.cold[player] = config.getList(player.name)!![0] as Int
        HashMap.thirsty[player] = config.getList(player.name)!![0] as Int
    }
}