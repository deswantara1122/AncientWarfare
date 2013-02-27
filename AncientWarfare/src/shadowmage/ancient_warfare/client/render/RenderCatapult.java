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

import org.lwjgl.opengl.GL11;

import shadowmage.ancient_warfare.client.model.ModelCatapult;
import shadowmage.ancient_warfare.common.vehicles.VehicleBase;
import shadowmage.ancient_warfare.common.vehicles.VehicleCatapult;

public class RenderCatapult extends RenderVehicleBase
{

ModelCatapult model = new ModelCatapult();


@Override
public void renderVehicle(VehicleBase veh, double x, double y, double z, float yaw, float tick)
  {
  VehicleCatapult cat = (VehicleCatapult)veh;
  //Minecraft.getMinecraft().renderEngine.bindTexture(Minecraft.getMinecraft().renderEngine.getTexture("foo.png"));
  
  GL11.glPushMatrix();
  GL11.glTranslated(x, y, z);
  GL11.glRotatef(yaw, 0, 1, 0);
  
  
  GL11.glScalef(-1, -1, 1);  
    
  model.setArmRotation(cat.armAngle + (tick*cat.armSpeed));
  model.setCrankRotations(cat.crankAngle + (tick*cat.crankSpeed));
  float wheelAngle = cat.wheelAngle + (tick*cat.wheelSpeed);
  model.setWheelRotations(wheelAngle, wheelAngle, wheelAngle, wheelAngle);
  model.render(veh, 0, 0, 0, 0, 0, 0.0625f);
  GL11.glPopMatrix();
  }

}