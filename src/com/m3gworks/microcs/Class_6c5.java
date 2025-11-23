package com.m3gworks.microcs; 
import javax.microedition.m3g.Transform;
import javax.microedition.m3g.World;

public class Class_6c5 extends Class_79b {
   public float[] var_29;
   private Transform var_122 = new Transform();
   private Transform var_138 = new Transform();
   private Transform var_194 = new Transform();
   private float var_1c0 = 0.0F;
   public int var_1fd;
   public int var_211 = -1;
   public int var_231 = 0;

   public Class_6c5(int var1, String var2, int var3) {
      super(var1, var2, var3);
      super.var_255 = new TerroristModelLoader(this);
   }

   public void initialize(World var1) {
      super.var_255.sub_41(var1).setUserObject(this);
   }

   public void reset() {
      super.reset();
      this.var_122 = null;
      this.var_138 = null;
      this.var_194 = null;
      this.var_29 = null;
   }

   public void respawn() {
      super.respawn();
      this.var_1fd = TerroristModelLoader.var_2ca[1][1] - TerroristModelLoader.var_2ca[1][0] - 1;
      this.var_122.setIdentity();
      this.var_138.setIdentity();
      this.var_194.setIdentity();
      this.var_211 = -1;
      this.sub_3a();
   }

   public final void sub_3a() {
      TerroristModelLoader var1;
      (var1 = (TerroristModelLoader)super.var_255).var_cf.setTransform(this.var_122);
      var1.var_158.setTransform(this.var_138);
      var1.var_1d0.setTransform(this.var_194);
      boolean var2 = false;
      if (this.var_211 != 0 && this.var_211 != -1) {
         float[] var3 = this.sub_1f9();
         float[] var4;
         float var5 = ((var4 = Class_497.sub_33().var_2c.sub_1f9())[0] - var3[0]) * (var4[0] - var3[0]) + (var4[2] - var3[2]) * (var4[2] - var3[2]);
         float var6 = 3600.0F;
         if (var5 < var6) {
            var2 = true;
         }
      } else {
         var2 = true;
      }

      if (var2) {
         super.var_255.var_bf.animate(this.var_1fd * 50);
      }

   }

   public final float sub_93() {
      return 1.0F;
   }

   public final float[] sub_b9(float[] var1) {
      float[] var2 = new float[3];
      if (this.sub_1d9(var1) == null) {
         var2[0] = var1[0];
         var2[1] = var1[1];
         var2[2] = var1[2];
      }

      return var2;
   }

   public final float sub_e9(float var1) {
      super.var_329 += var1;
      float var2 = 75.0F;
      if (super.var_329 > var2) {
         super.var_329 = var2;
         return 0.0F;
      } else {
         this.var_122.postRotate(var1, TerroristModelLoader.var_25d[0], TerroristModelLoader.var_25d[1], TerroristModelLoader.var_25d[2]);
         return var1;
      }
   }

   public final float sub_118(float var1) {
      super.var_329 -= var1;
      float var2 = -75.0F;
      if (super.var_329 < var2) {
         super.var_329 = var2;
         return 0.0F;
      } else {
         this.var_122.postRotate(-var1, TerroristModelLoader.var_25d[0], TerroristModelLoader.var_25d[1], TerroristModelLoader.var_25d[2]);
         return var1;
      }
   }

   public final float sub_166(float var1) {
      super.var_34f += var1;
      this.var_138.postRotate(var1, TerroristModelLoader.var_27b[0], TerroristModelLoader.var_27b[1], TerroristModelLoader.var_27b[2]);
      this.var_1c0 += var1;
      if (this.var_1c0 >= 45.0F) {
         this.sub_228();
      }

      return var1;
   }

   public final float sub_19a(float var1) {
      super.var_34f -= var1;
      this.var_138.postRotate(-var1, TerroristModelLoader.var_27b[0], TerroristModelLoader.var_27b[1], TerroristModelLoader.var_27b[2]);
      this.var_1c0 -= var1;
      if (this.var_1c0 <= -45.0F) {
         this.sub_228();
      }

      return var1;
   }

   public final void sub_1bb(int var1, float[] var2) {
      this.var_29 = var2;
      if (var1 != 1 && var1 != 2) {
         this.sub_24a();
      } else {
         this.sub_228();
      }

      this.sub_275(var1);
      this.sub_af(var2);
   }

   public final void sub_1d0() {
      int var1 = TerroristModelLoader.var_2ca[1][1];
      super.var_255.var_bf.translate(this.var_29[0] / (float)var1, this.var_29[1] / (float)var1, this.var_29[2] / (float)var1);
   }

   private void sub_228() {
      this.var_194.postRotate(this.var_1c0, TerroristModelLoader.var_27b[0], TerroristModelLoader.var_27b[1], TerroristModelLoader.var_27b[2]);
      this.var_1c0 = 0.0F;
   }

   private void sub_24a() {
      float var1 = 0.0F;
      if (this.var_1c0 > 0.0F) {
         var1 = 60.0F - this.var_1c0;
         this.var_1c0 = 60.0F;
      } else {
         var1 = -60.0F - this.var_1c0;
         this.var_1c0 = -60.0F;
      }

      this.var_194.postRotate(-var1, TerroristModelLoader.var_27b[0], TerroristModelLoader.var_27b[1], TerroristModelLoader.var_27b[2]);
   }

   public final void sub_275(int var1) {
      if (var1 == 0) {
         this.var_122.setIdentity();
         this.var_138.setIdentity();
         this.var_194.setIdentity();
      }

      this.var_211 = var1;
      this.var_231 = 1;
   }

   public final void sub_29a() {
      if (!this.sub_2e9()) {
         this.var_1fd = TerroristModelLoader.var_2ca[this.var_211][0] + (this.var_231 - 1);
         ++this.var_231;
      }
   }

   public final boolean sub_2e9() {
      if (this.var_211 == -1) {
         return true;
      } else {
         return this.var_231 > TerroristModelLoader.var_2ca[this.var_211][1];
      }
   }
}
