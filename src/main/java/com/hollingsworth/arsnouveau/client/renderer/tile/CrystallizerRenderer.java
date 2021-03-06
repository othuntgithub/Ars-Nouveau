package com.hollingsworth.arsnouveau.client.renderer.tile;


import com.hollingsworth.arsnouveau.client.particle.ParticleColor;
import com.hollingsworth.arsnouveau.client.particle.ParticleLineData;
import com.hollingsworth.arsnouveau.client.particle.ParticleUtil;
import com.hollingsworth.arsnouveau.common.block.tile.CrystallizerTile;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class CrystallizerRenderer extends TileEntityRenderer<CrystallizerTile> {

    public CrystallizerRenderer(TileEntityRendererDispatcher manager) {
        super(manager);
    }

    @Override
    public void render(CrystallizerTile crystallizerTile, float f, MatrixStack ms, IRenderTypeBuffer buffers, int light, int overlay) {
        World world = crystallizerTile.getWorld();
        BlockPos pos  = crystallizerTile.getPos();

        double x = crystallizerTile.getPos().getX();
        double y = crystallizerTile.getPos().getY();
        double z = crystallizerTile.getPos().getZ();
        ms.push();
        ms.translate(0.5, -0.5, 0.5);
      //  model.render(ms, buffer, light, overlay, 1, 1, 1, 1, 1);
        boolean draining = crystallizerTile.draining;
        int baseAge = draining ? 20 : 40;
        int randBound = draining ? 3 : 6;
        int numParticles = draining ? 2 : 1;
        float scaleAge = draining ?(float) ParticleUtil.inRange(0.1, 0.2) : (float) ParticleUtil.inRange(0.05, 0.15);
        if(world.rand.nextInt( randBound)  == 0){
            for(int i =0; i< numParticles; i++){
                Vector3d particlePos = new Vector3d(pos.getX(), pos.getY(), pos.getZ()).add(0.5, 0.5, 0.5);
                particlePos = particlePos.add(ParticleUtil.pointInSphere());
                world.addParticle(ParticleLineData.createData(new ParticleColor(255,25,180) ,scaleAge, baseAge+world.rand.nextInt(20)) ,
                        particlePos.getX(), particlePos.getY(), particlePos.getZ(),
                        pos.getX() + 0.5  , pos.getY() +0.5 , pos.getZ()+ 0.5);
            }
        }

        if(crystallizerTile.stack == null)
            return;

        if (crystallizerTile.entity == null || !ItemStack.areItemStacksEqual(crystallizerTile.entity.getItem(), crystallizerTile.stack)) {
            crystallizerTile.entity = new ItemEntity(crystallizerTile.getWorld(), x ,y, z, crystallizerTile.stack);
        }
        crystallizerTile.entity.setPosition(x,y+1,z);
        ItemEntity entityItem = crystallizerTile.entity;
        ms.pop();
        ms.push();
        ms.scale(0.5f, 0.5f, 0.5f);
        ms.translate(1D, 1f, 1D);
        Minecraft.getInstance().getItemRenderer().renderItem(entityItem.getItem(), ItemCameraTransforms.TransformType.FIXED, 15728880, overlay, ms, buffers);
        ms.pop();
    }
}
