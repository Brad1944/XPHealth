package top.apip.xphealth

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import top.apip.xphealth.commands.MainCommand
import top.apip.xphealth.listener.Events
import top.apip.xphealth.utils.ConfigWrapper

class XPHealth : JavaPlugin() {

    lateinit var configWrapper: ConfigWrapper
    override fun onEnable() {
        // magic
        saveDefaultConfig()
        config.options().copyDefaults(true)
        configWrapper = ConfigWrapper(config)

        Bukkit.getPluginManager().registerEvents(Events(this), this)
        getCommand("xphealth")?.setExecutor(MainCommand(this))
    }



    override fun onDisable() {
    }
}