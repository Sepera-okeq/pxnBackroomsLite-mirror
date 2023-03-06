package com.poixson.backroomslite;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.generator.ChunkGenerator;

import com.poixson.commonmc.tools.plugin.xJavaPlugin;


public class BackroomsLitePlugin extends xJavaPlugin {
	@Override public int getSpigotPluginID() { return 108409; }
	@Override public int getBStatsID() {       return 17876;  }
	public static final String LOG_PREFIX  = "[pxnBackroomsLite] ";
	public static final String CHAT_PREFIX = ChatColor.AQUA + "[Backrooms] " + ChatColor.WHITE;

	protected static final String GENERATOR_NAME = "BackroomsLite";
//TODO: change to https
	protected static final String DEFAULT_RESOURCE_PACK = "http://dl.poixson.com/mcplugins/pxnBackrooms/pxnBackrooms-resourcepack.zip";

	protected final Level0Generator generator;



	public BackroomsLitePlugin() {
		super(BackroomsLitePlugin.class);
		this.generator = new Level0Generator();
	}



	@Override
	public void onEnable() {
		super.onEnable();
		// resource pack
		{
			final String pack = Bukkit.getResourcePack();
			if (pack == null || pack.isEmpty()) {
				LOG.warning(LOG_PREFIX + "Resource pack not set");
				LOG.warning(LOG_PREFIX + "You can use this one: " + DEFAULT_RESOURCE_PACK);
			} else {
				LOG.info(String.format(
					"%sUsing resource pack: %s",
					LOG_PREFIX,
					Bukkit.getResourcePack()
				));
			}
		}
	}

	@Override
	public void onDisable() {
		super.onDisable();
	}



	@Override
	public ChunkGenerator getDefaultWorldGenerator(final String worldName, final String argsStr) {
		LOG.info(String.format("%s%s world: %s", LOG_PREFIX, GENERATOR_NAME, worldName));
		return this.generator;
	}



}
