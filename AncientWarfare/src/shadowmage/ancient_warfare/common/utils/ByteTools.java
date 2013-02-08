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
package shadowmage.ancient_warfare.common.utils;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ByteTools
{

public static List<byte[]> getByteChunks(byte[] allBytes, int packetSize)
  {
  int numOfChunks = (allBytes.length/packetSize)+1;  
  List<byte[]> byteChunks = new ArrayList<byte[]>(numOfChunks);  
  for(int i = 0; i < numOfChunks; i++)
    {
    byte[] chunk = new byte[packetSize];
    for(int k = 0; k < packetSize ; k++)
      {
      if(k + i*packetSize < allBytes.length)
        {
        chunk[k] = allBytes[k+i*packetSize];
        }
      }
    byteChunks.add(chunk);
    }
  return byteChunks;
  }

public static byte[] compositeByteChunks(List<byte[]> chunks, int packetSize)
  {
  byte[] fullFile = new byte[chunks.size()*packetSize];    
  for(int i = 0; i < chunks.size(); i++)
    {
    for(int k = 0; k < packetSize; k++)
      {
      fullFile[ i * packetSize + k] = chunks.get(i)[k];
      }
    }
  return fullFile;
  }

}