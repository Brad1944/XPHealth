package top.apip.xphealth.listener

import org.bukkit.attribute.Attribute
import org.bukkit.attribute.AttributeModifier
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.event.player.PlayerLevelChangeEvent
import org.bukkit.event.player.PlayerQuitEvent
import top.apip.xphealth.XPHealth

class Events(private val main: XPHealth): Listener {

    private val attribute: AttributeModifier = AttributeModifier("XPLevel", main.configWrapper.attributeDiff, AttributeModifier.Operation.ADD_NUMBER)

    @EventHandler
    fun onLevelUp(event: PlayerLevelChangeEvent) {
        if (event.newLevel < event.oldLevel) return
        event.player.getAttribute(Attribute.GENERIC_MAX_HEALTH)?.addModifier(attribute)
    }

    @EventHandler
    fun onDeath(event: PlayerDeathEvent) {
        event.player.getAttribute(Attribute.GENERIC_MAX_HEALTH)?.removeModifier(attribute)
    }

    @EventHandler
    fun onLogout(event: PlayerQuitEvent) {
        event.player.getAttribute(Attribute.GENERIC_MAX_HEALTH)?.removeModifier(attribute)
    }

}