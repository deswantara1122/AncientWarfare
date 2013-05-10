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
package shadowmage.ancient_warfare.client.gui;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import shadowmage.ancient_warfare.client.gui.elements.GuiInventorySlot;

public abstract class GuiContainer2 extends GuiScreen
{

/**
 * need to rip out all the vanilla slot crap, replace with intelligent
 * slot stuff.
 * 
 * need to figure out what all that touchscreen shit is...or perhaps just
 * remove it and forget about them (cuz IDGAF)
 * 
 * need a way to determine if mouse is over a slot, even if slot is embedded in
 * a guiScrollableArea
 * 
 */

/** Stacks renderer. Icons, stack size, health, etc... */
protected static RenderItem itemRenderer = new RenderItem();

/** The X size of the inventory window in pixels. */
protected int xSize = 176;

/** The Y size of the inventory window in pixels. */
protected int ySize = 166;

/** A list of the players inventory slots. */
public Container inventorySlots;

protected List<GuiInventorySlot> allSlots = new ArrayList<GuiInventorySlot>();

/**
 * Starting X position for the Gui. Inconsistent use for Gui backgrounds.
 */
protected int guiLeft;

/**
 * Starting Y position for the Gui. Inconsistent use for Gui backgrounds.
 */
protected int guiTop;


protected int mouseX;
protected int mouseY;

/**
 * the MOUSE slot
 */
private Slot theSlot;


public GuiContainer2(Container par1Container)
  {
  this.inventorySlots = par1Container;
  }

/**
 * Adds the buttons (and other controls) to the screen in question.
 */
@Override
public void initGui()
  {
  super.initGui();
  this.mc.thePlayer.openContainer = this.inventorySlots;
  this.guiLeft = (this.width - this.xSize) / 2;
  this.guiTop = (this.height - this.ySize) / 2;
  }

/**
 * Draws the screen and all the components in it.
 */
@Override
public void drawScreen(int par1, int par2, float par3)
  {

  }

/**
 * Draw the foreground layer for the GuiContainer (everything in front of the items)
 */
protected void drawGuiContainerForegroundLayer(int par1, int par2) {}

/**
 * Draw the background layer for the GuiContainer (everything behind the items)
 */
protected abstract void drawGuiContainerBackgroundLayer(float f, int i, int j);

/**
 * Called when the mouse is moved or a mouse button is released.  Signature: (mouseX, mouseY, which) which==-1 is
 * mouseMove, which==0 or which==1 is mouseUp
 */
@Override
protected void mouseMovedOrUp(int par1, int par2, int par3)
  {

  }

/**
 * Args: left, top, width, height, pointX, pointY. Note: left, top are local to Gui, pointX, pointY are local to
 * screen
 */
protected boolean isPointInRegion(int par1, int par2, int par3, int par4, int par5, int par6)
  {
  int k1 = this.guiLeft;
  int l1 = this.guiTop;
  par5 -= k1;
  par6 -= l1;
  return par5 >= par1 - 1 && par5 < par1 + par3 + 1 && par6 >= par2 - 1 && par6 < par2 + par4 + 1;
  }

protected void handleMouseClick(Slot par1Slot, int par2, int par3, int par4)
  {
  if (par1Slot != null)
    {
    par2 = par1Slot.slotNumber;
    }
  this.mc.playerController.windowClick(this.inventorySlots.windowId, par2, par3, par4, this.mc.thePlayer);
  }

/**
 * Fired when a key is typed. This is the equivalent of KeyListener.keyTyped(KeyEvent e).
 */
@Override
protected void keyTyped(char par1, int par2)
  {
  if (par2 == 1 || par2 == this.mc.gameSettings.keyBindInventory.keyCode)
    {
    this.mc.thePlayer.closeScreen();
    }
  this.checkHotbarKeys(par2);
  if (this.theSlot != null && this.theSlot.getHasStack())
    {
    if (par2 == this.mc.gameSettings.keyBindPickBlock.keyCode)
      {
      this.handleMouseClick(this.theSlot, this.theSlot.slotNumber, 0, 3);
      }
    else if (par2 == this.mc.gameSettings.keyBindDrop.keyCode)
      {
      this.handleMouseClick(this.theSlot, this.theSlot.slotNumber, isCtrlKeyDown() ? 1 : 0, 4);
      }
    }
  }

/**
 * This function is what controls the hotbar shortcut check when you press a number key when hovering a stack.
 */
protected boolean checkHotbarKeys(int par1)
  {
  if (this.mc.thePlayer.inventory.getItemStack() == null && this.theSlot != null)
    {
    for (int j = 0; j < 9; ++j)
      {
      if (par1 == 2 + j)
        {
        this.handleMouseClick(this.theSlot, this.theSlot.slotNumber, j, 2);
        return true;
        }
      }
    }
  return false;
  }

/**
 * Called when the screen is unloaded. Used to disable keyboard repeat events
 */
@Override
public void onGuiClosed()
  {
  if (this.mc.thePlayer != null)
    {
    this.inventorySlots.onCraftGuiClosed(this.mc.thePlayer);
    }
  }

/**
 * Returns true if this GUI should pause the game when it is displayed in single-player
 */
@Override
public boolean doesGuiPauseGame()
  {
  return false;
  }

/**
 * Called from the main game loop to update the screen.
 */
@Override
public void updateScreen()
  {
  if (!this.mc.thePlayer.isEntityAlive() || this.mc.thePlayer.isDead)
    {
    this.mc.thePlayer.closeScreen();
    }
  }


}
