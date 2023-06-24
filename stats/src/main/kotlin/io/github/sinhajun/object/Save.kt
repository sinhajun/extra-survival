package io.github.sinhajun.`object`

import net.kyori.adventure.text.Component
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.entity.Player
import java.io.File
import java.io.IOException

object Save {
    fun save(config: YamlConfiguration, player: Player, file: File) {
        try {
            config[player.name] = arrayListOf(HashMap.hot[player], HashMap.cold[player], HashMap.thirsty[player])
            try {
                config.save(file)
            } catch (ignored: IOException) {}
        } catch (ignored: NullPointerException) {
            player.kick(Component.text().content("Stats: null").asComponent())
        }
    }
}