package com.m3gworks.microcs; 
import java.util.Vector;
import javax.microedition.lcdui.Image;
import javax.microedition.m3g.Camera;
import javax.microedition.m3g.Image2D;

public final class Class_4e4 {
   private static Class_4e4 var_50;
   public static Image2D[] var_b0;
   public static Image[] var_d7;
   public static Image2D[] var_10f;
   public static Image[] var_146;
   private Vector var_180 = new Vector();

   private Class_4e4() {
   }

   public static Class_4e4 sub_38() {
      if (var_50 == null) {
         var_50 = new Class_4e4();
      }

      return var_50;
   }

   public static void sub_86() {
      var_d7 = new Image[3];
      var_b0 = ResourceLoader.loadSpriteSheetWithImages("/res/image2d/muzzleflash_r.png", 3, 32, var_d7);
      var_146 = new Image[1];
      var_10f = ResourceLoader.loadSpriteSheetWithImages("/res/image2d/muzzleflash_p.png", 1, 32, var_146);
   }

   public final Class_56b sub_c3(Camera var1, int var2) {
      if (this.var_180 == null) {
         this.var_180 = new Vector();
      }

      Image2D[] var3 = (Image2D[])null;
      if (var2 == 1) {
         var3 = var_b0;
      } else if (var2 == 2) {
         var3 = var_10f;
      }

      Class_56b var4;
      (var4 = new Class_56b(var3, var1, 3.0F)).var_1a.setPickingEnable(false);
      this.var_180.addElement(var4);
      return var4;
   }

   public final void sub_dc() {
      if (this.var_180 != null) {
         for(int var1 = 0; var1 < this.var_180.size(); ++var1) {
            Object var2;
            if ((var2 = this.var_180.elementAt(var1)) != null) {
               Class_56b var3;
               (var3 = (Class_56b)var2).sub_117();
            }
         }

      }
   }

   public final void sub_f2() {
      this.var_180 = null;
   }

   public static void sub_136() {
      var_b0 = null;
      var_10f = null;
   }
}
