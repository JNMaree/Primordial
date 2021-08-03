package primordial.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.ToolType;
import primordial.startup.Config;
import primordial.startup.Setup;

import java.util.function.Consumer;

public class CrudeTierItem extends Item implements IItemTier
{
    public CrudeTierItem(ToolType toolType) {
        super(new Item.Properties()
                .tab(Setup.ITEM_GROUP)
                .stacksTo(1)
                .setNoRepair()
                .addToolType(toolType, toolLevel)
        );
    }

    private static int toolLevel = Config.CRUDE_TIER_LEVEL.get();
    private static int toolUses = Config.CRUDE_DURABILITY.get();
    private static int toolEnchantibility = Config.CRUDE_ENCHANTIBILITY.get();

    @Override
    public int getUses() {
        return toolUses;
    }


    @Override
    public float getSpeed() {
        return 1F;
    }

    @Override
    public float getAttackDamageBonus() {
        return 0;
    }

    @Override
    public int getLevel() {
        return toolLevel;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.EMPTY;
    }

    @Override
    public int getItemEnchantability(ItemStack stack) {
        return toolEnchantibility;
    }


}
