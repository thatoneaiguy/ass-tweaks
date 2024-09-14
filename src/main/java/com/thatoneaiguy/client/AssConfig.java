package com.thatoneaiguy.client;

import eu.midnightdust.lib.config.MidnightConfig;

public class AssConfig extends MidnightConfig {

    @Comment
    public static Comment bundlehead;

    @Entry(min=1,max=128)
    public static int MAX_STORAGE = 64;
    @Entry(min=1,max=128)
    public static int ENCH_BOOK_VALUE = 8;
    @Entry(min=1,max=128)
    public static int UNSTACKABLE_VALUE = 16;
    @Entry(min=1,max=128)
    public static int TOTEM_VALUE = 16;
}
