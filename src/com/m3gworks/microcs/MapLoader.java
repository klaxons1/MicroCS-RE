package com.m3gworks.microcs; 
import java.util.Vector;
import javax.microedition.m3g.Appearance;
import javax.microedition.m3g.Background;
import javax.microedition.m3g.CompositingMode;
import javax.microedition.m3g.Image2D;
import javax.microedition.m3g.Light;
import javax.microedition.m3g.Loader;
import javax.microedition.m3g.Mesh;
import javax.microedition.m3g.Object3D;
import javax.microedition.m3g.Sprite3D;
import javax.microedition.m3g.World;

public final class MapLoader {
   private static MapLoader var_32;
   public Vector var_64 = new Vector();
   public World var_168;
   public int var_197;
   public float[] var_1a7;
   public Vector[][] var_1dc;
   private Vector var_207 = null;

   static {
      GameConfig.sub_17().initializeAllMaps();
   }

   private MapLoader() {
   }

   public static MapLoader sub_41() {
      if (var_32 == null) {
         var_32 = new MapLoader();
      }

      return var_32;
   }

   public final World sub_ca() {
      try {
         Object3D[] var2 = Loader.load(this.sub_347().mapFilePath);

         for(int var3 = 0; var3 < var2.length; ++var3) {
            if (var2[var3] instanceof World) {
               this.var_168 = (World)var2[var3];
               break;
            }
         }

         this.sub_10c(this.var_197);
         this.sub_1cd();
         this.sub_221();
      } catch (Exception var4) {
         System.out.println("Load map error!");
         var4.printStackTrace();
      }

      return this.var_168;
   }

   private void sub_10c(int var1) {
      if (var1 != 5) {
         this.sub_13b();
      }

      switch(var1) {
      case 1:
         this.sub_185();
      default:
      }
   }

   private void sub_13b() {
      Image2D var1 = ResourceLoader.loadImage2DFromFile("/res/map/moon.png");
      Appearance var2 = new Appearance();
      CompositingMode var3;
      (var3 = new CompositingMode()).setBlending(68);
      var2.setCompositingMode(var3);
      Sprite3D var4 = new Sprite3D(false, var1, var2);
      this.var_168.addChild(var4);
      var4.setTranslation(0.0F, 50.0F, 0.0F);
   }

   private void sub_185() {
      this.var_207 = new Vector();
      Image2D var1 = ResourceLoader.createImage2D("/res/map/tree.png");
      HudElementSprite var2 = new HudElementSprite(var1, Class_24d.sub_d().sub_db("MAIN"), 38.8F, 8.0F, 59.1F, 16.0F);
      this.var_207.addElement(var2);
      this.var_168.addChild(var2.var_53);
      var2 = new HudElementSprite(var1, Class_24d.sub_d().sub_db("MAIN"), 31.9F, 8.0F, 90.2F, 16.0F);
      this.var_207.addElement(var2);
      this.var_168.addChild(var2.var_53);
      var2 = new HudElementSprite(var1, Class_24d.sub_d().sub_db("MAIN"), -57.9F, 8.0F, -51.7F, 16.0F);
      this.var_207.addElement(var2);
      this.var_168.addChild(var2.var_53);
   }

   public final void sub_1ae() {
      if (this.var_207 != null) {
         for(int var1 = 0; var1 < this.var_207.size(); ++var1) {
            ((HudElementSprite)this.var_207.elementAt(var1)).sub_9e();
         }

      }
   }

   private void sub_1cd() {
      Light var1;
      (var1 = new Light()).setMode(128);
      var1.setIntensity(3.0F);
      this.var_168.addChild(var1);
   }

   private void sub_221() {
      int[] var1 = this.sub_347().objectIds;
      this.var_1a7 = new float[4];
      int var3;
      if (var1 == null) {
         this.var_1a7[0] = -400.0F;
         this.var_1a7[1] = -400.0F;
         this.var_1a7[2] = 400.0F;
         this.var_1a7[3] = 400.0F;
         int var23 = (int)Math.ceil((double)((this.var_1a7[2] - this.var_1a7[0]) / 20.0F));
         var3 = (int)Math.ceil((double)((this.var_1a7[3] - this.var_1a7[1]) / 20.0F));
         this.var_1dc = new Vector[var3][var23];
      } else {
         this.var_1a7[0] = Float.MAX_VALUE;
         this.var_1a7[1] = Float.MAX_VALUE;
         this.var_1a7[2] = -3.4028235E38F;
         this.var_1a7[3] = -3.4028235E38F;
         BoundingBox[] var2 = new BoundingBox[var1.length];

         for(var3 = 0; var3 < var1.length; ++var3) {
            Mesh var4;
            float[] var5 = ResourceLoader.getTransformedVertices(var4 = (Mesh)this.var_168.find(var1[var3]), this.var_168);
            BoundingBox var6 = new BoundingBox(var5, var4);
            var2[var3] = var6;
            float[] var7 = var6.var_8f;
            float[] var8 = var6.var_d3;
            if (var7[0] < this.var_1a7[0]) {
               this.var_1a7[0] = var7[0];
            }

            if (var7[2] < this.var_1a7[1]) {
               this.var_1a7[1] = var7[2];
            }

            if (var8[0] > this.var_1a7[2]) {
               this.var_1a7[2] = var8[0];
            }

            if (var8[2] > this.var_1a7[3]) {
               this.var_1a7[3] = var8[2];
            }
         }

         float[] var10000 = this.var_1a7;
         var10000[0] -= 2.0F;
         var10000 = this.var_1a7;
         var10000[1] -= 2.0F;
         var10000 = this.var_1a7;
         var10000[2] += 2.0F;
         var10000 = this.var_1a7;
         var10000[3] += 2.0F;
         float var24 = this.var_1a7[2] - this.var_1a7[0];
         float var25 = this.var_1a7[3] - this.var_1a7[1];
         int var26 = (int)Math.ceil((double)(var24 / 20.0F));
         int var27 = (int)Math.ceil((double)(var25 / 20.0F));
         this.var_1dc = new Vector[var27][var26];

         for(int var28 = 0; var28 < var2.length; ++var28) {
            BoundingBox var29;
            float var9 = (var29 = var2[var28]).var_8f[0];
            float var10 = var29.var_8f[2];
            float var11 = var29.var_d3[0];
            float var12 = var29.var_d3[2];
            float var13;
            int var14 = (var13 = (var10 - this.var_1a7[1]) / 20.0F) < 1.0F ? 0 : (int)Math.floor((double)var13);
            float var15;
            int var16 = (var15 = (var9 - this.var_1a7[0]) / 20.0F) < 1.0F ? 0 : (int)Math.floor((double)var15);
            float var17;
            int var18 = (var17 = (var12 - this.var_1a7[1]) / 20.0F) < 1.0F ? 0 : (int)Math.floor((double)var17);
            float var19;
            int var20 = (var19 = (var11 - this.var_1a7[0]) / 20.0F) < 1.0F ? 0 : (int)Math.floor((double)var19);

            for(int var21 = var14; var21 <= var18; ++var21) {
               for(int var22 = var16; var22 <= var20; ++var22) {
                  if (this.var_1dc[var21][var22] == null) {
                     this.var_1dc[var21][var22] = new Vector();
                  }

                  this.var_1dc[var21][var22].addElement(var29);
               }
            }
         }

      }
   }

   public final void sub_281() {
      this.var_168 = null;
      this.var_1a7 = null;
      this.var_1dc = null;
      this.var_207 = null;
   }

   public final void sub_2e1(int var1, int var2) {
      Background var3;
      if ((var3 = this.var_168.getBackground()) != null) {
         var3.setImageMode(33, 32);
         int var5 = (var3.getImage().getHeight() - var2) / 2;
         var3.setCrop(0, var5, var1, var2);
      }

   }

   public final void sub_2f3(MapParameters var1) {
      this.var_64.addElement(var1);
   }

   public final MapParameters sub_347() {
      return (MapParameters)this.var_64.elementAt(this.var_197);
   }
}
