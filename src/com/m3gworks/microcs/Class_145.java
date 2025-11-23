package com.m3gworks.microcs; 
import com.m3gworks.engine.GameMIDlet;
import javax.microedition.m3g.World;

public final class Class_145 implements Runnable {
   private static Class_145 var_61;
   private static boolean var_81 = false;
   public int var_a2 = 0;
   public int var_da = 0;

   private Class_145() {
   }

   public static Class_145 sub_56() {
      if (var_61 == null) {
         var_61 = new Class_145();
      }

      return var_61;
   }

   public static void sub_70() {
      Class_512 var0 = new Class_512();
      LocalPlayer var1 = new LocalPlayer(1, "Me", 0, 1, var0);
      Class_497.sub_33().sub_6d(var1);
      GameCanvas.getInstance();
      float[] var3 = MapLoader.sub_41().sub_347().spawnPoints;

      for(int var4 = 1; var4 < var3.length / 3; ++var4) {
         PlayerCharacter var5 = new PlayerCharacter(var4 + 1, "Bot", 1, 2);
         Class_497.sub_33().sub_6d(var5);
      }

   }

   public static void sub_c8() {
      GameMIDlet.sub_f().var_3a.setCurrent(GameCanvas.getInstance());
      GameCanvas.getInstance().onSizeChanged();
      (new Thread(var_61)).start();
   }

   public final void run() {
      try {
         GameCanvas.getInstance().screenState = 9;
         ++this.var_da;
         this.var_a2 = 1;
         GameCanvas.getInstance().onSizeChanged();
         Class_24d.sub_d().sub_24();
         ++this.var_da;
         World var1 = MapLoader.sub_41().sub_ca();
         ++this.var_da;
         this.var_a2 = 20;
         GameCanvas.getInstance().onSizeChanged();
         ++this.var_da;
         if (!var_81 && GameConfig.sub_17().isMultiplayer()) {
            Class_852.sub_76(var1);
         }

         ++this.var_da;
         this.var_a2 = 25;
         GameCanvas.getInstance().onSizeChanged();
         if (!var_81) {
            Grenade.sub_3c();
         }

         ++this.var_da;
         this.var_a2 = 28;
         GameCanvas.getInstance().onSizeChanged();
         if (!var_81) {
            Class_7ee.sub_7f();
         }

         ++this.var_da;
         this.var_a2 = 35;
         GameCanvas.getInstance().onSizeChanged();
         this.var_a2 = 50;
         GameCanvas.getInstance().onSizeChanged();
         ++this.var_da;
         if (!var_81) {
            Class_4e4.sub_86();
         }

         ++this.var_da;
         this.var_a2 = 60;
         GameCanvas.getInstance().onSizeChanged();
         Class_497.sub_33().sub_d0(var1);
         this.var_a2 = 80;
         GameCanvas.getInstance().onSizeChanged();
         ++this.var_da;
         this.var_a2 = 85;
         GameCanvas.getInstance().onSizeChanged();
         if (!var_81) {
            Class_62a.sub_131();
         }

         ++this.var_da;
         this.var_a2 = 90;
         GameCanvas.getInstance().onSizeChanged();
         if (!var_81) {
            Class_5e3.sub_2b();
         }

         ++this.var_da;
         this.var_a2 = 95;
         GameCanvas.getInstance().onSizeChanged();
         System.gc();
         this.var_a2 = 100;
         GameCanvas.getInstance().onSizeChanged();
         ++this.var_da;
         var_81 = true;
      } catch (Exception var2) {
         GameMIDlet.sub_f().var_3a.setCurrent(GameCanvas.getInstance());
         GameCanvas.getInstance().showErrorMessage(this.var_da + var2.toString());
         return;
      }

      this.var_a2 = 0;
      sub_dd();
   }

   private static void sub_dd() {
      Class_1f1.sub_27().sub_79();
   }

   public static void sub_ef() {
      Class_24d.sub_d().sub_45();
      MapLoader.sub_41().sub_281();
      if (GameConfig.sub_17().isMultiplayer()) {
         Class_852.sub_42().sub_112();
      }

      Class_7ee.sub_2e().sub_1fa();
      Class_4e4.sub_38().sub_f2();
      Class_62a.sub_48().sub_10e();
      Class_5e3.sub_be();
      Class_497.sub_33().sub_153();
      Class_900.sub_1f3();
      Runtime.getRuntime().gc();
   }

   public static void sub_146() {
      if (GameConfig.sub_17().isMultiplayer()) {
         Class_852.sub_173();
      }

      Class_7ee.sub_252();
      Grenade.sub_157();
      WeaponShop.staticCleanup();
      if (GameCanvas.getInstance().soundEnabled) {
         SoundManager.sub_3f().sub_102();
      }

      Class_4e4.sub_136();
      Class_62a.sub_181();
      Class_5e3.sub_85();
      Runtime.getRuntime().gc();
   }
}
