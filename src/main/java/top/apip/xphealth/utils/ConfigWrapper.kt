package top.apip.xphealth.utils

import org.bukkit.configuration.file.FileConfiguration

class ConfigWrapper(private val config: FileConfiguration) {
    val attributeDiff: Double = config.getDouble("health-difference")
}