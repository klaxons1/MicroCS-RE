package com.m3gworks.microcs; 
public class Class_723 extends EnemyAI {
   public final void sub_98(Class_79b var1) {
      PlayerCharacter var2;
      int var3;
      if ((var2 = (PlayerCharacter)var1).sub_2e9()) {
         label63: {
            if (var2.var_3c <= 0) {
               return;
            }

            var3 = Randomizer.random.nextInt(4);
            if (var2.var_130) {
               var2.var_130 = false;
               if (var3 != 0) {
                  if (Class_1f1.sub_27().var_7a == 2) {
                     this.sub_11(var1, var3);
                     return;
                  }
                  break label63;
               }
            } else {
               if (var2.var_13b) {
                  var2.var_13b = false;
                  if (Class_1f1.sub_27().var_7a == 2) {
                     if (var3 == 0 || var3 == 2) {
                        var2.fireWeapon();
                     }

                     return;
                  }
                  break label63;
               }

               if (var3 <= 1) {
                  if (!Class_497.sub_33().var_2c.sub_10e(var1) && Class_1f1.sub_27().var_7a == 2) {
                     this.sub_11(var1, var3);
                     return;
                  }
                  break label63;
               }

               if (var3 == 2) {
                  sub_87((Class_6c5)var1);
                  break label63;
               }
            }

            sub_bb((Class_6c5)var1);
         }
      }

      var3 = var2.var_211;
      if (!var2.sub_2e9() && (var3 == 1 || var3 == 2 || var3 == 3 || var3 == 4)) {
         var2.sub_1d0();
      }

      var2.sub_29a();
   }

   private boolean sub_11(Class_79b var1, int var2) {
      ChooseTeam var3 = (ChooseTeam)var1;
      sub_6c(var1);
      if (var2 == 1) {
         var1.sub_e9(0.1F);
      } else {
         var1.sub_118(0.3F);
      }

      if (GameCanvas.getInstance().soundEnabled) {
         int var4;
         if ((var4 = var3.getWeaponShop().getCurrentWeapon().weaponType) == 10) {
            SoundManager.sub_3f().sub_5e(1);
         } else if (var4 == 11) {
            SoundManager.sub_3f().sub_5e(2);
         } else if (var4 == 20) {
            SoundManager.sub_3f().sub_5e(3);
         }
      }

      var3.fireWeapon();
      return true;
   }

   private static void sub_6c(Class_79b var0) {
      Class_79b var1 = Class_497.sub_33().var_2c;
      float[] var2 = var0.sub_1f9();
      float[] var3 = var1.sub_1f9();
      float[] var4 = new float[]{var3[0] - var2[0], 0.0F, var3[2] - var2[2]};
      float[] var5;
      float var8 = (float)Math.toDegrees((double)((float) MathUtilsArcSin.asin((double) MathUtils.dotProduct(var5 = var0.sub_175(1, 3.0F), var4) / (Math.sqrt((double)(var5[0] * var5[0] + var5[1] * var5[1] + var5[2] * var5[2])) * Math.sqrt((double)(var4[0] * var4[0] + var4[1] * var4[1] + var4[2] * var4[2]))))));
      if (MathUtils.crossProduct(var5, var4)[1] < 0.0F) {
         var0.sub_19a(var8);
      } else {
         var0.sub_166(var8);
      }
   }

   private static void sub_87(Class_6c5 var0) {
      int var1;
      if ((var1 = Randomizer.random.nextInt(25)) % 2 == 0) {
         var0.sub_166((float)var1);
      } else {
         var0.sub_19a((float)var1);
      }
   }

   private static void sub_bb(Class_6c5 var0) {
      float[] var1 = var0.sub_175(1, 3.0F);
      BoundingSphere var2 = var0.sub_dd(var1);
      float[] var3 = var0.sub_b9(var1);
      if (var0.findPlayerInRadius(var2) == null && var3[0] == var1[0] && var3[1] == var1[1] && var3[2] == var1[2]) {
         var0.sub_1bb(1, var3);
      } else if (Randomizer.random.nextInt(2) == 0) {
         var0.sub_166(70.0F);
      } else {
         var0.sub_19a(70.0F);
      }
   }
}
