package primordial.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import primordial.startup.Setup;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.Nullable;
import java.util.List;

public class CrudePickaxe extends Item{

    public CrudePickaxe(){
        super(new Item.Properties()
                .tab(Setup.ITEM_GROUP)
                .setNoRepair()
                .stacksTo(1)
                .addToolType(ToolType.PICKAXE, 1)   //Stone_level Pickaxe
        );
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> list, ITooltipFlag flags){
        list.add(new TranslationTextComponent("message.CrudePickaxe"));
    }
}
