package com.m3gworks.microcs; 
import javax.microedition.m3g.Camera;
import javax.microedition.m3g.RayIntersection;
import javax.microedition.m3g.World;

public final class PlayerCharacter extends Class_6c5 implements ChooseTeam {
   public int var_e;
   public int var_3c;
   public WeaponShop var_78;
   public Grenade var_a5;
   private Class_56b var_e3;
   public boolean var_130 = false;
   public boolean var_13b = false;

   public PlayerCharacter(int var1, String var2, int var3, int var4) {
      super(var1, var2, var4);
      this.var_e = var3;
   }

   public final void initialize(World var1) {
      super.initialize(var1);
      this.sub_5b(Class_24d.sub_d().sub_db("MAIN"));
      this.var_78 = new WeaponShop();
   }

   public final void reset() {
      super.reset();
      this.var_78.cleanup();
      this.var_78 = null;
      this.var_e3 = null;
   }

   public final void respawn() {
      super.respawn();
      if (this.var_3c <= 0) {
         this.var_78.initializeInventory();
      }

      WeaponParameters var1 = (WeaponParameters) WeaponShop.allWeapons.elementAt(WeaponShop.defaultPrimaryWeaponId);
      this.var_78.equipWeapon(var1);
      this.var_78.switchToWeaponSlot(1);
      this.var_3c = 100;
   }

   public final int fireWeapon() {
      this.var_e3.sub_eb(true);
      LocalPlayer var1 = (LocalPlayer)Class_497.sub_33().var_2c;
      if (Randomizer.random.nextInt(5) == 0) {
         var1.takeDamage(this, this.var_78.currentWeaponSlot, (RayIntersection)null, (World)null);
         this.var_13b = true;
         return 1;
      } else {
         return 2;
      }
   }

   public final int takeDamage(Class_79b var1, int var2, RayIntersection var3, World var4) {
      boolean var5 = false;
      if (this.var_3c <= 0) {
         return 0;
      } else {
         if (var2 != 4) {
            Class_7ee.sub_2e().sub_e3(1, var3, var4, Class_24d.sub_d().var_c8);
         }

         int var6 = (var6 = this.sub_71(var1, var2)) == 0 ? 1 : var6;
         this.sub_21(var6);
         if (this.var_3c <= 0) {
            this.sub_275(0);
            ((Class_2fa)Class_1f1.sub_27()).sub_1a(this);
         }

         return var6;
      }
   }

   private void sub_21(int var1) {
      this.var_3c -= var1;
      if (this.var_3c < 0) {
         this.var_3c = 0;
      }

      this.var_130 = true;
   }

   private void sub_5b(Camera var1) {
      this.var_e3 = Class_4e4.sub_38().sub_c3(var1, 1);
      ((TerroristModelLoader)super.var_255).var_68.addChild(this.var_e3.var_1a);
      this.var_e3.var_1a.translate(-0.03F, 2.0F, -0.2F);
   }

   private int sub_71(Class_79b var1, int var2) {
      LocalPlayer var3 = (LocalPlayer)var1;
      int var4 = 0;
      if (var2 == 1) {
         if (var3.weaponShop.getCurrentWeapon().weaponType == 11) {
            var4 = this.var_3c;
         } else {
            var4 = Randomizer.random.nextInt(60);
         }
      } else if (var2 == 2) {
         var4 = Randomizer.random.nextInt(40);
      } else if (var2 == 3) {
         var4 = Randomizer.random.nextInt(30);
      } else if (var2 == 4) {
         var4 = Randomizer.random.nextInt(6) * 20;
      }

      return var4;
   }

   public final int getHealth() {
      return this.var_3c;
   }

   public final int getTeamId() {
      return this.var_e;
   }

   public final WeaponShop getWeaponShop() {
      return this.var_78;
   }

   public final Grenade getGranade() {
      return this.var_a5;
   }
}
