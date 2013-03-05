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
package shadowmage.ancient_warfare.common.vehicles.materials;

public class VehicleMaterial implements IVehicleMaterial
{

public MaterialLevel[] materialLevels;

public VehicleMaterial(int levelCount)
  {
  this.materialLevels = new MaterialLevel[levelCount];
  }

private MaterialLevel getLevel(int num)
  {
  if(num<0 || num>=this.materialLevels.length)
    {
    return new MaterialLevel();
    }
  return this.materialLevels[num];
  }

@Override
public int getNumOfLevels()
  {
  return this.materialLevels.length;
  }

@Override
public float getHPFactor(int level)
  {
  return getLevel(level).hpFactor;
  }

@Override
public float getSpeedForwardFactor(int level)
  {
  return getLevel(level).speedForwardFactor;
  }

@Override
public float getSpeedStrafeFactor(int level)
  {
  return getLevel(level).speedStrafeFactor;
  }

@Override
public float getWeightFactor(int level)
  {
  return getLevel(level).weightFactor;
  }

@Override
public float getAccuracyFactor(int level)
  {
  return getLevel(level).accuracyFactor;
  }

@Override
public float getMisfireChance(int level)
  {
  return getLevel(level).misfireChance;
  }

}
