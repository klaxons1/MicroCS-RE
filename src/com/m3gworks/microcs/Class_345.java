package com.m3gworks.microcs; 
public class Class_345 extends Class_646 {
   public final void sub_28(int var1, Class_900 var2) {
      Class_79b var3 = Class_497.sub_33().var_2c;
      int var4 = Class_1f1.sub_27().var_7a;
      if (Class_5e3.sub_be().var_b9) {
         if (var1 == 35 || var1 == -11) {
            Class_5e3.sub_be().sub_1a2();
            return;
         }

         if (var1 == 48) {
            if (Class_5e3.sub_be().var_b9 && Class_5e3.sub_be().var_95 == 1) {
               Class_5e3.sub_be().sub_1a2();
               return;
            }
         } else {
            int var16 = var2.getGameAction(var1);
            Class_5e3.sub_be().sub_fa(var1, var16);
         }
      } else {
         InputHandler var5 = InputHandler.sub_5f();
         if (var4 == 2) {
            if (var1 == 50) {
               var5.sub_107(1, true);
            } else if (var1 == 56) {
               var5.sub_107(2, true);
            } else if (var1 == 52) {
               var5.sub_107(7, true);
            } else if (var1 == 54) {
               var5.sub_107(8, true);
            } else if (var1 != 53 && var2.getGameAction(var1) != 8) {
               if (var2.getGameAction(var1) == 1) {
                  var5.sub_107(1, true);
               } else if (var2.getGameAction(var1) == 6) {
                  var5.sub_107(2, true);
               } else if (var2.getGameAction(var1) == 2) {
                  var5.sub_107(7, true);
               } else if (var2.getGameAction(var1) == 5) {
                  var5.sub_107(8, true);
               } else if (var1 == 57) {
                  ChooseTeam var6;
                  if ((var6 = (ChooseTeam)var3).getWeaponShop().getCurrentWeapon().weaponType == 11) {
                     if (var2.var_234) {
                        var2.sub_19e(false);
                     } else {
                        var2.sub_19e(true);
                     }
                  }
               } else if (var1 == 55) {
                  System.out.println(var3.sub_1f9()[0] + "  " + var3.sub_1f9()[1] + "  " + var3.sub_1f9()[2]);
               }
            } else {
               var5.sub_107(0, true);
            }
         }

         if (var1 == 48) {
            var5.sub_107(-1, false);
            Class_5e3.sub_be().var_95 = 1;
            Class_5e3.sub_be().sub_14a();
            return;
         }

         int var8;
         int var17;
         if (var1 == 49) {
            Class_900.sub_d6().sub_19e(false);
            var17 = ((ChooseTeam)Class_497.sub_33().var_2c).getWeaponShop().currentWeaponSlot;
            boolean var18 = false;

            for(var8 = 0; var8 < 4; ++var8) {
               if (var17 == 4) {
                  var17 = 1;
               } else {
                  ++var17;
               }

               if (((ChooseTeam)var3).getWeaponShop().switchToWeaponSlot(var17)) {
                  return;
               }
            }

            return;
         }

         if (var1 == 51) {
            var17 = ((LocalPlayer)var3).money;
            WeaponShop var7;
            var8 = (var7 = ((ChooseTeam)var3).getWeaponShop()).currentWeaponSlot;
            int var9 = ((ChooseTeam)var3).getWeaponShop().getCurrentAmmo();
            int var10 = ((ChooseTeam)var3).getWeaponShop().getCurrentWeapon().clipCapacity;
            int var11 = var9 % var10;
            int var13 = var9 / var10;
            if (var11 != 0) {
               ++var13;
            }

            boolean var14 = false;
            WeaponParameters var15 = null;
            if (var8 == 1) {
               if (var13 >= 4) {
                  var14 = true;
               }

               var15 = (WeaponParameters) WeaponShop.allWeapons.elementAt(WeaponShop.defaultRifleId);
            } else if (var8 == 2) {
               if (var13 >= 8) {
                  var14 = true;
               }

               var15 = (WeaponParameters) WeaponShop.allWeapons.elementAt(WeaponShop.defaultPistolId);
            }

            if (var15 != null && var15.price <= var17 && !var14) {
               var7.equipWeapon(var15);
               ((LocalPlayer)var3).spendMoney(var15.price);
               Class_62a.sub_48().sub_ae(6, (String)null);
               return;
            }
         } else if (var1 == 35 || var1 == -11) {
            var5.sub_107(-1, false);
            Class_5e3.sub_be().var_95 = 0;
            Class_5e3.sub_be().sub_14a();
            return;
         }
      }

   }

   public final void sub_4a(int var1, Class_900 var2) {
      if (!Class_5e3.sub_be().var_b9) {
         InputHandler var3 = InputHandler.sub_5f();
         if (var1 == 50) {
            var3.sub_107(1, false);
            return;
         }

         if (var1 == 56) {
            var3.sub_107(2, false);
            return;
         }

         if (var1 == 52) {
            var3.sub_107(7, false);
            return;
         }

         if (var1 == 54) {
            var3.sub_107(8, false);
            return;
         }

         if (var1 == 53 || var2.getGameAction(var1) == 8) {
            var3.sub_107(0, false);
            return;
         }

         if (var2.getGameAction(var1) == 1) {
            var3.sub_107(1, false);
            return;
         }

         if (var2.getGameAction(var1) == 6) {
            var3.sub_107(2, false);
            return;
         }

         if (var2.getGameAction(var1) == 2) {
            var3.sub_107(7, false);
            return;
         }

         if (var2.getGameAction(var1) == 5) {
            var3.sub_107(8, false);
            return;
         }
      } else if (var1 == 42) {
         Class_5e3.sub_be().sub_1a2();
      }

   }
}
