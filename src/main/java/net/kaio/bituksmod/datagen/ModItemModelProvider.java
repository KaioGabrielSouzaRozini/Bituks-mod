package net.kaio.bituksmod.datagen;

import net.kaio.bituksmod.BituksMod;
import net.kaio.bituksmod.block.ModBlocks;
import net.kaio.bituksmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, BituksMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.TURMALINA);
        simpleItem(ModItems.RAW_TURMALINA);
        simpleItem(ModItems.RED_ACACIA_STICK);
        simpleItem(ModItems.TURMALINA_CRISTAL);
        simpleItem(ModItems.TURMALINA_FRUIT);
        simpleItem(ModItems.TURMALINA_SEEDS);
        simpleItem(ModItems.DAGGER_HANDLE);
        simpleItem(ModItems.TURMALINA_PEARL);

        handheldItem(ModItems.TURMALINA_SWORD);
        handheldItem(ModItems.TURMALINA_DAGGER);

        saplingItem(ModBlocks.RED_ACACIA_SAPLING);
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(BituksMod.MOD_ID,"block/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(BituksMod.MOD_ID,"item/" + item.getId().getPath()));
    }
    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(BituksMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}
