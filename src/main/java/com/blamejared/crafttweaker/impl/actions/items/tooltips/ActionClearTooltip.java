package com.blamejared.crafttweaker.impl.actions.items.tooltips;

import com.blamejared.crafttweaker.api.actions.IUndoableAction;
import com.blamejared.crafttweaker.api.item.IItemStack;

public class ActionClearTooltip implements IUndoableAction {
    
    private IItemStack stack;
    
    public ActionClearTooltip(IItemStack stack) {
        this.stack = stack;
    }
    
    @Override
    public void apply() {
    
    }
    
    @Override
    public String describe() {
        return "Clearing the tooltip for: " + stack.getCommandString();
    }
    
    @Override
    public void undo() {
    
    }
    
    @Override
    public String describeUndo() {
        return "Unclearing the tooltip for: " + stack.getCommandString();
    }
    
    
}
