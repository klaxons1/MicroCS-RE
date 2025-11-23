package com.m3gworks.microcs;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.microedition.m3g.Image2D;
import javax.microedition.m3g.RayIntersection;
import javax.microedition.m3g.World;

public final class Grenade {
   public Class_79b var_26;
   private static Image2D var_77;
   private static float var_90 = 2.5F;
   private HudElementSprite var_b6;
   private float[] var_c7;
   private float[] var_10a;
   private int var_11d = 0;
   private boolean var_176 = true;

   public Grenade(Class_79b var1) {
      this.var_26 = var1;
   }

   public static void sub_3c() {
      var_77 = ResourceLoader.createImage2D("/res/image2d/grenade.png");
   }

   public final void sub_55(World var1, float[] var2, float[] var3) {
      this.var_176 = false;
      this.var_c7 = var2;
      float[] var4 = MathUtils.normalizeVector(var3);
      this.var_10a = var4;
      this.var_10a[0] *= var_90;
      this.var_10a[1] *= var_90;
      this.var_10a[2] *= var_90;
      this.var_11d = 0;
      if (this.var_b6 == null) {
         this.var_b6 = new HudElementSprite(var_77, var1.getActiveCamera(), var2[0], var2[1], var2[2], 0.3F);
         var1.addChild(this.var_b6.var_53);
         this.var_b6.var_53.setPickingEnable(false);
      }

      this.var_b6.var_53.setTranslation(var2[0], var2[1], var2[2]);
      this.var_b6.var_53.setRenderingEnable(true);
   }

   public final void sub_8a(World var1) {
      if (!this.var_176) {
         float[] var2;
         (var2 = new float[3])[0] = this.var_c7[0] + this.var_10a[0] * (float)this.var_11d;
         float var3 = -0.2F;
         var2[1] = this.var_c7[1] + this.var_10a[1] * (float)this.var_11d + 0.5F * var3 * (float)this.var_11d * (float)this.var_11d;
         var2[2] = this.var_c7[2] + this.var_10a[2] * (float)this.var_11d;
         this.var_b6.var_53.setTranslation(var2[0], var2[1], var2[2]);
         this.var_b6.sub_9e();
         ++this.var_11d;
         float[] var5 = MathUtils.normalizeVector(new float[]{this.var_10a[0], this.var_10a[1] + var3 * (float)this.var_11d, this.var_10a[2]});
         RayIntersection var6 = new RayIntersection();
         var1.pick(-1, var2[0], var2[1], var2[2], var5[0], var5[1], var5[2], var6);
         float var8 = var6.getDistance();
         float[] var9;
         (var9 = new float[3])[0] = this.var_c7[0] + this.var_10a[0] * (float)this.var_11d;
         var9[1] = this.var_c7[1] + this.var_10a[1] * (float)this.var_11d + 0.5F * var3 * (float)this.var_11d * (float)this.var_11d;
         var9[2] = this.var_c7[2] + this.var_10a[2] * (float)this.var_11d;
         if ((var9[0] - var2[0]) * (var9[0] - var2[0]) + (var9[1] - var2[1]) * (var9[1] - var2[1]) + (var9[2] - var2[2]) * (var9[2] - var2[2]) > var8 * var8) {
            this.var_b6.var_53.setRenderingEnable(false);
            if (var2[1] < 3.0F) {
               var2[1] = 3.0F;
            }

            Class_7ee.sub_2e().sub_13d(var2, var1, Class_24d.sub_d().var_c8);
            if (GameCanvas.getInstance().soundEnabled) {
               SoundManager.sub_3f().sub_5e(4);
            }

            Class_497.sub_33();
            Hashtable var12;
            Enumeration var13 = (var12 = Class_497.sub_33().var_52).keys();

            while(var13.hasMoreElements()) {
               Integer var14 = (Integer)var13.nextElement();
               Class_79b var15;
               if ((var15 = (Class_79b)var12.get(var14)).var_140 == 2) {
                  this.sub_e8(var15, var2);
               }
            }

            this.var_176 = true;
         }

      }
   }

   private void sub_e8(Class_79b var1, float[] var2) {
      if (var1 != this.var_26) {
         if (((ChooseTeam)var1).getHealth() > 0) {
            float[] var3;
            if (((var3 = var1.sub_1f9())[0] - var2[0]) * (var3[0] - var2[0]) + (var3[1] - var2[1]) * (var3[1] - var2[1]) + (var3[2] - var2[2]) * (var3[2] - var2[2]) < 36.0F) {
               ((ChooseTeam)var1).takeDamage(this.var_26, 4, (RayIntersection)null, (World)null);
            }

         }
      }
   }

   public final void sub_141() {
      this.var_c7 = null;
      this.var_10a = null;
      this.var_b6 = null;
   }

   public static void sub_157() {
      var_77 = null;
   }
}
