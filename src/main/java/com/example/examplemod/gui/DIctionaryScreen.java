package com.example.examplemod.gui;

import com.example.examplemod.dictionary.ItemManager;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;

public class DIctionaryScreen extends DebugScreen {
    private ArrayList<ItemStack> itemStackList = new ArrayList<>();
    protected DIctionaryScreen(Component pTitle) {
        super(pTitle);
        for(ItemStack itemStack:ItemManager.getItemStackMap().values()){
            itemStackList.add(itemStack);
        }
    }

    @Override
    protected void init() {
        super.init();

    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        int x= 0, line=0, id = 0;
        for(int i = 0; i < itemStackList.size();i++){
            x+= 20;
            renderItem(pGuiGraphics, x, line * 20, 1, itemStackList.get(i), pPartialTick);

        }
    }

    public void renderItem(GuiGraphics pGuiGraphics, int resultX, int resultY, float scale, ItemStack item, float pPartialTick){
        pGuiGraphics.pose().pushPose();
        pGuiGraphics.setColor(123,123,1, 0.5F);
        pGuiGraphics.pose().scale(scale,scale,scale);
        pGuiGraphics.renderItem(item, resultX, resultY);
        pGuiGraphics.pose().popPose();
    }
}
