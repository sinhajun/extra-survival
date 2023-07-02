package io.github.sinhajun.config.save

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerQuitEvent

class SaveConfig : Listener {
    @EventHandler
    fun onQuit(event: PlayerQuitEvent) {
        Save.save(event.player)
    }
}