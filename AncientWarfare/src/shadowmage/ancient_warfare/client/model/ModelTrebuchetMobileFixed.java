//auto-generated model template
//template generated by MEIM
//template v 1.0
//author Shadowmage45 (shadowage_catapults@hotmail.com)
 
package shadowmage.ancient_warfare.client.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import shadowmage.ancient_warfare.common.utils.Trig;
 
 
public class ModelTrebuchetMobileFixed extends ModelVehicleBase
{
 
ModelRenderer turretMidBeam;
ModelRenderer upright1;
ModelRenderer upright2;
ModelRenderer turretFrontBeam;
ModelRenderer turretRearBeam;
ModelRenderer turretLeftBeam1;
ModelRenderer turretLeftBeam2;
ModelRenderer turretRightBeam1;
ModelRenderer turretRightBeam2;
ModelRenderer trebuchetAxle;
ModelRenderer trebBeamFront;
ModelRenderer trebuchetWeightAxle;
ModelRenderer trebuchetWeightSide1;
ModelRenderer trebuchetWeight1;
ModelRenderer trebuchetWeightSide2;
ModelRenderer trebuchetArm2;
ModelRenderer trebuchetSlingString;
ModelRenderer trebuchetSlingPouchT3;
ModelRenderer trebuchetRFAngle;
ModelRenderer trebuchetLFAngle;
ModelRenderer trebuchetLeftAngle;
ModelRenderer trebuchetRightAngle;
ModelRenderer trebuchetRRAngle;
ModelRenderer trebuchetLRAngle;
ModelRenderer frontCrossBeam;
ModelRenderer rightBeam;
ModelRenderer pivotCrossBeam;
ModelRenderer rearCrossBeam;
ModelRenderer rearAxle;
ModelRenderer RRWheelPivot;
ModelRenderer RRS4;
ModelRenderer RRS2;
ModelRenderer RRS3;
ModelRenderer RRw1;
ModelRenderer RRw2;
ModelRenderer RRw3;
ModelRenderer RRw8;
ModelRenderer RRw7;
ModelRenderer RRw6;
ModelRenderer RRw4;
ModelRenderer RRw5;
ModelRenderer RLWheelPivot;
ModelRenderer RLS2;
ModelRenderer RLS3;
ModelRenderer RLS4;
ModelRenderer RLw1;
ModelRenderer RLw2;
ModelRenderer RLw3;
ModelRenderer RLw8;
ModelRenderer RLw7;
ModelRenderer RLw6;
ModelRenderer RLw5;
ModelRenderer RLw4;
ModelRenderer leftBeam;
ModelRenderer frontAxle;
ModelRenderer FRWheelPivot;
ModelRenderer FRS2;
ModelRenderer FRS3;
ModelRenderer FRS4;
ModelRenderer frw1;
ModelRenderer Frw4;
ModelRenderer FLr5;
ModelRenderer Frw6;
ModelRenderer Frw7;
ModelRenderer Frw8;
ModelRenderer Frw3;
ModelRenderer Frw2;
ModelRenderer FLWheelPivot;
ModelRenderer FLw3;
ModelRenderer FLw2;
ModelRenderer FS4;
ModelRenderer FLS2;
ModelRenderer FS3;
ModelRenderer flw1;
ModelRenderer FLw4;
ModelRenderer FLw5;
ModelRenderer FLw6;
ModelRenderer FLw7;
ModelRenderer FLw8;
ModelRenderer chairBrace;
ModelRenderer chairBottom;
ModelRenderer chairBack;
ModelRenderer flagPole;
ModelRenderer flagCloth;
public ModelTrebuchetMobileFixed(){
  turretMidBeam = new ModelRenderer(this,"turretMidBeam");
  turretMidBeam.setTextureOffset(0,128);
  turretMidBeam.setTextureSize(256,256);
  turretMidBeam.setRotationPoint(0.0f, -12.0f, 0.0f);
  setPieceRotation(turretMidBeam,0.0f, 0.0f, 0.0f);
  turretMidBeam.addBox(-21.0f,-1.0f,-1.5f,42,2,3);
  upright1 = new ModelRenderer(this,"upright1");
  upright1.setTextureOffset(0,140);
  upright1.setTextureSize(256,256);
  upright1.setRotationPoint(-6.0f, -1.0f, -1.5f);
  setPieceRotation(upright1,0.0f, 0.0f, 0.0f);
  upright1.addBox(-2.5f,-33.0f,0.0f,3,33,3);
  turretMidBeam.addChild(upright1);
  upright2 = new ModelRenderer(this,"upright2");
  upright2.setTextureOffset(0,140);
  upright2.setTextureSize(256,256);
  upright2.setRotationPoint(5.0f, -1.0f, -1.5f);
  setPieceRotation(upright2,1.4564162E-8f, 0.0f, 1.0402973E-9f);
  upright2.addBox(0.5f,-33.0f,0.0f,3,33,3);
  turretMidBeam.addChild(upright2);
  turretFrontBeam = new ModelRenderer(this,"turretFrontBeam");
  turretFrontBeam.setTextureOffset(0,134);
  turretFrontBeam.setTextureSize(256,256);
  turretFrontBeam.setRotationPoint(0.0f, 0.0f, -18.0f);
  setPieceRotation(turretFrontBeam,0.0f, 0.0f, 0.0f);
  turretFrontBeam.addBox(-15.0f,-1.0f,-1.5f,30,2,3);
  turretMidBeam.addChild(turretFrontBeam);
  turretRearBeam = new ModelRenderer(this,"turretRearBeam");
  turretRearBeam.setTextureOffset(0,134);
  turretRearBeam.setTextureSize(256,256);
  turretRearBeam.setRotationPoint(0.0f, 0.0f, 18.0f);
  setPieceRotation(turretRearBeam,0.0f, 0.0f, 0.0f);
  turretRearBeam.addBox(-15.0f,-1.0f,-1.5f,30,2,3);
  turretMidBeam.addChild(turretRearBeam);
  turretLeftBeam1 = new ModelRenderer(this,"turretLeftBeam1");
  turretLeftBeam1.setTextureOffset(13,140);
  turretLeftBeam1.setTextureSize(256,256);
  turretLeftBeam1.setRotationPoint(12.0f, 0.0f, -16.5f);
  setPieceRotation(turretLeftBeam1,0.0f, 0.0f, 0.0f);
  turretLeftBeam1.addBox(0.0f,-1.0f,0.0f,3,2,15);
  turretMidBeam.addChild(turretLeftBeam1);
  turretLeftBeam2 = new ModelRenderer(this,"turretLeftBeam2");
  turretLeftBeam2.setTextureOffset(13,140);
  turretLeftBeam2.setTextureSize(256,256);
  turretLeftBeam2.setRotationPoint(12.0f, 0.0f, 1.5f);
  setPieceRotation(turretLeftBeam2,0.0f, 0.0f, 0.0f);
  turretLeftBeam2.addBox(0.0f,-1.0f,0.0f,3,2,15);
  turretMidBeam.addChild(turretLeftBeam2);
  turretRightBeam1 = new ModelRenderer(this,"turretRightBeam1");
  turretRightBeam1.setTextureOffset(13,140);
  turretRightBeam1.setTextureSize(256,256);
  turretRightBeam1.setRotationPoint(-15.0f, 0.0f, -16.5f);
  setPieceRotation(turretRightBeam1,0.0f, 0.0f, 0.0f);
  turretRightBeam1.addBox(0.0f,-1.0f,0.0f,3,2,15);
  turretMidBeam.addChild(turretRightBeam1);
  turretRightBeam2 = new ModelRenderer(this,"turretRightBeam2");
  turretRightBeam2.setTextureOffset(13,140);
  turretRightBeam2.setTextureSize(256,256);
  turretRightBeam2.setRotationPoint(-15.0f, 0.0f, 1.5f);
  setPieceRotation(turretRightBeam2,0.0f, 0.0f, 0.0f);
  turretRightBeam2.addBox(0.0f,-1.0f,0.0f,3,2,15);
  turretMidBeam.addChild(turretRightBeam2);
  trebuchetAxle = new ModelRenderer(this,"trebuchetAxle");
  trebuchetAxle.setTextureOffset(67,134);
  trebuchetAxle.setTextureSize(256,256);
  trebuchetAxle.setRotationPoint(0.0f, -33.0f, 0.0f);
  setPieceRotation(trebuchetAxle,0.0f, 0.0f, 0.0f);
  trebuchetAxle.addBox(-6.0f,-0.5f,-0.5f,12,1,1);
  trebBeamFront = new ModelRenderer(this,"trebBeamFront");
  trebBeamFront.setTextureOffset(94,128);
  trebBeamFront.setTextureSize(256,256);
  trebBeamFront.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(trebBeamFront,0.0f, 0.0f, 0.0f);
  trebBeamFront.addBox(-1.5f,-1.5f,-10.5f,3,3,40);
  trebuchetWeightAxle = new ModelRenderer(this,"trebuchetWeightAxle");
  trebuchetWeightAxle.setTextureOffset(67,137);
  trebuchetWeightAxle.setTextureSize(256,256);
  trebuchetWeightAxle.setRotationPoint(0.0f, 0.0f, -9.0f);
  setPieceRotation(trebuchetWeightAxle,0.0f, 0.0f, 0.0f);
  trebuchetWeightAxle.addBox(-3.5f,-0.5f,-0.5f,7,1,1);
  trebuchetWeightSide1 = new ModelRenderer(this,"trebuchetWeightSide1");
  trebuchetWeightSide1.setTextureOffset(50,140);
  trebuchetWeightSide1.setTextureSize(256,256);
  trebuchetWeightSide1.setRotationPoint(-3.0f, 0.0f, 0.0f);
  setPieceRotation(trebuchetWeightSide1,0.0f, 0.0f, 0.0f);
  trebuchetWeightSide1.addBox(0.0f,-2.0f,-1.0f,1,7,2);
  trebuchetWeight1 = new ModelRenderer(this,"trebuchetWeight1");
  trebuchetWeight1.setTextureOffset(13,158);
  trebuchetWeight1.setTextureSize(256,256);
  trebuchetWeight1.setRotationPoint(0.0f, 5.0f, 0.0f);
  setPieceRotation(trebuchetWeight1,-1.0402973E-9f, 0.0f, 0.0f);
  trebuchetWeight1.addBox(-2.0f,0.0f,-6.0f,10,15,12);
  trebuchetWeightSide1.addChild(trebuchetWeight1);
  trebuchetWeightAxle.addChild(trebuchetWeightSide1);
  trebuchetWeightSide2 = new ModelRenderer(this,"trebuchetWeightSide2");
  trebuchetWeightSide2.setTextureOffset(50,140);
  trebuchetWeightSide2.setTextureSize(256,256);
  trebuchetWeightSide2.setRotationPoint(2.0f, 0.0f, 0.0f);
  setPieceRotation(trebuchetWeightSide2,0.0f, 0.0f, 0.0f);
  trebuchetWeightSide2.addBox(0.0f,-2.0f,-1.0f,1,7,2);
  trebuchetWeightAxle.addChild(trebuchetWeightSide2);
  trebBeamFront.addChild(trebuchetWeightAxle);
  trebuchetArm2 = new ModelRenderer(this,"trebuchetArm2");
  trebuchetArm2.setTextureOffset(94,172);
  trebuchetArm2.setTextureSize(256,256);
  trebuchetArm2.setRotationPoint(0.0f, -1.0f, 28.5f);
  setPieceRotation(trebuchetArm2,0.0f, 0.0f, 0.0f);
  trebuchetArm2.addBox(-1.0f,0.0f,0.0f,2,2,40);
  trebuchetSlingString = new ModelRenderer(this,"trebuchetSlingString");
  trebuchetSlingString.setTextureOffset(58,140);
  trebuchetSlingString.setTextureSize(256,256);
  trebuchetSlingString.setRotationPoint(0.0f, 1.0f, 39.0f);
  setPieceRotation(trebuchetSlingString,0.0f, -1.0402973E-9f, 0.0f);
  trebuchetSlingString.addBox(-0.5f,-0.5f,-0.5f,1,24,1);
  trebuchetSlingPouchT3 = new ModelRenderer(this,"trebuchetSlingPouchT3");
  trebuchetSlingPouchT3.setTextureOffset(63,149);
  trebuchetSlingPouchT3.setTextureSize(256,256);
  trebuchetSlingPouchT3.setRotationPoint(0.0f, 23.0f, 0.0f);
  setPieceRotation(trebuchetSlingPouchT3,0.0f, 0.0f, 0.0f);
  trebuchetSlingPouchT3.addBox(-3.0f,-2.0f,-3.0f,6,6,6);
  trebuchetSlingString.addChild(trebuchetSlingPouchT3);
  trebuchetArm2.addChild(trebuchetSlingString);
  trebBeamFront.addChild(trebuchetArm2);
  trebuchetAxle.addChild(trebBeamFront);
  turretMidBeam.addChild(trebuchetAxle);
  trebuchetRFAngle = new ModelRenderer(this,"trebuchetRFAngle");
  trebuchetRFAngle.setTextureOffset(0,177);
  trebuchetRFAngle.setTextureSize(256,256);
  trebuchetRFAngle.setRotationPoint(-8.0f, -33.0f, 0.0f);
  setPieceRotation(trebuchetRFAngle,-0.5061452f, 0.366519f, 0.0f);
  trebuchetRFAngle.addBox(0.0f,0.0f,-1.0f,2,38,2);
  turretMidBeam.addChild(trebuchetRFAngle);
  trebuchetLFAngle = new ModelRenderer(this,"trebuchetLFAngle");
  trebuchetLFAngle.setTextureOffset(0,177);
  trebuchetLFAngle.setTextureSize(256,256);
  trebuchetLFAngle.setRotationPoint(8.0f, -33.0f, 0.0f);
  setPieceRotation(trebuchetLFAngle,-0.5061452f, -0.36651903f, 0.0f);
  trebuchetLFAngle.addBox(-2.0f,0.0f,-1.0f,2,38,2);
  turretMidBeam.addChild(trebuchetLFAngle);
  trebuchetLeftAngle = new ModelRenderer(this,"trebuchetLeftAngle");
  trebuchetLeftAngle.setTextureOffset(0,218);
  trebuchetLeftAngle.setTextureSize(256,256);
  trebuchetLeftAngle.setRotationPoint(8.0f, -34.0f, 1.0f);
  setPieceRotation(trebuchetLeftAngle,5.0558447E-7f, 0.0f, -0.34906563f);
  trebuchetLeftAngle.addBox(-2.0f,0.0f,-2.0f,2,36,2);
  turretMidBeam.addChild(trebuchetLeftAngle);
  trebuchetRightAngle = new ModelRenderer(this,"trebuchetRightAngle");
  trebuchetRightAngle.setTextureOffset(0,218);
  trebuchetRightAngle.setTextureSize(256,256);
  trebuchetRightAngle.setRotationPoint(-8.0f, -34.0f, 1.0f);
  setPieceRotation(trebuchetRightAngle,5.0558447E-7f, 0.0f, 0.34906584f);
  trebuchetRightAngle.addBox(0.0f,0.0f,-2.0f,2,36,2);
  turretMidBeam.addChild(trebuchetRightAngle);
  trebuchetRRAngle = new ModelRenderer(this,"trebuchetRRAngle");
  trebuchetRRAngle.setTextureOffset(0,177);
  trebuchetRRAngle.setTextureSize(256,256);
  trebuchetRRAngle.setRotationPoint(-8.0f, -33.0f, 0.0f);
  setPieceRotation(trebuchetRRAngle,0.5061455f, -0.36651894f, -1.2483568E-8f);
  trebuchetRRAngle.addBox(0.0f,0.0f,-1.0f,2,38,2);
  turretMidBeam.addChild(trebuchetRRAngle);
  trebuchetLRAngle = new ModelRenderer(this,"trebuchetLRAngle");
  trebuchetLRAngle.setTextureOffset(0,177);
  trebuchetLRAngle.setTextureSize(256,256);
  trebuchetLRAngle.setRotationPoint(8.0f, -33.0f, 0.0f);
  setPieceRotation(trebuchetLRAngle,0.5061455f, 0.34906572f, 0.0f);
  trebuchetLRAngle.addBox(-2.0f,0.0f,-1.0f,2,38,2);
  turretMidBeam.addChild(trebuchetLRAngle);
  frontCrossBeam = new ModelRenderer(this,"frontCrossBeam");
  frontCrossBeam.setTextureOffset(0,0);
  frontCrossBeam.setTextureSize(256,256);
  frontCrossBeam.setRotationPoint(-12.0f, -11.0f, -19.0f);
  setPieceRotation(frontCrossBeam,0.0f, 0.0f, 0.0f);
  frontCrossBeam.addBox(0.0f,0.0f,-0.5f,24,3,3);
  rightBeam = new ModelRenderer(this,"rightBeam");
  rightBeam.setTextureOffset(0,7);
  rightBeam.setTextureSize(256,256);
  rightBeam.setRotationPoint(-3.0f, 0.0f, 0.0f);
  setPieceRotation(rightBeam,0.0f, 0.0f, 0.0f);
  rightBeam.addBox(0.0f,0.0f,-5.0f,3,3,48);
  frontCrossBeam.addChild(rightBeam);
  pivotCrossBeam = new ModelRenderer(this,"pivotCrossBeam");
  pivotCrossBeam.setTextureOffset(0,0);
  pivotCrossBeam.setTextureSize(256,256);
  pivotCrossBeam.setRotationPoint(0.0f, 0.0f, 17.5f);
  setPieceRotation(pivotCrossBeam,0.0f, 0.0f, 0.0f);
  pivotCrossBeam.addBox(0.0f,0.0f,0.0f,24,3,3);
  frontCrossBeam.addChild(pivotCrossBeam);
  rearCrossBeam = new ModelRenderer(this,"rearCrossBeam");
  rearCrossBeam.setTextureOffset(0,0);
  rearCrossBeam.setTextureSize(256,256);
  rearCrossBeam.setRotationPoint(0.0f, 0.0f, 35.5f);
  setPieceRotation(rearCrossBeam,0.0f, 0.0f, 0.0f);
  rearCrossBeam.addBox(0.0f,0.0f,0.0f,24,3,3);
  rearAxle = new ModelRenderer(this,"rearAxle");
  rearAxle.setTextureOffset(0,59);
  rearAxle.setTextureSize(256,256);
  rearAxle.setRotationPoint(12.0f, 3.0f, 1.5f);
  setPieceRotation(rearAxle,1.3773537E-6f, 0.0f, 0.0f);
  rearAxle.addBox(-17.0f,-0.5f,-0.5f,34,1,1);
  RRWheelPivot = new ModelRenderer(this,"RRWheelPivot");
  RRWheelPivot.setTextureOffset(0,62);
  RRWheelPivot.setTextureSize(256,256);
  RRWheelPivot.setRotationPoint(-17.0f, 0.0f, 0.0f);
  setPieceRotation(RRWheelPivot,0.0f, 0.0f, 0.0f);
  RRWheelPivot.addBox(-0.5f,-7.0f,-0.5f,1,14,1);
  RRS4 = new ModelRenderer(this,"RRS4");
  RRS4.setTextureOffset(23,62);
  RRS4.setTextureSize(256,256);
  RRS4.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(RRS4,0.0f, 0.0f, 0.0f);
  RRS4.addBox(-0.5f,-0.5f,-7.0f,1,1,14);
  RRWheelPivot.addChild(RRS4);
  RRS2 = new ModelRenderer(this,"RRS2");
  RRS2.setTextureOffset(23,62);
  RRS2.setTextureSize(256,256);
  RRS2.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(RRS2,0.7853982f, 0.0f, 0.0f);
  RRS2.addBox(-0.5f,-0.5f,-7.0f,1,1,14);
  RRWheelPivot.addChild(RRS2);
  RRS3 = new ModelRenderer(this,"RRS3");
  RRS3.setTextureOffset(23,62);
  RRS3.setTextureSize(256,256);
  RRS3.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(RRS3,-0.7853982f, 0.0f, 0.0f);
  RRS3.addBox(-0.5f,-0.5f,-7.0f,1,1,14);
  RRWheelPivot.addChild(RRS3);
  RRw1 = new ModelRenderer(this,"RRw1");
  RRw1.setTextureOffset(0,84);
  RRw1.setTextureSize(256,256);
  RRw1.setRotationPoint(-1.0f, -8.0f, -3.0f);
  setPieceRotation(RRw1,0.0f, 0.0f, 0.0f);
  RRw1.addBox(0.0f,0.0f,0.0f,2,1,6);
  RRWheelPivot.addChild(RRw1);
  RRw2 = new ModelRenderer(this,"RRw2");
  RRw2.setTextureOffset(0,75);
  RRw2.setTextureSize(256,256);
  RRw2.setRotationPoint(-1.0f, -8.0f, 3.0f);
  setPieceRotation(RRw2,-0.7853982f, 0.0f, 0.0f);
  RRw2.addBox(0.0f,0.0f,0.0f,2,1,7);
  RRWheelPivot.addChild(RRw2);
  RRw3 = new ModelRenderer(this,"RRw3");
  RRw3.setTextureOffset(0,84);
  RRw3.setTextureSize(256,256);
  RRw3.setRotationPoint(-1.0f, -3.0f, 8.0f);
  setPieceRotation(RRw3,-1.570796f, 0.0f, 0.0f);
  RRw3.addBox(0.0f,0.0f,0.0f,2,1,6);
  RRWheelPivot.addChild(RRw3);
  RRw8 = new ModelRenderer(this,"RRw8");
  RRw8.setTextureOffset(0,75);
  RRw8.setTextureSize(256,256);
  RRw8.setRotationPoint(-1.0f, 3.0f, 8.0f);
  setPieceRotation(RRw8,0.7853982f, 0.0f, 0.0f);
  RRw8.addBox(0.0f,-1.0f,-7.0f,2,1,7);
  RRWheelPivot.addChild(RRw8);
  RRw7 = new ModelRenderer(this,"RRw7");
  RRw7.setTextureOffset(0,84);
  RRw7.setTextureSize(256,256);
  RRw7.setRotationPoint(-1.0f, 7.0f, -3.0f);
  setPieceRotation(RRw7,0.0f, 0.0f, 0.0f);
  RRw7.addBox(0.0f,0.0f,0.0f,2,1,6);
  RRWheelPivot.addChild(RRw7);
  RRw6 = new ModelRenderer(this,"RRw6");
  RRw6.setTextureOffset(0,75);
  RRw6.setTextureSize(256,256);
  RRw6.setRotationPoint(-1.0f, 3.0f, -8.0f);
  setPieceRotation(RRw6,-0.7853982f, 0.0f, 0.0f);
  RRw6.addBox(0.0f,-1.0f,0.0f,2,1,7);
  RRWheelPivot.addChild(RRw6);
  RRw4 = new ModelRenderer(this,"RRw4");
  RRw4.setTextureOffset(0,75);
  RRw4.setTextureSize(256,256);
  RRw4.setRotationPoint(-1.0f, -8.0f, -3.0f);
  setPieceRotation(RRw4,0.7853982f, 0.0f, 0.0f);
  RRw4.addBox(0.0f,0.0f,-7.0f,2,1,7);
  RRWheelPivot.addChild(RRw4);
  RRw5 = new ModelRenderer(this,"RRw5");
  RRw5.setTextureOffset(0,84);
  RRw5.setTextureSize(256,256);
  RRw5.setRotationPoint(-1.0f, -3.0f, -8.0f);
  setPieceRotation(RRw5,1.570796f, 0.0f, 0.0f);
  RRw5.addBox(0.0f,0.0f,-6.0f,2,1,6);
  RRWheelPivot.addChild(RRw5);
  rearAxle.addChild(RRWheelPivot);
  RLWheelPivot = new ModelRenderer(this,"RLWheelPivot");
  RLWheelPivot.setTextureOffset(0,62);
  RLWheelPivot.setTextureSize(256,256);
  RLWheelPivot.setRotationPoint(17.0f, 0.0f, 0.0f);
  setPieceRotation(RLWheelPivot,0.0f, 0.0f, 0.0f);
  RLWheelPivot.addBox(-0.5f,-7.0f,-0.5f,1,14,1);
  RLS2 = new ModelRenderer(this,"RLS2");
  RLS2.setTextureOffset(23,62);
  RLS2.setTextureSize(256,256);
  RLS2.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(RLS2,0.7853982f, 0.0f, 0.0f);
  RLS2.addBox(-0.5f,-0.5f,-7.0f,1,1,14);
  RLWheelPivot.addChild(RLS2);
  RLS3 = new ModelRenderer(this,"RLS3");
  RLS3.setTextureOffset(23,62);
  RLS3.setTextureSize(256,256);
  RLS3.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(RLS3,-0.7853982f, 0.0f, 0.0f);
  RLS3.addBox(-0.5f,-0.5f,-7.0f,1,1,14);
  RLWheelPivot.addChild(RLS3);
  RLS4 = new ModelRenderer(this,"RLS4");
  RLS4.setTextureOffset(23,62);
  RLS4.setTextureSize(256,256);
  RLS4.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(RLS4,0.0f, 0.0f, 0.0f);
  RLS4.addBox(-0.5f,-0.5f,-7.0f,1,1,14);
  RLWheelPivot.addChild(RLS4);
  RLw1 = new ModelRenderer(this,"RLw1");
  RLw1.setTextureOffset(0,84);
  RLw1.setTextureSize(256,256);
  RLw1.setRotationPoint(-1.0f, -8.0f, -3.0f);
  setPieceRotation(RLw1,0.0f, -1.0402973E-9f, 0.0f);
  RLw1.addBox(0.0f,0.0f,0.0f,2,1,6);
  RLWheelPivot.addChild(RLw1);
  RLw2 = new ModelRenderer(this,"RLw2");
  RLw2.setTextureOffset(0,75);
  RLw2.setTextureSize(256,256);
  RLw2.setRotationPoint(-1.0f, -8.0f, 3.0f);
  setPieceRotation(RLw2,-0.7853982f, 0.0f, 0.0f);
  RLw2.addBox(0.0f,0.0f,0.0f,2,1,7);
  RLWheelPivot.addChild(RLw2);
  RLw3 = new ModelRenderer(this,"RLw3");
  RLw3.setTextureOffset(0,84);
  RLw3.setTextureSize(256,256);
  RLw3.setRotationPoint(-1.0f, -3.0f, 8.0f);
  setPieceRotation(RLw3,-1.570796f, 0.0f, 0.0f);
  RLw3.addBox(0.0f,0.0f,0.0f,2,1,6);
  RLWheelPivot.addChild(RLw3);
  RLw8 = new ModelRenderer(this,"RLw8");
  RLw8.setTextureOffset(0,75);
  RLw8.setTextureSize(256,256);
  RLw8.setRotationPoint(-1.0f, 3.0f, 8.0f);
  setPieceRotation(RLw8,0.7853982f, 0.0f, 0.0f);
  RLw8.addBox(0.0f,-1.0f,-7.0f,2,1,7);
  RLWheelPivot.addChild(RLw8);
  RLw7 = new ModelRenderer(this,"RLw7");
  RLw7.setTextureOffset(0,84);
  RLw7.setTextureSize(256,256);
  RLw7.setRotationPoint(-1.0f, 7.0f, -3.0f);
  setPieceRotation(RLw7,0.0f, 0.0f, 0.0f);
  RLw7.addBox(0.0f,0.0f,0.0f,2,1,6);
  RLWheelPivot.addChild(RLw7);
  RLw6 = new ModelRenderer(this,"RLw6");
  RLw6.setTextureOffset(0,75);
  RLw6.setTextureSize(256,256);
  RLw6.setRotationPoint(-1.0f, 3.0f, -8.0f);
  setPieceRotation(RLw6,-0.7853982f, 0.0f, 0.0f);
  RLw6.addBox(0.0f,-1.0f,0.0f,2,1,7);
  RLWheelPivot.addChild(RLw6);
  RLw5 = new ModelRenderer(this,"RLw5");
  RLw5.setTextureOffset(0,84);
  RLw5.setTextureSize(256,256);
  RLw5.setRotationPoint(-1.0f, -3.0f, -8.0f);
  setPieceRotation(RLw5,1.570796f, 0.0f, 0.0f);
  RLw5.addBox(0.0f,0.0f,-6.0f,2,1,6);
  RLWheelPivot.addChild(RLw5);
  RLw4 = new ModelRenderer(this,"RLw4");
  RLw4.setTextureOffset(0,75);
  RLw4.setTextureSize(256,256);
  RLw4.setRotationPoint(-1.0f, -8.0f, -3.0f);
  setPieceRotation(RLw4,0.7853982f, 0.0f, 0.0f);
  RLw4.addBox(0.0f,0.0f,-7.0f,2,1,7);
  RLWheelPivot.addChild(RLw4);
  rearAxle.addChild(RLWheelPivot);
  rearCrossBeam.addChild(rearAxle);
  frontCrossBeam.addChild(rearCrossBeam);
  leftBeam = new ModelRenderer(this,"leftBeam");
  leftBeam.setTextureOffset(0,7);
  leftBeam.setTextureSize(256,256);
  leftBeam.setRotationPoint(24.0f, 0.0f, 0.0f);
  setPieceRotation(leftBeam,0.0f, 0.0f, 0.0f);
  leftBeam.addBox(0.0f,0.0f,-5.0f,3,3,48);
  frontCrossBeam.addChild(leftBeam);
  frontAxle = new ModelRenderer(this,"frontAxle");
  frontAxle.setTextureOffset(0,59);
  frontAxle.setTextureSize(256,256);
  frontAxle.setRotationPoint(12.0f, 3.0f, 1.0f);
  setPieceRotation(frontAxle,0.0f, 0.0f, 0.0f);
  frontAxle.addBox(-17.0f,-0.5f,-0.5f,34,1,1);
  FRWheelPivot = new ModelRenderer(this,"FRWheelPivot");
  FRWheelPivot.setTextureOffset(0,62);
  FRWheelPivot.setTextureSize(256,256);
  FRWheelPivot.setRotationPoint(-17.0f, 0.0f, 0.0f);
  setPieceRotation(FRWheelPivot,0.0f, 0.0f, 0.0f);
  FRWheelPivot.addBox(-0.5f,-7.0f,-0.5f,1,14,1);
  FRS2 = new ModelRenderer(this,"FRS2");
  FRS2.setTextureOffset(23,62);
  FRS2.setTextureSize(256,256);
  FRS2.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(FRS2,0.7853982f, 0.0f, 0.0f);
  FRS2.addBox(-0.5f,-0.5f,-7.0f,1,1,14);
  FRWheelPivot.addChild(FRS2);
  FRS3 = new ModelRenderer(this,"FRS3");
  FRS3.setTextureOffset(23,62);
  FRS3.setTextureSize(256,256);
  FRS3.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(FRS3,-0.7853982f, 0.0f, 0.0f);
  FRS3.addBox(-0.5f,-0.5f,-7.0f,1,1,14);
  FRWheelPivot.addChild(FRS3);
  FRS4 = new ModelRenderer(this,"FRS4");
  FRS4.setTextureOffset(23,62);
  FRS4.setTextureSize(256,256);
  FRS4.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(FRS4,0.0f, 0.0f, 0.0f);
  FRS4.addBox(-0.5f,-0.5f,-7.0f,1,1,14);
  FRWheelPivot.addChild(FRS4);
  frw1 = new ModelRenderer(this,"frw1");
  frw1.setTextureOffset(0,84);
  frw1.setTextureSize(256,256);
  frw1.setRotationPoint(-1.0f, -8.0f, -3.0f);
  setPieceRotation(frw1,0.0f, 0.0f, 0.0f);
  frw1.addBox(0.0f,0.0f,0.0f,2,1,6);
  FRWheelPivot.addChild(frw1);
  Frw4 = new ModelRenderer(this,"Frw4");
  Frw4.setTextureOffset(0,75);
  Frw4.setTextureSize(256,256);
  Frw4.setRotationPoint(-1.0f, -8.0f, -3.0f);
  setPieceRotation(Frw4,0.7853982f, 0.0f, 0.0f);
  Frw4.addBox(0.0f,0.0f,-7.0f,2,1,7);
  FRWheelPivot.addChild(Frw4);
  FLr5 = new ModelRenderer(this,"FLr5");
  FLr5.setTextureOffset(0,84);
  FLr5.setTextureSize(256,256);
  FLr5.setRotationPoint(-1.0f, -3.0f, -8.0f);
  setPieceRotation(FLr5,1.5707958f, 0.0f, 0.0f);
  FLr5.addBox(0.0f,0.0f,-6.0f,2,1,6);
  FRWheelPivot.addChild(FLr5);
  Frw6 = new ModelRenderer(this,"Frw6");
  Frw6.setTextureOffset(0,75);
  Frw6.setTextureSize(256,256);
  Frw6.setRotationPoint(-1.0f, 3.0f, -8.0f);
  setPieceRotation(Frw6,-0.7853982f, 0.0f, 0.0f);
  Frw6.addBox(0.0f,-1.0f,0.0f,2,1,7);
  FRWheelPivot.addChild(Frw6);
  Frw7 = new ModelRenderer(this,"Frw7");
  Frw7.setTextureOffset(0,84);
  Frw7.setTextureSize(256,256);
  Frw7.setRotationPoint(-1.0f, 7.0f, -3.0f);
  setPieceRotation(Frw7,0.0f, 0.0f, 0.0f);
  Frw7.addBox(0.0f,0.0f,0.0f,2,1,6);
  FRWheelPivot.addChild(Frw7);
  Frw8 = new ModelRenderer(this,"Frw8");
  Frw8.setTextureOffset(0,75);
  Frw8.setTextureSize(256,256);
  Frw8.setRotationPoint(-1.0f, 3.0f, 8.0f);
  setPieceRotation(Frw8,0.7853982f, 0.0f, 0.0f);
  Frw8.addBox(0.0f,-1.0f,-7.0f,2,1,7);
  FRWheelPivot.addChild(Frw8);
  Frw3 = new ModelRenderer(this,"Frw3");
  Frw3.setTextureOffset(0,84);
  Frw3.setTextureSize(256,256);
  Frw3.setRotationPoint(-1.0f, -3.0f, 8.0f);
  setPieceRotation(Frw3,-1.570796f, 0.0f, 0.0f);
  Frw3.addBox(0.0f,0.0f,0.0f,2,1,6);
  FRWheelPivot.addChild(Frw3);
  Frw2 = new ModelRenderer(this,"Frw2");
  Frw2.setTextureOffset(0,75);
  Frw2.setTextureSize(256,256);
  Frw2.setRotationPoint(-1.0f, -8.0f, 3.0f);
  setPieceRotation(Frw2,-0.7853982f, 0.0f, 0.0f);
  Frw2.addBox(0.0f,0.0f,0.0f,2,1,7);
  FRWheelPivot.addChild(Frw2);
  frontAxle.addChild(FRWheelPivot);
  FLWheelPivot = new ModelRenderer(this,"FLWheelPivot");
  FLWheelPivot.setTextureOffset(0,62);
  FLWheelPivot.setTextureSize(256,256);
  FLWheelPivot.setRotationPoint(17.0f, 0.0f, 0.0f);
  setPieceRotation(FLWheelPivot,0.0f, 0.0f, 0.0f);
  FLWheelPivot.addBox(-0.5f,-7.0f,-0.5f,1,14,1);
  FLw3 = new ModelRenderer(this,"FLw3");
  FLw3.setTextureOffset(0,84);
  FLw3.setTextureSize(256,256);
  FLw3.setRotationPoint(-1.0f, -3.0f, 8.0f);
  setPieceRotation(FLw3,-1.570796f, 0.0f, 0.0f);
  FLw3.addBox(0.0f,0.0f,0.0f,2,1,6);
  FLWheelPivot.addChild(FLw3);
  FLw2 = new ModelRenderer(this,"FLw2");
  FLw2.setTextureOffset(0,75);
  FLw2.setTextureSize(256,256);
  FLw2.setRotationPoint(-1.0f, -8.0f, 3.0f);
  setPieceRotation(FLw2,-0.7853982f, 0.0f, 0.0f);
  FLw2.addBox(0.0f,0.0f,0.0f,2,1,7);
  FLWheelPivot.addChild(FLw2);
  FS4 = new ModelRenderer(this,"FS4");
  FS4.setTextureOffset(23,62);
  FS4.setTextureSize(256,256);
  FS4.setRotationPoint(0.0f, 0.0f, -0.0f);
  setPieceRotation(FS4,0.0f, 0.0f, 0.0f);
  FS4.addBox(-0.5f,-0.5f,-7.0f,1,1,14);
  FLWheelPivot.addChild(FS4);
  FLS2 = new ModelRenderer(this,"FLS2");
  FLS2.setTextureOffset(23,62);
  FLS2.setTextureSize(256,256);
  FLS2.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(FLS2,0.7853982f, 0.0f, 0.0f);
  FLS2.addBox(-0.5f,-0.5f,-7.0f,1,1,14);
  FLWheelPivot.addChild(FLS2);
  FS3 = new ModelRenderer(this,"FS3");
  FS3.setTextureOffset(23,62);
  FS3.setTextureSize(256,256);
  FS3.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(FS3,-0.7853982f, 0.0f, 0.0f);
  FS3.addBox(-0.5f,-0.5f,-7.0f,1,1,14);
  FLWheelPivot.addChild(FS3);
  flw1 = new ModelRenderer(this,"flw1");
  flw1.setTextureOffset(0,84);
  flw1.setTextureSize(256,256);
  flw1.setRotationPoint(-1.0f, -8.0f, -3.0f);
  setPieceRotation(flw1,0.0f, 0.0f, 0.0f);
  flw1.addBox(0.0f,0.0f,0.0f,2,1,6);
  FLWheelPivot.addChild(flw1);
  FLw4 = new ModelRenderer(this,"FLw4");
  FLw4.setTextureOffset(0,75);
  FLw4.setTextureSize(256,256);
  FLw4.setRotationPoint(-1.0f, -8.0f, -3.0f);
  setPieceRotation(FLw4,0.7853982f, 0.0f, 0.0f);
  FLw4.addBox(0.0f,0.0f,-7.0f,2,1,7);
  FLWheelPivot.addChild(FLw4);
  FLw5 = new ModelRenderer(this,"FLw5");
  FLw5.setTextureOffset(0,84);
  FLw5.setTextureSize(256,256);
  FLw5.setRotationPoint(-1.0f, -3.0f, -8.0f);
  setPieceRotation(FLw5,1.5707955f, 0.0f, 0.0f);
  FLw5.addBox(0.0f,0.0f,-6.0f,2,1,6);
  FLWheelPivot.addChild(FLw5);
  FLw6 = new ModelRenderer(this,"FLw6");
  FLw6.setTextureOffset(0,75);
  FLw6.setTextureSize(256,256);
  FLw6.setRotationPoint(-1.0f, 3.0f, -8.0f);
  setPieceRotation(FLw6,-0.7853982f, 0.0f, 0.0f);
  FLw6.addBox(0.0f,-1.0f,0.0f,2,1,7);
  FLWheelPivot.addChild(FLw6);
  FLw7 = new ModelRenderer(this,"FLw7");
  FLw7.setTextureOffset(0,84);
  FLw7.setTextureSize(256,256);
  FLw7.setRotationPoint(-1.0f, 7.0f, -3.0f);
  setPieceRotation(FLw7,0.0f, 0.0f, 0.0f);
  FLw7.addBox(0.0f,0.0f,0.0f,2,1,6);
  FLWheelPivot.addChild(FLw7);
  FLw8 = new ModelRenderer(this,"FLw8");
  FLw8.setTextureOffset(0,75);
  FLw8.setTextureSize(256,256);
  FLw8.setRotationPoint(-1.0f, 3.0f, 8.0f);
  setPieceRotation(FLw8,0.7853982f, 0.0f, 0.0f);
  FLw8.addBox(0.0f,-1.0f,-7.0f,2,1,7);
  FLWheelPivot.addChild(FLw8);
  frontAxle.addChild(FLWheelPivot);
  frontCrossBeam.addChild(frontAxle);
  chairBrace = new ModelRenderer(this,"chairBrace");
  chairBrace.setTextureOffset(70,59);
  chairBrace.setTextureSize(256,256);
  chairBrace.setRotationPoint(10.5f, -1.5f, 1.0f);
  setPieceRotation(chairBrace,0.0f, 0.0f, 0.0f);
  chairBrace.addBox(0.0f,0.0f,-8.0f,3,1,7);
  chairBottom = new ModelRenderer(this,"chairBottom");
  chairBottom.setTextureOffset(54,68);
  chairBottom.setTextureSize(256,256);
  chairBottom.setRotationPoint(-3.5f, -1.5f, -1.0f);
  setPieceRotation(chairBottom,0.1570796f, 0.0f, 0.0f);
  chairBottom.addBox(0.0f,0.0f,-9.0f,10,1,9);
  chairBrace.addChild(chairBottom);
  chairBack = new ModelRenderer(this,"chairBack");
  chairBack.setTextureOffset(49,79);
  chairBack.setTextureSize(256,256);
  chairBack.setRotationPoint(-3.5f, -1.0f, -1.0f);
  setPieceRotation(chairBack,-0.1745329f, 0.0f, 0.0f);
  chairBack.addBox(0.0f,-10.0f,0.0f,10,10,1);
  chairBrace.addChild(chairBack);
  frontCrossBeam.addChild(chairBrace);
  flagPole = new ModelRenderer(this,"flagPole");
  flagPole.setTextureOffset(19,78);
  flagPole.setTextureSize(256,256);
  flagPole.setRotationPoint(-14.0f, -27.0f, 22.0f);
  setPieceRotation(flagPole,0.0f, 0.0f, 0.0f);
  flagPole.addBox(0.0f,0.0f,0.0f,1,16,1);
  flagCloth = new ModelRenderer(this,"flagCloth");
  flagCloth.setTextureOffset(24,78);
  flagCloth.setTextureSize(256,256);
  flagCloth.setRotationPoint(-14.0f, -27.0f, 23.0f);
  setPieceRotation(flagCloth,3.2249215E-8f, 0.0f, 0.0f);
  flagCloth.addBox(0.0f,0.0f,0.0f,1,8,11);
  setArmRotations(-27.f, -64.f);
  }
 
@Override
public void render(Entity entity, float f1, float f2, float f3, float f4, float f5, float f6)
  {
  super.render(entity, f1, f2, f3, f4, f5, f6);
  setRotationAngles(f1, f2, f3, f4, f5, f6, entity);
  turretMidBeam.render(f6);
  frontCrossBeam.render(f6);
  flagPole.render(f6);
  }
 
public void setPieceRotation(ModelRenderer model, float x, float y, float z)
  {
  model.rotateAngleX = x;
  model.rotateAngleY = y;
  model.rotateAngleZ = z;
  }

public void setArmRotations(float main, float string)
  {
  trebuchetAxle.rotateAngleX = Trig.toRadians(main);
  trebuchetWeightAxle.rotateAngleX = Trig.toRadians(-main);
  trebuchetSlingString.rotateAngleX = Trig.toRadians(string);
  }
public void setWheelRotations(float fl, float fr, float rl, float rr)
  {
  this.FRWheelPivot.rotateAngleX = Trig.toDegrees(fr);
  this.FLWheelPivot.rotateAngleX = Trig.toDegrees(fl);
  this.RRWheelPivot.rotateAngleX = Trig.toDegrees(rr);
  this.RLWheelPivot.rotateAngleX = Trig.toDegrees(rl);
  }

@Override
public void renderFlag()
  {
  flagCloth.render(0.0625f);
  }
}
