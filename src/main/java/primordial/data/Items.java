package primordial.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import primordial.Primordial;
import primordial.startup.Registration;

public class Items extends ItemModelProvider
{
    public Items(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator, Primordial.MODID, fileHelper);
    }

    @Override
    protected void registerModels() {
        ResourceLocation texHandheld = new ResourceLocation("item/handheld");
        //Handheld Items
        singleTexture(Registration.CRUDE_PICKAXE.get().getRegistryName().getPath(), texHandheld,
                "layer0", new ResourceLocation(Primordial.MODID, "item/crude_pickaxe"));
        //Block Items
        withExistingParent(Registration.BLOCK_OVEN_ITEM.get().getRegistryName().getPath(),
                new ResourceLocation(Primordial.MODID, "block/clay_oven"));
    }
}
