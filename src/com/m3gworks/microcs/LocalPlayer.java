package com.m3gworks.microcs; 
import java.util.Enumeration;
import java.util.Hashtable;
import javax.microedition.m3g.Camera;
import javax.microedition.m3g.Mesh;
import javax.microedition.m3g.Node;
import javax.microedition.m3g.RayIntersection;
import javax.microedition.m3g.World;

public final class LocalPlayer extends Class_811 implements ChooseTeam {
   public int teamId;
   public int hp;
   public WeaponShop weaponShop;
   public Grenade grenade;
   public int money = 1000;
   private int bloodEffectTimer = 3;

   public LocalPlayer(int var1, String var2, int var3, int var4, Class_719 var5) {
      super(var1, var2, var4, var5);
      this.teamId = var3;
   }

   public final void initialize(World var1) {
      super.initialize(var1);
      if (this.weaponShop == null) {
         this.weaponShop = new WeaponShop();
      }

      if (this.grenade == null) {
         this.grenade = new Grenade(this);
      }

   }

   public final void reset() {
      super.reset();
      this.weaponShop.cleanup();
      this.weaponShop = null;
      this.grenade.sub_141();
      this.grenade = null;
   }

   public final void respawn() {
      super.respawn();
      if (this.hp <= 0) {
         this.weaponShop.initializeInventory();
      }

      this.hp = 100;
   }

   public final int fireWeapon() {
      int var1;
      if ((var1 = this.weaponShop.currentWeaponSlot) != 3) {
         this.weaponShop.useAmmo();
      }

      World var2 = MapLoader.sub_41().var_168;
      if (var1 == 4) {
         float[] var3;
         (var3 = this.sub_1f9())[1] = var3[1] * 1.2F;
         float[] var4 = this.sub_175(1, 1.0F);
         this.grenade.sub_55(var2, var3, var4);
      } else {
         RayIntersection var15 = new RayIntersection();
         Camera var16 = Class_24d.sub_d().var_c8;
         if (var2.pick(-1, 0.5F, 0.5F, var16, var15)) {
            float[] var5 = new float[6];
            var15.getRay(var5);
            float var6 = var15.getDistance();
            float var7 = var5[0] + var5[3] * var6;
            float var8 = var5[1] + var5[4] * var6;
            float var9 = var5[2] + var5[5] * var6;
            Node var10 = var15.getIntersected();
            PlayerCharacter var11 = null;
            Object var12;
            if ((var12 = ((Mesh)var10).getUserObject()) != null && var12 instanceof PlayerCharacter) {
               var11 = (PlayerCharacter)var12;
            }

            if (var11 != null) {
               if (var11.var_3c <= 0) {
                  return 2;
               }

               if (var1 == 3) {
                  float var13 = (var7 - var5[0]) * (var7 - var5[0]) + (var8 - var5[1]) * (var8 - var5[1]) + (var9 - var5[2]) * (var9 - var5[2]);
                  float var14 = var11.var_284.var_f1 * 2.0F * 1.2F;
                  if (var13 > var14 * var14) {
                     return 2;
                  }
               }

               int var17 = var11.takeDamage(this, this.weaponShop.currentWeaponSlot, var15, var2);
               this.money += var17 * 10;
               if (var11.var_3c <= 0) {
                  this.money += 500;
               }

               return 1;
            }

            if (((Mesh)var10).getAppearance(0).getCompositingMode().getBlending() != 64 && (var1 == 1 || var1 == 2)) {
               if (GameConfig.sub_17().isMultiplayer()) {
                  Class_852.sub_42().sub_c1(1, var15, var2);
               }

               if (GameConfig.sub_17().hasSound()) {
                  Class_7ee.sub_2e().sub_e3(2, var15, var2, var16);
               }

               if (GameConfig.sub_17().sub_a5()) {
                  Class_7ee.sub_2e().sub_e3(3, var15, var2, var16);
               }
            }
         }
      }

      return 2;
   }

   public final int takeDamage(Class_79b var1, int var2, RayIntersection var3, World var4) {
      PlayerCharacter var5 = (PlayerCharacter)var1;
      int var6 = 0;
      int var7 = var5.var_78.currentWeaponSlot;
      if (this.hp > 0) {
         if (var7 != 3) {
            this.startBleeding();
         }

         if (var7 == 1) {
            if (var5.var_78.getCurrentWeapon().weaponType == 11) {
               var6 = this.hp;
            } else {
               var6 = Randomizer.random.nextInt(25);
            }
         } else if (var7 == 2) {
            var6 = Randomizer.random.nextInt(15);
         } else if (var7 == 3) {
            var6 = Randomizer.random.nextInt(20);
         } else if (var7 == 4) {
            var6 = Randomizer.random.nextInt(6) * 20;
         }

         var6 = var6 == 0 ? 1 : var6;
         if (this.weaponShop.armorLevel > 0) {
            WeaponShop var10000 = this.weaponShop;
            var10000.armorLevel -= var6 - var6 / 3;
            this.weaponShop.armorLevel = this.weaponShop.armorLevel < 0 ? 0 : this.weaponShop.armorLevel;
            var6 /= 3;
         }

         this.applyDamage(var6);
      }

      if (this.hp <= 0) {
         ((Class_2fa)Class_1f1.sub_27()).sub_1a(this);
      }

      return var6;
   }

   public final Class_79b findPlayerInRadius(BoundingSphere var1) {
      Class_79b var2 = null;
      Hashtable var3;
      Enumeration var4 = (var3 = Class_497.sub_33().var_52).keys();

      while(var4.hasMoreElements()) {
         Integer var5 = (Integer)var4.nextElement();
         Class_79b var6;
         if (((ChooseTeam)(var6 = (Class_79b)var3.get(var5))).getHealth() > 0 && var6 != this && var6.var_284.sub_1b(var1)) {
            var2 = var6;
            break;
         }
      }

      return var2;
   }

   public final void spendMoney(int var1) {
      this.money -= var1;
   }

   private void startBleeding() {
      this.bloodEffectTimer = 0;
   }

   public final boolean isBleeding() {
      if (this.bloodEffectTimer < 3) {
         ++this.bloodEffectTimer;
         return true;
      } else {
         return false;
      }
   }

   private void applyDamage(int var1) {
      this.hp -= var1;
      if (this.hp < 0) {
         this.hp = 0;
      }

   }

   public final int getHealth() {
      return this.hp;
   }

   public final WeaponShop getWeaponShop() {
      return this.weaponShop;
   }

   public final Grenade getGranade() {
      return this.grenade;
   }

   public final int getTeamId() {
      return this.teamId;
   }
}
