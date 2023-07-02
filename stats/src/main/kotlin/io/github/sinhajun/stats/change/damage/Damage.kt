package io.github.sinhajun.stats.change.damage

import io.github.sinhajun.plugin.plugin
import io.github.sinhajun.stats.map.StatMap
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerRespawnEvent
import org.bukkit.scheduler.BukkitRunnable

class Damage: Listener {
    @EventHandler
    fun onDamage(event: PlayerJoinEvent) {
        val player = event.player
        object : BukkitRunnable() {
            override fun run() {
                when (100) {
                    StatMap.hot[player]!!, StatMap.cold[player]!!, StatMap.thirsty[player]!! -> {
                        player.damage(5.0)
                    }
                }
            }
        }.runTaskTimer(plugin, 0L, 20L)
    }
    @EventHandler
    fun onDead(event: PlayerRespawnEvent) {
        val player = event.player
        StatMap.hot[player] = 0
        StatMap.cold[player] = 0
        StatMap.thirsty[player] = 0
    }
}