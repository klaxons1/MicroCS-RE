package com.m3gworks.microcs; 
import java.util.Vector;
import javax.microedition.m3g.Camera;
import javax.microedition.m3g.Image2D;
import javax.microedition.m3g.Node;
import javax.microedition.m3g.RayIntersection;
import javax.microedition.m3g.Transform;
import javax.microedition.m3g.World;

public final class Class_7ee {
   private static Class_7ee var_58;
   private static Image2D[] var_bd;
   private static Image2D[] var_e8;
   private static Image2D[] var_127;
   private static Image2D[] var_15a;
   private Vector var_171;
   private Vector var_1aa;
   private Vector var_1d4;
   private Vector var_20b;

   private Class_7ee() {
   }

   public static Class_7ee sub_2e() {
      if (var_58 == null) {
         var_58 = new Class_7ee();
      }

      return var_58;
   }

   public static void sub_7f() {
      var_bd = ResourceLoader.loadSpriteSheet("/res/image2d/bloodspray.png", 4, 32);
      if (GameConfig.sub_17().hasSound()) {
         var_e8 = ResourceLoader.loadSpriteSheet("/res/image2d/smokepuff.png", 4, 32);
      }

      if (GameConfig.sub_17().sub_a5()) {
         var_127 = ResourceLoader.loadSpriteSheet("/res/image2d/wallsplash.png", 4, 32);
      }

      var_15a = ResourceLoader.loadSpriteSheet("/res/image2d/explosion.png", 6, 64);
   }

   public final void sub_e3(int var1, RayIntersection var2, World var3, Camera var4) {
      Vector var5 = null;
      Image2D[] var6 = (Image2D[])null;
      float var7 = 1.0F;
      if (this.var_171 == null) {
         this.var_171 = new Vector();
      }

      if (this.var_1aa == null) {
         this.var_1aa = new Vector();
      }

      if (this.var_1d4 == null) {
         this.var_1d4 = new Vector();
      }

      if (var1 == 1) {
         var5 = this.var_171;
         var6 = var_bd;
         var7 = 16.0F;
      } else if (var1 == 2) {
         var5 = this.var_1aa;
         var6 = var_e8;
         var7 = 6.0F;
      } else if (var1 == 3) {
         var5 = this.var_1d4;
         var6 = var_127;
         var7 = 16.0F;
      }

      Class_56b var8 = null;

      for(int var9 = 0; var9 < var5.size(); ++var9) {
         Class_56b var11;
         if (!(var11 = (Class_56b)var5.elementAt(var9)).var_136) {
            var8 = var11;
            break;
         }
      }

      if (var8 == null) {
         Class_56b var14 = null;
         if (var5.size() > 0) {
            var14 = (Class_56b)var5.elementAt(0);
         }

         if (var14 != null) {
            var8 = new Class_56b(var14.var_1a, var14.var_b2, var4);
         } else {
            var8 = new Class_56b(var6, var4, var7);
         }

         var3.addChild(var8.var_1a);
         var5.addElement(var8);
      }

      var8.sub_eb(true);
      float var15 = 0.0F;
      float var10 = 0.0F;
      float var16 = 0.0F;
      if (var2 != null) {
         float var12 = var2.getDistance();
         float[] var13 = new float[6];
         var2.getRay(var13);
         var15 = var13[0] + var13[3] * var12;
         var10 = var13[1] + var13[4] * var12;
         var16 = var13[2] + var13[5] * var12;
      }

      var8.sub_be(var15, var10, var16);
      if (var1 == 2) {
         sub_131(var8, var2, var3);
      }

   }

   private static void sub_131(Class_56b var0, RayIntersection var1, World var2) {
      float var3 = var1.getNormalX();
      float var4 = var1.getNormalY();
      float var5 = var1.getNormalZ();
      Node var6 = var1.getIntersected();
      Transform var7 = new Transform();
      var6.getTransformTo(var2, var7);
      float[] var8 = new float[]{var3, var4, var5, 0.0F};
      var7.transform(var8);
      float[] var9;
      (var9 = new float[3])[0] = var8[0];
      var9[1] = var8[1];
      var9[2] = var8[2];
      float[] var10 = new float[6];
      var1.getRay(var10);
      float[] var11 = new float[]{var10[3], var10[4], var10[5]};
      if (MathUtils.dotProduct(var9, var11) > 0.0F) {
         var9[0] = -var9[0];
         var9[1] = -var9[1];
         var9[2] = -var9[2];
      }

      float var12 = 0.2F;
      float var13 = 0.2F / MathUtils.vectorLength(var9);
      var9[0] *= var13;
      var9[1] = var9[1] * var13 + 0.08F;
      var9[2] *= var13;
      var0.sub_178(var9);
   }

   public final void sub_13d(float[] var1, World var2, Camera var3) {
      if (this.var_20b == null) {
         this.var_20b = new Vector();
      }

      Class_56b var4 = null;

      for(int var5 = 0; var5 < this.var_20b.size(); ++var5) {
         Class_56b var7;
         if (!(var7 = (Class_56b)this.var_20b.elementAt(var5)).var_136) {
            var4 = var7;
            break;
         }
      }

      if (var4 == null) {
         var4 = new Class_56b(var_15a, var3, 32.0F);
         var2.addChild(var4.var_1a);
         this.var_20b.addElement(var4);
      }

      var4.sub_eb(true);
      var4.sub_be(var1[0], var1[1], var1[2]);
   }

   public final void sub_19d() {
      sub_1cb(this.var_171);
      sub_1cb(this.var_1aa);
      sub_1cb(this.var_1d4);
      sub_1cb(this.var_20b);
   }

   private static void sub_1cb(Vector var0) {
      if (var0 != null) {
         for(int var1 = 0; var1 < var0.size(); ++var1) {
            Object var2;
            if ((var2 = var0.elementAt(var1)) != null) {
               Class_56b var3;
               (var3 = (Class_56b)var2).sub_117();
            }
         }
      }

   }

   public final void sub_1fa() {
      this.var_171 = null;
      this.var_1aa = null;
      this.var_1d4 = null;
      this.var_20b = null;
   }

   public static void sub_252() {
      var_bd = null;
      var_e8 = null;
      var_127 = null;
      var_15a = null;
   }
}
