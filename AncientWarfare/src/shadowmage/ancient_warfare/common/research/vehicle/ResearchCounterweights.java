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
package shadowmage.ancient_warfare.common.research.vehicle;

import net.minecraft.client.Minecraft;
import shadowmage.ancient_warfare.common.research.ResearchGoal;

public class ResearchCounterweights extends ResearchGoal
{

/**
 * @param num
 */
public ResearchCounterweights(int num, int rank)
  {
  super(num);
  this.displayName = "Counterweights "+(rank+1);  
  this.detailedDescription.add("Researching counterweights advances knowledge");
  this.detailedDescription.add("regarding the application of weight and leverage");
  this.detailedDescription.add("to increase range, damage, and effiency of weight");
  this.detailedDescription.add("based siege weapons.");
  }

}
