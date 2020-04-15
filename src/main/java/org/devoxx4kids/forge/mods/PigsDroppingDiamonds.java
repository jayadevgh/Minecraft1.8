package org.devoxx4kids.forge.mods;

import java.util.Random;

import net.minecraft.entity.passive.EntityPig;
import net.minecraft.init.Items;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PigsDroppingDiamonds {
	@SubscribeEvent
	public void dropDiamonds(LivingDeathEvent event){ 
		if (!(event.entity instanceof EntityPig)) { 
			return;
		}

		Random random = new Random(); 
		int x = random.nextInt(5);
		if (!event.entity.worldObj.isRemote) {
			if(x != 0) {
				event.entity.dropItem(Items.porkchop, random.nextInt(11)); 
			}
			else {
				event.entity.dropItem(Items.diamond, random.nextInt(6));
			}
		}
	}
}
