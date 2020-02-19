package com.hollingsworth.craftedmagic.block;

import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.IntNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class PhantomBlockTile extends TileEntity implements ITickableTileEntity {

    int age;
    public PhantomBlockTile() {
        super(ModBlocks.PHANTOM_TILE);
    }

    @Override
    public void tick() {
        if(!world.isRemote){
            age++;
            //15 seconds
            if(age > 20 * 15){
                world.destroyBlock(this.getPos(), false);
                world.removeTileEntity(this.getPos());
            }
        }
    }

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        this.age = compound.getInt("age");
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.put("age", new IntNBT(age));
        return super.write(compound);
    }
}