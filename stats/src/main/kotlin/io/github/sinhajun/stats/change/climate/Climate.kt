package io.github.sinhajun.stats.change.climate

import org.bukkit.block.Biome

object Climate {
    // 기후
    val polar = arrayOf(Biome.SNOWY_TAIGA, Biome.FROZEN_RIVER, Biome.SNOWY_PLAINS, Biome.ICE_SPIKES, Biome.SNOWY_BEACH, Biome.GROVE, Biome.SNOWY_SLOPES, Biome.JAGGED_PEAKS, Biome.FROZEN_PEAKS)
    val subarctic = arrayOf(Biome.WINDSWEPT_HILLS, Biome.WINDSWEPT_FOREST, Biome.WINDSWEPT_GRAVELLY_HILLS, Biome.STONY_SHORE, Biome.TAIGA, Biome.OLD_GROWTH_PINE_TAIGA, Biome.OLD_GROWTH_SPRUCE_TAIGA, Biome.STONY_PEAKS)
    val temperate = arrayOf(Biome.RIVER, Biome.FOREST, Biome.FLOWER_FOREST, Biome.BIRCH_FOREST, Biome.OLD_GROWTH_BIRCH_FOREST, Biome.DARK_FOREST, Biome.PLAINS, Biome.SUNFLOWER_PLAINS, Biome.SWAMP, Biome.MANGROVE_SWAMP, Biome.BEACH, Biome.MUSHROOM_FIELDS, Biome.MEADOW, Biome.CHERRY_GROVE)
    val tropical = arrayOf(Biome.JUNGLE, Biome.SPARSE_JUNGLE, Biome.BAMBOO_JUNGLE)
    val dry = arrayOf(Biome.SAVANNA, Biome.SAVANNA_PLATEAU, Biome.WINDSWEPT_SAVANNA, Biome.DESERT, Biome.BADLANDS, Biome.WOODED_BADLANDS, Biome.ERODED_BADLANDS)
    // 해양
    val iceSea = arrayOf(Biome.FROZEN_OCEAN, Biome.DEEP_FROZEN_OCEAN, Biome.COLD_OCEAN, Biome.DEEP_COLD_OCEAN)
    val sea = arrayOf(Biome.OCEAN, Biome.DEEP_OCEAN)
    val lukewarmSea = arrayOf(Biome.LUKEWARM_OCEAN, Biome.DEEP_LUKEWARM_OCEAN)
    val warmSea = arrayOf(Biome.WARM_OCEAN)
    // 지하
    val cave = arrayOf(Biome.LUSH_CAVES, Biome.DRIPSTONE_CAVES, Biome.DEEP_DARK)
}