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
package shadowmage.ancient_warfare.common.container;

import java.util.List;

import shadowmage.ancient_warfare.common.config.Config;
import shadowmage.ancient_warfare.common.interfaces.IEntityContainerSynch;
import shadowmage.ancient_warfare.common.item.ItemLoader;
import shadowmage.ancient_warfare.common.npcs.NpcBase;
import shadowmage.ancient_warfare.common.npcs.waypoints.CourierRoutingInfo;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ContainerNpcCourier extends ContainerBase
{

NpcBase npc;

/**
 * @param openingPlayer
 * @param synch
 */
public ContainerNpcCourier(EntityPlayer openingPlayer, NpcBase npc)
  {
  super(openingPlayer, null);
  this.npc = npc;
  int y;
  int x;
  int slotNum;
  int xPos; 
  int yPos;
  for (x = 0; x < 9; ++x)//add player hotbar slots
    {
    slotNum = x;
    xPos = 8 + x * 18;
    yPos = 142+28;
    this.addSlotToContainer(new Slot(openingPlayer.inventory, x, xPos, yPos));
    }
  for (y = 0; y < 3; ++y)
    {
    for (x = 0; x < 9; ++x)
      {
      slotNum = y*9 + x + 9;// +9 is to increment past hotbar slots
      xPos = 8 + x * 18;
      yPos = 84 + y * 18+28;
      this.addSlotToContainer(new Slot(openingPlayer.inventory, slotNum, xPos, yPos));
      }
    }
    
  IInventory te = npc.inventory;
  for(y = 0; y < te.getSizeInventory()/9; y++)
    {
    for(x = 0; x < 9; x++)
      {
      slotNum = y*9 + x;
      if(slotNum<te.getSizeInventory())
        {
        xPos = 8 + x * 18;
        yPos = 10 + y * 18;       
        Slot slot = new Slot(te, slotNum, xPos, yPos);
        this.addSlotToContainer(slot);        
        }
      }
    }

  
  te = npc.specInventory;
  Config.logDebug("opening container courier. spec inv size: "+te.getSizeInventory());
  
  for(x = 0; x < te.getSizeInventory(); x++)
    {
    slotNum = x;
    Config.logDebug("checking slotNum: "+slotNum);
    if(slotNum<te.getSizeInventory())
      {
      xPos = 8 + x * 18;
      yPos = 10 + 3*18 + 2;       
      Slot slot = new Slot(te, slotNum, xPos, yPos);
      Config.logDebug("adding specinventory slot");
      this.addSlotToContainer(slot);        
      }
    }
  }

@Override
public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int slotClickedIndex)
  {
  ItemStack slotStackCopy = null;
  Slot theSlot = (Slot)this.inventorySlots.get(slotClickedIndex);
  if (theSlot != null && theSlot.getHasStack())
    {
    ItemStack slotStack = theSlot.getStack();
    slotStackCopy = slotStack.copy();
    int storageSlots = npc.npcType.getInventorySize(npc.rank);    
    if (slotClickedIndex < 36)//player slots...
      {      
      if (!this.mergeItemStack(slotStack, 36, 36+storageSlots, false))//merge into storage inventory
        {
        return null;
        }
      }
    else if(slotClickedIndex >=36 &&slotClickedIndex < 36+storageSlots)//vehicle slots, merge to player inventory
      {
      if (!this.mergeItemStack(slotStack, 0, 36, true))//merge into player inventory
        {
        return null;
        }
      }
    if (slotStack.stackSize == 0)
      {
      theSlot.putStack((ItemStack)null);
      }
    else
      {
      theSlot.onSlotChanged();
      }
    if (slotStack.stackSize == slotStackCopy.stackSize)
      {
      return null;
      }
    theSlot.onPickupFromSlot(par1EntityPlayer, slotStack);
    }
  return slotStackCopy;
  }

@Override
public void onCraftGuiClosed(EntityPlayer par1EntityPlayer)
  {
  Config.logDebug("on craft gui closed...");
  super.onCraftGuiClosed(par1EntityPlayer);
  if(!npc.worldObj.isRemote)
    {
    npc.wayNav.clearCourierPoints();
    ItemStack stack = npc.specInventory.getStackInSlot(0);
    Config.logDebug("stack in spec slot: "+stack);
    if(stack!=null && stack.itemID == ItemLoader.courierRouteSlip.itemID)
      {
      Config.logDebug("adding courier info to npc");
      CourierRoutingInfo info = new CourierRoutingInfo(stack);
      for(int i = 0 ; i < info.getRouteSize(); i++)
        {
        Config.logDebug("adding courier waypoint to npc");
        npc.wayNav.addCourierPoint(info.getPoint(i));
        }    
      }
    } 
  }

@Override
public void handlePacketData(NBTTagCompound tag)
  {

  }

@Override
public void handleInitData(NBTTagCompound tag)
  {

  }

@Override
public List<NBTTagCompound> getInitData()
{

return null;
}

}