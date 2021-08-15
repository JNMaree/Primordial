package primordial.fluids;

import net.minecraft.fluid.FluidState;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;

public abstract class FluidClayMud extends ForgeFlowingFluid
{
    public FluidClayMud(Properties props) {
        super(props);
    }

    private static int clayColor = 0x7A7A7AFF;

    public static FluidAttributes.Builder addAttributes(FluidAttributes.Builder attrBuilder) {
        return attrBuilder
                .color(clayColor)
                .density(2000)
                .temperature(300)
                .viscosity(10000);
    }

    public static class Flowing extends FluidClayMud {

        public Flowing(Properties props) {
            super(props);
        }

        @Override
        public boolean isSource(FluidState fluidState) {
            return false;
        }

        @Override
        public int getAmount(FluidState fluidState) {
            return fluidState.getAmount();
        }
    }

    public static class Source extends FluidClayMud {
        public Source(Properties props) {
            super(props);
        }

        @Override
        public boolean isSource(FluidState fluidState) {
            return true;
        }

        @Override
        public int getAmount(FluidState fluidState) {
            return 4;
        }
    }
}
