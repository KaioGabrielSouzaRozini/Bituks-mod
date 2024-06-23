package net.kaio.bituksmod.world.feature.tree;

import net.kaio.bituksmod.BituksMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.foliageplacers.PineFoliagePlacer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModFoliagePlacers {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS =
            DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, BituksMod.MOD_ID);

    public static final RegistryObject<FoliagePlacerType<PineFoliagePlacer>> PINE_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("red_acacia_foliage_placer", () -> new FoliagePlacerType<>(PineFoliagePlacer.CODEC));

    public static void register(IEventBus eventBus) {
        FOLIAGE_PLACERS.register(eventBus);
    }
}
