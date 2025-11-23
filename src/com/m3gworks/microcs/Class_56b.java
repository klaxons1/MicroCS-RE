package com.m3gworks.microcs; 
import javax.microedition.m3g.Appearance;
import javax.microedition.m3g.Camera;
import javax.microedition.m3g.CompositingMode;
import javax.microedition.m3g.Image2D;
import javax.microedition.m3g.Mesh;
import javax.microedition.m3g.Node;
import javax.microedition.m3g.Texture2D;
import javax.microedition.m3g.TriangleStripArray;
import javax.microedition.m3g.VertexArray;
import javax.microedition.m3g.VertexBuffer;

public final class Class_56b {
   public Mesh var_1a;
   private Appearance var_42;
   public Texture2D[] var_b2;
   private int var_e5;
   private int var_ff;
   public boolean var_136;
   private Camera var_144;
   private float[] var_1a1 = new float[3];

   public Class_56b(Image2D[] var1, Camera var2, float var3) {
      this.var_144 = var2;
      VertexBuffer var4 = sub_22();
      int[] var5 = new int[]{1, 2, 0, 3};
      int[] var6 = new int[]{4};
      TriangleStripArray var7 = new TriangleStripArray(var5, var6);
      this.var_e5 = var1.length;
      this.var_ff = 0;
      this.var_b2 = sub_69(var1, this.var_e5);
      this.var_42 = this.sub_90(this.var_b2[this.var_ff]);
      this.var_1a = new Mesh(var4, var7, this.var_42);
      float var8 = var3 * 0.5F;
      this.var_1a.scale(var8, var8, var8);
      if (this.var_144 != null) {
         this.var_1a.setAlignment(this.var_144, 148, (Node)null, 144);
      }

      this.var_1a.setPickingEnable(false);
      this.sub_eb(false);
   }

   public Class_56b(Mesh var1, Texture2D[] var2, Camera var3) {
      this.var_ff = 0;
      this.var_b2 = var2;
      this.var_e5 = var2.length;
      this.var_1a = (Mesh)var1.duplicate();
      this.var_42 = this.var_1a.getAppearance(0);
      this.var_42.setTexture(0, var2[this.var_ff]);
      this.var_144 = var3;
      if (this.var_144 != null) {
         this.var_1a.setAlignment(this.var_144, 148, (Node)null, 144);
      }

      this.var_1a.setPickingEnable(false);
      this.sub_eb(false);
   }

   private static VertexBuffer sub_22() {
      short[] var0 = new short[]{-1, -1, 0, 1, -1, 0, 1, 1, 0, -1, 1, 0};
      VertexArray var1;
      (var1 = new VertexArray(var0.length / 3, 3, 2)).set(0, var0.length / 3, var0);
      short[] var2 = new short[]{0, 1, 1, 1, 1, 0, 0, 0};
      VertexArray var3;
      (var3 = new VertexArray(var2.length / 2, 2, 2)).set(0, var2.length / 2, var2);
      VertexBuffer var4;
      (var4 = new VertexBuffer()).setPositions(var1, 0.25F, (float[])null);
      var4.setTexCoords(0, var3, 1.0F, (float[])null);
      return var4;
   }

   private static Texture2D[] sub_69(Image2D[] var0, int var1) {
      Texture2D[] var2 = new Texture2D[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         if (var0[var3] != null) {
            var2[var3] = new Texture2D(var0[var3]);
            var2[var3].setFiltering(210, 210);
            var2[var3].setWrapping(240, 240);
            var2[var3].setBlending(228);
         } else {
            System.out.println("Image " + var3 + " is null");
         }
      }

      return var2;
   }

   private Appearance sub_90(Texture2D var1) {
      this.var_42 = new Appearance();
      CompositingMode var2;
      (var2 = new CompositingMode()).setBlending(64);
      this.var_42.setCompositingMode(var2);
      this.var_42.setTexture(0, var1);
      return this.var_42;
   }

   public final void sub_be(float var1, float var2, float var3) {
      this.var_1a.setTranslation(var1, var2, var3);
   }

   public final void sub_eb(boolean var1) {
      this.var_136 = var1;
      if (this.var_136) {
         this.var_1a.setRenderingEnable(true);
         this.var_ff = 0;
         this.var_1a1[0] = 0.0F;
         this.var_1a1[0] = 0.0F;
         this.var_1a1[0] = 0.0F;
      } else {
         this.var_1a.setRenderingEnable(false);
      }
   }

   public final void sub_117() {
      if (this.var_136) {
         if (this.var_144 != null) {
            this.var_1a.align(this.var_144);
         }

         if (this.var_ff == this.var_e5) {
            this.sub_eb(false);
            return;
         }

         this.var_42.setTexture(0, this.var_b2[this.var_ff]);
         ++this.var_ff;
         if (this.var_1a1[0] != 0.0F || this.var_1a1[1] != 0.0F || this.var_1a1[2] != 0.0F) {
            float[] var1 = new float[3];
            this.var_1a.getTranslation(var1);
            float[] var2 = MathUtils.addVectors(var1, this.var_1a1);
            this.sub_be(var2[0], var2[1], var2[2]);
         }
      }

   }

   public final void sub_178(float[] var1) {
      System.arraycopy(var1, 0, this.var_1a1, 0, this.var_1a1.length);
   }
}
