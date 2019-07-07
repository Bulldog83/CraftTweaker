package com.blamejared.crafttweaker.impl.managers;

import com.blamejared.crafttweaker.CraftTweaker;
import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.item.IIngredient;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.managers.ICookingRecipeManager;
import com.blamejared.crafttweaker.impl.actions.recipes.ActionAddRecipe;
import net.minecraft.item.crafting.FurnaceRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import org.openzen.zencode.java.ZenCodeGlobals;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("crafttweaker.api.FurnaceManager")
public class CTFurnaceManager implements ICookingRecipeManager {
    
    @ZenCodeGlobals.Global("furnace")
    public static final CTFurnaceManager INSTANCE = new CTFurnaceManager();
    
    @Override
    public void addRecipe(String name, IItemStack output, IIngredient input, float xp, int cookTime) {
        CraftTweakerAPI.apply(new ActionAddRecipe(this, new FurnaceRecipe(new ResourceLocation(CraftTweaker.MODID, name), "", input.asVanillaIngredient(), output.getInternal(), xp, cookTime), ""));
    }
    
    @Override
    public IRecipeType getRecipeType() {
        return IRecipeType.SMELTING;
    }
    
}