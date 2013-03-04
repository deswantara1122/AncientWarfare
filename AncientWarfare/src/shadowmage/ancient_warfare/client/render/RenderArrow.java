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

import net.minecraft.entity.Entity;
import shadowmage.ancient_warfare.client.model.ModelArrow;
import shadowmage.ancient_warfare.common.config.Config;

public class RenderArrow extends RenderMissileBase
{

public ModelArrow arrow = new ModelArrow();

@Override
public void doRender(Entity var1, double var2, double var4, double var6,  float var8, float var9)
  {
  GL11.glPushMatrix();
  GL11.glTranslated(var2, var4, var6);
  GL11.glRotatef(var8 - 90, 0, 1, 0);
  GL11.glRotatef(var1.rotationPitch - 90, 1, 0, 0);
  GL11.glScaled(-1, -1, 1);  
  arrow.render(var1, 0, 0, 0, 0, 0, 0.0625f);
  GL11.glPopMatrix();
  }

}