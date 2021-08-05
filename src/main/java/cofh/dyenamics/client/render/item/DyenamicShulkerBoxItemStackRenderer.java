package cofh.dyenamics.client.render.item;

import cofh.dyenamics.common.blockentity.DyenamicShulkerBoxBlockEntity;
import cofh.dyenamics.common.blocks.DyenamicShulkerBoxBlock;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class DyenamicShulkerBoxItemStackRenderer extends ItemStackTileEntityRenderer
{
    DyenamicShulkerBoxBlockEntity blockEntity = null;

    @Override
    public void func_239207_a_(@Nonnull ItemStack stack, @Nonnull ItemCameraTransforms.TransformType transformType, @Nonnull MatrixStack matrixStack, @Nonnull IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay) {
        if (blockEntity == null) {
            blockEntity = new DyenamicShulkerBoxBlockEntity();
        }
        Item item = stack.getItem();
        if (item instanceof BlockItem) {
            Block block = ((BlockItem) item).getBlock();
            if (block instanceof DyenamicShulkerBoxBlock) {
                blockEntity.setColor(((DyenamicShulkerBoxBlock) block).getDyenamicColor());

                TileEntityRendererDispatcher.instance.renderItem(blockEntity, matrixStack, buffer, combinedLight, combinedOverlay);
            }
        }
    }
}
