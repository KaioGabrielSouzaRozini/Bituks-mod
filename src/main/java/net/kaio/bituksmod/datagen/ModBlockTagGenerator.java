package net.kaio.bituksmod.datagen;

import net.kaio.bituksmod.BituksMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import net.kaio.bituksmod.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, BituksMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {


        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.TURMALINA_BLOCK.get(),
                        ModBlocks.TURMALINA_ORE.get(),
                        ModBlocks.DEEPSLATE_TURMALINA_ORE.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.TURMALINA_BLOCK.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.TURMALINA_ORE.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.DEEPSLATE_TURMALINA_ORE.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.RED_ACACIA_LOG.get())
                .add(ModBlocks.RED_ACACIA_WOOD.get())
                .add(ModBlocks.STRIPPED_RED_ACACIA_LOG.get())
                .add(ModBlocks.STRIPPED_RED_ACACIA_WOOD.get());

        this.tag(BlockTags.PLANKS).add(ModBlocks.RED_ACACIA_PLANKS.get());
    }


}
