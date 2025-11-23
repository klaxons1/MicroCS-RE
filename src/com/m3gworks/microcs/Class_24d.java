package com.m3gworks.microcs; 
import java.util.Enumeration;
import java.util.Hashtable;
import javax.microedition.m3g.Camera;

public final class Class_24d {
   private static Class_24d var_28;
   private Hashtable var_7c = null;
   public Camera var_c8;

   private Class_24d() {
   }

   public static Class_24d sub_d() {
      if (var_28 == null) {
         var_28 = new Class_24d();
      }

      return var_28;
   }

   public final void sub_24() {
      this.var_7c = new Hashtable();
      GameConfig.sub_17().sub_52b();
   }

   public final void sub_45() {
      Enumeration var1 = this.var_7c.keys();

      while(var1.hasMoreElements()) {
         String var2 = (String)var1.nextElement();
         this.var_7c.get(var2);
      }

      this.var_7c = null;
   }

   public final void sub_7d(String var1, Camera var2) {
      this.var_7c.put(var1, var2);
   }

   public final Camera sub_db(String var1) {
      Object var2;
      return (var2 = this.var_7c.get(var1)) == null ? null : (Camera)var2;
   }

   public final void sub_fb(Camera var1, Class_900 var2) {
      this.var_c8 = var1;
      float var3 = (float)var2.getWidth() / (float)var2.getHeight();
      float var4 = 60.0F / var3;
      var1.setPerspective(var4, var3, 0.1F, 1000.0F);
      MapLoader.sub_41().var_168.setActiveCamera(var1);
   }
}
