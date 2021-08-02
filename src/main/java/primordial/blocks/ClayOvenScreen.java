package primordial.blocks;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import primordial.Primordial;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;

public class ClayOvenScreen extends ContainerScreen<ClayOvenContainer>
{
    public ClayOvenScreen(ClayOvenContainer container, PlayerInventory pinv, ITextComponent name) {
        super(container, pinv, name);
    }

    private ResourceLocation GUI = new ResourceLocation(Primordial.MODID, "textures/gui/clay_oven_gui.png");

    @Override
    protected void renderBg(MatrixStack mstack, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bind(GUI);
        int relX = (this.width - this.imageWidth)/2;
        int relY = (this.height - this.imageHeight)/2;
        this.blit(mstack, relX, relY, 0,0, this.imageWidth, this.imageHeight);
    }

    @Override
    public void render(MatrixStack mstack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(mstack);
        super.render(mstack, mouseX, mouseY, partialTicks);
        this.renderTooltip(mstack, mouseX, mouseY);
    }

    @Override
    protected void renderLabels(MatrixStack mstack, int mouseX, int mouseY) {
        drawString(mstack, Minecraft.getInstance().font, "Progress: " + menu.getItems(), 10, 10, 0xffffff);
    }
}
