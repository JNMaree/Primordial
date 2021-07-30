package primordial.startup;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.config.ModConfig;

public class Config {

    public static ForgeConfigSpec SERVER_CONFIG;
    public static ForgeConfigSpec CLIENT_CONFIG;

    public static final String SUBCATEGORY_CLAY_OVEN = "clay_oven";
    public static ForgeConfigSpec.IntValue CLAY_OVEN_TICKS;

    public static final String CATEGORY_GENERAL = "general";

    static {

        ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
        ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();

        CLIENT_BUILDER.comment("General Settings").push(CATEGORY_GENERAL);
        CLIENT_BUILDER.pop();

        setupClayOvenConfig(SERVER_BUILDER, CLIENT_BUILDER);
        SERVER_BUILDER.pop();

        SERVER_CONFIG = SERVER_BUILDER.build();
        CLIENT_CONFIG = CLIENT_BUILDER.build();
    }

    private static void setupClayOvenConfig(ForgeConfigSpec.Builder server_builder, ForgeConfigSpec.Builder client_builder){
        server_builder.comment("Clay_Oven Settings").push(SUBCATEGORY_CLAY_OVEN);

        CLAY_OVEN_TICKS = server_builder.comment("Ticks per operation").defineInRange("ticks", 200, 0, Integer.MAX_VALUE);

    }

    @SubscribeEvent
    public static void onLoad(final ModConfig.Loading configEvent) {

    }

    @SubscribeEvent
    public static void onReload(final ModConfig.Loading configEvent) {

    }

}
