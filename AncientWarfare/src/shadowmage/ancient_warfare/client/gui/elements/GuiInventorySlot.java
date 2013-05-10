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

import net.minecraft.inventory.Slot;

public class GuiInventorySlot extends GuiElement
{

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
