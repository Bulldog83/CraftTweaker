package com.blamejared.crafttweaker.impl.events;

import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.item.tooltip.ITooltipFunction;
import com.blamejared.crafttweaker.impl.item.MCItemStackMutable;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.*;

public class CTEventHandler {
    
    public static final Map<IItemStack, Integer> BURN_TIMES = new HashMap<>();
    
    public static final Map<IItemStack, List<ITooltipFunction>> TOOLTIPS = new HashMap<>();
    
    @SubscribeEvent
    public void burnTimeTweaker(FurnaceFuelBurnTimeEvent e) {
        BURN_TIMES.keySet().stream().filter(iItemStack -> iItemStack.matches(new MCItemStackMutable(e.getItemStack()))).findFirst().ifPresent(iItemStack -> e.setBurnTime(BURN_TIMES.get(iItemStack)));
    }
    
    @SubscribeEvent
    public void handleTooltips(ItemTooltipEvent e){
//        e.getEntityPlayer()
    }
}
