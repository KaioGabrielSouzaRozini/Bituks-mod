package net.kaio.bituksmod.worldgen.tree;

import net.kaio.bituksmod.BituksMod;
import net.kaio.bituksmod.worldgen.tree.custom.RedAcaciaTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTrunkPlacerTypes {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER =
            DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, BituksMod.MOD_ID);

    public static final RegistryObject<TrunkPlacerType<RedAcaciaTrunkPlacer>> PINE_TRUNK_PLACER =
            TRUNK_PLACER.register("pine_trunk_placer", () -> new TrunkPlacerType<>(RedAcaciaTrunkPlacer.CODEC));

    public static void register(IEventBus eventBus) {
        TRUNK_PLACER.register(eventBus);
    }
}
