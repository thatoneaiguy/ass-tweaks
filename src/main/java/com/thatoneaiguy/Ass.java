package com.thatoneaiguy;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Ass implements ModInitializer {

	public static final String MODID = "ass";

	public static final Logger LOGGER = LoggerFactory.getLogger("Ass Tweaks");

	@Override
	public void onInitialize() {}

	public static Identifier id(String path) {
		return new Identifier(MODID, path);
	}
}