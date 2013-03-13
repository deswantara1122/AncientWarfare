//auto-generated model template
//template generated by MEIM
//template v 1.0
//author Shadowmage45 (shadowage_catapults@hotmail.com)
 
package shadowmage.ancient_warfare.client.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import shadowmage.ancient_warfare.common.utils.Trig;
 
 
public class ModelBallista extends ModelVehicleBase
{
 
ModelRendererCustom frontCrossBeam;
ModelRendererCustom rightBeam;
ModelRendererCustom pivotCrossBeam;
ModelRendererCustom rearCrossBeam;
ModelRendererCustom rearAxle;
ModelRendererCustom RRWheelPivot;
ModelRendererCustom RRS4;
ModelRendererCustom RRS2;
ModelRendererCustom RRS3;
ModelRendererCustom RRw1;
ModelRendererCustom RRw2;
ModelRendererCustom RRw3;
ModelRendererCustom RRw8;
ModelRendererCustom RRw7;
ModelRendererCustom RRw6;
ModelRendererCustom RRw4;
ModelRendererCustom RRw5;
ModelRendererCustom RLWheelPivot;
ModelRendererCustom RLS2;
ModelRendererCustom RLS3;
ModelRendererCustom RLS4;
ModelRendererCustom RLw1;
ModelRendererCustom RLw2;
ModelRendererCustom RLw3;
ModelRendererCustom RLw8;
ModelRendererCustom RLw7;
ModelRendererCustom RLw6;
ModelRendererCustom RLw5;
ModelRendererCustom RLw4;
ModelRendererCustom leftBeam;
ModelRendererCustom frontAxle;
ModelRendererCustom FRWheelPivot;
ModelRendererCustom FRS2;
ModelRendererCustom FRS3;
ModelRendererCustom FRS4;
ModelRendererCustom frw1;
ModelRendererCustom Frw4;
ModelRendererCustom FLr5;
ModelRendererCustom Frw6;
ModelRendererCustom Frw7;
ModelRendererCustom Frw8;
ModelRendererCustom Frw3;
ModelRendererCustom Frw2;
ModelRendererCustom FLWheelPivot;
ModelRendererCustom FLw3;
ModelRendererCustom FLw2;
ModelRendererCustom FS4;
ModelRendererCustom FLS2;
ModelRendererCustom FS3;
ModelRendererCustom flw1;
ModelRendererCustom FLw4;
ModelRendererCustom FLw5;
ModelRendererCustom FLw6;
ModelRendererCustom FLw7;
ModelRendererCustom FLw8;
ModelRendererCustom chairBrace;
ModelRendererCustom chairBottom;
ModelRendererCustom chairBack;
ModelRendererCustom flagPole;
ModelRendererCustom flagCloth;
ModelRendererCustom pivot;
ModelRendererCustom armMain;
ModelRendererCustom armFront;
ModelRendererCustom turretHorizontalBrace2;
ModelRendererCustom turretHorizontalBrace3;
ModelRendererCustom armMidBrace;
ModelRendererCustom armSlotLeft;
ModelRendererCustom armSlotRight;
ModelRendererCustom armleftVertical3;
ModelRendererCustom armLeftVertical2;
ModelRendererCustom armLeftVertical1;
ModelRendererCustom turretHorizontalBrace4;
ModelRendererCustom leftTensionerRope;
ModelRendererCustom leftTensioner;
ModelRendererCustom leftTensioner2;
ModelRendererCustom rightTensionerRope;
ModelRendererCustom rightTensioner;
ModelRendererCustom rightTensioner2;
ModelRendererCustom turretHorizontalBrace1;
ModelRendererCustom armRightVertical3;
ModelRendererCustom armRightVertical2;
ModelRendererCustom armRightVertical1;
ModelRendererCustom trigger1;
ModelRendererCustom trigger2;
ModelRendererCustom crankAxle;
ModelRendererCustom crankHandle1;
ModelRendererCustom crankHandle2;
ModelRendererCustom catch2;
ModelRendererCustom catch1;
ModelRendererCustom armRightMain;
ModelRendererCustom armRightMainInner;
ModelRendererCustom armRightMainInner3;
ModelRendererCustom armRightMainInner2;
ModelRendererCustom armRightInner;
ModelRendererCustom armRightOuter;
ModelRendererCustom stringRight;
ModelRendererCustom armLeftMain;
ModelRendererCustom armLeftMainInner;
ModelRendererCustom armLeftOuter;
ModelRendererCustom armLeftMainInner2;
ModelRendererCustom armLeftMainInner3;
ModelRendererCustom armLeftInner;
ModelRendererCustom stringLeft;
public ModelBallista(){
  frontCrossBeam = new ModelRendererCustom(this,"frontCrossBeam");
  frontCrossBeam.setTextureOffset(0,198);
  frontCrossBeam.setTextureSize(256,256);
  frontCrossBeam.setRotationPoint(-12.0f, -11.0f, -16.5f);
  setPieceRotation(frontCrossBeam,0.0f, 0.0f, 0.0f);
  frontCrossBeam.addBox(0.0f,0.0f,0.0f,24,3,3);
  rightBeam = new ModelRendererCustom(this,"rightBeam");
  rightBeam.setTextureOffset(0,205);
  rightBeam.setTextureSize(256,256);
  rightBeam.setRotationPoint(-3.0f, 0.0f, 0.0f);
  setPieceRotation(rightBeam,0.0f, 0.0f, 0.0f);
  rightBeam.addBox(0.0f,0.0f,-5.0f,3,3,48);
  frontCrossBeam.addChild(rightBeam);
  pivotCrossBeam = new ModelRendererCustom(this,"pivotCrossBeam");
  pivotCrossBeam.setTextureOffset(0,198);
  pivotCrossBeam.setTextureSize(256,256);
  pivotCrossBeam.setRotationPoint(0.0f, 0.0f, 15.0f);
  setPieceRotation(pivotCrossBeam,0.0f, 0.0f, 0.0f);
  pivotCrossBeam.addBox(0.0f,0.0f,0.0f,24,3,3);
  frontCrossBeam.addChild(pivotCrossBeam);
  rearCrossBeam = new ModelRendererCustom(this,"rearCrossBeam");
  rearCrossBeam.setTextureOffset(0,198);
  rearCrossBeam.setTextureSize(256,256);
  rearCrossBeam.setRotationPoint(0.0f, 0.0f, 35.0f);
  setPieceRotation(rearCrossBeam,0.0f, 0.0f, 0.0f);
  rearCrossBeam.addBox(0.0f,0.0f,0.0f,24,3,3);
  rearAxle = new ModelRendererCustom(this,"rearAxle");
  rearAxle.setTextureOffset(0,124);
  rearAxle.setTextureSize(256,256);
  rearAxle.setRotationPoint(12.0f, 3.0f, 1.5f);
  setPieceRotation(rearAxle,1.3773537E-6f, 0.0f, 0.0f);
  rearAxle.addBox(-17.0f,-0.5f,-0.5f,34,1,1);
  RRWheelPivot = new ModelRendererCustom(this,"RRWheelPivot");
  RRWheelPivot.setTextureOffset(0,92);
  RRWheelPivot.setTextureSize(256,256);
  RRWheelPivot.setRotationPoint(-17.0f, 0.0f, 0.0f);
  setPieceRotation(RRWheelPivot,0.0f, 0.0f, 0.0f);
  RRWheelPivot.addBox(-0.5f,-7.0f,-0.5f,1,14,1);
  RRS4 = new ModelRendererCustom(this,"RRS4");
  RRS4.setTextureOffset(0,108);
  RRS4.setTextureSize(256,256);
  RRS4.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(RRS4,0.0f, 0.0f, 0.0f);
  RRS4.addBox(-0.5f,-0.5f,-7.0f,1,1,14);
  RRWheelPivot.addChild(RRS4);
  RRS2 = new ModelRendererCustom(this,"RRS2");
  RRS2.setTextureOffset(0,108);
  RRS2.setTextureSize(256,256);
  RRS2.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(RRS2,0.7853982f, 0.0f, 0.0f);
  RRS2.addBox(-0.5f,-0.5f,-7.0f,1,1,14);
  RRWheelPivot.addChild(RRS2);
  RRS3 = new ModelRendererCustom(this,"RRS3");
  RRS3.setTextureOffset(0,108);
  RRS3.setTextureSize(256,256);
  RRS3.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(RRS3,-0.7853982f, 0.0f, 0.0f);
  RRS3.addBox(-0.5f,-0.5f,-7.0f,1,1,14);
  RRWheelPivot.addChild(RRS3);
  RRw1 = new ModelRendererCustom(this,"RRw1");
  RRw1.setTextureOffset(0,84);
  RRw1.setTextureSize(256,256);
  RRw1.setRotationPoint(-1.0f, -8.0f, -3.0f);
  setPieceRotation(RRw1,0.0f, 0.0f, 0.0f);
  RRw1.addBox(0.0f,0.0f,0.0f,2,1,6);
  RRWheelPivot.addChild(RRw1);
  RRw2 = new ModelRendererCustom(this,"RRw2");
  RRw2.setTextureOffset(0,75);
  RRw2.setTextureSize(256,256);
  RRw2.setRotationPoint(-1.0f, -8.0f, 3.0f);
  setPieceRotation(RRw2,-0.7853982f, 0.0f, 0.0f);
  RRw2.addBox(0.0f,0.0f,0.0f,2,1,7);
  RRWheelPivot.addChild(RRw2);
  RRw3 = new ModelRendererCustom(this,"RRw3");
  RRw3.setTextureOffset(0,84);
  RRw3.setTextureSize(256,256);
  RRw3.setRotationPoint(-1.0f, -3.0f, 8.0f);
  setPieceRotation(RRw3,-1.570796f, 0.0f, 0.0f);
  RRw3.addBox(0.0f,0.0f,0.0f,2,1,6);
  RRWheelPivot.addChild(RRw3);
  RRw8 = new ModelRendererCustom(this,"RRw8");
  RRw8.setTextureOffset(0,75);
  RRw8.setTextureSize(256,256);
  RRw8.setRotationPoint(-1.0f, 3.0f, 8.0f);
  setPieceRotation(RRw8,0.7853982f, 0.0f, 0.0f);
  RRw8.addBox(0.0f,-1.0f,-7.0f,2,1,7);
  RRWheelPivot.addChild(RRw8);
  RRw7 = new ModelRendererCustom(this,"RRw7");
  RRw7.setTextureOffset(0,84);
  RRw7.setTextureSize(256,256);
  RRw7.setRotationPoint(-1.0f, 7.0f, -3.0f);
  setPieceRotation(RRw7,0.0f, 0.0f, 0.0f);
  RRw7.addBox(0.0f,0.0f,0.0f,2,1,6);
  RRWheelPivot.addChild(RRw7);
  RRw6 = new ModelRendererCustom(this,"RRw6");
  RRw6.setTextureOffset(0,75);
  RRw6.setTextureSize(256,256);
  RRw6.setRotationPoint(-1.0f, 3.0f, -8.0f);
  setPieceRotation(RRw6,-0.7853982f, 0.0f, 0.0f);
  RRw6.addBox(0.0f,-1.0f,0.0f,2,1,7);
  RRWheelPivot.addChild(RRw6);
  RRw4 = new ModelRendererCustom(this,"RRw4");
  RRw4.setTextureOffset(0,75);
  RRw4.setTextureSize(256,256);
  RRw4.setRotationPoint(-1.0f, -8.0f, -3.0f);
  setPieceRotation(RRw4,0.7853982f, 0.0f, 0.0f);
  RRw4.addBox(0.0f,0.0f,-7.0f,2,1,7);
  RRWheelPivot.addChild(RRw4);
  RRw5 = new ModelRendererCustom(this,"RRw5");
  RRw5.setTextureOffset(0,84);
  RRw5.setTextureSize(256,256);
  RRw5.setRotationPoint(-1.0f, -3.0f, -8.0f);
  setPieceRotation(RRw5,1.570796f, 0.0f, 0.0f);
  RRw5.addBox(0.0f,0.0f,-6.0f,2,1,6);
  RRWheelPivot.addChild(RRw5);
  rearAxle.addChild(RRWheelPivot);
  RLWheelPivot = new ModelRendererCustom(this,"RLWheelPivot");
  RLWheelPivot.setTextureOffset(0,92);
  RLWheelPivot.setTextureSize(256,256);
  RLWheelPivot.setRotationPoint(17.0f, 0.0f, 0.0f);
  setPieceRotation(RLWheelPivot,0.0f, 0.0f, 0.0f);
  RLWheelPivot.addBox(-0.5f,-7.0f,-0.5f,1,14,1);
  RLS2 = new ModelRendererCustom(this,"RLS2");
  RLS2.setTextureOffset(0,108);
  RLS2.setTextureSize(256,256);
  RLS2.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(RLS2,0.7853982f, 0.0f, 0.0f);
  RLS2.addBox(-0.5f,-0.5f,-7.0f,1,1,14);
  RLWheelPivot.addChild(RLS2);
  RLS3 = new ModelRendererCustom(this,"RLS3");
  RLS3.setTextureOffset(0,108);
  RLS3.setTextureSize(256,256);
  RLS3.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(RLS3,-0.7853982f, 0.0f, 0.0f);
  RLS3.addBox(-0.5f,-0.5f,-7.0f,1,1,14);
  RLWheelPivot.addChild(RLS3);
  RLS4 = new ModelRendererCustom(this,"RLS4");
  RLS4.setTextureOffset(0,108);
  RLS4.setTextureSize(256,256);
  RLS4.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(RLS4,0.0f, 0.0f, 0.0f);
  RLS4.addBox(-0.5f,-0.5f,-7.0f,1,1,14);
  RLWheelPivot.addChild(RLS4);
  RLw1 = new ModelRendererCustom(this,"RLw1");
  RLw1.setTextureOffset(0,84);
  RLw1.setTextureSize(256,256);
  RLw1.setRotationPoint(-1.0f, -8.0f, -3.0f);
  setPieceRotation(RLw1,0.0f, -1.0402973E-9f, 0.0f);
  RLw1.addBox(0.0f,0.0f,0.0f,2,1,6);
  RLWheelPivot.addChild(RLw1);
  RLw2 = new ModelRendererCustom(this,"RLw2");
  RLw2.setTextureOffset(0,75);
  RLw2.setTextureSize(256,256);
  RLw2.setRotationPoint(-1.0f, -8.0f, 3.0f);
  setPieceRotation(RLw2,-0.7853982f, 0.0f, 0.0f);
  RLw2.addBox(0.0f,0.0f,0.0f,2,1,7);
  RLWheelPivot.addChild(RLw2);
  RLw3 = new ModelRendererCustom(this,"RLw3");
  RLw3.setTextureOffset(0,84);
  RLw3.setTextureSize(256,256);
  RLw3.setRotationPoint(-1.0f, -3.0f, 8.0f);
  setPieceRotation(RLw3,-1.570796f, 0.0f, 0.0f);
  RLw3.addBox(0.0f,0.0f,0.0f,2,1,6);
  RLWheelPivot.addChild(RLw3);
  RLw8 = new ModelRendererCustom(this,"RLw8");
  RLw8.setTextureOffset(0,75);
  RLw8.setTextureSize(256,256);
  RLw8.setRotationPoint(-1.0f, 3.0f, 8.0f);
  setPieceRotation(RLw8,0.7853982f, 0.0f, 0.0f);
  RLw8.addBox(0.0f,-1.0f,-7.0f,2,1,7);
  RLWheelPivot.addChild(RLw8);
  RLw7 = new ModelRendererCustom(this,"RLw7");
  RLw7.setTextureOffset(0,84);
  RLw7.setTextureSize(256,256);
  RLw7.setRotationPoint(-1.0f, 7.0f, -3.0f);
  setPieceRotation(RLw7,0.0f, 0.0f, 0.0f);
  RLw7.addBox(0.0f,0.0f,0.0f,2,1,6);
  RLWheelPivot.addChild(RLw7);
  RLw6 = new ModelRendererCustom(this,"RLw6");
  RLw6.setTextureOffset(0,75);
  RLw6.setTextureSize(256,256);
  RLw6.setRotationPoint(-1.0f, 3.0f, -8.0f);
  setPieceRotation(RLw6,-0.7853982f, 0.0f, 0.0f);
  RLw6.addBox(0.0f,-1.0f,0.0f,2,1,7);
  RLWheelPivot.addChild(RLw6);
  RLw5 = new ModelRendererCustom(this,"RLw5");
  RLw5.setTextureOffset(0,84);
  RLw5.setTextureSize(256,256);
  RLw5.setRotationPoint(-1.0f, -3.0f, -8.0f);
  setPieceRotation(RLw5,1.570796f, 0.0f, 0.0f);
  RLw5.addBox(0.0f,0.0f,-6.0f,2,1,6);
  RLWheelPivot.addChild(RLw5);
  RLw4 = new ModelRendererCustom(this,"RLw4");
  RLw4.setTextureOffset(0,75);
  RLw4.setTextureSize(256,256);
  RLw4.setRotationPoint(-1.0f, -8.0f, -3.0f);
  setPieceRotation(RLw4,0.7853982f, 0.0f, 0.0f);
  RLw4.addBox(0.0f,0.0f,-7.0f,2,1,7);
  RLWheelPivot.addChild(RLw4);
  rearAxle.addChild(RLWheelPivot);
  rearCrossBeam.addChild(rearAxle);
  frontCrossBeam.addChild(rearCrossBeam);
  leftBeam = new ModelRendererCustom(this,"leftBeam");
  leftBeam.setTextureOffset(0,205);
  leftBeam.setTextureSize(256,256);
  leftBeam.setRotationPoint(24.0f, 0.0f, 0.0f);
  setPieceRotation(leftBeam,0.0f, 0.0f, 0.0f);
  leftBeam.addBox(0.0f,0.0f,-5.0f,3,3,48);
  frontCrossBeam.addChild(leftBeam);
  frontAxle = new ModelRendererCustom(this,"frontAxle");
  frontAxle.setTextureOffset(0,124);
  frontAxle.setTextureSize(256,256);
  frontAxle.setRotationPoint(12.0f, 3.0f, 1.5f);
  setPieceRotation(frontAxle,0.0f, 0.0f, 0.0f);
  frontAxle.addBox(-17.0f,-0.5f,-0.5f,34,1,1);
  FRWheelPivot = new ModelRendererCustom(this,"FRWheelPivot");
  FRWheelPivot.setTextureOffset(0,92);
  FRWheelPivot.setTextureSize(256,256);
  FRWheelPivot.setRotationPoint(-17.0f, 0.0f, 0.0f);
  setPieceRotation(FRWheelPivot,0.0f, 0.0f, 0.0f);
  FRWheelPivot.addBox(-0.5f,-7.0f,-0.5f,1,14,1);
  FRS2 = new ModelRendererCustom(this,"FRS2");
  FRS2.setTextureOffset(0,108);
  FRS2.setTextureSize(256,256);
  FRS2.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(FRS2,0.7853982f, 0.0f, 0.0f);
  FRS2.addBox(-0.5f,-0.5f,-7.0f,1,1,14);
  FRWheelPivot.addChild(FRS2);
  FRS3 = new ModelRendererCustom(this,"FRS3");
  FRS3.setTextureOffset(0,108);
  FRS3.setTextureSize(256,256);
  FRS3.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(FRS3,-0.7853982f, 0.0f, 0.0f);
  FRS3.addBox(-0.5f,-0.5f,-7.0f,1,1,14);
  FRWheelPivot.addChild(FRS3);
  FRS4 = new ModelRendererCustom(this,"FRS4");
  FRS4.setTextureOffset(0,108);
  FRS4.setTextureSize(256,256);
  FRS4.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(FRS4,0.0f, 0.0f, 0.0f);
  FRS4.addBox(-0.5f,-0.5f,-7.0f,1,1,14);
  FRWheelPivot.addChild(FRS4);
  frw1 = new ModelRendererCustom(this,"frw1");
  frw1.setTextureOffset(0,84);
  frw1.setTextureSize(256,256);
  frw1.setRotationPoint(-1.0f, -8.0f, -3.0f);
  setPieceRotation(frw1,0.0f, 0.0f, 0.0f);
  frw1.addBox(0.0f,0.0f,0.0f,2,1,6);
  FRWheelPivot.addChild(frw1);
  Frw4 = new ModelRendererCustom(this,"Frw4");
  Frw4.setTextureOffset(0,75);
  Frw4.setTextureSize(256,256);
  Frw4.setRotationPoint(-1.0f, -8.0f, -3.0f);
  setPieceRotation(Frw4,0.7853982f, 0.0f, 0.0f);
  Frw4.addBox(0.0f,0.0f,-7.0f,2,1,7);
  FRWheelPivot.addChild(Frw4);
  FLr5 = new ModelRendererCustom(this,"FLr5");
  FLr5.setTextureOffset(0,84);
  FLr5.setTextureSize(256,256);
  FLr5.setRotationPoint(-1.0f, -3.0f, -8.0f);
  setPieceRotation(FLr5,1.5707958f, 0.0f, 0.0f);
  FLr5.addBox(0.0f,0.0f,-6.0f,2,1,6);
  FRWheelPivot.addChild(FLr5);
  Frw6 = new ModelRendererCustom(this,"Frw6");
  Frw6.setTextureOffset(0,75);
  Frw6.setTextureSize(256,256);
  Frw6.setRotationPoint(-1.0f, 3.0f, -8.0f);
  setPieceRotation(Frw6,-0.7853982f, 0.0f, 0.0f);
  Frw6.addBox(0.0f,-1.0f,0.0f,2,1,7);
  FRWheelPivot.addChild(Frw6);
  Frw7 = new ModelRendererCustom(this,"Frw7");
  Frw7.setTextureOffset(0,84);
  Frw7.setTextureSize(256,256);
  Frw7.setRotationPoint(-1.0f, 7.0f, -3.0f);
  setPieceRotation(Frw7,0.0f, 0.0f, 0.0f);
  Frw7.addBox(0.0f,0.0f,0.0f,2,1,6);
  FRWheelPivot.addChild(Frw7);
  Frw8 = new ModelRendererCustom(this,"Frw8");
  Frw8.setTextureOffset(0,75);
  Frw8.setTextureSize(256,256);
  Frw8.setRotationPoint(-1.0f, 3.0f, 8.0f);
  setPieceRotation(Frw8,0.7853982f, 0.0f, 0.0f);
  Frw8.addBox(0.0f,-1.0f,-7.0f,2,1,7);
  FRWheelPivot.addChild(Frw8);
  Frw3 = new ModelRendererCustom(this,"Frw3");
  Frw3.setTextureOffset(0,84);
  Frw3.setTextureSize(256,256);
  Frw3.setRotationPoint(-1.0f, -3.0f, 8.0f);
  setPieceRotation(Frw3,-1.570796f, 0.0f, 0.0f);
  Frw3.addBox(0.0f,0.0f,0.0f,2,1,6);
  FRWheelPivot.addChild(Frw3);
  Frw2 = new ModelRendererCustom(this,"Frw2");
  Frw2.setTextureOffset(0,75);
  Frw2.setTextureSize(256,256);
  Frw2.setRotationPoint(-1.0f, -8.0f, 3.0f);
  setPieceRotation(Frw2,-0.7853982f, 0.0f, 0.0f);
  Frw2.addBox(0.0f,0.0f,0.0f,2,1,7);
  FRWheelPivot.addChild(Frw2);
  frontAxle.addChild(FRWheelPivot);
  FLWheelPivot = new ModelRendererCustom(this,"FLWheelPivot");
  FLWheelPivot.setTextureOffset(0,92);
  FLWheelPivot.setTextureSize(256,256);
  FLWheelPivot.setRotationPoint(17.0f, 0.0f, 0.0f);
  setPieceRotation(FLWheelPivot,0.0f, 0.0f, 0.0f);
  FLWheelPivot.addBox(-0.5f,-7.0f,-0.5f,1,14,1);
  FLw3 = new ModelRendererCustom(this,"FLw3");
  FLw3.setTextureOffset(0,84);
  FLw3.setTextureSize(256,256);
  FLw3.setRotationPoint(-1.0f, -3.0f, 8.0f);
  setPieceRotation(FLw3,-1.570796f, 0.0f, 0.0f);
  FLw3.addBox(0.0f,0.0f,0.0f,2,1,6);
  FLWheelPivot.addChild(FLw3);
  FLw2 = new ModelRendererCustom(this,"FLw2");
  FLw2.setTextureOffset(0,75);
  FLw2.setTextureSize(256,256);
  FLw2.setRotationPoint(-1.0f, -8.0f, 3.0f);
  setPieceRotation(FLw2,-0.7853982f, 0.0f, 0.0f);
  FLw2.addBox(0.0f,0.0f,0.0f,2,1,7);
  FLWheelPivot.addChild(FLw2);
  FS4 = new ModelRendererCustom(this,"FS4");
  FS4.setTextureOffset(0,108);
  FS4.setTextureSize(256,256);
  FS4.setRotationPoint(0.0f, 0.0f, -0.0f);
  setPieceRotation(FS4,0.0f, 0.0f, 0.0f);
  FS4.addBox(-0.5f,-0.5f,-7.0f,1,1,14);
  FLWheelPivot.addChild(FS4);
  FLS2 = new ModelRendererCustom(this,"FLS2");
  FLS2.setTextureOffset(0,108);
  FLS2.setTextureSize(256,256);
  FLS2.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(FLS2,0.7853982f, 0.0f, 0.0f);
  FLS2.addBox(-0.5f,-0.5f,-7.0f,1,1,14);
  FLWheelPivot.addChild(FLS2);
  FS3 = new ModelRendererCustom(this,"FS3");
  FS3.setTextureOffset(0,108);
  FS3.setTextureSize(256,256);
  FS3.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(FS3,-0.7853982f, 0.0f, 0.0f);
  FS3.addBox(-0.5f,-0.5f,-7.0f,1,1,14);
  FLWheelPivot.addChild(FS3);
  flw1 = new ModelRendererCustom(this,"flw1");
  flw1.setTextureOffset(0,84);
  flw1.setTextureSize(256,256);
  flw1.setRotationPoint(-1.0f, -8.0f, -3.0f);
  setPieceRotation(flw1,0.0f, 0.0f, 0.0f);
  flw1.addBox(0.0f,0.0f,0.0f,2,1,6);
  FLWheelPivot.addChild(flw1);
  FLw4 = new ModelRendererCustom(this,"FLw4");
  FLw4.setTextureOffset(0,75);
  FLw4.setTextureSize(256,256);
  FLw4.setRotationPoint(-1.0f, -8.0f, -3.0f);
  setPieceRotation(FLw4,0.7853982f, 0.0f, 0.0f);
  FLw4.addBox(0.0f,0.0f,-7.0f,2,1,7);
  FLWheelPivot.addChild(FLw4);
  FLw5 = new ModelRendererCustom(this,"FLw5");
  FLw5.setTextureOffset(0,84);
  FLw5.setTextureSize(256,256);
  FLw5.setRotationPoint(-1.0f, -3.0f, -8.0f);
  setPieceRotation(FLw5,1.5707955f, 0.0f, 0.0f);
  FLw5.addBox(0.0f,0.0f,-6.0f,2,1,6);
  FLWheelPivot.addChild(FLw5);
  FLw6 = new ModelRendererCustom(this,"FLw6");
  FLw6.setTextureOffset(0,75);
  FLw6.setTextureSize(256,256);
  FLw6.setRotationPoint(-1.0f, 3.0f, -8.0f);
  setPieceRotation(FLw6,-0.7853982f, 0.0f, 0.0f);
  FLw6.addBox(0.0f,-1.0f,0.0f,2,1,7);
  FLWheelPivot.addChild(FLw6);
  FLw7 = new ModelRendererCustom(this,"FLw7");
  FLw7.setTextureOffset(0,84);
  FLw7.setTextureSize(256,256);
  FLw7.setRotationPoint(-1.0f, 7.0f, -3.0f);
  setPieceRotation(FLw7,0.0f, 0.0f, 0.0f);
  FLw7.addBox(0.0f,0.0f,0.0f,2,1,6);
  FLWheelPivot.addChild(FLw7);
  FLw8 = new ModelRendererCustom(this,"FLw8");
  FLw8.setTextureOffset(0,75);
  FLw8.setTextureSize(256,256);
  FLw8.setRotationPoint(-1.0f, 3.0f, 8.0f);
  setPieceRotation(FLw8,0.7853982f, 0.0f, 0.0f);
  FLw8.addBox(0.0f,-1.0f,-7.0f,2,1,7);
  FLWheelPivot.addChild(FLw8);
  frontAxle.addChild(FLWheelPivot);
  frontCrossBeam.addChild(frontAxle);
  chairBrace = new ModelRendererCustom(this,"chairBrace");
  chairBrace.setTextureOffset(86,139);
  chairBrace.setTextureSize(256,256);
  chairBrace.setRotationPoint(10.5f, 0.5f, 41.0f);
  setPieceRotation(chairBrace,0.0f, 0.0f, 0.0f);
  chairBrace.addBox(0.0f,0.0f,-8.0f,3,1,7);
  chairBottom = new ModelRendererCustom(this,"chairBottom");
  chairBottom.setTextureOffset(63,128);
  chairBottom.setTextureSize(256,256);
  chairBottom.setRotationPoint(-3.5f, -1.5f, -1.0f);
  setPieceRotation(chairBottom,0.1570796f, 0.0f, 0.0f);
  chairBottom.addBox(0.0f,0.0f,-9.0f,10,1,9);
  chairBrace.addChild(chairBottom);
  chairBack = new ModelRendererCustom(this,"chairBack");
  chairBack.setTextureOffset(63,139);
  chairBack.setTextureSize(256,256);
  chairBack.setRotationPoint(-3.5f, -1.0f, -1.0f);
  setPieceRotation(chairBack,-0.1745329f, 0.0f, 0.0f);
  chairBack.addBox(0.0f,-10.0f,0.0f,10,10,1);
  chairBrace.addChild(chairBack);
  frontCrossBeam.addChild(chairBrace);
  flagPole = new ModelRendererCustom(this,"flagPole");
  flagPole.setTextureOffset(0,0);
  flagPole.setTextureSize(256,256);
  flagPole.setRotationPoint(-2.0f, -16.0f, 40.0f);
  setPieceRotation(flagPole,0.0f, 0.0f, 0.0f);
  flagPole.addBox(0.0f,0.0f,0.0f,1,16,1);
  flagCloth = new ModelRendererCustom(this,"flagCloth");
  flagCloth.setTextureOffset(5,0);
  flagCloth.setTextureSize(256,256);
  flagCloth.setRotationPoint(0.0f, 0.0f, 1.0f);
  setPieceRotation(flagCloth,0.0f, 0.0f, 0.0f);
  flagCloth.addBox(0.0f,0.0f,0.0f,1,8,11);
  flagPole.addChild(flagCloth);
  frontCrossBeam.addChild(flagPole);
  pivot = new ModelRendererCustom(this,"pivot");
  pivot.setTextureOffset(55,198);
  pivot.setTextureSize(256,256);
  pivot.setRotationPoint(12.0f, 0.0f, 1.5f);
  setPieceRotation(pivot,0.0f, 0.0f, 0.0f);
  pivot.addBox(-1.0f,-4.0f,-1.0f,2,4,2);
  frontCrossBeam.addChild(pivot);
  armMain = new ModelRendererCustom(this,"armMain");
  armMain.setTextureOffset(103,225);
  armMain.setTextureSize(256,256);
  armMain.setRotationPoint(0.0f, -15.0f, -15.0f);
  setPieceRotation(armMain,-6.585082E-7f, -2.3593943E-6f, 0.0f);
  armMain.addBox(-1.5f,-2.0f,-4.5f,3,2,28);
  armFront = new ModelRendererCustom(this,"armFront");
  armFront.setTextureOffset(103,219);
  armFront.setTextureSize(256,256);
  armFront.setRotationPoint(-1.5f, -2.0f, -11.5f);
  setPieceRotation(armFront,0.0f, 0.0f, 0.0f);
  armFront.addBox(0.0f,0.0f,0.0f,3,2,4);
  armMain.addChild(armFront);
  turretHorizontalBrace2 = new ModelRendererCustom(this,"turretHorizontalBrace2");
  turretHorizontalBrace2.setTextureOffset(0,187);
  turretHorizontalBrace2.setTextureSize(256,256);
  turretHorizontalBrace2.setRotationPoint(11.0f, -1.5f, -4.5f);
  setPieceRotation(turretHorizontalBrace2,0.0f, 0.5410521f, 0.0f);
  turretHorizontalBrace2.addBox(-13.0f,0.0f,-3.0f,13,1,3);
  armMain.addChild(turretHorizontalBrace2);
  turretHorizontalBrace3 = new ModelRendererCustom(this,"turretHorizontalBrace3");
  turretHorizontalBrace3.setTextureOffset(0,192);
  turretHorizontalBrace3.setTextureSize(256,256);
  turretHorizontalBrace3.setRotationPoint(-11.0f, -2.0f, -7.5f);
  setPieceRotation(turretHorizontalBrace3,0.0f, 0.0f, 0.0f);
  turretHorizontalBrace3.addBox(0.0f,0.0f,0.0f,22,2,3);
  armMain.addChild(turretHorizontalBrace3);
  armMidBrace = new ModelRendererCustom(this,"armMidBrace");
  armMidBrace.setTextureOffset(162,170);
  armMidBrace.setTextureSize(256,256);
  armMidBrace.setRotationPoint(-1.5f, -3.0f, -11.5f);
  setPieceRotation(armMidBrace,0.0f, 0.0f, 0.0f);
  armMidBrace.addBox(0.0f,0.0f,0.0f,3,1,35);
  armMain.addChild(armMidBrace);
  armSlotLeft = new ModelRendererCustom(this,"armSlotLeft");
  armSlotLeft.setTextureOffset(166,220);
  armSlotLeft.setTextureSize(256,256);
  armSlotLeft.setRotationPoint(0.5f, -4.0f, -11.5f);
  setPieceRotation(armSlotLeft,0.0f, 0.0f, 0.0f);
  armSlotLeft.addBox(0.0f,0.0f,0.0f,1,1,35);
  armMain.addChild(armSlotLeft);
  armSlotRight = new ModelRendererCustom(this,"armSlotRight");
  armSlotRight.setTextureOffset(166,220);
  armSlotRight.setTextureSize(256,256);
  armSlotRight.setRotationPoint(-1.5f, -4.0f, -11.5f);
  setPieceRotation(armSlotRight,0.0f, 0.0f, 0.0f);
  armSlotRight.addBox(0.0f,0.0f,0.0f,1,1,35);
  armMain.addChild(armSlotRight);
  armleftVertical3 = new ModelRendererCustom(this,"armleftVertical3");
  armleftVertical3.setTextureOffset(123,223);
  armleftVertical3.setTextureSize(256,256);
  armleftVertical3.setRotationPoint(10.0f, -3.0f, -6.0f);
  setPieceRotation(armleftVertical3,0.0f, 0.0f, 0.0f);
  armleftVertical3.addBox(0.0f,0.0f,0.0f,1,1,1);
  armMain.addChild(armleftVertical3);
  armLeftVertical2 = new ModelRendererCustom(this,"armLeftVertical2");
  armLeftVertical2.setTextureOffset(123,223);
  armLeftVertical2.setTextureSize(256,256);
  armLeftVertical2.setRotationPoint(10.0f, -7.0f, -6.0f);
  setPieceRotation(armLeftVertical2,0.0f, 0.0f, 0.0f);
  armLeftVertical2.addBox(0.0f,0.0f,0.0f,1,1,1);
  armMain.addChild(armLeftVertical2);
  armLeftVertical1 = new ModelRendererCustom(this,"armLeftVertical1");
  armLeftVertical1.setTextureOffset(118,219);
  armLeftVertical1.setTextureSize(256,256);
  armLeftVertical1.setRotationPoint(10.0f, -7.0f, -7.0f);
  setPieceRotation(armLeftVertical1,0.0f, 0.0f, 0.0f);
  armLeftVertical1.addBox(0.0f,0.0f,0.0f,1,5,1);
  armMain.addChild(armLeftVertical1);
  turretHorizontalBrace4 = new ModelRendererCustom(this,"turretHorizontalBrace4");
  turretHorizontalBrace4.setTextureOffset(0,192);
  turretHorizontalBrace4.setTextureSize(256,256);
  turretHorizontalBrace4.setRotationPoint(-11.0f, -9.0f, -7.5f);
  setPieceRotation(turretHorizontalBrace4,0.0f, 0.0f, 0.0f);
  turretHorizontalBrace4.addBox(0.0f,0.0f,0.0f,22,2,3);
  armMain.addChild(turretHorizontalBrace4);
  leftTensionerRope = new ModelRendererCustom(this,"leftTensionerRope");
  leftTensionerRope.setTextureOffset(234,207);
  leftTensionerRope.setTextureSize(256,256);
  leftTensionerRope.setRotationPoint(5.5f, -7.0f, -6.0f);
  setPieceRotation(leftTensionerRope,0.0f, 0.0f, 0.0f);
  leftTensionerRope.addBox(-0.5f,-3.0f,-0.5f,1,11,1);
  leftTensioner = new ModelRendererCustom(this,"leftTensioner");
  leftTensioner.setTextureOffset(128,219);
  leftTensioner.setTextureSize(256,256);
  leftTensioner.setRotationPoint(0.0f, -3.0f, 0.0f);
  setPieceRotation(leftTensioner,0.0f, 0.0f, 0.0f);
  leftTensioner.addBox(-1.0f,-0.5f,-0.5f,2,1,1);
  leftTensionerRope.addChild(leftTensioner);
  leftTensioner2 = new ModelRendererCustom(this,"leftTensioner2");
  leftTensioner2.setTextureOffset(128,222);
  leftTensioner2.setTextureSize(256,256);
  leftTensioner2.setRotationPoint(0.0f, -3.0f, -0.0f);
  setPieceRotation(leftTensioner2,0.0f, 0.0f, 0.0f);
  leftTensioner2.addBox(-0.5f,-0.5f,-1.0f,1,1,2);
  leftTensionerRope.addChild(leftTensioner2);
  armMain.addChild(leftTensionerRope);
  rightTensionerRope = new ModelRendererCustom(this,"rightTensionerRope");
  rightTensionerRope.setTextureOffset(234,207);
  rightTensionerRope.setTextureSize(256,256);
  rightTensionerRope.setRotationPoint(-5.5f, -7.0f, -6.0f);
  setPieceRotation(rightTensionerRope,0.0f, 0.0f, 0.0f);
  rightTensionerRope.addBox(-0.5f,-3.0f,-0.5f,1,11,1);
  rightTensioner = new ModelRendererCustom(this,"rightTensioner");
  rightTensioner.setTextureOffset(128,219);
  rightTensioner.setTextureSize(256,256);
  rightTensioner.setRotationPoint(0.0f, -3.0f, 0.0f);
  setPieceRotation(rightTensioner,0.0f, 0.0f, 0.0f);
  rightTensioner.addBox(-1.0f,-0.5f,-0.5f,2,1,1);
  rightTensionerRope.addChild(rightTensioner);
  rightTensioner2 = new ModelRendererCustom(this,"rightTensioner2");
  rightTensioner2.setTextureOffset(128,222);
  rightTensioner2.setTextureSize(256,256);
  rightTensioner2.setRotationPoint(0.0f, -3.0f, 0.0f);
  setPieceRotation(rightTensioner2,0.0f, 0.0f, 0.0f);
  rightTensioner2.addBox(-0.5f,-0.5f,-1.0f,1,1,2);
  rightTensionerRope.addChild(rightTensioner2);
  armMain.addChild(rightTensionerRope);
  turretHorizontalBrace1 = new ModelRendererCustom(this,"turretHorizontalBrace1");
  turretHorizontalBrace1.setTextureOffset(0,187);
  turretHorizontalBrace1.setTextureSize(256,256);
  turretHorizontalBrace1.setRotationPoint(-11.0f, -1.5f, -4.5f);
  setPieceRotation(turretHorizontalBrace1,0.0f, -0.5410521f, 0.0f);
  turretHorizontalBrace1.addBox(0.0f,0.0f,-3.0f,13,1,3);
  armMain.addChild(turretHorizontalBrace1);
  armRightVertical3 = new ModelRendererCustom(this,"armRightVertical3");
  armRightVertical3.setTextureOffset(123,223);
  armRightVertical3.setTextureSize(256,256);
  armRightVertical3.setRotationPoint(-11.0f, -3.0f, -6.0f);
  setPieceRotation(armRightVertical3,0.0f, 0.0f, 0.0f);
  armRightVertical3.addBox(0.0f,0.0f,0.0f,1,1,1);
  armMain.addChild(armRightVertical3);
  armRightVertical2 = new ModelRendererCustom(this,"armRightVertical2");
  armRightVertical2.setTextureOffset(123,223);
  armRightVertical2.setTextureSize(256,256);
  armRightVertical2.setRotationPoint(-11.0f, -7.0f, -6.0f);
  setPieceRotation(armRightVertical2,0.0f, 0.0f, 0.0f);
  armRightVertical2.addBox(0.0f,0.0f,0.0f,1,1,1);
  armMain.addChild(armRightVertical2);
  armRightVertical1 = new ModelRendererCustom(this,"armRightVertical1");
  armRightVertical1.setTextureOffset(118,219);
  armRightVertical1.setTextureSize(256,256);
  armRightVertical1.setRotationPoint(-11.0f, -7.0f, -7.0f);
  setPieceRotation(armRightVertical1,0.0f, 0.0f, 0.0f);
  armRightVertical1.addBox(0.0f,0.0f,0.0f,1,5,1);
  armMain.addChild(armRightVertical1);
  trigger1 = new ModelRendererCustom(this,"trigger1");
  trigger1.setTextureOffset(133,212);
  trigger1.setTextureSize(256,256);
  trigger1.setRotationPoint(-0.0f, -1.0f, 17.5f);
  setPieceRotation(trigger1,-1.256629f, 0.0f, 0.0f);
  trigger1.addBox(-0.5f,-1.0f,0.0f,1,1,5);
  trigger2 = new ModelRendererCustom(this,"trigger2");
  trigger2.setTextureOffset(128,214);
  trigger2.setTextureSize(256,256);
  trigger2.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(trigger2,1.2217292f, 1.934953E-7f, 3.1625038E-7f);
  trigger2.addBox(-0.5f,-4.0f,0.0f,1,4,1);
  trigger1.addChild(trigger2);
  armMain.addChild(trigger1);
  crankAxle = new ModelRendererCustom(this,"crankAxle");
  crankAxle.setTextureOffset(153,223);
  crankAxle.setTextureSize(256,256);
  crankAxle.setRotationPoint(-2.0f, -2.0f, 21.0f);
  setPieceRotation(crankAxle,0.0f, 0.0f, 0.0f);
  crankAxle.addBox(0.0f,-0.5f,-0.5f,4,1,1);
  crankHandle1 = new ModelRendererCustom(this,"crankHandle1");
  crankHandle1.setTextureOffset(0,0);
  crankHandle1.setTextureSize(256,256);
  crankHandle1.setRotationPoint(-0.5f, 0.0f, 0.0f);
  setPieceRotation(crankHandle1,0.0f, 0.0f, 0.0f);
  crankHandle1.addBox(-0.5f,-2.5f,-0.5f,1,5,1);
  crankAxle.addChild(crankHandle1);
  crankHandle2 = new ModelRendererCustom(this,"crankHandle2");
  crankHandle2.setTextureOffset(0,0);
  crankHandle2.setTextureSize(256,256);
  crankHandle2.setRotationPoint(-0.5f, 0.0f, 0.0f);
  setPieceRotation(crankHandle2,0.0f, 0.0f, 0.0f);
  crankHandle2.addBox(-0.5f,-0.5f,-2.5f,1,1,5);
  crankAxle.addChild(crankHandle2);
  armMain.addChild(crankAxle);
  catch2 = new ModelRendererCustom(this,"catch2");
  catch2.setTextureOffset(133,206);
  catch2.setTextureSize(256,256);
  catch2.setRotationPoint(-1.0f, -6.0f, 20.5f);
  setPieceRotation(catch2,-0.8552113f, 0.0f, 0.0f);
  catch2.addBox(0.0f,0.0f,0.0f,2,1,4);
  armMain.addChild(catch2);
  catch1 = new ModelRendererCustom(this,"catch1");
  catch1.setTextureOffset(133,201);
  catch1.setTextureSize(256,256);
  catch1.setRotationPoint(-1.0f, -6.0f, 17.5f);
  setPieceRotation(catch1,0.0f, 0.0f, 0.0f);
  catch1.addBox(0.0f,0.0f,0.0f,2,1,3);
  armMain.addChild(catch1);
  armRightMain = new ModelRendererCustom(this,"armRightMain");
  armRightMain.setTextureOffset(103,214);
  armRightMain.setTextureSize(256,256);
  armRightMain.setRotationPoint(-5.5f, -5.0f, -6.0f);
  setPieceRotation(armRightMain,0.0f, 0.5235982f, 0.0f);
  armRightMain.addBox(-6.5f,-1.0f,-1.0f,8,3,1);
  armRightMainInner = new ModelRendererCustom(this,"armRightMainInner");
  armRightMainInner.setTextureOffset(103,202);
  armRightMainInner.setTextureSize(256,256);
  armRightMainInner.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(armRightMainInner,0.0f, 0.0f, 0.0f);
  armRightMainInner.addBox(-2.5f,-1.0f,0.0f,4,3,1);
  armRightMain.addChild(armRightMainInner);
  armRightMainInner3 = new ModelRendererCustom(this,"armRightMainInner3");
  armRightMainInner3.setTextureOffset(114,200);
  armRightMainInner3.setTextureSize(256,256);
  armRightMainInner3.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(armRightMainInner3,0.0f, 0.0f, 0.0f);
  armRightMainInner3.addBox(-6.5f,0.0f,0.0f,4,1,1);
  armRightMain.addChild(armRightMainInner3);
  armRightMainInner2 = new ModelRendererCustom(this,"armRightMainInner2");
  armRightMainInner2.setTextureOffset(114,203);
  armRightMainInner2.setTextureSize(256,256);
  armRightMainInner2.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(armRightMainInner2,0.0f, 0.0f, 0.0f);
  armRightMainInner2.addBox(-6.5f,-0.5f,-0.5f,4,2,1);
  armRightMain.addChild(armRightMainInner2);
  armRightInner = new ModelRendererCustom(this,"armRightInner");
  armRightInner.setTextureOffset(103,207);
  armRightInner.setTextureSize(256,256);
  armRightInner.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(armRightInner,0.0f, 0.0f, 0.0f);
  armRightInner.addBox(-13.25f,0.0f,-0.5f,7,1,1);
  armRightMain.addChild(armRightInner);
  armRightOuter = new ModelRendererCustom(this,"armRightOuter");
  armRightOuter.setTextureOffset(103,210);
  armRightOuter.setTextureSize(256,256);
  armRightOuter.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(armRightOuter,0.0f, 0.0f, 0.0f);
  armRightOuter.addBox(-13.5f,-0.5f,-1.0f,7,2,1);
  armRightMain.addChild(armRightOuter);
  stringRight = new ModelRendererCustom(this,"stringRight");
  stringRight.setTextureOffset(197,214);
  stringRight.setTextureSize(256,256);
  stringRight.setRotationPoint(-13.0f, 0.5f, 0.0f);
  setPieceRotation(stringRight,0.0f, -0.5235985f, 0.0f);
  stringRight.addBox(0.0f,-0.5f,0.0f,17,1,1);
  armRightMain.addChild(stringRight);
  armMain.addChild(armRightMain);
  armLeftMain = new ModelRendererCustom(this,"armLeftMain");
  armLeftMain.setTextureOffset(103,214);
  armLeftMain.setTextureSize(256,256);
  armLeftMain.setRotationPoint(5.5f, -6.0f, -6.0f);
  setPieceRotation(armLeftMain,0.0f, -0.5235988f, 0.0f);
  armLeftMain.addBox(-1.5f,0.0f,-1.0f,8,3,1);
  armLeftMainInner = new ModelRendererCustom(this,"armLeftMainInner");
  armLeftMainInner.setTextureOffset(103,202);
  armLeftMainInner.setTextureSize(256,256);
  armLeftMainInner.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(armLeftMainInner,0.0f, 0.0f, 0.0f);
  armLeftMainInner.addBox(-1.5f,0.0f,0.0f,4,3,1);
  armLeftMain.addChild(armLeftMainInner);
  armLeftOuter = new ModelRendererCustom(this,"armLeftOuter");
  armLeftOuter.setTextureOffset(103,210);
  armLeftOuter.setTextureSize(256,256);
  armLeftOuter.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(armLeftOuter,0.0f, 0.0f, 0.0f);
  armLeftOuter.addBox(6.5f,0.5f,-1.0f,7,2,1);
  armLeftMain.addChild(armLeftOuter);
  armLeftMainInner2 = new ModelRendererCustom(this,"armLeftMainInner2");
  armLeftMainInner2.setTextureOffset(114,203);
  armLeftMainInner2.setTextureSize(256,256);
  armLeftMainInner2.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(armLeftMainInner2,0.0f, 0.0f, 0.0f);
  armLeftMainInner2.addBox(2.5f,0.5f,-0.5f,4,2,1);
  armLeftMain.addChild(armLeftMainInner2);
  armLeftMainInner3 = new ModelRendererCustom(this,"armLeftMainInner3");
  armLeftMainInner3.setTextureOffset(114,200);
  armLeftMainInner3.setTextureSize(256,256);
  armLeftMainInner3.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(armLeftMainInner3,0.0f, 0.0f, 0.0f);
  armLeftMainInner3.addBox(2.5f,1.0f,-0.0f,4,1,1);
  armLeftMain.addChild(armLeftMainInner3);
  armLeftInner = new ModelRendererCustom(this,"armLeftInner");
  armLeftInner.setTextureOffset(103,207);
  armLeftInner.setTextureSize(256,256);
  armLeftInner.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(armLeftInner,0.0f, 0.0f, 0.0f);
  armLeftInner.addBox(6.25f,1.0f,-0.5f,7,1,1);
  armLeftMain.addChild(armLeftInner);
  stringLeft = new ModelRendererCustom(this,"stringLeft");
  stringLeft.setTextureOffset(197,217);
  stringLeft.setTextureSize(256,256);
  stringLeft.setRotationPoint(13.0f, 1.5f, 0.0f);
  setPieceRotation(stringLeft,0.0f, 0.5235985f, 0.0f);
  stringLeft.addBox(-17.0f,-0.5f,0.0f,17,1,1);
  armLeftMain.addChild(stringLeft);
  armMain.addChild(armLeftMain);
  }
 
@Override
public void render(Entity entity, float f1, float f2, float f3, float f4, float f5, float f6)
  {
  super.render(entity, f1, f2, f3, f4, f5, f6);
  setRotationAngles(f1, f2, f3, f4, f5, f6, entity);
  frontCrossBeam.bindParentTexture(entity.getTexture());
  frontCrossBeam.render(f6);
  armMain.bindParentTexture(entity.getTexture());
  armMain.render(f6);
  }
 
public void setPieceRotation(ModelRenderer model, float x, float y, float z)
  {
  model.rotateAngleX = x;
  model.rotateAngleY = y;
  model.rotateAngleZ = z;
  }

public void setCrankRotations(float rot)
  {
  crankAxle.rotateAngleX = rot = Trig.toRadians(rot);
  }

public void setTurretRotation(float yaw, float pitch)
  {
  armMain.rotateAngleX = Trig.toRadians(pitch);
  armMain.rotateAngleY = Trig.toRadians(yaw);  
  }

public void setWheelRotations(float fl, float fr, float rl, float rr)
  {
  this.FRWheelPivot.rotateAngleX = Trig.toDegrees(fr);
  this.FLWheelPivot.rotateAngleX = Trig.toDegrees(fl);
  this.RRWheelPivot.rotateAngleX = Trig.toDegrees(rr);
  this.RLWheelPivot.rotateAngleX = Trig.toDegrees(rl);
  }

@Override
public void renderFlag(int color)
  {
  // TODO Auto-generated method stub
  
  }
}
