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
package shadowmage.ancient_warfare.common.tracker;

import java.util.HashMap;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import shadowmage.ancient_warfare.common.AWStructureModule;
import shadowmage.ancient_warfare.common.config.Config;
import shadowmage.ancient_warfare.common.crafting.AWCraftingManager;
import shadowmage.ancient_warfare.common.npcs.NpcBase;
import shadowmage.ancient_warfare.common.tracker.entry.NpcDataList;
import shadowmage.ancient_warfare.common.world_gen.WorldGenManager;

/**
 * handles saving and loading of game data to world directory
 * @author Shadowmage
 *
 */
public class GameDataTracker
{

private static GameDataTracker INSTANCE;
AWGameData gameData = null;

/**
 * map of npcs, by owning team (only tracks player owned npcs)
 * stored to be viewable through npc town-hall block info GUI
 */
HashMap<Integer, NpcDataList> npcTracker = new HashMap<Integer, NpcDataList>();

private GameDataTracker()
  {  
  }
public static GameDataTracker instance()
  {
  if(INSTANCE==null)
    {
    INSTANCE = new GameDataTracker();
    }
  return INSTANCE;
  }

private String lastSavePath = "";
private long lastLoadedTimeStamp = -1L;

public void markGameDataDirty()
  {
  if(this.gameData!=null)
    {
    this.gameData.markDirty();
    }
  }

public void handleNpcUpdate(NpcBase npc)
  {
  if(!this.npcTracker.containsKey(npc.teamNum))
    {
    this.npcTracker.put(npc.teamNum, new NpcDataList(npc.teamNum));
    }
  this.npcTracker.get(npc.teamNum).handleNpcUpdate(npc);
  this.markGameDataDirty();
  }

public void handleNpcDeath(NpcBase npc)
  {
  if(!this.npcTracker.containsKey(npc.teamNum))
    {
    return;
    }
  this.npcTracker.get(npc.teamNum).handleNpcDeath(npc);
  this.markGameDataDirty();
  }

public void resetAllTrackedData()
  {
  PlayerTracker.instance().clearAllData();
  TeamTracker.instance().clearAllData();
  AWStructureModule.instance().clearAllData();
  WorldGenManager.resetMap();
  AWCraftingManager.instance().resetClientData();
  this.npcTracker.clear();
  this.markGameDataDirty();
  this.lastLoadedTimeStamp = -1L;
  }

public void handleWorldLoad(World world)
  {
  if(world.isRemote)
    {
    return;
    }
  Config.logDebug("loading game data from world");
  this.gameData = AWGameData.get(world);
  }

public void handleWorldSave(World world)
  {
  if(world.isRemote)
    {
    return;
    }
  }

public void loadNpcMap(NBTTagCompound tag)
  {
  NBTTagList list = tag.getTagList("list");
  NBTTagCompound entryTag;
  NpcDataList data;
  for(int i = 0; i < list.tagCount(); i++)
    {
    entryTag = (NBTTagCompound) list.tagAt(i);
    data = new NpcDataList();
    data.readFromNBT(entryTag);
    this.npcTracker.put(data.teamNum, data);
    }
  }

public NBTTagCompound getNpcMapTag()
  {
  NBTTagCompound tag = new NBTTagCompound();
  NBTTagList list = new NBTTagList();
  for(NpcDataList data : this.npcTracker.values())
    {
    list.appendTag(data.getNBTTag());
    }  
  tag.setTag("list", list);
  return tag;
  }

}
