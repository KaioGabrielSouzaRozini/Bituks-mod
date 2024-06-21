package net.kaio.bituksmod.item;

import net.kaio.bituksmod.BituksMod;
import net.kaio.bituksmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModeCreativeModelTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BituksMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> BITUKS_TAB = CREATIVE_MODE_TABS.register("bitukstab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TURMALINA.get()))
            .title(Component.translatable("creativetab.bituks_tab"))
            .displayItems((pParameters, pOutput) -> {
                pOutput.accept(ModItems.TURMALINA.get());
                pOutput.accept(ModItems.RAW_TURMALINA.get());
                pOutput.accept(ModItems.DAGGER_HANDLE.get());
                pOutput.accept(ModItems.TURMALINA_CRISTAL.get());
                pOutput.accept(ModItems.TURMALINA_FRUIT.get());
                pOutput.accept(ModItems.TURMALINA_SWORD.get());
                pOutput.accept(ModItems.TURMALINA_PEARL.get());
                pOutput.accept(ModItems.TURMALINA_PEARL.get());
                pOutput.accept(ModItems.TURMALINA_SEEDS.get());
                pOutput.accept(ModItems.RED_ACACIA_STICK.get());
                pOutput.accept(ModBlocks.RED_ACACIA_SAPLING.get());
                pOutput.accept(ModBlocks.DEEPSLATE_TURMALINA_ORE.get());
                pOutput.accept(ModBlocks.RED_ACACIA_LEAVES.get());
                pOutput.accept(ModBlocks.TURMALINA_BLOCK.get());
                pOutput.accept(ModBlocks.RED_ACACIA_LOG.get());
                pOutput.accept(ModBlocks.RED_ACACIA_WOOD.get());
                pOutput.accept(ModBlocks.RED_ACACIA_PLANKS.get());
                pOutput.accept(ModBlocks.STRIPPED_RED_ACACIA_LOG.get());
                pOutput.accept(ModBlocks.TURMALINA_CROP.get());
                pOutput.accept(ModBlocks.STRIPPED_RED_ACACIA_WOOD.get());

            })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

    };

