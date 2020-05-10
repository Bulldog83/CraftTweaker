package com.blamejared.crafttweaker.impl.text;

import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import net.minecraft.util.text.*;
import org.openzen.zencode.java.ZenCodeType;

import java.util.Arrays;

@ZenRegister
@ZenCodeType.Name("crafttweaker.api.text.TextComponent")
public class MCTextComponent {
    
    private final ITextComponent internal;
    
    public MCTextComponent(ITextComponent internal) {
        this.internal = internal;
    }
    
    @ZenCodeType.Constructor
    public MCTextComponent(String text) {
        this.internal = new StringTextComponent(text);
    }
    
    @ZenCodeType.Method
    public MCTextComponent applyTextStyles(MCTextFormatting... formatting) {
        return new MCTextComponent(getInternal().applyTextStyles(Arrays.stream(formatting).map(MCTextFormatting::getInternal).toArray(TextFormatting[]::new)));
    }
    
    @ZenCodeType.Method
    public MCTextComponent appendText(String text) {
        return new MCTextComponent(getInternal().appendText(text));
    }
    
    @ZenCodeType.Method
    public MCTextComponent appendSibling(MCTextComponent text) {
        return new MCTextComponent(getInternal().appendSibling(text.getInternal()));
    }
    
    @ZenCodeType.Getter("unformattedText")
    public String getUnformattedText() {
        return getInternal().getUnformattedComponentText();
    }
    
    @ZenCodeType.Method
    public String getTruncated(int maxLength) {
        return getInternal().getStringTruncated(maxLength);
    }
    
    @ZenCodeType.Getter("formattedText")
    public String getFormattedText() {
        return getInternal().getFormattedText();
    }
    
    public ITextComponent getInternal() {
        return internal;
    }
}
