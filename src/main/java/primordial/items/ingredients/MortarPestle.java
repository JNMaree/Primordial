package primordial.items.ingredients;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class MortarPestle extends Item
{
    public MortarPestle() {
        super(new Item.Properties()
                .tab(ItemGroup.TAB_MISC)
                .stacksTo(1));
    }
}
