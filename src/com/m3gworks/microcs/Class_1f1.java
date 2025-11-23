package com.m3gworks.microcs; 
import com.m3gworks.engine.GameMIDlet;
import java.util.Timer;

public abstract class Class_1f1 implements Runnable {
   private static Class_1f1 var_3d;
   public int var_7a = 5;
   public Class_96d var_ac;
   public int var_102 = 0;

   public static Class_1f1 sub_27() {
      if (var_3d == null) {
         try {
            var_3d = (Class_1f1) GameConfig.sub_17().sub_14f().newInstance();
         } catch (InstantiationException var1) {
            var1.printStackTrace();
         } catch (IllegalAccessException var2) {
            var2.printStackTrace();
         }
      }

      return var_3d;
   }

   public final void sub_79() {
      if (this.var_7a == 4 || this.var_7a == 5) {
         Thread var1 = new Thread(this);
         this.var_102 = 0;
         var1.start();
      }
   }

   public void run() {
      Class_900 var1 = Class_900.sub_7a();
      GameMIDlet.sub_f().var_3a.setCurrent(var1);
      this.sub_c6();
      this.var_7a = 1;
      Timer var2 = new Timer();
      this.var_ac = new Class_96d(GameConfig.sub_17().sub_3bd());
      var2.schedule(this.var_ac, 0L, 1000L);

      while(this.var_7a != 4 && this.var_7a != 5) {
         try {
            var1.sub_100();
            if (this.var_7a == 1 && this.var_ac.var_4a == 0) {
               this.var_7a = 2;
               this.var_ac = null;
               if (MapLoader.sub_41().sub_347().isEnabled) {
                  this.var_ac = new Class_96d(180);
                  var2.schedule(this.var_ac, 0L, 1000L);
               }
            }

            if (this.var_7a == 2) {
               if (MapLoader.sub_41().sub_347().isEnabled && this.var_ac.var_4a == 0 || this.var_102 != 0) {
                  this.var_7a = 3;
                  this.sub_e2();
                  if (MapLoader.sub_41().sub_347().isEnabled) {
                     this.var_ac.cancel();
                  }

                  this.var_ac = new Class_96d(GameConfig.sub_17().sub_3d3());
                  var2.schedule(this.var_ac, 0L, 1000L);
               }
            } else if (this.var_7a == 3 && this.var_ac.var_4a == 0) {
               this.var_7a = 4;
            }

            Thread.yield();
         } catch (Exception var4) {
            var4.printStackTrace();
         }
      }

      if (this.var_7a == 5) {
         this.sub_128();
      }

      if (this.var_7a == 4) {
         this.sub_ee();
      }

   }

   public abstract void sub_c6();

   public abstract void sub_e2();

   public abstract void sub_ee();

   public abstract void sub_128();
}
