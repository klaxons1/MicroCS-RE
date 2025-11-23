package com.m3gworks.microcs; 
import java.util.Enumeration;
import java.util.Hashtable;
import javax.microedition.m3g.World;

public final class Class_497 {
   private static Class_497 var_f;
   public Class_79b var_2c;
   public Hashtable var_52;

   private Class_497() {
   }

   public static Class_497 sub_33() {
      if (var_f == null) {
         var_f = new Class_497();
      }

      return var_f;
   }

   public final void sub_6d(Class_79b var1) {
      if (this.var_52 == null) {
         this.var_52 = new Hashtable();
      }

      this.var_52.put(new Integer(var1.var_6c), var1);
      if (var1.var_6c == 1) {
         this.var_2c = var1;
      }

   }

   public final void sub_d0(World var1) {
      Enumeration var2 = this.var_52.keys();

      while(var2.hasMoreElements()) {
         Integer var3 = (Integer)var2.nextElement();
         ((Class_79b)this.var_52.get(var3)).initialize(var1);
      }

   }

   public final void sub_10f() {
      Enumeration var1 = this.var_52.keys();

      while(var1.hasMoreElements()) {
         Integer var2 = (Integer)var1.nextElement();
         ((Class_79b)this.var_52.get(var2)).respawn();
      }

   }

   public final void sub_153() {
      Enumeration var1 = this.var_52.keys();

      while(var1.hasMoreElements()) {
         Integer var2 = (Integer)var1.nextElement();
         ((Class_79b)this.var_52.get(var2)).reset();
      }

      this.var_52 = null;
   }

   public final void sub_19b() {
      Enumeration var1 = this.var_52.keys();

      while(var1.hasMoreElements()) {
         Integer var2 = (Integer)var1.nextElement();
         Class_79b var3;
         if ((var3 = (Class_79b)this.var_52.get(var2)).var_37b) {
            var3.var_255.sub_8c(true);
            var3.sub_3a();
         } else {
            var3.var_255.sub_8c(false);
         }
      }

   }
}
