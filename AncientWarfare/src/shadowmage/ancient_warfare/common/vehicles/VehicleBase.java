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
package shadowmage.ancient_warfare.common.vehicles;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import shadowmage.ancient_warfare.common.AWCore;
import shadowmage.ancient_warfare.common.config.Config;
import shadowmage.ancient_warfare.common.interfaces.IAmmoType;
import shadowmage.ancient_warfare.common.interfaces.IMissileHitCallback;
import shadowmage.ancient_warfare.common.inventory.VehicleInventory;
import shadowmage.ancient_warfare.common.registry.VehicleRegistry;
import shadowmage.ancient_warfare.common.registry.entry.VehicleUpgrade;
import shadowmage.ancient_warfare.common.utils.ByteTools;
import shadowmage.ancient_warfare.common.utils.EntityPathfinder;
import shadowmage.ancient_warfare.common.utils.Pos3f;
import shadowmage.ancient_warfare.common.utils.Trig;
import shadowmage.ancient_warfare.common.vehicles.helpers.VehicleAmmoHelper;
import shadowmage.ancient_warfare.common.vehicles.helpers.VehicleFiringHelper;
import shadowmage.ancient_warfare.common.vehicles.helpers.VehicleMovementHelper;
import shadowmage.ancient_warfare.common.vehicles.helpers.VehicleUpgradeHelper;
import shadowmage.ancient_warfare.common.vehicles.materials.IVehicleMaterial;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;

public abstract class VehicleBase extends Entity implements IEntityAdditionalSpawnData, IMissileHitCallback
{


/**
 * these are the current max stats.  set from setVehicleType().  these are local cached bases, after application of material factors
 */
public float baseForwardSpeed;
public float baseStrafeSpeed;
public float basePitchMin;
public float basePitchMax;
public float baseTurretRotationMax;
public float baseLaunchSpeedMax;
public float baseHealth = 100;
public float baseAccuracy = 1.f;
public float baseWeight = 1000;//kg
public int reloadTimeBase = 100;

/**
 * in meters/second
 */
public float launchPowerCurrent = 31.321f * 0.4f;

/**
 * local current stats, fully updated and modified from upgrades/etc
 */
public float maxForwardSpeedCurrent = 0.8f;
public float maxStrafeSpeedCurrent = 2.0f;
public int reloadTimeCurrent = 100;
public float accuracyCurrent = 1.f;
public float turretPitchMin = 0.f;
public float turretPitchMax = 90.f;
public float launchSpeedCurrentMax = 32.321f;

/**
 * local variables
 */
public float vehicleHealth = 100;
public float turretRotationHome;
public float turretRotationMax = 45.f;
public float turretRotation = 0.f;
public float turretDestRot = 0.f;
public float turretRotInc = 1.f;
public float turretPitch = 45.f;
public float turretDestPitch = 45.f;
public float turretPitchInc = 1.f;

/**
 * set by move helper on movement update. used during client rendering to update wheel rotation and other movement speed based animations
 */
public float wheelRotation = 0.f;
public float wheelRotationPrev = 0.f;
public float velocity = 0.f; //TODO set this in move helper onUpdate tick

/**
 * used to clear input if the vehicle WAS ridden but isn't any more
 */
private boolean isRidden = false;

/**
 * complex stat tracking helpers, move, ammo, upgrades, general stats
 */
public VehicleAmmoHelper ammoHelper;
public VehicleUpgradeHelper upgradeHelper;
public VehicleMovementHelper moveHelper;
public VehicleFiringHelper firingHelper;
public VehicleInventory inventory;
public EntityPathfinder navigator;

public IVehicleType vehicleType = VehicleRegistry.DUMMY_VEHICLE;//set to dummy vehicle so it is never null...
public int vehicleMaterialLevel = 0;//the current material level of this vehicle. should be read/set prior to calling updateBaseStats

public VehicleBase(World par1World)
  {
  super(par1World);
  this.navigator = new EntityPathfinder(this, worldObj, 16);  
  this.upgradeHelper = new VehicleUpgradeHelper(this);
  this.moveHelper = new VehicleMovementHelper(this);
  this.ammoHelper = new VehicleAmmoHelper(this);
  this.firingHelper = new VehicleFiringHelper(this);
  this.inventory = new VehicleInventory(this);
  this.stepHeight = 1.12f;
  }

public void setVehicleType(IVehicleType vehicle, int materialLevel)
  {
  this.vehicleType = vehicle;
  float width = vehicleType.getWidth();
  float height = vehicleType.getHeight();
  this.setSize(width, height);
  for(IAmmoType ammo : vehicleType.getValidAmmoTypes())
    {
    this.ammoHelper.addUseableAmmo(ammo);
    }
  for(VehicleUpgrade up : this.vehicleType.getValidUpgrades())
    {
    this.upgradeHelper.addValidUpgrade(up);
    }
  this.updateBaseStats();
  }

public void updateBaseStats()
  {
  IVehicleMaterial material = vehicleType.getMaterialType();
  int level = this.vehicleMaterialLevel;
  float baseForwardSpeed = vehicleType.getBaseForwardSpeed() * material.getSpeedForwardFactor(level);
  float baseStrafeSpeed = vehicleType.getBaseStrafeSpeed() * material.getSpeedStrafeFactor(level);
  float basePitchMin = vehicleType.getBasePitchMin();
  float basePitchMax = vehicleType.getBasePitchMax();
  float baseTurretRotationMax = vehicleType.getBaseTurretRotationAmount();
  float baseMissileVelocityMax = vehicleType.getBaseMissileVelocityMax();
  float baseHealth = vehicleType.getBaseHealth() * material.getHPFactor(level);
  float baseAccuracy = vehicleType.getBaseAccuracy() * material.getAccuracyFactor(level);
  float baseWeight = vehicleType.getBaseWeight() * material.getWeightFactor(level);  
  }

public float getHorizontalMissileOffset()
  {
  return this.vehicleType.getMissileHorizontalOffset();
  }

public float getVerticalMissileOffset()
  {
  return this.vehicleType.getMissileVerticalOffset();
  }

public float getForwardsMissileOffset()
  {
  return this.vehicleType.getMissileForwardsOffset();
  }

public boolean isAimable()
  {
  return vehicleType.isCombatEngine();
  }

public boolean canAimRotate()
  {
  return vehicleType.canAdjustYaw();
  }

public boolean canAimPitch()
  {
  return vehicleType.canAdjustPitch();
  }

public boolean canAimPower()
  {
  return vehicleType.canAdjustPower();
  }

public boolean isDrivable()
  {
  return vehicleType.isDrivable();
  }

public boolean isMountable()
  {
  return vehicleType.isMountable();
  }

public float getRiderForwardOffset()
  {
  return vehicleType.getRiderForwardsOffset();  
  }

public float getRiderVerticalOffset()
  {
  return vehicleType.getRiderVerticalOffest();
  }

public float getRiderHorizontalOffset()
  {
  return vehicleType.getRiderHorizontalOffset();
  }

public Pos3f getMissileOffset()
  {
  Pos3f off = new Pos3f();  
  float x = this.getHorizontalMissileOffset();
  float y = this.getVerticalMissileOffset();
  float z = this.getForwardsMissileOffset();
  float angle = Trig.toDegrees((float) Math.atan2(z, x));
  float len = MathHelper.sqrt_float(x*x+z*z);
  angle+= this.rotationYaw;  
  x = Trig.cosDegrees(angle)*len;
  z = -Trig.sinDegrees(angle)*len;
  off.x = x;
  off.y = y;
  off.z = z;  
  return off;
  }

/**
 * called on every tick that the vehicle is 'firing' to update the firing animation and to call
 * launchMissile when animation has reached launch point
 */
public abstract void onFiringUpdate();

/**
 * called every tick after the vehicle has fired, until reload timer is complete, to update animations
 */
public abstract void onReloadUpdate();

/**
 * reset all upgradeable stats back to the base for this vehicle
 */
public void resetUpgradeStats()
  {
  this.firingHelper.resetUpgradeStats();
  this.moveHelper.resetUpgradeStats();
  }

/**
 * need to setup on-death item drops
 */
@Override
public void setDead()
  {
  super.setDead();
  }

@Override
public void onUpdate()
  { 
  super.onUpdate();  
  if(this.worldObj.isRemote)
    {
    this.onUpdateClient();
    }
  else
    {    
    this.onUpdateServer();
    }
  this.moveHelper.onMovementTick();
  this.firingHelper.onTick(); 
  if(turretPitch!=turretDestPitch)
    {
    this.updateTurretPitch();
    }
  if(turretRotation!=turretDestRot)
    {
    this.updateTurretRotation();
    }
  }

/**
 * client-side updates
 */
public void onUpdateClient()
  {  
  
  }

/**
 * server-side updates...
 */
public void onUpdateServer()
  {
  if(this.isRidden && this.riddenByEntity==null)
    {
    this.isRidden = false;
    this.moveHelper.clearInputFromDismount();
    }
  this.isRidden = this.riddenByEntity != null;
  }

public void updateTurretPitch()
  {
  if(!canAimPitch())
    {
    turretDestPitch = turretPitch;
    return;
    }
  if(turretPitch>turretDestPitch)
    {
    turretPitch-=turretPitchInc;
    }
  else if(turretPitch<turretDestPitch)
    {
    turretPitch+=turretPitchInc;
    }
  if(Trig.getAbsDiff(turretDestPitch, turretPitch)<turretPitchInc)
    {
    turretPitch = turretDestPitch;
    }
  }

public void updateTurretRotation()
  {
  if(!canAimRotate())
    {
    turretDestRot = turretRotation;
    return;
    }
  //TODO
  }

/**
 * Called from Packet02Vehicle
 * Generic update method for client-server coms
 * @param tag
 */
public void handlePacketUpdate(NBTTagCompound tag)
  {
  if(tag.hasKey("input"))
    {
    this.handleInputData(tag.getCompoundTag("input"));
    }
  if(tag.hasKey("health"))
    {    
    this.handleHealthUpdateData(tag);
    }
  if(tag.hasKey("upgrade"))
    {
    this.upgradeHelper.handleUpgradePacketData(tag.getCompoundTag("upgrade"));
    }
  if(tag.hasKey("ammo"))
    {
    this.ammoHelper.handleAmmoUpdatePacket(tag.getCompoundTag("ammo"));
    }
  if(tag.hasKey("ammoSel"))
    {
    this.ammoHelper.handleAmmoSelectPacket(tag.getCompoundTag("ammoSel"));
    }
  }

public void handleHealthUpdateData(NBTTagCompound tag)
  {
  this.vehicleHealth = tag.getFloat("health");
  }

public void handleInputData(NBTTagCompound tag)
  {
  Config.logDebug("receiving input packet data. server: "+!worldObj.isRemote);
  this.moveHelper.handleInputData(tag);
  this.firingHelper.handleInputData(tag);
  }

/**
 * handle movement input, sent from inputHelper when vehicle is ridden
 * @param forward
 * @param strafe
 */
public void handleKeyboardMovement(byte forward, byte strafe)
  {
  this.moveHelper.handleKeyboardInput(forward, strafe);  
  }

@Override
public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
  {
  super.attackEntityFrom(par1DamageSource, par2);
  this.vehicleHealth-=par2;
  if(this.vehicleHealth<=0)
    {
    this.setDead();
    return true;
    }
  return false;
  }

@Override
public String getTexture()
  {
  return vehicleType.getTextureForMaterialLevel(vehicleMaterialLevel);
  }

@Override
public void updateRiderPosition()
  {
  if (!(this.riddenByEntity instanceof EntityPlayer) || !((EntityPlayer)this.riddenByEntity).func_71066_bF())
    {
    this.riddenByEntity.lastTickPosX = this.lastTickPosX;
    this.riddenByEntity.lastTickPosY = this.lastTickPosY + this.getRiderVerticalOffset() + this.riddenByEntity.getYOffset();
    this.riddenByEntity.lastTickPosZ = this.lastTickPosZ;
    }
  double posX = this.posX;
  double posY = this.posY + this.getRiderVerticalOffset();
  double posZ = this.posZ;
  posX += Trig.sinDegrees(rotationYaw)*-this.getRiderForwardOffset();
  posX += Trig.cosDegrees(rotationYaw)*this.getRiderHorizontalOffset();
  posZ += Trig.cosDegrees(rotationYaw)*-this.getRiderForwardOffset();
  posZ += Trig.sinDegrees(rotationYaw)*this.getRiderHorizontalOffset();
  this.riddenByEntity.setPosition(posX, posY  + this.riddenByEntity.getYOffset(), posZ);
  }

@Override
public boolean interact(EntityPlayer player)
  {  
  if(this.isMountable() && !player.worldObj.isRemote && !player.isSneaking() && (this.riddenByEntity==null || this.riddenByEntity==player))
    {
    player.mountEntity(this);
    return true;
    }
  return true;
  }

@Override
public void setPositionAndRotation2(double par1, double par3, double par5, float yaw, float par8, int par9)
  {      
  if(this.riddenByEntity!=null && this.riddenByEntity == AWCore.proxy.getClientPlayer())
    {
    double var10 = par1 - this.posX;
    double var12 = par3 - this.posY;
    double var14 = par5 - this.posZ;
    double var16 = var10 * var10 + var12 * var12 + var14 * var14;    
    if (var16 <= 1.0D)
      {
      float rot = this.rotationYaw;
      float rot2 = yaw;      
      if(Trig.getAbsDiff(rot, rot2)>2)
        { 
        //float diff = this.rotationYaw - this.prevRotationYaw;//pull diff of current rot and prev rot.  change rot. change prev rot to rot. apply diff to prev rot DONE
        this.setRotation(yaw, par8);
        this.prevRotationYaw = this.rotationYaw;//TODO hack to fix rendering...need to rebound prevRotataion..
//        this.prevRotationYaw = this.rotationYaw + diff;        
        }      
      return;
      }
    Config.logDebug("crazy synch error!!");
    } 
  super.setPositionAndRotation(par1, par3, par5, yaw, par8);
  }

@Override
public AxisAlignedBB getBoundingBox()
  {
  return this.boundingBox;
  }

@Override
public AxisAlignedBB getCollisionBox(Entity par1Entity)
  {
  return par1Entity.boundingBox;
  }

@Override
public boolean canBeCollidedWith()
  {
  return true;
  }

@Override
protected void entityInit()
  {
  }

@Override
public void writeSpawnData(ByteArrayDataOutput data)
  {
  data.writeFloat(this.vehicleHealth);  
  ByteTools.writeNBTTagCompound(upgradeHelper.getNBTTag(), data);
  ByteTools.writeNBTTagCompound(ammoHelper.getNBTTag(), data);
  ByteTools.writeNBTTagCompound(moveHelper.getNBTTag(), data);
  ByteTools.writeNBTTagCompound(firingHelper.getNBTTag(), data);  
  }

@Override
public void readSpawnData(ByteArrayDataInput data)
  {
  this.vehicleHealth = data.readFloat();
  this.upgradeHelper.readFromNBT(ByteTools.readNBTTagCompound(data));
  this.ammoHelper.readFromNBT(ByteTools.readNBTTagCompound(data));
  this.moveHelper.readFromNBT(ByteTools.readNBTTagCompound(data));
  this.firingHelper.readFromNBT(ByteTools.readNBTTagCompound(data));
  //TODO write/read extra stats--turret pitch/rotation/destinations
  }

@Override
protected void readEntityFromNBT(NBTTagCompound tag)
  {
  IVehicleType vehType = VehicleRegistry.instance().getVehicleType(tag.getInteger("vehType"));
  int level = tag.getInteger("matLvl");
  this.setVehicleType(vehType, level);
  this.vehicleHealth = tag.getFloat("health");
  this.turretRotationHome = tag.getFloat("turHome");
  this.inventory.readFromNBT(tag);
  this.upgradeHelper.readFromNBT(tag.getCompoundTag("upgrades"));
  this.ammoHelper.readFromNBT(tag.getCompoundTag("ammo"));
  this.moveHelper.readFromNBT(tag.getCompoundTag("move"));
  this.firingHelper.readFromNBT(tag.getCompoundTag("fire"));
  this.launchPowerCurrent = tag.getFloat("lc");
  this.turretPitch = tag.getFloat("tp");
  this.turretDestPitch = tag.getFloat("tpd");
  this.turretRotation = tag.getFloat("tr");
  this.turretDestRot = tag.getFloat("trd");
  }

@Override
protected void writeEntityToNBT(NBTTagCompound tag)
  {
  tag.setInteger("vehType", this.vehicleType.getGlobalVehicleType());
  tag.setInteger("matLvl", this.vehicleMaterialLevel);
  tag.setFloat("health", this.vehicleHealth);
  tag.setFloat("turHome", this.turretRotationHome);
  this.inventory.writeToNBT(tag);
  tag.setCompoundTag("upgrades", this.upgradeHelper.getNBTTag());
  tag.setCompoundTag("ammo", this.ammoHelper.getNBTTag());
  tag.setCompoundTag("move", this.moveHelper.getNBTTag());
  tag.setCompoundTag("fire", this.firingHelper.getNBTTag());  
  tag.setFloat("lc", launchPowerCurrent);
  tag.setFloat("tp", turretPitch);
  tag.setFloat("tpd", turretDestPitch);
  tag.setFloat("tr", turretRotation);
  tag.setFloat("trd", turretDestRot);
  }

@Override
public void onMissileImpact(World world, double x, double y, double z)
  {
  if(this.ridingEntity instanceof IMissileHitCallback)
    {
    ((IMissileHitCallback)this.ridingEntity).onMissileImpact(world, x, y, z);
    }
  }

@Override
public void onMissileImpactEntity(World world, Entity entity)
  {
  if(this.ridingEntity instanceof IMissileHitCallback)
    {
    ((IMissileHitCallback)this.ridingEntity).onMissileImpactEntity(world, entity);
    }
  }

}
