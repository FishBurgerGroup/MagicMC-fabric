package com.fishburgergroup.magicmc.items;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.MobSpawnerBlockEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.MobSpawnerLogic;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

import java.util.Objects;

public class SpellItem extends SpawnEggItem {
    public SpellItem(EntityType<?> type, int primaryColor, int secondaryColor, Settings settings) {
        super(type, primaryColor, secondaryColor, settings);
    }
   @Override
   public ActionResult useOnBlock(ItemUsageContext context){
       /*ActionResult actionresult=super.useOnBlock(context);
       context.getPlayer().getMovementDirection();
        return actionresult;*/
       //System.out.println("58");
       World world = context.getWorld();
       if (!(world instanceof ServerWorld)) {
           return ActionResult.SUCCESS;
       } else {
          // System.out.println("5858");
           ItemStack itemStack = context.getStack();
           BlockPos blockPos = context.getBlockPos();
           Direction direction = context.getSide();
           BlockState blockState = world.getBlockState(blockPos);
           if (blockState.isOf(Blocks.SPAWNER)) {
               BlockEntity blockEntity = world.getBlockEntity(blockPos);
               if (blockEntity instanceof MobSpawnerBlockEntity) {
                   MobSpawnerLogic mobSpawnerLogic = ((MobSpawnerBlockEntity)blockEntity).getLogic();
                   EntityType<?> entityType = this.getEntityType(itemStack.getTag());
                   mobSpawnerLogic.setEntityId(entityType);
                   blockEntity.markDirty();
                   world.updateListeners(blockPos, blockState, blockState, 3);
                   itemStack.decrement(1);
                   return ActionResult.CONSUME;
               }
           }
           //System.out.println("585858");
           BlockPos blockPos3;
           if (blockState.getCollisionShape(world, blockPos).isEmpty()) {
               blockPos3 = blockPos;
           } else {
               blockPos3 = blockPos.offset(direction);
           }
           //System.out.println("58585858");
           EntityType<?> entityType2 = this.getEntityType(itemStack.getTag());
           System.out.println("58");
           if (entityType2.spawnFromItemStack((ServerWorld)world, itemStack, context.getPlayer(), blockPos3, SpawnReason.SPAWN_EGG, true, !Objects.equals(blockPos, blockPos3) && direction == Direction.UP) != null) {
               itemStack.decrement(1);
           }
           System.out.println("58631");
           return ActionResult.CONSUME;
       }
   }


}
