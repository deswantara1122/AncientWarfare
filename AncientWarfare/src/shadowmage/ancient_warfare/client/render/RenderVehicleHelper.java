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
package shadowmage.ancient_warfare.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import shadowmage.ancient_warfare.client.registry.RenderRegistry;
import shadowmage.ancient_warfare.common.vehicles.VehicleBase;

public class RenderVehicleHelper extends Render
{

@Override
public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9)
  {
  VehicleBase vehicle = (VehicleBase) var1;
  Minecraft.getMinecraft().renderEngine.bindTexture(Minecraft.getMinecraft().renderEngine.getTexture(var1.getTexture()));
  RenderRegistry.instance().getRenderForVehicle(vehicle.vehicleType.getGlobalVehicleType()).renderVehicle(vehicle, var2, var4, var6, var8, var9);
  }

}
