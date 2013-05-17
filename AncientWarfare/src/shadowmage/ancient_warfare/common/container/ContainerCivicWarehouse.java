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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import shadowmage.ancient_warfare.common.civics.TECivicWarehouse;
import shadowmage.ancient_warfare.common.config.Config;
import shadowmage.ancient_warfare.common.inventory.AWInventoryMapped;
import shadowmage.ancient_warfare.common.utils.InventoryTools;
import shadowmage.ancient_warfare.common.utils.StackWrapper;
import shadowmage.ancient_warfare.common.utils.StackWrapperComparatorAlphaAZ;

public class ContainerCivicWarehouse extends ContainerBase
{

TECivicWarehouse te;
public List<StackWrapper> warehouseItems = new ArrayList<StackWrapper>();
protected StackWrapperComparatorAlphaAZ azSorter = new StackWrapperComparatorAlphaAZ();


protected AWInventoryMapped cacheInventory = new AWInventoryMapped(0);

public int filledSlotCount = 0;

/**
 * @param openingPlayer
 * @param synch
 */
public ContainerCivicWarehouse(EntityPlayer openingPlayer, TECivicWarehouse te)
  {
  super(openingPlayer, te);
  this.te = te;  
  if(!te.worldObj.isRemote)
    {
    long t1 = System.nanoTime();
    this.warehouseItems = InventoryTools.getCompactedInventory(te.inventory, azSorter);
    long t2 = System.nanoTime();
    Config.logDebug("initializing server container. items length: "+warehouseItems.size() + " time: "+ (t2-t1));
    t1 = System.nanoTime();
    this.filledSlotCount = te.getSizeInventory() - te.inventory.getEmptySlotCount();
    t2 = System.nanoTime();
    Config.logDebug("empty slot counting time: "+(t2-t1));
    
    this.cacheInventory.setInventorySize(te.getSizeInventory());
    
    ItemStack stack = null;
    for(int i = 0; i < te.getSizeInventory(); i++)
      {
      stack = te.getStackInSlot(i);
      if(stack!=null)
        {
        this.cacheInventory.setInventorySlotContents(i, stack.copy());
        }      
      }    
    }
    
  int y;
  int x;
  int slotNum;  
  int xPos; 
  int yPos;
  for (x = 0; x < 9; ++x)//add player hotbar slots
    {
    slotNum = x;
    xPos = 8 + x * 18;
    yPos = 162 + 3*18;
    this.addSlotToContainer(new Slot(openingPlayer.inventory, x, xPos, yPos));
    }
  for (y = 0; y < 3; ++y)
    {
    for (x = 0; x < 9; ++x)
      {
      slotNum = y*9 + x + 9;// +9 is to increment past hotbar slots
      xPos = 8 + x * 18;
      yPos = 158 + y * 18;
      this.addSlotToContainer(new Slot(openingPlayer.inventory, slotNum, xPos, yPos));
      }
    }
  
  for(y = 0; y < 3; y++)
    {
    for(x = 0; x < 3; x++)
      {
      slotNum = y*3 + x;
      xPos = 8 + x * 18;
      yPos = 98 + y * 18;
      Slot slot = new Slot(te.inputSlots, slotNum, xPos, yPos);
      this.addSlotToContainer(slot);      
      }
    }
  
  for(y = 0; y < 3; y++)
    {
    for(x = 0; x < 3; x++)
      {
      slotNum = y*3 + x;
      xPos = 8 + x * 18 + 6*18;
      yPos = 98 + y * 18;       
      Slot slot = new Slot(te.withdrawSlots, slotNum, xPos, yPos);
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
    int storageSlots = te.inputSlots.getSizeInventory();
    int storageSlots2 = te.withdrawSlots.getSizeInventory();
    if (slotClickedIndex < 36)//player slots...
      {      
      if (!this.mergeItemStack(slotStack, 36, 36+storageSlots, false))//merge into storage inventory
        {
        return null;
        }
      }
    else if(slotClickedIndex >=36 &&slotClickedIndex < 36+storageSlots)//storage slots, merge to player inventory
      {
      if (!this.mergeItemStack(slotStack, 0, 36, true))//merge into player inventory
        {
        return null;
        }
      }
    else if(slotClickedIndex >=36+storageSlots && slotClickedIndex < 36+storageSlots+storageSlots2)//storage slots, merge to player inventory
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
public void handlePacketData(NBTTagCompound tag)
  {
  if(tag.hasKey("req"))
    {
    this.handleRequest(tag);
    }
  if(tag.hasKey("init"))
    {
    this.handleInitData(tag);
    }
  }

protected void handleRequest(NBTTagCompound tag)
  {
  int index = tag.getInteger("slot");
  if(index>=0 && index < this.warehouseItems.size())
    {
    StackWrapper wrap = this.warehouseItems.get(index);
    ItemStack stack = wrap.stack;
    if(te.withdrawSlots.canHoldItem(stack, 64))
      {
      ItemStack removed = te.inventory.getItems(stack, 64);
      removed = te.withdrawSlots.tryMergeItem(removed);
      te.overflow.tryMergeItem(removed);
      }
    }
  }

@Override
public void handleInitData(NBTTagCompound tag)
  {
  this.warehouseItems = InventoryTools.getCompactInventoryFromTag(tag);
  this.filledSlotCount = tag.getInteger("filledSlotCount");  
  Config.logDebug("read warehouse items length: "+warehouseItems.size());
  }

@Override
public List<NBTTagCompound> getInitData()
  {
  List<NBTTagCompound> tags = new ArrayList<NBTTagCompound>();
  long t1 = System.nanoTime();
  NBTTagCompound tag = InventoryTools.getTagForCompactInventory(warehouseItems);
  tag.setInteger("filledSlotCount", this.filledSlotCount);
  tags.add(tag);
  long t2 = System.nanoTime();
  Config.logDebug("inv compact time: "+(t2-t1));
  return tags;
  }

@Override
public void onCraftGuiClosed(EntityPlayer par1EntityPlayer)
  {
  te.removePlayer(par1EntityPlayer);
  super.onCraftGuiClosed(par1EntityPlayer);
  }

@Override
public void detectAndSendChanges()
  {
  Config.logDebug("detecting changes...client: "+this.player.worldObj.isRemote);
  boolean sendPacket = false;
  if(te.getSizeInventory()!=cacheInventory.getSizeInventory())
    {
    sendPacket = true;
    }
  else
    {
    ItemStack cacheStack = null;
    ItemStack teStack = null;
    long t1 = System.nanoTime();
    for(int i = 0; i < this.cacheInventory.getSizeInventory(); i++)
      {
      cacheStack = cacheInventory.getStackInSlot(i);
      teStack = te.inventory.getStackInSlot(i);
      if(!ItemStack.areItemStacksEqual(cacheStack, teStack))        
        {
        sendPacket = true;      
        if(teStack!=null)
        {
            cacheInventory.setInventorySlotContents(i, teStack.copy());
        	
        }
        else
        {

            cacheInventory.setInventorySlotContents(i, null);
        }  
        }
      }
    long t2 = System.nanoTime();
    Config.logDebug("inv check time: "+ (t2-t1) + " send packet: "+sendPacket);
    }
  if(sendPacket)
    {
    this.filledSlotCount = te.getSizeInventory() - te.inventory.getEmptySlotCount();
    this.warehouseItems = InventoryTools.getCompactedInventory(te.inventory, azSorter);
    NBTTagCompound tag = InventoryTools.getTagForCompactInventory(warehouseItems);
    tag.setInteger("filledSlotCount", this.filledSlotCount);
    tag.setBoolean("init", true);
    this.sendDataToPlayer(tag);
    }  
  super.detectAndSendChanges();
  }



}
