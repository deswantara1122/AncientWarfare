/**
   Copyright 2012 John Cummens (aka Shadowmage, Shadowmage4513)
   This software is distributed under the terms of the GNU General Public Licence.
   Please see COPYING for precise license information.

   This file is part of Ancient Warfare.

   Ancient Warfare is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   Ancient Warfare is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with Ancient Warfare.  If not, see <http://www.gnu.org/licenses/>.
 */
package shadowmage.ancient_warfare.client.gui.elements;

import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;

import org.lwjgl.opengl.GL11;

public class GuiInventorySlot extends GuiElement
{
protected static RenderItem itemRenderer = new RenderItem();
Slot slot;
/**
 * @param elementNum
 * @param parent
 * @param w
 * @param h
 */
public GuiInventorySlot(int elementNum, IGuiElementCallback parent, Slot slot)
  {
  super(elementNum, parent, 18, 18);
  this.slot = slot;
  }

@Override
public void drawElement(int mouseX, int mouseY)
  {  
  int i = guiLeft + renderPosX;
  int j = guiTop + renderPosY;
  ItemStack itemstack = slot.getStack();
  boolean flag = false;
  boolean flag1 = false;
  String s = null;

  this.zLevel = 100.0F;
  itemRenderer.zLevel = 100.0F;

  if (itemstack == null)
    {
    Icon icon = slot.getBackgroundIconIndex();
    if (icon != null)
      {
      GL11.glDisable(GL11.GL_LIGHTING);
      this.mc.renderEngine.bindTexture("/gui/items.png");
      this.drawTexturedModelRectFromIcon(i, j, icon, 16, 16);
      GL11.glEnable(GL11.GL_LIGHTING);
      flag1 = true;
      }
    }
  if (!flag1)
    {
    if (flag)
      {
      drawRect(i, j, i + 16, j + 16, -2130706433);
      }
    GL11.glEnable(GL11.GL_DEPTH_TEST);
    itemRenderer.renderItemAndEffectIntoGUI(this.mc.fontRenderer, this.mc.renderEngine, itemstack, i, j);
    itemRenderer.renderItemOverlayIntoGUI(this.mc.fontRenderer, this.mc.renderEngine, itemstack, i, j, s);
    }
  itemRenderer.zLevel = 0.0F;
  this.zLevel = 0.0F; 
  if (this.isMouseOver(mouseX, mouseY))
    {
    int i1;
    GL11.glDisable(GL11.GL_LIGHTING);
    GL11.glDisable(GL11.GL_DEPTH_TEST);
    int k1 = this.guiLeft + this.renderPosX;
    i1 = this.guiTop + this.renderPosY;
    this.drawGradientRect(k1, i1, k1 + 16, i1 + 16, -2130706433, -2130706433);
    GL11.glEnable(GL11.GL_LIGHTING);
    GL11.glEnable(GL11.GL_DEPTH_TEST);
    }
  }

@Override
public boolean handleMousePressed(int x, int y, int num)
  {
  // TODO Auto-generated method stub
  return false;
  }

@Override
public boolean handleMouseReleased(int x, int y, int num)
  {
  // TODO Auto-generated method stub
  return false;
  }

@Override
public boolean handleMouseMoved(int x, int y, int num)
  {
  // TODO Auto-generated method stub
  return false;
  }

@Override
public boolean handleMouseWheel(int x, int y, int wheel)
  {
  // TODO Auto-generated method stub
  return false;
  }

@Override
public boolean handleKeyInput(char ch, int keyNum)
  {
  // TODO Auto-generated method stub
  return false;
  }

}
