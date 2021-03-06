/**
   Copyright 2012 John Cummens (aka Shadowmage, Shadowmage4513)
   This software is distributed under the terms of the GNU General Public License.
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
package shadowmage.ancient_warfare.common.npcs.helpers.targeting;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import shadowmage.ancient_warfare.common.npcs.NpcBase;
import shadowmage.ancient_warfare.common.targeting.TargetType;
import shadowmage.ancient_warfare.common.tracker.TeamTracker;

public class AITargetEntryTeamHealing extends AITargetEntry
{

public AITargetEntryTeamHealing(NpcBase npc, TargetType typeName, Class clz, int priority, float maxTargetRange)
  {
  super(npc, typeName, clz, priority, true, maxTargetRange);
  }

@Override
public boolean isTarget(Entity ent)
  {
  if(ent==null || ent.isDead)
    {
    return false;
    }
  if(ent instanceof EntityPlayer)
    {
    EntityPlayer player = (EntityPlayer)ent;    
    int pTeam = TeamTracker.instance().getTeamForPlayer(player);
    if(player.getHealth()< player.getMaxHealth() && !TeamTracker.instance().isHostileTowards(npc.worldObj, npc.teamNum, pTeam) && !TeamTracker.instance().isHostileTowards(npc.worldObj, pTeam, npc.teamNum))
      {
      return true;
      }       
    }
  else if(ent instanceof NpcBase)
    {
    NpcBase otherNpc = (NpcBase)ent;
    if(otherNpc.getHealth()< otherNpc.getMaxHealth() && !TeamTracker.instance().isHostileTowards(npc.worldObj, npc.teamNum, otherNpc.teamNum) && !TeamTracker.instance().isHostileTowards(npc.worldObj, otherNpc.teamNum, npc.teamNum))
      {
      return true;
      } 
    }
  return false;
  }


}
