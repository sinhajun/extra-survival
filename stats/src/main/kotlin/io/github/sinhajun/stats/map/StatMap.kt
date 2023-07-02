package io.github.sinhajun.stats.map

import org.bukkit.entity.Player

object StatMap {
    val hot = HashMap<Player, Int>()
    val cold = HashMap<Player, Int>()
    val thirsty = HashMap<Player, Int>()
}