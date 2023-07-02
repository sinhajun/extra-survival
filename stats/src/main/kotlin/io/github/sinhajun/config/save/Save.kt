package io.github.sinhajun.config.save

import io.github.sinhajun.plugin.configuration
import io.github.sinhajun.stats.map.StatMap
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.entity.Player

object Save {
    fun save(player: Player) {
        val config = YamlConfiguration.loadConfiguration(configuration)

        if (StatMap.hot[player] == null) StatMap.hot[player] = 0
        if (StatMap.cold[player] == null) StatMap.cold[player] = 0
        if (StatMap.thirsty[player] == null) StatMap.thirsty[player] = 0

        config[player.name] = arrayListOf(StatMap.hot[player], StatMap.cold[player], StatMap.thirsty[player])

        config.save(configuration)
    }
}