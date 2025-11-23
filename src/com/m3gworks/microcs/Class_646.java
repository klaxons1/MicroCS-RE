package com.m3gworks.microcs; 
public abstract class Class_646 {
   private static Class_646 var_4e;

   public static Class_646 sub_62() {
      if (var_4e == null) {
         try {
            var_4e = (Class_646) GameConfig.sub_17().sub_2cf().newInstance();
         } catch (InstantiationException var1) {
            var1.printStackTrace();
         } catch (IllegalAccessException var2) {
            var2.printStackTrace();
         }
      }

      return var_4e;
   }

   public abstract void sub_28(int var1, Class_900 var2);

   public abstract void sub_4a(int var1, Class_900 var2);
}
