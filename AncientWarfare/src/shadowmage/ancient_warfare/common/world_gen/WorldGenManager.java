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
package shadowmage.ancient_warfare.common.world_gen;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import shadowmage.ancient_warfare.common.config.Config;
import shadowmage.ancient_warfare.common.interfaces.INBTTaggable;
import shadowmage.ancient_warfare.common.manager.StructureManager;
import shadowmage.ancient_warfare.common.structures.build.BuilderInstant;
import shadowmage.ancient_warfare.common.structures.data.ProcessedStructure;
import shadowmage.ancient_warfare.common.structures.data.StructureBB;
import shadowmage.ancient_warfare.common.utils.BlockPosition;
import shadowmage.ancient_warfare.common.utils.Pair;
import shadowmage.ancient_warfare.common.utils.Trig;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenManager implements IWorldGenerator, INBTTaggable
{

private static Map<Integer, WorldGenStructureMap> dimensionStructures = new HashMap<Integer, WorldGenStructureMap>();

private WorldGenManager(){};
private static WorldGenManager INSTANCE;
public static WorldGenManager instance()  
  {
  if(INSTANCE==null)
    {
    INSTANCE = new WorldGenManager();
    }
  return INSTANCE;
  }

public WorldGenStructureMap getDimensionMapFor(int dim)
  {
  if(!dimensionStructures.containsKey(dim))
    {
    this.dimensionStructures.put(dim, new WorldGenStructureMap());
    }
  return this.dimensionStructures.get(dim);
  }

public void setGeneratedAt(int dim, int worldX, int worldY, int worldZ, int face, int value, String name, boolean unique)
  {
  if(!dimensionStructures.containsKey(dim))
    {
    this.dimensionStructures.put(dim, new WorldGenStructureMap());
    }
  this.dimensionStructures.get(dim).setGeneratedAt(worldX, worldY, worldZ,face , value, name, unique);
  }

public void loadConfig(String pathName)
  {
  WorldGenStructureManager.instance().loadConfig(pathName);
  }

public static void resetMap()
  {
  dimensionStructures = new HashMap<Integer, WorldGenStructureMap>();
  }

public boolean attemptPlacementSubsurface(World world, int x, int y, int z, int face, ProcessedStructure struct, Random random)
  {  
  if(y==-1)
    {
//    Config.logDebug("underground structure--invalid topBlock");
    return false;
    }
  int size = struct.ySize - (struct.ySize-struct.verticalOffset);
  if(y-size <=1)
    {
    Config.logDebug("site rejected by structure, too low");
    return false;
    }
  BlockPosition hit = new BlockPosition(x,y,z);    
  hit.y++;
  if(!struct.canGenerateAtSubSurface(world, hit, face, struct))
    {
//    Config.logDebug("underground structure rejected build site");
    return false;
    }  
  if(this.checkBBCollisions(world, struct, hit, face, x/16, z/16))
    {
    return false;
    }
  Config.log("Ancient Warfare generating structure at: "+x+","+y+","+z +" :: "+struct.name);
  BuilderInstant builder = new BuilderInstant(world, struct, face, hit);
  builder.setWorldGen();
  builder.startConstruction(); 
  return true;
  }

public boolean attemptPlacementSurface(World world, int x, int y, int z, int face, ProcessedStructure struct, Random random)
  {  
  if(y==-1)
    {
    Config.logDebug("invalid topBlock");
    return false;
    }
  int size = struct.ySize - (struct.ySize-struct.verticalOffset);
  if(y-size <=1)
    {
    Config.logDebug("site rejected by structure, too low");
    return false;
    }
  BlockPosition hit = new BlockPosition(x,y,z);
  hit.y++;
  if(!struct.canGenerateAtSurface(world, hit.copy(), face, struct))
    {
    Config.logDebug("site rejected by structure: "+struct.name);
    return false;
    }  
  
  if(this.checkBBCollisions(world, struct, hit, face, x/16, z/16))
    {
    Config.logDebug("site rejected due to structure overlap");
    return false;
    }
  Config.log("Ancient Warfare generating structure at: "+x+","+y+","+z +" :: "+struct.name);
  BuilderInstant builder = new BuilderInstant(world, struct, face, hit);
  builder.setWorldGen();
  builder.startConstruction();  
  return true;
  }

@Override
public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
  {  
  if(world.isRemote){return;}
  int dim =world.getWorldInfo().getDimension();
  if(!WorldGenStructureManager.instance().isValidDimension(dim))
    {
    Config.logDebug("invalid dimension for generation");
    return;
    }
  
  if(random.nextInt(WorldGenStructureManager.structureGenRandomRange)>WorldGenStructureManager.structureGenRandomChance)
    {
//    Config.logDebug("Exit for early random chance check");
    return;
    }
  
  int maxRange = WorldGenStructureManager.structureGenMaxCheckRange;

  float dist = 0;//found distance
  int foundValue = 0;//found value
  if(! WorldGenManager.instance().dimensionStructures.containsKey(dim))
    {
    WorldGenStructureMap map = new WorldGenStructureMap();
    WorldGenManager.instance().dimensionStructures.put(dim, map);
    }
  Pair<Float, Integer> values =  WorldGenManager.instance().dimensionStructures.get(dim).getClosestStructureDistance(chunkX, chunkZ, maxRange);
  foundValue = values.value();
  if(values.key()==-1)
    {
    dist = maxRange;
    }
  else
    {
    dist = values.key();
    } 

  /**
   * select structure from those available to the current available value....
   */
  int x = chunkX*16 + random.nextInt(16);
  int z = chunkZ*16 + random.nextInt(16); 
  ChunkCoordinates spawnPos = world.getSpawnPoint();
  float spawnDist = Trig.getDistance(x, spawnPos.posY, z, spawnPos.posX, spawnPos.posY, spawnPos.posZ);
  if(spawnDist< 12 *16 )
    {    
    Config.logDebug("structure gen exit for too close to spawnPos");
    return;
    }
  String biomeName = world.provider.getBiomeGenForCoords(x, z).biomeName;
  int maxValue = WorldGenStructureManager.structureGenMaxClusterValue - foundValue;
  maxValue = maxValue < 0 ? 0 : maxValue;
  ProcessedStructure struct = WorldGenStructureManager.instance().getStructureForBiome(biomeName, maxValue, random);
  if(struct!=null)
    {
    /**
     * then check cluster filled percentage
     */
    float valPercent = (float)foundValue / (float) WorldGenStructureManager.structureGenMaxClusterValue;
    if(random.nextFloat() < valPercent)
      {
      Config.logDebug("Exit for value ratio check");
      return;
      }        
    /**
     * else, place the struct....
     */
    boolean placed = false;
    
    int y = 0;
    int face = random.nextInt(4);    
    if(struct.underground)
      {
      y = getSubsurfaceTarget(world, x, z, struct.undergroundMinLevel, struct.undergroundMaxLevel, struct.minSubmergedDepth, random);      
      placed = this.attemptPlacementSubsurface(world, x, y, z, face, struct, random);
      }
    else
      {
      y = getTopBlockHeight(world, x, z, struct.maxWaterDepth, struct.maxLavaDepth, struct.validTargetBlocks);
      placed = this.attemptPlacementSurface(world, x, y, z, face, struct, random);
      }    
    if(placed)
      {   
      Config.logDebug("generated : "+struct.name);
      WorldGenStructureEntry ent = struct.getWorldGenEntry();
      if(ent!=null)
        {
        WorldGenManager.instance().setGeneratedAt(dim, x, y, z, face, ent.value, ent.name, ent.unique);
        }      
      }
    else
      {
      Config.logDebug("placement fail");
      }
    }
  else
    {
    Config.logDebug("exit for null structure");
    }
  }

public int getSubsurfaceTarget(World world, int x, int z, int minLevel, int maxLevel, int minSubmerged, Random random)
  {
  int y = getRawTopBlockHeight(world, x, z);
  int genLevel = minLevel;
  if(y>maxLevel)
    {
    int diff = y - maxLevel;
    if(diff<minSubmerged)
      {
      genLevel = maxLevel - (minSubmerged-diff);
      }
    else
      {
      genLevel = maxLevel;
      }    
    }
  else
    {
    genLevel = y - minSubmerged;    
    }
  if(genLevel<minLevel)
    {
    return -1;
    }
  int range = genLevel - minLevel;
  int level = random.nextInt(range) + minLevel;
  return level;
  }

private int getRawTopBlockHeight(World world, int x, int z)
  {
  int top = world.provider.getActualHeight();
  return getRawTopBlockBetween(world, x, z, 1, top);
  }

private int getRawTopBlockBetween(World world, int x, int z, int min, int max)
  {
  int top = world.provider.getActualHeight();
  top = top > max? max : top;
  for(int i = top; i >= min; i--)
    {
    int id = world.getBlockId(x, i, z);
    if(id!=0 && Block.isNormalCube(id) && id != Block.wood.blockID)      
      {
      return i;
      }
    }
  return -1;
  }

/**
 * return the topMost solid block, -1 if no valid block is found
 * @param world
 * @param x
 * @param z
 * @return
 */
public int getTopBlockHeight(World world, int x, int z, int maxWater, int maxLava, int[] allowedTargetBlocks)
  {
  int y = getRawTopBlockHeight(world, x, z);
  int id = world.getBlockId(x, y, z);
  if(allowedTargetBlocks !=null)
    {        
    boolean valid = false;
    for(int allowedID : allowedTargetBlocks)
      {
      if(id==allowedID)
        {
        valid = true;
        break;
        }
      }
    if(valid)
      {
      int topID = world.getBlockId(x, y+1, z);
      if(topID == Block.waterMoving.blockID || topID == Block.waterStill.blockID)
        {
        if(maxWater>0)
          {
          int run = 1;
          int foundWater = 1;
          while(world.getBlockId(x, y+1+run, z)!=0 && y+1+run<world.provider.getActualHeight() && foundWater <= maxWater);
            {
            foundWater++;
            run++;
            if(foundWater>maxWater)
              {
              return -1;
              }
            }
          return y;
          }
        return -1;       
        }
      else if(topID == Block.lavaMoving.blockID || topID== Block.lavaStill.blockID)
        {
        if(maxLava>0)
          {
          int run = 1;
          int foundWater = 1;
          while(world.getBlockId(x, y+1+run, z)!=0 && y+1+run<world.provider.getActualHeight() && foundWater <= maxLava);
            {
            foundWater++;
            run++;
            if(foundWater>maxLava)
              {
              return -1;
              }
            }
          return y;
          }
        return -1;
        }
      else if(!Block.isNormalCube(topID))//else it is some other non-solid block, like snow, grass, leaves
        {
        return y;
        }
      }
    }
  return -1;
  }

@Override
public NBTTagCompound getNBTTag()
  {
  NBTTagCompound tag = new NBTTagCompound();
  NBTTagList tagList = new NBTTagList();
  for(Integer i : dimensionStructures.keySet())
    {
    WorldGenStructureMap map = dimensionStructures.get(i);
    NBTTagCompound mapTag = map.getNBTTag();
    mapTag.setInteger("dim", i);
    tagList.appendTag(mapTag);
    }  
  tag.setTag("dimList", tagList);
  return tag;
  }

@Override
public void readFromNBT(NBTTagCompound tag)
  {
  NBTTagList tagList = tag.getTagList("dimList");
  for(int i = 0; i < tagList.tagCount(); i++)
    {
    NBTTagCompound entTag = (NBTTagCompound) tagList.tagAt(i);    
    int dim = entTag.getInteger("dim");
    WorldGenStructureMap map = new WorldGenStructureMap();
    map.readFromNBT(entTag);
    dimensionStructures.put(dim, map);
    }
  }

public void addStructureMapForDimension(int dim, WorldGenStructureMap map)
  {
  this.dimensionStructures.put(dim, map);
  }

/**
 * checks around the chosen site for a chosen structure, to see if there are any structures in nearby chunks
 * if so, it chcks to see if structBB has overlap with the previously generated struct BB
 * @return
 */
private boolean checkBBCollisions(World world, ProcessedStructure struct, BlockPosition hit, int face, int chunkX, int chunkZ)
  {
  int dim = world.getWorldInfo().getDimension();
  if(!dimensionStructures.containsKey(dim))
    {
    return false;
    }
  WorldGenStructureMap mp = dimensionStructures.get(dim);
  StructureBB bb = null;
  StructureBB checkBB = null;
  ProcessedStructure check;
  for(int cX = chunkX-1; cX <= chunkX+1; cX++)
    {
    for(int cZ = chunkZ-1; cZ <= chunkZ+1; cZ++)
      {
      GeneratedStructureEntry gen = mp.getEntryFor(cX, cZ);
      if(gen!=null)
        {
        if(bb==null)
          {
          bb=struct.getStructureBB(hit, face);  
          int expA = struct.getClearingBuffer();
          int expB = struct.getLevelingBuffer();
          int expAmt = expA > expB ? expA : expB;
          bb.expand(expAmt, expAmt, expAmt);
          }
        check = StructureManager.instance().getStructureServer(gen.name);
        checkBB = check.getStructureBB(new BlockPosition(cX*16+gen.xOff, gen.yPos, cZ*16+gen.zOff), gen.face);
        int expA = check.getClearingBuffer();
        int expB = check.getLevelingBuffer();
        int expAmt = expA > expB ? expA : expB;
        checkBB.expand(expAmt, expAmt, expAmt);
        if(bb.collidesWith(checkBB))
          {
          return true;
          }
        }
      }
    }
  return false;
  }
  

}
