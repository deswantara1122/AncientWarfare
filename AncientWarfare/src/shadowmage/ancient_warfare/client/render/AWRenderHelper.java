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
package shadowmage.ancient_warfare.client.render;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.ForgeSubscribe;

import org.lwjgl.opengl.GL11;

import shadowmage.ancient_warfare.common.civics.TECivic;
import shadowmage.ancient_warfare.common.config.Config;
import shadowmage.ancient_warfare.common.config.Settings;
import shadowmage.ancient_warfare.common.interfaces.IScannerItem;
import shadowmage.ancient_warfare.common.item.ItemBuilderBase;
import shadowmage.ancient_warfare.common.item.ItemBuilderDirect;
import shadowmage.ancient_warfare.common.item.ItemCivicPlacer;
import shadowmage.ancient_warfare.common.item.ItemGateSpawner;
import shadowmage.ancient_warfare.common.item.ItemLoader;
import shadowmage.ancient_warfare.common.item.ItemStructureScanner;
import shadowmage.ancient_warfare.common.structures.data.StructureClientInfo;
import shadowmage.ancient_warfare.common.utils.BlockPosition;
import shadowmage.ancient_warfare.common.utils.BlockTools;
import shadowmage.ancient_warfare.common.vehicles.VehicleBase;

public class AWRenderHelper
{

private static AWRenderHelper INSTANCE;
private AWRenderHelper()
  {  
  }
public static AWRenderHelper instance()
  {
  if(INSTANCE==null)
    {
    INSTANCE = new AWRenderHelper();
    }
  return INSTANCE;
  }

private void renderScannerBB(EntityPlayer player, ItemStack stack, IScannerItem item, float partialTick, boolean useSneak)
  {
  if(player==null || stack==null || item== null)
    {
    return;
    }    
  BlockPosition p1 = item.getScanPos1(stack);
  if(p1==null)
    {
    return;
    }  
  int face = BlockTools.getPlayerFacingFromYaw(player.rotationYaw);
  BlockPosition p2 = item.getScanPos2(stack);
  if(p2==null)
    {
    p2 = BlockTools.getBlockClickedOn(player, player.worldObj, useSneak ? player.isSneaking() : true);
    if(p2==null)
      {   
      return;
      }
    }
  adjustPositionsForScanBB(p1, p2);
  AxisAlignedBB bb = AxisAlignedBB.getBoundingBox(p1.x, p1.y, p1.z, p2.x, p2.y, p2.z);
  BoundingBoxRender.drawOutlinedBoundingBox(adjustBBForPlayerPos(bb, player, partialTick).contract(.02D, .02D, .02D), 0.8f, 0.2f, 0.8f);
  }

/**
 * uhh..yah......wonderful manual correction...
 * @param p1
 * @param p2
 */
private void adjustPositionsForScanBB(BlockPosition p1, BlockPosition p2)
  {
  if(p2.x<p1.x)
    {
    p1.x++;
    }
  else
    {
    p2.x++;
    }
  if(p2.z<p1.z)
    {
    p1.z++;
    }
  else
    {
    p2.z++;
    }
  if(p1.y>p2.y)
    {
    p1.y++;
    }
  else
    {
    p2.y++;
    }
  }

private void renderStructureBB(EntityPlayer player, ItemStack stack, ItemBuilderBase item, float partialTick)
  {
  if(player==null || stack==null || item== null)
    {
    return;
    }  
  StructureClientInfo info = item.getStructureForStack(stack);    
  if(info==null)
    {
    return;
    }
  BlockPosition hit = BlockTools.getBlockClickedOn(player, player.worldObj, true);
  if(hit==null)
    {
    return;
    }
  int face = BlockTools.getPlayerFacingFromYaw(player.rotationYaw);
  BlockPosition originalHit = hit.copy();
  hit.y-=info.yOffset;
  hit = this.offsetForWorldRender(hit, face);  

  if(item.renderBuilderBlockBB())
    {
    hit.moveForward(face, -info.zOffset + 1 + info.clearingBuffer);
    } 

  AxisAlignedBB bb = info.getBBForRender(hit, face);  
  BoundingBoxRender.drawOutlinedBoundingBox(adjustBBForPlayerPos(bb, player, partialTick).contract(.02D, .02D, .02D), 0.8f, 0.2f, 0.8f);
  if(item.renderBuilderBlockBB())
    {
    bb = AxisAlignedBB.getBoundingBox(originalHit.x, originalHit.y, originalHit.z, originalHit.x+1, originalHit.y+1, originalHit.z+1);
    BoundingBoxRender.drawOutlinedBoundingBox(adjustBBForPlayerPos(bb, player, partialTick).contract(.02D, .02D, .02D), 0.3f, 0.3f, 0.8f);
    }

  if(info.maxClearing > 0|| info.clearingBuffer >0)
    {
    bb = info.getClearingBBForRender(hit, face);
    BoundingBoxRender.drawOutlinedBoundingBox(adjustBBForPlayerPos(bb, player, partialTick).contract(0.1d, 0.1d, 0.1d), 0.8f, 0.f, 0.f);
    }

  if(info.maxLeveling >0)
    {
    bb = info.getLevelingBBForRender(hit, face);
    BoundingBoxRender.drawOutlinedBoundingBox(adjustBBForPlayerPos(bb, player, partialTick).contract(0.1d, 0.1d, 0.1d), 0.3f, 0.8f, 0.3f);
    }
  }

public BlockPosition offsetForWorldRender(BlockPosition hit, int face)
  {
  if(face==0 || face == 1)//south
    {
    hit.moveLeft(face,1);
    }  
  if(face==2 || face==1)
    {
    hit.moveBack(face, 1);
    }
  return hit;
  }

/**
 * @param bb
 * @param player
 * @param partialTick
 * @return
 */
public static AxisAlignedBB adjustBBForPlayerPos(AxisAlignedBB bb, EntityPlayer player, float partialTick)
  {
  double x = player.lastTickPosX + (player.posX - player.lastTickPosX) * partialTick;
  double y = player.lastTickPosY + (player.posY - player.lastTickPosY) * partialTick;
  double z = player.lastTickPosZ + (player.posZ - player.lastTickPosZ) * partialTick;  
  return bb.offset(-x, -y, -z);
  }

@ForgeSubscribe
public void handleRenderLastEvent(RenderWorldLastEvent evt)
  {
  Minecraft mc = Minecraft.getMinecraft();
  if(mc==null)
    {
    return;
    }
  EntityPlayer player = mc.thePlayer;
  if(player==null)
    {
    return;
    }
  if(Config.DEBUG)
    {
    RenderDebugPath.renderPaths(player.worldObj, player, evt.partialTicks);
    }
  
  if(Settings.getRenderAdvOverlay() && player.ridingEntity instanceof VehicleBase && mc.currentScreen==null)
    {
    RenderOverlayAdvanced.renderAdvancedVehicleOverlay((VehicleBase)player.ridingEntity, player, evt.partialTicks);
    }
    
  if(Settings.getRenderCivicBounds())
    {
    this.renderCivicBoundingBoxes(player.worldObj, player, evt.partialTicks);
    }
  
  ItemStack stack = player.inventory.getCurrentItem();
  if(stack==null || stack.getItem()==null)
    {
    return;
    }
  int id = stack.itemID;

  if(ItemBuilderBase.isBuilderItem(id))
    {
    this.renderStructureBB(player, stack, (ItemBuilderBase)stack.getItem(), evt.partialTicks);
    }  
  if(id==ItemLoader.structureBuilderDirect.itemID)
    {
    if(ItemBuilderDirect.isScanning(stack))
      {
      this.renderScannerBB(player, stack, (ItemBuilderDirect)stack.getItem(), evt.partialTicks, true);      
      }
    }
  else if(ItemStructureScanner.isScannerItem(id))
    {
    this.renderScannerBB(player, stack, (ItemStructureScanner)stack.getItem(), evt.partialTicks, true);
    }
  else if(id==ItemLoader.civicPlacer.itemID)
    {
    this.renderScannerBB(player, stack, (ItemCivicPlacer)stack.getItem(), evt.partialTicks, true);
    }
  else if(id==ItemLoader.gateSpawner.itemID)
    {
    this.renderScannerBB(player, stack, (ItemGateSpawner)stack.getItem(), evt.partialTicks, false);
    }
  }

public static void renderCivicBoundingBoxes(World world, EntityPlayer player, float partialTick)
  {
  List<TileEntity> tes = world.loadedTileEntityList;
  for(TileEntity te : tes)
    {
    if(TECivic.class.isAssignableFrom(te.getClass()))
      {
      TECivic tec = (TECivic)te;
      if(!tec.shouldRenderMainBounds())
        {
        continue;
        }
      AxisAlignedBB bb = tec.getWorkBounds(); 
      if(bb!=null)
        {
        BoundingBoxRender.drawOutlinedBoundingBox(adjustBBForPlayerPos(bb, player, partialTick), 1.f, 1.f, 1.f);
        }
      bb = tec.getSecondaryRenderBounds();
      if(bb!=null)
        {
        BoundingBoxRender.drawOutlinedBoundingBox(adjustBBForPlayerPos(bb, player, partialTick), 1.f, 0.6f, 0.6f);
        }
      }
    }
  }

static int[][] colors = new int[16][3];

static
{
colors[0] = new int[]{221,221,221};
colors[1] = new int[]{219,125,62};
colors[2] = new int[]{179,80,188};
colors[3] = new int[]{107,138,201};
colors[4] = new int[]{177,166,39};
colors[5] = new int[]{65,174,56};
colors[6] = new int[]{208,132,153};
colors[7] = new int[]{64,64,64};
colors[8] = new int[]{154,161,161};
colors[9] = new int[]{46,110,137};
colors[10] = new int[]{126,61,181};
colors[11] = new int[]{46,56,141};
colors[12] = new int[]{79,50,31};
colors[13] = new int[]{53,70,27};
colors[14] = new int[]{150,52,48};
colors[15] = new int[]{25,22,22};
}
static int[] colorWhite = new int[]{255,255,255};

public static int[] getRenderColorFor(int color)
  {
  if(color <0 || color>=16)
    {
    return colorWhite;
    }
  return colors[color];     
  }

public static void setTeamRenderColor(int teamNum)
  {
  int[] color = getRenderColorFor(teamNum);
  GL11.glColor3ub((byte)color[0], (byte)color[1], (byte)color[2]); 
  }

/**
 * from meta of 0-15 return the composite color (ARGB) for rendering
 * @param woolColor
 * @return
 */
public static int getCompositeColor(int woolColor)
  {
  int color = 0;
  int colors[] = getRenderColorFor(woolColor);
  color = color | (colors[0]<<16);
  color = color | (colors[1]<<8);
  color = color | (colors[2]);
  return color;
  }

}
