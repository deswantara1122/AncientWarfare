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
package shadowmage.ancient_warfare.common.network;

import net.minecraft.nbt.NBTTagCompound;
import shadowmage.ancient_warfare.common.manager.StructureManager;
import shadowmage.ancient_warfare.common.tracker.PlayerTracker;
import shadowmage.ancient_warfare.common.tracker.TeamTracker;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

/**
 * client-server mod meta-data comms packet
 * used to send server-> client onLogin data
 * used to send server-> client team/playerEntry update data
 * used to send server-> client cooldown, research, and stats data
 * used to send client-> server input for non-GUI information (team changes,
 * @author Shadowmage
 *
 */
public class Packet01ModData extends PacketBase
{

@Override
public String getChannel()
  {  
  return "AW_mod";
  }

@Override
public int getPacketType()
  {  
  return 1;
  }

public void setInitData(NBTTagCompound tag)
  {
  this.packetData.setCompoundTag("init", tag);
  }

public void setStructData(NBTTagCompound tag)
  {
  this.packetData.setCompoundTag("struct", tag);
  }

@Override
public void writeDataToStream(ByteArrayDataOutput data)
  {
  
  }

@Override
public void readDataStream(ByteArrayDataInput data)
  {
  
  }

@Override
public void execute()
  {
  System.out.println("executing packet01");
  NBTTagCompound tag;
  
  /***
   * init data, should break out to player entry, team entry, pass to client-trackers
   */
  if(this.packetData.hasKey("init") && world.isRemote)
    {
    tag = packetData.getCompoundTag("init");
    if(tag.hasKey("playerData"))
      {
      PlayerTracker.instance().handleClientInit(tag.getCompoundTag("playerData"));
      }
    if(tag.hasKey("teamData"))
      {
      TeamTracker.instance().handleClientInit(tag.getCompoundTag("teamData"));
      }    
    }  
  
  /**
   * structure information, completely handled in structManager
   */
  if(this.packetData.hasKey("struct"))
    {
    if(world.isRemote)
      {
      StructureManager.instance().handlePacketDataClient(packetData.getCompoundTag("struct"));
      }
    else
      {
      StructureManager.instance().handlePacketDataServer(packetData.getCompoundTag("struct"));
      }
    }
    
  /**
   * team update tag..
   */
  if(this.packetData.hasKey("team"))
    {
    tag = packetData.getCompoundTag("team");
    if(world.isRemote)
      {      
      TeamTracker.instance().handleClientUpdate(tag);
      }
    else
      {
      TeamTracker.instance().handleServerUpdate(tag);
      }    
    }  
  
  }
  
    
    


}