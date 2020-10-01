package com.hollingsworth.arsnouveau.api.enchanting_apparatus;

import com.hollingsworth.arsnouveau.ModConfig;
import com.hollingsworth.arsnouveau.api.ArsNouveauAPI;
import com.hollingsworth.arsnouveau.api.util.ManaUtil;
import com.hollingsworth.arsnouveau.api.util.SpellRecipeUtil;
import com.hollingsworth.arsnouveau.api.util.SpellUtil;
import com.hollingsworth.arsnouveau.common.block.tile.EnchantingApparatusTile;
import com.hollingsworth.arsnouveau.common.enchantment.EnchantmentRegistry;
import com.hollingsworth.arsnouveau.common.items.SpellParchment;
import com.hollingsworth.arsnouveau.setup.APIRegistry;
import com.hollingsworth.arsnouveau.setup.ItemsRegistry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ReactiveEnchantmentRecipe implements IEnchantingRecipe{

    public ReactiveEnchantmentRecipe(){ }

    public boolean isWriteSpell(List<ItemStack> pedestalItems, ItemStack reagent){
        ItemStack[] items = {ItemsRegistry.spellParchment.getDefaultInstance()};
        List<ItemStack> stacks = Arrays.asList(items);
        if(EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistry.REACTIVE_ENCHANTMENT, reagent) == 0)
            return false;

        if(!EnchantingApparatusRecipe.areSameSet(stacks, pedestalItems))
            return false;

        for(ItemStack stack : pedestalItems){
            if(stack.getItem() instanceof SpellParchment && SpellParchment.getSpellRecipe(stack) == null){
                return false;
            }
        }
        return true;
    }

    public boolean isLevelOne(List<ItemStack> pedestalItems, ItemStack reagent){
        ItemStack[] items = {ItemsRegistry.spellParchment.getDefaultInstance(),
                ArsNouveauAPI.getInstance().getGlyphItem(ModConfig.AugmentAmplifyID).getDefaultInstance(),
                ArsNouveauAPI.getInstance().getGlyphItem(ModConfig.AugmentAmplifyID).getDefaultInstance(),
                ArsNouveauAPI.getInstance().getGlyphItem(ModConfig.AugmentAmplifyID).getDefaultInstance()};
        List<ItemStack> stacks = Arrays.asList(items);
        if(EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistry.REACTIVE_ENCHANTMENT, reagent) != 0)
            return false;
        if(!EnchantingApparatusRecipe.areSameSet(stacks, pedestalItems))
            return false;
        for(ItemStack stack : pedestalItems){
            if(stack.getItem() instanceof SpellParchment && SpellParchment.getSpellRecipe(stack) == null){
                return false;
            }
        }
        return true;
    }

    public boolean isLevelTwo(List<ItemStack> pedestalItems, ItemStack reagent){
        ItemStack[] items = {Items.BLAZE_POWDER.getDefaultInstance(),
                Items.BLAZE_POWDER.getDefaultInstance(),
                Items.BLAZE_POWDER.getDefaultInstance(),
                Items.BLAZE_POWDER.getDefaultInstance(),
                Items.GOLD_BLOCK.getDefaultInstance(),
                ArsNouveauAPI.getInstance().getGlyphItem(ModConfig.AugmentExtendTimeID).getDefaultInstance(),
                ArsNouveauAPI.getInstance().getGlyphItem(ModConfig.AugmentAOEID).getDefaultInstance(),
                ArsNouveauAPI.getInstance().getGlyphItem(ModConfig.AugmentDampenID).getDefaultInstance()};
        List<ItemStack> stacks = Arrays.asList(items);
        if(EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistry.REACTIVE_ENCHANTMENT, reagent) != 1)
            return false;
        if(!EnchantingApparatusRecipe.areSameSet(stacks, pedestalItems))
            return false;
       return true;
    }

    public boolean isLevelThree(List<ItemStack> pedestalItems, ItemStack reagent){
        ItemStack[] items = {ItemsRegistry.mythicalClay.getDefaultInstance(),
                ItemsRegistry.mythicalClay.getDefaultInstance(),
                ItemsRegistry.mythicalClay.getDefaultInstance(),
                ItemsRegistry.mythicalClay.getDefaultInstance(),
                Items.ENDER_PEARL.getDefaultInstance(),
                ArsNouveauAPI.getInstance().getGlyphItem(ModConfig.AugmentPierceID).getDefaultInstance(),
                ArsNouveauAPI.getInstance().getGlyphItem(ModConfig.AugmentExtractID).getDefaultInstance(),
                ArsNouveauAPI.getInstance().getGlyphItem(ModConfig.AugmentFortuneID).getDefaultInstance()};
        List<ItemStack> stacks = Arrays.asList(items);
        if(EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistry.REACTIVE_ENCHANTMENT, reagent) != 2)
            return false;
        if(!EnchantingApparatusRecipe.areSameSet(stacks, pedestalItems))
            return false;
        return true;
    }

    public ItemStack getParchment(List<ItemStack> pedestalItems){
        for(ItemStack stack : pedestalItems){
            if(stack.getItem() instanceof SpellParchment){
                return stack;
            }
        }
        return null;
    }

    @Override
    public boolean isMatch(List<ItemStack> pedestalItems, ItemStack reagent, EnchantingApparatusTile enchantingApparatusTile) {
        if(isLevelOne(pedestalItems, reagent) && ManaUtil.hasManaNearby(enchantingApparatusTile.getPos(), enchantingApparatusTile.getWorld(), 10, manaCost())){
            return true;
        }else if(isLevelTwo(pedestalItems, reagent) &&
                ManaUtil.hasManaNearby(enchantingApparatusTile.getPos(), enchantingApparatusTile.getWorld(), 10, manaCost() * 2)){
            return true;
        }else if(isLevelThree(pedestalItems, reagent) &&
                ManaUtil.hasManaNearby(enchantingApparatusTile.getPos(), enchantingApparatusTile.getWorld(), 10, manaCost() * 3)){
            return true;
        }else if(isWriteSpell(pedestalItems, reagent)) {
            System.out.println("is write ");
            return true;
        }
        return false;
    }

    @Override
    public ItemStack getResult(List<ItemStack> pedestalItems, ItemStack reagent, EnchantingApparatusTile enchantingApparatusTile) {
        Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(reagent);
        if(isLevelOne(pedestalItems, reagent)){
            enchantments.put(EnchantmentRegistry.REACTIVE_ENCHANTMENT, 1);
            EnchantmentHelper.setEnchantments(enchantments, reagent);
            CompoundNBT tag = reagent.getTag();
            ItemStack parchment = getParchment(pedestalItems);
            tag.putString("spell", parchment.getTag().getString("spell"));
            reagent.setTag(tag);
        }else if(isLevelTwo(pedestalItems, reagent) && ManaUtil.takeManaNearby(enchantingApparatusTile.getPos(), enchantingApparatusTile.getWorld(), 10, manaCost() * 2) != null){
            enchantments.put(EnchantmentRegistry.REACTIVE_ENCHANTMENT, 2);
            EnchantmentHelper.setEnchantments(enchantments, reagent);
        }else if(isLevelThree(pedestalItems, reagent) && ManaUtil.takeManaNearby(enchantingApparatusTile.getPos(), enchantingApparatusTile.getWorld(), 10, manaCost() * 3) != null){
            enchantments.put(EnchantmentRegistry.REACTIVE_ENCHANTMENT, 3);
            EnchantmentHelper.setEnchantments(enchantments, reagent);
        }else if(isWriteSpell(pedestalItems, reagent)){
            CompoundNBT tag = reagent.getTag();
            ItemStack parchment = getParchment(pedestalItems);
            tag.putString("spell", parchment.getTag().getString("spell"));
            reagent.setTag(tag);
        }

        return reagent;
    }

    @Override
    public int manaCost() {
        return 3000;
    }

    @Override
    public boolean consumesMana() {
        return true;
    }
}