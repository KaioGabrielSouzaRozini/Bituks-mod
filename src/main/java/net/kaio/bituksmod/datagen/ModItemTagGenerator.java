package net.kaio.bituksmod.datagen;

import net.kaio.bituksmod.BituksMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import net.kaio.bituksmod.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, BituksMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.RED_ACACIA_LOG.get().asItem())
                .add(ModBlocks.RED_ACACIA_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_RED_ACACIA_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_RED_ACACIA_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS).add(ModBlocks.RED_ACACIA_PLANKS.get().asItem());
    }
}
