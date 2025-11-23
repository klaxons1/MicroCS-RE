package com.m3gworks.microcs; 
import javax.microedition.lcdui.Graphics;

public abstract class Class_62a {
   private static Class_62a var_74;

   public static Class_62a sub_48() {
      if (var_74 == null) {
         try {
            var_74 = (Class_62a) GameConfig.sub_17().sub_1fb().newInstance();
         } catch (InstantiationException var1) {
            var1.printStackTrace();
         } catch (IllegalAccessException var2) {
            var2.printStackTrace();
         }
      }

      return var_74;
   }

   public abstract void sub_88(Graphics var1, Class_900 var2);

   public abstract void sub_ae(int var1, String var2);

   public abstract void sub_10e();

   public static void sub_131() {
      GameConfig.sub_17().sub_45a();
   }

   public static void sub_181() {
      GameConfig.sub_17().sub_4a9();
   }
}
