package io.github.sinhajun.stats.change.item

import io.github.sinhajun.stats.map.StatMap
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerItemConsumeEvent

class DrinkWater : Listener {
    @EventHandler
    fun onDrink(event: PlayerItemConsumeEvent) {
        val itemStack = event.item
        val player = event.player
        if (itemStack.type == Material.POTION || itemStack.type == Material.MILK_BUCKET) {
            StatMap.thirsty[player] = StatMap.thirsty[player]!! - (10..15).random()
            StatMap.hot[player] = StatMap.hot[player]!! - (5..10).random()
        }
    }
}