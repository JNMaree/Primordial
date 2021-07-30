package primordial.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.IItemHandler;
import primordial.startup.Config;
import primordial.startup.Registration;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;


public class ClayOvenTileEntity extends TileEntity implements ITickableTileEntity
{
    public ClayOvenTileEntity(){
        super(Registration.BLOCK_OVEN_TILE.get());
    }

    private ItemStackHandler createHandler() {
        return new ItemStackHandler(1){
            @Override
            protected void onContentsChanged(int slot) {
                setChanged();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                return stack.getItem().isEdible();
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                if (stack.getItem().isEdible()) {
                    return stack;
                }
                return super.insertItem(slot, stack, simulate);
            }
        };
    }

    private ItemStackHandler itemHandler = createHandler();
    private LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);

    private int process_counter;

    @Override
    public void tick() {
        assert level != null;
        if (level.isClientSide){return;}

        if (process_counter > 0){
            process_counter--;
            setChanged();
        }

        if (process_counter <= 0) {
            ItemStack stack = itemHandler.getStackInSlot(0);
            itemHandler.extractItem(0, 1, false);
            itemHandler.setStackInSlot(0, ItemStack.of(Items.DIAMOND.getDefaultInstance().serializeNBT()));
            process_counter = Config.CLAY_OVEN_TICKS.get();
            setChanged();
        }
    }

    @Override
    public void setRemoved() {
        super.setRemoved();
        handler.invalidate();
    }

    @Override
    public void load(BlockState state, CompoundNBT tag) {
        itemHandler.deserializeNBT(tag.getCompound("inv"));
        process_counter = tag.getInt("counter");
        super.load(state, tag);
    }

    @Override
    public CompoundNBT save(CompoundNBT tag) {
        tag.put("inv", itemHandler.serializeNBT());
        tag.putInt("counter", process_counter);
        return super.save(tag);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return handler.cast();
        }
        return super.getCapability(cap, side);
    }
}
