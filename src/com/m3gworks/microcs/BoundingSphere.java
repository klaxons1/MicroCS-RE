package com.m3gworks.microcs; 
public final class BoundingSphere {
   public float[] var_44 = new float[3];
   public float var_f1;

   public BoundingSphere() {
   }

   public BoundingSphere(float[] var1, float var2) {
      this.var_44 = var1;
      this.var_f1 = var2;
   }

   public final boolean sub_1b(BoundingSphere var1) {
      float[] var2;
      float var3 = ((var2 = var1.var_44)[0] - this.var_44[0]) * (var2[0] - this.var_44[0]) + (var2[1] - this.var_44[1]) * (var2[1] - this.var_44[1]) + (var2[2] - this.var_44[2]) * (var2[2] - this.var_44[2]);
      float var4 = (this.var_f1 + var1.var_f1) * (this.var_f1 + var1.var_f1);
      return !(var3 > var4);
   }

   public final void sub_48(float var1, float var2, float var3) {
      this.var_44[0] = var1;
      this.var_44[1] = var2;
      this.var_44[2] = var3;
   }
}
