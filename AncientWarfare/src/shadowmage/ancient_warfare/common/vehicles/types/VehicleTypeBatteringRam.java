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
package shadowmage.ancient_warfare.common.vehicles.types;

import shadowmage.ancient_warfare.common.config.Config;
import shadowmage.ancient_warfare.common.registry.ArmorRegistry;
import shadowmage.ancient_warfare.common.vehicles.VehicleBase;
import shadowmage.ancient_warfare.common.vehicles.VehicleVarHelpers.BatteringRamVarHelper;
import shadowmage.ancient_warfare.common.vehicles.helpers.VehicleFiringVarsHelper;
import shadowmage.ancient_warfare.common.vehicles.materials.VehicleMaterial;

public class VehicleTypeBatteringRam extends VehicleType
{

/**
 * @param typeNum
 */
public VehicleTypeBatteringRam(int typeNum)
  {
  super(typeNum);
  this.vehicleMaterial = VehicleMaterial.materialWood;
  this.validArmors.add(ArmorRegistry.armorStone);
  this.validArmors.add(ArmorRegistry.armorIron);
  this.validArmors.add(ArmorRegistry.armorObsidian);
  
  this.width = 2.7f;
  this.height = 2.1f; 
  this.isMountable = true;  
  this.isDrivable = true;
  this.isCombatEngine = true;
  this.canAdjustPower = false;
  this.canAdjustPitch = false;
  this.canAdjustYaw = false;  
  this.shouldRiderSit = true;
  this.moveRiderWithTurret = false;
  this.accuracy = 0.99f;
  this.baseStrafeSpeed = 1.f;
  this.baseForwardSpeed = 4.5f*0.05f;  
  this.basePitchMax = 0.f;
  this.basePitchMin = 0.f;
  this.turretRotationMax = 0.f;
  this.turretForwardsOffset = 2.6f;
  this.turretVerticalOffset = 1.8f;
  this.turretHorizontalOffset = -.3f;
  
  this.riderForwardsOffset = 0.f;
  this.riderVerticalOffset = 0.65f;
  this.riderHorizontalOffset = 0.325f;
  this.displayName = "Battering Ram";
  this.displayTooltip = "Get up close and personal!";
  this.storageBaySize = 0;
  this.armorBaySize = 6;
  this.upgradeBaySize = 3;
  }

@Override
public VehicleFiringVarsHelper getFiringVarsHelper(VehicleBase veh)
  {
  return new BatteringRamVarHelper(veh);
  }

@Override
public String getTextureForMaterialLevel(int level)
  {
  switch(level)
    {
    case 0:
    return Config.texturePath + "models/batteringRam1.png";
    case 1:
    return Config.texturePath + "models/batteringRam2.png";
    case 2:
    return Config.texturePath + "models/batteringRam3.png";
    case 3:
    return Config.texturePath + "models/batteringRam4.png";
    case 4:
    return Config.texturePath + "models/batteringRam5.png";
    default:
    return Config.texturePath + "models/batteringRam1.png";
    }
  }

}
