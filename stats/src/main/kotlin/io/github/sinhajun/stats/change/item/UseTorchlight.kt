package io.github.sinhajun.stats.change.item

import io.github.sinhajun.plugin.plugin
import io.github.sinhajun.stats.map.StatMap
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.scheduler.BukkitRunnable

class UseTorchlight : Listener {
    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        val player = event.player
        object : BukkitRunnable() {
            override fun run() {
                if (player.inventory.itemInMainHand.type == Material.TORCH || player.inventory.itemInOffHand.type == Material.TORCH) {
                    StatMap.cold[player] = StatMap.cold[player]!! - (2..5).random()
                }
                if (player.inventory.itemInMainHand.type == Material.REDSTONE_TORCH || player.inventory.itemInOffHand.type == Material.REDSTONE_TORCH) {
                    StatMap.cold[player] = StatMap.cold[player]!! - (5..10).random()
                }
            }
        }.runTaskTimer(plugin, 100L, 100L)
    }
}