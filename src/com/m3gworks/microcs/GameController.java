package com.m3gworks.microcs; 
import javax.microedition.m3g.Background;

public class GameController extends InputHandler {
   private boolean var_4f = false;
   private int var_83 = 0;
   public int var_8e = 0;
   private int var_fa = 1;
   public int var_151 = 0;
   private int var_19d = 1;

   public GameController() {
      super.var_7e = new boolean[9];
   }

   public final void sub_bb() {
      Class_79b var1;
      ChooseTeam var2 = (ChooseTeam)(var1 = Class_497.sub_33().var_2c);
      float var3 = 0.0F;
      if (!super.var_7e[5] && !super.var_7e[6] && !super.var_7e[7] && !super.var_7e[8]) {
         var1.var_1fa = 0;
      } else {
         ++var1.var_1fa;
      }

      var3 = (var3 = Class_79b.var_1af * (float)var1.var_1fa) >= Class_79b.var_1ee ? Class_79b.var_1ee : var3;
      if (super.var_7e[1]) {
         sub_5b((Class_811)var1, 1);
      } else if (super.var_7e[2]) {
         sub_5b((Class_811)var1, 2);
      }

      if (super.var_7e[3]) {
         sub_5b((Class_811)var1, 3);
      } else if (super.var_7e[4]) {
         sub_5b((Class_811)var1, 4);
      }

      if (!super.var_7e[1] && !super.var_7e[2] && !super.var_7e[3] && !super.var_7e[4]) {
         if (this.var_8e != 0) {
            --this.var_8e;
         }
      } else {
         if (this.var_8e == 0) {
            this.var_fa = 1;
         } else if (this.var_8e == 3) {
            this.var_fa = -1;
         }

         this.var_8e += this.var_fa;
      }

      var2.getGranade().sub_8a(MapLoader.sub_41().var_168);
      float var4;
      if (super.var_7e[5]) {
         var1.sub_e9(var3);
         var4 = 0.0F;
      } else if (super.var_7e[6]) {
         var1.sub_118(var3);
         var4 = 0.0F;
      }

      Background var5;
      int var7;
      if (super.var_7e[7]) {
         var4 = var1.sub_166(var3);
         if ((var5 = MapLoader.sub_41().var_168.getBackground()) != null) {
            var7 = (int)(var4 * ((float)var5.getCropWidth() / 60.0F));
            var5.setCrop(var5.getCropX() - var7, var5.getCropY(), var5.getCropWidth(), var5.getCropHeight());
         }
      } else if (super.var_7e[8]) {
         var4 = var1.sub_19a(var3);
         if ((var5 = MapLoader.sub_41().var_168.getBackground()) != null) {
            var7 = (int)(var4 * ((float)var5.getCropWidth() / 60.0F));
            var5.setCrop(var5.getCropX() + var7, var5.getCropY(), var5.getCropWidth(), var5.getCropHeight());
         }
      }

      if (super.var_7e[0]) {
         int var8 = var2.getWeaponShop().getCurrentWeapon().weaponType;
         int var9 = var2.getWeaponShop().currentWeaponSlot;
         if (var8 == 10 && !this.var_4f) {
            this.var_4f = true;
            return;
         }

         if (var9 == 2 || var9 == 3 || var9 == 4 || var8 == 11) {
            this.sub_107(0, false);
         }

         if (var9 == 3) {
            ((HUDRenderer)Class_62a.sub_48()).sub_f0();
            var2.fireWeapon();
            return;
         }

         if (var2.getWeaponShop().getCurrentAmmo() > 0) {
            if (var8 == 10) {
               float var6 = 0.1F * (float)this.var_83;
               switch(Randomizer.random.nextInt(3)) {
               case 0:
                  var1.sub_166(var6);
                  break;
               case 1:
                  var1.sub_19a(var6);
               case 2:
               }

               ++this.var_83;
            }

            if (GameCanvas.getInstance().soundEnabled) {
               if (var8 == 10) {
                  SoundManager.sub_3f().sub_5e(1);
               } else if (var8 == 11) {
                  SoundManager.sub_3f().sub_5e(2);
               } else if (var8 == 20) {
                  SoundManager.sub_3f().sub_5e(3);
               }
            }

            var2.fireWeapon();
            if (var9 != 1 && var9 != 2) {
               if (var9 == 4 && var2.getWeaponShop().ammoCounts[2] <= 0) {
                  var2.getWeaponShop().unequipWeapon(4);
                  var2.getWeaponShop().switchToWeaponSlot(2);
               }
            } else {
               ((HUDRenderer)Class_62a.sub_48()).sub_b0();
               if (var2.getWeaponShop().getCurrentAmmo() == 0) {
                  Class_62a.sub_48().sub_ae(4, (String)null);
               }

               if (this.var_151 == 0) {
                  this.var_19d = 1;
               } else if (this.var_151 == 3) {
                  this.var_19d = -1;
               }

               this.var_151 += this.var_19d;
            }

            if (var8 == 10 && !this.var_4f) {
               this.var_4f = false;
               return;
            }
         }
      } else if (this.var_151 != 0) {
         --this.var_151;
      }

   }

   private static void sub_5b(Class_811 var0, int var1) {
      float[] var2 = var0.sub_175(var1, 1.0F);
      BoundingSphere var3 = var0.sub_dd(var2);
      float[] var4;
      if (var0.findPlayerInRadius(var3) == null && ((var4 = var0.sub_19(var2))[0] != 0.0F || var4[1] != 0.0F || var4[2] != 0.0F)) {
         var0.sub_6f(var4);
      }

   }

   public final void sub_107(int var1, boolean var2) {
      super.sub_107(var1, var2);
      if (var1 != -1 && var1 == 0 && var2) {
         this.var_4f = true;
         this.var_83 = 0;
      }

   }
}
