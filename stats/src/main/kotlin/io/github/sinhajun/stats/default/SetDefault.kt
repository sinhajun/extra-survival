package io.github.sinhajun.stats.default

import io.github.sinhajun.plugin.plugin
import io.github.sinhajun.stats.map.StatMap
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.scheduler.BukkitRunnable

class SetDefault : Listener {
    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        val player = event.player
        object : BukkitRunnable() {
            override fun run() {
                player.setDefault()
            }
        }.runTaskTimer(plugin, 0L, 0L)
    }

    // 스탯 최댓값 : 50
    private fun Player.setDefault() {
        val player = player!!
        if (StatMap.hot[player]!! < 0) StatMap.hot[player] = 0 else if (StatMap.cold[player]!! < 0) StatMap.cold[player] = 0 else if (StatMap.thirsty[player]!! < 0) StatMap.thirsty[player] = 0
        if (StatMap.hot[player]!! > 100) StatMap.hot[player] = 100 else if (StatMap.cold[player]!! > 100) StatMap.cold[player] = 100 else if (StatMap.thirsty[player]!! > 100) StatMap.thirsty[player] = 100
    }
}