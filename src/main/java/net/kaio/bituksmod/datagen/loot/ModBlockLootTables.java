package net.kaio.bituksmod.datagen.loot;

import net.kaio.bituksmod.block.custom.TurmalinaCropBlock;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.kaio.bituksmod.block.ModBlocks;
import net.kaio.bituksmod.item.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.TURMALINA_BLOCK.get());

        this.add(ModBlocks.TURMALINA_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.TURMALINA_ORE.get(), ModItems.RAW_TURMALINA.get()));

        this.add(ModBlocks.DEEPSLATE_TURMALINA_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.DEEPSLATE_TURMALINA_ORE.get(), ModItems.RAW_TURMALINA.get()));

        this.dropSelf(ModBlocks.RED_ACACIA_LOG.get());
        this.dropSelf(ModBlocks.RED_ACACIA_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_RED_ACACIA_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_RED_ACACIA_WOOD.get());
        this.dropSelf(ModBlocks.RED_ACACIA_PLANKS.get());


        this.add(ModBlocks.RED_ACACIA_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.RED_ACACIA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.TURMALINA_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(TurmalinaCropBlock.AGE, 5));

        this.add(ModBlocks.TURMALINA_CROP.get(), createCropDrops(ModBlocks.TURMALINA_CROP.get(), ModItems.TURMALINA_FRUIT.get(),
                ModItems.TURMALINA_SEEDS.get(), lootitemcondition$builder));

        this.dropSelf(ModBlocks.RED_ACACIA_SAPLING.get());

    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
