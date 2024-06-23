package net.kaio.bituksmod.datagen;

import net.kaio.bituksmod.BituksMod;
import net.kaio.bituksmod.block.ModBlocks;
import net.kaio.bituksmod.block.custom.TurmalinaCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, BituksMod.MOD_ID, exFileHelper);
    }


    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.TURMALINA_BLOCK);
        blockWithItem(ModBlocks.DEEPSLATE_TURMALINA_ORE);
        blockWithItem(ModBlocks.TURMALINA_ORE);
        leavesBlock(ModBlocks.RED_ACACIA_LEAVES);

        blockWithItem(ModBlocks.RED_ACACIA_PLANKS);
        saplingBlock(ModBlocks.RED_ACACIA_SAPLING);

        logBlock(((RotatedPillarBlock) ModBlocks.RED_ACACIA_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.RED_ACACIA_WOOD.get()), blockTexture(ModBlocks.RED_ACACIA_LOG.get()), blockTexture(ModBlocks.RED_ACACIA_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_RED_ACACIA_LOG.get()), blockTexture(ModBlocks.STRIPPED_RED_ACACIA_LOG.get()),
                new ResourceLocation(BituksMod.MOD_ID, "block/stripped_red_acacia_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_RED_ACACIA_WOOD.get()), blockTexture(ModBlocks.STRIPPED_RED_ACACIA_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_RED_ACACIA_LOG.get()));

        blockItem(ModBlocks.RED_ACACIA_WOOD);
        blockItem(ModBlocks.RED_ACACIA_LOG);
        blockItem(ModBlocks.STRIPPED_RED_ACACIA_LOG);
        blockItem(ModBlocks.STRIPPED_RED_ACACIA_WOOD);


        makeTurmalinaCrop((CropBlock) ModBlocks.TURMALINA_CROP.get(), "turmalina_stage", "turmalina_stage");


    }
    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(BituksMod.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
    public void makeTurmalinaCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> turmalinaStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }
    private ConfiguredModel[] turmalinaStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((TurmalinaCropBlock) block).getAgeProperty()),
                new ResourceLocation(BituksMod.MOD_ID, "block/" + textureName + state.getValue(((TurmalinaCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }


    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
