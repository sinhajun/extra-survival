package io.github.sinhajun.config.load

import io.github.sinhajun.plugin.configuration
import io.github.sinhajun.stats.map.StatMap
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class LoadConfig : Listener {
    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        val player = event.player
        val config: YamlConfiguration = YamlConfiguration.loadConfiguration(configuration)
        if (config[player.name] == null) config[player.name] = arrayListOf(0, 0, 0)

        StatMap.hot[player] = config.getList(player.name)!![0] as Int
        StatMap.cold[player] = config.getList(player.name)!![1] as Int
        StatMap.thirsty[player] = config.getList(player.name)!![2] as Int
    }
}