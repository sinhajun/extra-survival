package io.github.sinhajun.stats.showStats

import io.github.sinhajun.plugin.plugin
import io.github.sinhajun.stats.map.StatMap
import net.kyori.adventure.text.Component
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.scheduler.BukkitRunnable

class ShowStats : Listener {
    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        object : BukkitRunnable() {
            override fun run() {
                val player = event.player
                player.sendActionBar(Component.text("${ChatColor.RED}${ChatColor.BOLD}hot : ${ChatColor.DARK_RED}${ChatColor.BOLD}${StatMap.hot[player]} " +
                        "${ChatColor.BLUE}${ChatColor.BOLD}cold : ${ChatColor.DARK_BLUE}${ChatColor.BOLD}${StatMap.cold[player]} " +
                        "${ChatColor.AQUA}${ChatColor.BOLD}thirsty : ${ChatColor.DARK_AQUA}${ChatColor.BOLD}${StatMap.thirsty[player]}"))
            }
        }.runTaskTimer(plugin, 0L, 0L)
    }
}