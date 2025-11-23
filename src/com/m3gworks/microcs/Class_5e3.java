package com.m3gworks.microcs; 
import javax.microedition.lcdui.Graphics;

public abstract class Class_5e3 {
   private static Class_5e3 var_4c;
   public int var_95;
   public boolean var_b9 = false;

   public static void sub_2b() {
      GameConfig.sub_17().sub_490();
   }

   public static void sub_85() {
      GameConfig.sub_17().sub_4dd();
   }

   public static Class_5e3 sub_be() {
      if (var_4c == null) {
         try {
            var_4c = (Class_5e3) GameConfig.sub_17().sub_23a().newInstance();
         } catch (InstantiationException var1) {
            var1.printStackTrace();
         } catch (IllegalAccessException var2) {
            var2.printStackTrace();
         }
      }

      return var_4c;
   }

   public abstract void sub_e7(Graphics var1, Class_900 var2);

   public abstract void sub_fa(int var1, int var2);

   public void sub_14a() {
      this.var_b9 = true;
   }

   public void sub_1a2() {
      this.var_b9 = false;
   }
}
