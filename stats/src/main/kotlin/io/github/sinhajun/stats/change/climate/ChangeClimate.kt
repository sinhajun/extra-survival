package io.github.sinhajun.stats.change.climate

import io.github.sinhajun.plugin.plugin
import io.github.sinhajun.stats.map.StatMap
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.scheduler.BukkitRunnable

class ChangeClimate : Listener {
    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        val player = event.player
        object : BukkitRunnable() {
            override fun run() {
                player.update()
            }
        }.runTaskTimer(plugin, 100L, 100L)
    }

    private fun Player.update() {
        val player = player!!
        val location = player.location
        val biome = player.world.getBiome(location)

        if (Climate.polar.contains(biome)) { // 한대 기후
            change((-3..0).random(), (1..3).random(), (0..1).random(), player)
        } else if (Climate.subarctic.contains(biome)) { // 냉대 기후
            change((-2..1).random(), (0..2).random(), (0..1).random(), player)
        } else if (Climate.temperate.contains(biome) || Climate.cave.contains(biome)) { // 온대 기후 || 동굴
            change((-1..1).random(), (-1..1).random(), (0..1).random(), player)
        } else if (Climate.tropical.contains(biome)) { // 열대 기후
            change((0..2).random(), (-2..1).random(), (0..2).random(), player)
        } else if (Climate.dry.contains(biome)) { // 건조 기후
            change((1..3).random(), (-3..0).random(), (0..2).random(), player)
        } else if (Climate.iceSea.contains(biome) && player.isInWater) { // 추운 바다
            change((-3..-1).random(), (1..4).random(), (-1..1).random(), player)
        } else if ((Climate.sea.contains(biome) || Climate.lukewarmSea.contains(biome)) && player.isInWater) { // 일반 바다 || 미지근한 바다
            change((-1..1).random(), (-1..1).random(), (-1..1).random(), player)
        } else if (Climate.warmSea.contains(biome) && player.isInWater) { // 따듯한 바다
            change((-1..2).random(), (-2..1).random(), (-1..1).random(), player)
        }
    }

    private fun change(hot: Int, cold: Int, thirsty: Int, player: Player) {
        StatMap.hot[player] = StatMap.hot[player]!! + hot
        StatMap.cold[player] = StatMap.cold[player]!! + cold
        StatMap.thirsty[player] = StatMap.thirsty[player]!! + thirsty
    }
}