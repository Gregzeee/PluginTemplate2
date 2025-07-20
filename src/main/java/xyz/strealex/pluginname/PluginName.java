package me.gregzee.pluginname;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class PluginName extends JavaPlugin {

    @Getter
    private static PluginName instance;

    @Override
    public void onEnable() {
        instance = this;
        configManager = new ConfigManager(this);

        if (!loadConfig()) {
            instance.getServer().getPluginManager().disablePlugin(instance);
            return;
        }

        registerCommands();
        registerListeners();
    }

    @Override
    public void onDisable() {
        getLogger().info("Disabling plugin...");
    }

    private void registerCommands() {
        new TestCommand();
    }

    private void registerListeners() {
        new TestListener(instance).register();
    }
}
