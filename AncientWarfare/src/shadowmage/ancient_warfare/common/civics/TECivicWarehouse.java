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
package shadowmage.ancient_warfare.common.civics;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import shadowmage.ancient_warfare.common.civics.types.Civic;
import shadowmage.ancient_warfare.common.config.Config;
import shadowmage.ancient_warfare.common.interfaces.IEntityContainerSynch;
import shadowmage.ancient_warfare.common.inventory.AWInventoryMapped;
import shadowmage.ancient_warfare.common.tracker.TeamTracker;

public class TECivicWarehouse extends TECivic implements IEntityContainerSynch
{

int storageSize = 0;

/**
 * 
 */
public TECivicWarehouse()
  {
  // TODO Auto-generated constructor stub
  }

@Override
public void setCivic(Civic civ)
  {
  this.civic = civ;
  inventory = new AWInventoryMapped(this.storageSize);
  }

public void addWareHouseBlock(int x, int y, int z)
  {
  this.storageSize += 27;
  ((AWInventoryMapped)this.inventory).setInventorySize(this.storageSize);
  Config.logDebug("adding warehouse block. new size: "+this.storageSize);
  }

public void removeWarehouseBlock(int x, int y, int z)
  {
  this.storageSize-= 27;
  ((AWInventoryMapped)this.inventory).setInventorySize(this.storageSize);
  Config.logDebug("removing warehouse block. new size: "+this.storageSize);
  }

@Override
protected void readCivicDataFromNBT(NBTTagCompound tag)
  {
  if(tag.hasKey("warehouseSize"))
    {
    storageSize = tag.getInteger("warehouseSize");
    }
  super.readCivicDataFromNBT(tag);  
  }

@Override
public void writeToNBT(NBTTagCompound tag)
  {
  super.writeToNBT(tag);
  tag.setInteger("warehouseSize", storageSize);
  }

@Override
public void handleClientInput(NBTTagCompound tag)
  {
  // TODO Auto-generated method stub  
  }

@Override
public void addPlayer(EntityPlayer player)
  {
  Config.logDebug("adding player to warehouse viewers");
  this.viewingPlayers.add(player);  
  }

@Override
public void removePlayer(EntityPlayer player)
  {  
  Config.logDebug("removing player from warehouse viewers");
  this.viewingPlayers.remove(player);
  }

protected Set<EntityPlayer> viewingPlayers = Collections.newSetFromMap(new WeakHashMap<EntityPlayer, Boolean>());

@Override
public boolean canInteract(EntityPlayer player)
  {
  return TeamTracker.instance().getTeamForPlayer(player)==this.teamNum;
  }

}
