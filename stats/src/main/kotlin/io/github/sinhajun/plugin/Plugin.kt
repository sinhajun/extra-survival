package io.github.sinhajun.plugin

import org.bukkit.plugin.java.JavaPlugin

lateinit var plugin: JavaPlugin
class Plugin : JavaPlugin() {
    override fun onEnable() {
        plugin = this
        logger.info("wa sans")
    }
}