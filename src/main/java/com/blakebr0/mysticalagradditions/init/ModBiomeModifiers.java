package com.blakebr0.mysticalagradditions.init;

import com.blakebr0.mysticalagradditions.MysticalAgradditions;
import com.blakebr0.mysticalagradditions.world.modifiers.EndInferiumOreModifier;
import com.blakebr0.mysticalagradditions.world.modifiers.EndProsperityOreModifier;
import com.blakebr0.mysticalagradditions.world.modifiers.NetherInferiumOreModifier;
import com.blakebr0.mysticalagradditions.world.modifiers.NetherProsperityOreModifier;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public final class ModBiomeModifiers {
    public static final DeferredRegister<MapCodec<? extends BiomeModifier>> REGISTRY = DeferredRegister.create(NeoForgeRegistries.BIOME_MODIFIER_SERIALIZERS, MysticalAgradditions.MOD_ID);

    public static final DeferredHolder<MapCodec<? extends BiomeModifier>, MapCodec<NetherProsperityOreModifier>> NETHER_PROSPERITY_ORE = REGISTRY.register("nether_prosperity_ore", () ->
            RecordCodecBuilder.mapCodec(builder -> builder.group(
                    Biome.LIST_CODEC.fieldOf("biomes").forGetter(NetherProsperityOreModifier::biomes),
                    PlacedFeature.CODEC.fieldOf("feature").forGetter(NetherProsperityOreModifier::feature)
            ).apply(builder, NetherProsperityOreModifier::new)));
    public static final DeferredHolder<MapCodec<? extends BiomeModifier>, MapCodec<NetherInferiumOreModifier>> NETHER_INFERIUM_ORE = REGISTRY.register("nether_inferium_ore", () ->
            RecordCodecBuilder.mapCodec(builder -> builder.group(
                    Biome.LIST_CODEC.fieldOf("biomes").forGetter(NetherInferiumOreModifier::biomes),
                    PlacedFeature.CODEC.fieldOf("feature").forGetter(NetherInferiumOreModifier::feature)
            ).apply(builder, NetherInferiumOreModifier::new)));
    public static final DeferredHolder<MapCodec<? extends BiomeModifier>, MapCodec<EndProsperityOreModifier>> END_PROSPERITY_ORE = REGISTRY.register("end_prosperity_ore", () ->
            RecordCodecBuilder.mapCodec(builder -> builder.group(
                    Biome.LIST_CODEC.fieldOf("biomes").forGetter(EndProsperityOreModifier::biomes),
                    PlacedFeature.CODEC.fieldOf("feature").forGetter(EndProsperityOreModifier::feature)
            ).apply(builder, EndProsperityOreModifier::new)));
    public static final DeferredHolder<MapCodec<? extends BiomeModifier>, MapCodec<EndInferiumOreModifier>> END_INFERIUM_ORE = REGISTRY.register("end_inferium_ore", () ->
            RecordCodecBuilder.mapCodec(builder -> builder.group(
                    Biome.LIST_CODEC.fieldOf("biomes").forGetter(EndInferiumOreModifier::biomes),
                    PlacedFeature.CODEC.fieldOf("feature").forGetter(EndInferiumOreModifier::feature)
            ).apply(builder, EndInferiumOreModifier::new)));
}
