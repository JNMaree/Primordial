package primordial.startup;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.config.ModConfig;

public class Config
{

    public static ForgeConfigSpec SERVER_CONFIG;
    public static ForgeConfigSpec CLIENT_CONFIG;

    public static ForgeConfigSpec.BooleanValue VANILLA_DISABLE_WOOD_TOOLS;
    public static ForgeConfigSpec.BooleanValue VANILLA_DISABLE_WOOD_SWORD;
    public static ForgeConfigSpec.BooleanValue VANILLA_DISABLE_STONE_TOOLS;
    public static ForgeConfigSpec.BooleanValue VANILLA_DISABLE_STONE_SWORD;

    public static final String SUBCATEGORY_CRUDE_TOOLS = "crude_tools";
    public static ForgeConfigSpec.IntValue CRUDE_DURABILITY;
    public static ForgeConfigSpec.IntValue CRUDE_TIER_LEVEL;
    public static ForgeConfigSpec.IntValue CRUDE_ENCHANTIBILITY;
    public static ForgeConfigSpec.DoubleValue CRUDE_SPEAR_ATTACK_BONUS;

    public static final String SUBCATEGORY_CLAY_OVEN = "clay_oven";
    public static ForgeConfigSpec.IntValue CLAY_OVEN_TICKS;


    public static final String CATEGORY_GENERAL = "general";

    static {

        ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
        ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();

        CLIENT_BUILDER.comment("General Settings").push(CATEGORY_GENERAL);

        setupGeneralConfig(SERVER_BUILDER, CLIENT_BUILDER);
        setupCrudeTools(SERVER_BUILDER, CLIENT_BUILDER);
        setupClayOvenConfig(SERVER_BUILDER, CLIENT_BUILDER);

        CLIENT_BUILDER.pop();
        SERVER_BUILDER.pop();

        SERVER_CONFIG = SERVER_BUILDER.build();
        CLIENT_CONFIG = CLIENT_BUILDER.build();
    }

    private static void setupGeneralConfig(ForgeConfigSpec.Builder server_builder, ForgeConfigSpec.Builder client_builder) {
        server_builder.comment("Vanilla Tool Settings").push(SUBCATEGORY_CRUDE_TOOLS);

        VANILLA_DISABLE_WOOD_TOOLS = server_builder.comment("Vanilla Disable").define("Wood Tools", true);
        VANILLA_DISABLE_WOOD_SWORD = server_builder.comment("Vanilla Disable").define("Wood Sword", true);
        VANILLA_DISABLE_STONE_TOOLS = server_builder.comment("Vanilla Disable").define("Stone Tools", true);
        VANILLA_DISABLE_STONE_SWORD = server_builder.comment("Vanilla Disable").define("Stone Sword", true);
    }

    private static void setupCrudeTools(ForgeConfigSpec.Builder server_builder, ForgeConfigSpec.Builder client_builder) {
        server_builder.comment("Crude Tool Settings").push(SUBCATEGORY_CRUDE_TOOLS);

        CRUDE_DURABILITY = server_builder.comment("Crude Tools").defineInRange("default durability", 60, 0, Integer.MAX_VALUE);
        CRUDE_TIER_LEVEL = server_builder.comment("Crude Tools").defineInRange("tier level", 1, 0, 3);
        CRUDE_ENCHANTIBILITY = server_builder.comment("Crude Tools").defineInRange("enchantibility", 0, 0, Integer.MAX_VALUE);
        CRUDE_SPEAR_ATTACK_BONUS = server_builder.comment("Crude Spear").defineInRange("attack bonus", 1d, 0, Integer.MAX_VALUE);
    }

    private static void setupClayOvenConfig(ForgeConfigSpec.Builder server_builder, ForgeConfigSpec.Builder client_builder) {
        server_builder.comment("Clay Oven Settings").push(SUBCATEGORY_CLAY_OVEN);

        CLAY_OVEN_TICKS = server_builder.comment("Ticks per operation").defineInRange("ticks", 200, 0, Integer.MAX_VALUE);
    }



    @SubscribeEvent
    public static void onLoad(final ModConfig.Loading configEvent) {

    }

    @SubscribeEvent
    public static void onReload(final ModConfig.Loading configEvent) {

    }

}
