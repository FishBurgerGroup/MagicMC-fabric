package com.fishburgergroup.magicmc;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class SpellEntity extends PathAwareEntity {
    public SpellEntity(EntityType<? extends PathAwareEntity> entityType, World world) {

        super(entityType, world);
        System.out.println("631");
    }
    @Override
    public void tick(){
        super.tick();
        this.move(MovementType.SELF, new Vec3d(0.01D, 0.0D, 0.0D));
    }
}
