package primordial.data;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.data.DataGenerator;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import primordial.Primordial;
import primordial.startup.Registration;

import java.util.function.Function;

public class BlockStates extends BlockStateProvider
{
    public BlockStates(DataGenerator dGen, ExistingFileHelper efHelper) {
        super(dGen, Primordial.MODID, efHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        registerClayOven();
    }

    private void registerClayOven() {
        ResourceLocation texSide = new ResourceLocation(Primordial.MODID, "block/clay_oven");
        ResourceLocation texFront = new ResourceLocation(Primordial.MODID, "block/clay_oven_front");
        ResourceLocation texBack = new ResourceLocation(Primordial.MODID, "block/clay_oven_back");
        ResourceLocation texFrontOn = new ResourceLocation(Primordial.MODID, "block/clay_oven_front_on");
        ResourceLocation texBackOn = new ResourceLocation(Primordial.MODID, "block/clay_oven_back_on");

        BlockModelBuilder modelClayOven = models().cube("clay_oven", texSide, texSide, texFront, texBack, texSide, texSide);
        BlockModelBuilder modelClayOvenOn = models().cube("clay_oven_on", texSide, texSide, texFrontOn, texBackOn, texSide, texSide);

        orientedBlock(Registration.BLOCK_OVEN.get(), state -> {
            if (state.getValue(BlockStateProperties.POWERED)) {
                return modelClayOvenOn;
            } else {
                return modelClayOven;
            }
        });
    }

    private void orientedBlock(Block block, Function<BlockState, ModelFile> mFunc) {
        getVariantBuilder(block).forAllStates(state ->{
            Direction face = state.getValue(BlockStateProperties.FACING);
            return ConfiguredModel.builder()
                    .modelFile(mFunc.apply(state))
                    //.rotationX(face.getAxis() == Direction.Axis.Y ? face.getAxisDirection().getStep() *-90 : 0)
                    .rotationY(face.getAxis() != Direction.Axis.Y ? ((face.get2DDataValue() + 2)%4) *90 : 0)
                    .build();
        });
    }
}
