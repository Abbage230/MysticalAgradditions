package com.blakebr0.mysticalagradditions.config;

import net.neoforged.fml.ModList;
import net.neoforged.neoforge.common.ModConfigSpec;

public final class ModConfigs {
    public static final ModConfigSpec COMMON;

    public static final ModConfigSpec.DoubleValue WITHERING_SOUL_DROP_CHANCE;
    public static final ModConfigSpec.IntValue DRAGON_SCALES_AMOUNT;
    public static final ModConfigSpec.BooleanValue FERTILIZABLE_CROPS;
    public static final ModConfigSpec.IntValue ESSENCE_APPLE_DURATION;

    public static final ModConfigSpec.BooleanValue GENERATE_NETHER_PROSPERITY;
    public static final ModConfigSpec.BooleanValue GENERATE_NETHER_INFERIUM;
    public static final ModConfigSpec.BooleanValue GENERATE_END_PROSPERITY;
    public static final ModConfigSpec.BooleanValue GENERATE_END_INFERIUM;

    // Common
    static {
        final var common = new ModConfigSpec.Builder();

        common.comment("General configuration options.").push("General");
        WITHERING_SOUL_DROP_CHANCE = common
                .comment("The percentage chance that a Wither will drop a Withering Soul when killed.")
                .defineInRange("witheringSoulChance", 0.35, 0, 1);
        DRAGON_SCALES_AMOUNT = common
                .comment("The amount of Dragon Scales that an Ender Dragon will drop when killed.")
                .defineInRange("dragonScalesAmount", 8, 0, 64);
        FERTILIZABLE_CROPS = common
                .comment("Can tier 6 crops be fertilized using Mystical Fertilizer or Fertilized Essence?")
                .define("fertilizableTier6Crops", false);
        ESSENCE_APPLE_DURATION = common
                .comment("The duration of each Essence Apples effects in seconds.")
                .defineInRange("essenceAppleDuration", 180, 1, Integer.MAX_VALUE);
        common.pop();

        common.comment("World generation options.").push("World");
        GENERATE_NETHER_PROSPERITY = common
                .comment("Should Nether Prosperity Ore generate in the world?")
                .define("generateNetherProsperityOre", true);
        GENERATE_NETHER_INFERIUM = common
                .comment("Should Nether Inferium Ore generate in the world?")
                .define("generateNetherInferiumOre", true);
        GENERATE_END_PROSPERITY = common
                .comment("Should End Prosperity Ore generate in the world?")
                .define("generateEndProsperityOre", true);
        GENERATE_END_INFERIUM = common
                .comment("Should End Inferium Ore generate in the world?")
                .define("generateEndInferiumOre", true);
        common.pop();

        COMMON = common.build();
    }

    public static boolean isTConstructInstalled() {
        return ModList.get().isLoaded("tconstruct");
    }
}
