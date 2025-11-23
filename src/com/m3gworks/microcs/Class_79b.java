package com.m3gworks.microcs; 
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import javax.microedition.m3g.World;

public abstract class Class_79b {
   public int var_6c;
   public String var_de;
   public int var_140;
   public static float var_1af = 0.5F;
   public static float var_1ee = 8.0F;
   public int var_1fa = 0;
   public Class_719 var_255;
   public BoundingSphere var_284 = new BoundingSphere();
   private BoundingSphere var_2d1 = new BoundingSphere(new float[3], 0.0F);
   public float var_329 = 0.0F;
   public float var_34f = 0.0F;
   public boolean var_37b = true;

   public Class_79b(int var1, String var2, int var3) {
      this.var_6c = var1;
      this.var_de = var2;
      this.var_140 = var3;
   }

   public abstract void initialize(World var1);

   public void reset() {
      this.var_255.sub_1c();
      this.var_255 = null;
      this.var_284 = null;
      this.var_2d1 = null;
   }

   public abstract float sub_93();

   public abstract float sub_e9(float var1);

   public abstract float sub_118(float var1);

   public abstract float sub_166(float var1);

   public abstract float sub_19a(float var1);

   public abstract void sub_3a();

   public void respawn() {
      this.var_329 = 0.0F;
      this.var_34f = 0.0F;
      float[] var1 = MapLoader.sub_41().sub_347().spawnPoints;
      int var2 = (this.var_6c - 1) * 3;
      this.var_255.var_bf.setTranslation(var1[var2], var1[var2 + 1], var1[var2 + 2]);
      this.sub_4e();
   }

   public final void sub_4e() {
      float[] var1 = MapLoader.sub_41().sub_347().spawnPoints;
      int var2 = (this.var_6c - 1) * 3;
      this.var_284.var_f1 = this.sub_93();
      this.var_284.sub_48(var1[var2], 0.0F, var1[var2 + 2]);
   }

   public final void sub_af(float[] var1) {
      float[] var2;
      float[] var10000 = var2 = this.var_284.var_44;
      var10000[0] += var1[0];
      var2[1] += var1[1];
      var2[2] += var1[2];
   }

   public final BoundingSphere sub_dd(float[] var1) {
      float[] var2 = this.var_284.var_44;
      this.var_2d1.var_44[0] = var2[0] + var1[0];
      this.var_2d1.var_44[1] = var2[1] + var1[1];
      this.var_2d1.var_44[2] = var2[2] + var1[2];
      this.var_2d1.var_f1 = this.var_284.var_f1;
      return this.var_2d1;
   }

   public Class_79b findPlayerInRadius(BoundingSphere var1) {
      Class_79b var2 = null;
      Hashtable var3;
      Enumeration var4 = (var3 = Class_497.sub_33().var_52).keys();

      while(var4.hasMoreElements()) {
         Integer var5 = (Integer)var4.nextElement();
         Class_79b var6;
         if ((var6 = (Class_79b)var3.get(var5)) != this && var6.var_284.sub_1b(var1)) {
            var2 = var6;
            break;
         }
      }

      return var2;
   }

   public final boolean sub_10e(Class_79b var1) {
      float[] var2 = var1.sub_1f9();
      float[] var3 = this.sub_1f9();
      float[] var4 = new float[]{var2[0] - var3[0], 0.0F, var2[2] - var3[2]};
      float[] var5 = MapLoader.sub_41().var_1a7;
      float var6;
      int var7 = (var6 = (var2[2] - var5[1]) / 20.0F) < 1.0F ? 0 : (int)Math.floor((double)var6);
      float var8;
      int var9 = (var8 = (var2[0] - var5[0]) / 20.0F) < 1.0F ? 0 : (int)Math.floor((double)var8);
      float var10;
      int var11 = (var10 = (var3[2] - var5[1]) / 20.0F) < 1.0F ? 0 : (int)Math.floor((double)var10);
      float var12;
      int var13 = (var12 = (var3[0] - var5[0]) / 20.0F) < 1.0F ? 0 : (int)Math.floor((double)var12);
      float[] var14;
      float[] var15 = MathUtils.normalizeVector(var14 = new float[]{(float)(var9 - var13), 0.0F, (float)(var7 - var11)});
      float[] var16 = new float[]{var15[0] * 20.0F / 2.0F, 0.0F, var15[2] * 20.0F / 2.0F};
      int var17 = -1;
      int var18 = -1;
      int var19 = 0;

      while(true) {
         float[] var10000 = new float[]{var3[0], this.var_284.var_f1 / 2.0F, var3[2]};
         int var21;
         int var22;
         if (var19 == 0) {
            var21 = var13;
            var22 = var11;
         } else {
            float var23 = var3[0] + (float)var19 * var16[0];
            float var24 = var3[2] + (float)var19 * var16[2];
            if (var4[0] >= 0.0F) {
               if (var23 > var2[0]) {
                  break;
               }
            } else if (var23 < var2[0]) {
               break;
            }

            if (var4[2] >= 0.0F) {
               if (var24 > var2[2]) {
                  break;
               }
            } else if (var24 < var2[2]) {
               break;
            }

            float var25;
            var22 = (var25 = (var24 - var5[1]) / 20.0F) < 1.0F ? 0 : (int)Math.floor((double)var25);
            float var26;
            var21 = (var26 = (var23 - var5[0]) / 20.0F) < 1.0F ? 0 : (int)Math.floor((double)var26);
         }

         ++var19;
         if (var21 != var17 || var22 != var18) {
            Vector var27;
            if ((var27 = MapLoader.sub_41().var_1dc[var22][var21]) != null) {
               for(int var28 = 0; var28 < var27.size(); ++var28) {
                  if (((BoundingBox)var27.elementAt(var28)).sub_112(var3, var4)) {
                     return true;
                  }
               }
            }

            if (var14[0] == 0.0F && var14[2] == 0.0F) {
               break;
            }

            var17 = var21;
            var18 = var22;
         }
      }

      return false;
   }

   public final boolean sub_126(Class_79b var1) {
      float[] var2 = var1.sub_1f9();
      return this.sub_15c(var2[0], var2[2]);
   }

   public final boolean sub_15c(float var1, float var2) {
      float[] var3 = this.sub_1f9();
      float[] var4 = new float[]{var1 - var3[0], 0.0F, var2 - var3[2]};
      float[] var5;
      return !((float)Math.toDegrees((double)((float) MathUtilsArcSin.asin((double) MathUtils.dotProduct(var5 = this.sub_175(1, 1.0F), var4) / (Math.sqrt((double)(var5[0] * var5[0] + var5[1] * var5[1] + var5[2] * var5[2])) * Math.sqrt((double)(var4[0] * var4[0] + var4[1] * var4[1] + var4[2] * var4[2])))))) > 40.0F);
   }

   public final float[] sub_175(int var1, float var2) {
      float var3 = 0.0F;
      switch(var1) {
      case 1:
         var3 = this.var_34f + 180.0F;
         break;
      case 2:
         var3 = this.var_34f;
         break;
      case 3:
         var3 = this.var_34f - 90.0F;
         break;
      case 4:
         var3 = this.var_34f + 90.0F;
      }

      float[] var4 = new float[3];
      double var5 = Math.sin(Math.toRadians((double)var3));
      double var7;
      double var9;
      if (Math.abs(var7 = Math.cos(Math.toRadians((double)var3))) == 1.0D) {
         var4[0] = 0.0F;
         var9 = (double)var2;
         var4[2] = (float)(var9 * var7);
         var4[1] = 0.0F;
      } else if (Math.abs(var5) == 1.0D) {
         var4[2] = 0.0F;
         var9 = (double)var2;
         var4[0] = (float)(var9 * var5);
         var4[1] = 0.0F;
      } else {
         var9 = (double)var2;
         var4[0] = (float)(var9 * var5);
         var4[2] = (float)(var9 * var7);
         var4[1] = 0.0F;
      }

      return var4;
   }

   public final BoundingBox sub_1d9(float[] var1) {
      MapLoader.sub_41();
      BoundingSphere var3 = this.sub_dd(var1);
      BoundingSphere var4 = new BoundingSphere(var3.var_44, var3.var_f1 * 2.0F);
      float[] var5 = this.var_284.var_44;
      float var6 = var4.var_f1;
      float var7 = var5[0] - var6;
      float var8 = var5[2] - var6;
      float var9 = var5[0] + var6;
      float var10 = var5[2] + var6;
      float[] var11 = MapLoader.sub_41().var_1a7;
      float var12;
      int var13 = (var12 = (var8 - var11[1]) / 20.0F) < 1.0F ? 0 : (int)Math.floor((double)var12);
      float var14;
      int var15 = (var14 = (var7 - var11[0]) / 20.0F) < 1.0F ? 0 : (int)Math.floor((double)var14);
      float var16;
      int var17 = (var16 = (var10 - var11[1]) / 20.0F) < 1.0F ? 0 : (int)Math.floor((double)var16);
      float var18;
      int var19 = (var18 = (var9 - var11[0]) / 20.0F) < 1.0F ? 0 : (int)Math.floor((double)var18);
      Vector[][] var20 = MapLoader.sub_41().var_1dc;

      for(int var21 = var13; var21 <= var17; ++var21) {
         for(int var22 = var15; var22 <= var19; ++var22) {
            if (var21 >= var20.length || var22 >= var20[var21].length) {
               return null;
            }

            if (var20[var21][var22] != null) {
               Vector var23 = var20[var21][var22];

               for(int var24 = 0; var24 < var23.size(); ++var24) {
                  BoundingBox var25;
                  if ((var25 = (BoundingBox)var23.elementAt(var24)).sub_57(var4)) {
                     return var25;
                  }
               }
            }
         }
      }

      return null;
   }

   public final float[] sub_1f9() {
      float[] var1 = new float[3];
      this.var_255.var_bf.getTranslation(var1);
      return var1;
   }
}
