package com.blamejared.crafttweaker.api.item.tooltip;

import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.impl.text.MCTextComponent;
import org.openzen.zencode.java.ZenCodeType;

import java.util.List;

@ZenCodeType.Name("crafttweaker.api.item.tooltip.ITooltipFunction")
@ZenRegister
public interface ITooltipFunction {
    
    void apply(IItemStack stack, List<MCTextComponent> tooltip, boolean isAdvanced);
}
