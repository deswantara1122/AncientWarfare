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
package shadowmage.ancient_warfare.common.registry;

import shadowmage.ancient_warfare.common.item.ItemLoader;
import shadowmage.ancient_warfare.common.vehicles.IVehicleType;
import shadowmage.ancient_warfare.common.vehicles.types.VehicleType;
import shadowmage.ancient_warfare.common.vehicles.types.VehicleTypeBallistaMobile;
import shadowmage.ancient_warfare.common.vehicles.types.VehicleTypeBallistaMobileTurret;
import shadowmage.ancient_warfare.common.vehicles.types.VehicleTypeBallistaStand;
import shadowmage.ancient_warfare.common.vehicles.types.VehicleTypeBallistaStandTurret;
import shadowmage.ancient_warfare.common.vehicles.types.VehicleTypeBatteringRam;
import shadowmage.ancient_warfare.common.vehicles.types.VehicleTypeCannonMobileFixed;
import shadowmage.ancient_warfare.common.vehicles.types.VehicleTypeCannonStandFixed;
import shadowmage.ancient_warfare.common.vehicles.types.VehicleTypeCannonStandTurret;
import shadowmage.ancient_warfare.common.vehicles.types.VehicleTypeCatapultMobileFixed;
import shadowmage.ancient_warfare.common.vehicles.types.VehicleTypeCatapultMobileTurret;
import shadowmage.ancient_warfare.common.vehicles.types.VehicleTypeCatapultStandFixed;
import shadowmage.ancient_warfare.common.vehicles.types.VehicleTypeHwacha;
import shadowmage.ancient_warfare.common.vehicles.types.VehicletypeCatapultStandTurret;

public class VehicleRegistry
{

public static final IVehicleType CATAPULT_STAND_FIXED = new VehicleTypeCatapultStandFixed(0);
public static final IVehicleType CATAPULT_STAND_TURRET = new VehicletypeCatapultStandTurret(1);
public static final IVehicleType CATAPULT_MOBILE_FIXED = new VehicleTypeCatapultMobileFixed(2);
public static final IVehicleType CATAPULT_MOBILE_TURRET = new VehicleTypeCatapultMobileTurret(3);

public static final IVehicleType BALLISTA_STAND_FIXED = new VehicleTypeBallistaStand(4);
public static final IVehicleType BALLISTA_STAND_TURRET = new VehicleTypeBallistaStandTurret(5);
public static final IVehicleType BALLISTA_MOBILE_FIXED = new VehicleTypeBallistaMobile(6);
public static final IVehicleType BALLISTA_MOBILE_TURRET = new VehicleTypeBallistaMobileTurret(7);

public static final IVehicleType BATTERING_RAM = new VehicleTypeBatteringRam(8);

public static final IVehicleType CANNON_STAND_FIXED = new VehicleTypeCannonStandFixed(9);
public static final IVehicleType CANNON_STAND_TURRET = new VehicleTypeCannonStandTurret(10);
public static final IVehicleType CANNON_MOBILE_FIXED = new VehicleTypeCannonMobileFixed(11);

public static final IVehicleType HWACHA = new VehicleTypeHwacha(12);

private VehicleRegistry(){}
private static VehicleRegistry INSTANCE;

public static VehicleRegistry instance()
  {
  if(INSTANCE==null){INSTANCE = new VehicleRegistry();}
  return INSTANCE;
  }

public void registerVehicles()
  {
  for(IVehicleType vehicle : VehicleType.vehicleTypes)
    {
    if(vehicle!=null)
      {
      ItemLoader.instance().addSubtypeToItem(ItemLoader.vehicleSpawner, vehicle.getGlobalVehicleType(), vehicle.getDisplayName(), vehicle.getDisplayTooltip());
      }
    }  
  }


}
