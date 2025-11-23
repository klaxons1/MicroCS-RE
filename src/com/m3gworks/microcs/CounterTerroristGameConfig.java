package com.m3gworks.microcs; 
import javax.microedition.m3g.Camera;

public class CounterTerroristGameConfig extends GameConfig {
   public static Class GameScreenClass;
   public static Class PlayerClass;
   public static Class MainMenuClass;
   public static Class var_110;
   public static Class var_11f;
   public static Class var_162;
   public static Class var_1b4;
   public static Class var_1d2;

   public final boolean isMultiplayer() {
      return false;
   }

   public final boolean hasSound() {
      return true;
   }

   public final boolean sub_a5() {
      return false;
   }

   public final Class sub_106() {
      Class var10000 = GameScreenClass;
      if (var10000 == null) {
         try {
            var10000 = Class.forName("com.m3gworks.microcs.Class_899");
         } catch (ClassNotFoundException var1) {
            throw new NoClassDefFoundError(var1.getMessage());
         }

         GameScreenClass = var10000;
         return var10000;
      } else {
         return var10000;
      }
   }

   public final Class sub_14f() {
      Class var10000 = PlayerClass;
      if (var10000 == null) {
         try {
            var10000 = Class.forName("com.m3gworks.microcs.Class_2fa");
         } catch (ClassNotFoundException var1) {
            throw new NoClassDefFoundError(var1.getMessage());
         }

         PlayerClass = var10000;
         return var10000;
      } else {
         return var10000;
      }
   }

   public final Class sub_199() {
      Class var10000 = MainMenuClass;
      if (var10000 == null) {
         try {
            var10000 = Class.forName("com.m3gworks.microcs.MainMenu");
         } catch (ClassNotFoundException var1) {
            throw new NoClassDefFoundError(var1.getMessage());
         }

         MainMenuClass = var10000;
         return var10000;
      } else {
         return var10000;
      }
   }

   public final Class sub_1fb() {
      Class var10000 = var_110;
      if (var10000 == null) {
         try {
            var10000 = Class.forName("com.m3gworks.microcs.HUDRenderer");
         } catch (ClassNotFoundException var1) {
            throw new NoClassDefFoundError(var1.getMessage());
         }

         var_110 = var10000;
         return var10000;
      } else {
         return var10000;
      }
   }

   public final Class sub_23a() {
      Class var10000 = var_11f;
      if (var10000 == null) {
         try {
            var10000 = Class.forName("com.m3gworks.microcs.BuyMenu");
         } catch (ClassNotFoundException var1) {
            throw new NoClassDefFoundError(var1.getMessage());
         }

         var_11f = var10000;
         return var10000;
      } else {
         return var10000;
      }
   }

   public final Class sub_274() {
      Class var10000 = var_162;
      if (var10000 == null) {
         try {
            var10000 = Class.forName("com.m3gworks.microcs.GameController");
         } catch (ClassNotFoundException var1) {
            throw new NoClassDefFoundError(var1.getMessage());
         }

         var_162 = var10000;
         return var10000;
      } else {
         return var10000;
      }
   }

   public final Class sub_2b8() {
      Class var10000 = var_1b4;
      if (var10000 == null) {
         try {
            var10000 = Class.forName("com.m3gworks.microcs.Class_723");
         } catch (ClassNotFoundException var1) {
            throw new NoClassDefFoundError(var1.getMessage());
         }

         var_1b4 = var10000;
         return var10000;
      } else {
         return var10000;
      }
   }

   public final Class sub_2cf() {
      Class var10000 = var_1d2;
      if (var10000 == null) {
         try {
            var10000 = Class.forName("com.m3gworks.microcs.Class_345");
         } catch (ClassNotFoundException var1) {
            throw new NoClassDefFoundError(var1.getMessage());
         }

         var_1d2 = var10000;
         return var10000;
      } else {
         return var10000;
      }
   }

   public final boolean sub_319() {
      return false;
   }

   public final boolean sub_361() {
      return true;
   }

   public final int sub_3bd() {
      return 2;
   }

   public final int sub_3d3() {
      return 3;
   }

   public final void sub_40a() {
      MainMenu.sub_338();
   }

   public final void sub_45a() {
      HUDRenderer.sub_131();
   }

   public final void sub_490() {
      BuyMenu.sub_2b();
   }

   public final void sub_49f() {
      MainMenu.sub_351();
   }

   public final void sub_4a9() {
      HUDRenderer.sub_181();
   }

   public final void sub_4dd() {
      BuyMenu.sub_85();
   }

   public final void initializeAllMaps() {
      MapParameters var1;
      (var1 = new MapParameters()).mapName = "Military base";
      var1.mapFilePath = "/res/map/military/military.m3g";
      var1.isEnabled = true;
      var1.spawnPoints = new float[]{-84.0F, 3.2F, -63.0F, -34.0F, 0.05F, 81.0F, 35.0F, 0.05F, 106.0F, 108.0F, 0.05F, -94.0F};
      var1.objectIds = new int[]{239, 240, 241, 243, 244, 246, 247, 248, 249, 250, 252, 253, 254, 255, 256, 257, 258, 259, 260, 261, 262, 263, 264, 265, 266};
      MapLoader.sub_41().sub_2f3(var1);
      (var1 = new MapParameters()).mapName = "Command";
      var1.mapFilePath = "/res/map/command/command.m3g";
      var1.isEnabled = true;
      var1.spawnPoints = new float[]{25.3F, 3.2F, 74.66F, -87.7F, 0.05F, 47.9F, -81.3F, 0.05F, -18.6F, 63.1F, 0.05F, -87.8F};
      var1.objectIds = new int[]{296, 297, 298, 299, 300, 301, 302, 303, 304, 305, 306, 307, 308, 309, 310, 311, 312, 313, 316, 317, 318, 319, 320, 321, 322, 323, 324, 325, 326, 327, 328, 329, 331, 332, 333, 334};
      MapLoader.sub_41().sub_2f3(var1);
      (var1 = new MapParameters()).mapName = "Street";
      var1.mapFilePath = "/res/map/street/street.m3g";
      var1.isEnabled = true;
      var1.spawnPoints = new float[]{26.1F, 3.2F, -12.1F, 74.8F, 0.05F, -120.0F, -75.6F, 0.05F, -124.0F, 90.3F, 0.05F, 111.0F};
      var1.objectIds = new int[]{264, 265, 266, 267, 269, 270, 272, 273, 274, 275, 276, 278, 279, 280, 281, 286, 287, 288, 289, 290, 291, 292, 293, 294, 295, 296, 297, 298};
      MapLoader.sub_41().sub_2f3(var1);
      (var1 = new MapParameters()).mapName = "Depository";
      var1.mapFilePath = "/res/map/depository/depository.m3g";
      var1.isEnabled = true;
      var1.spawnPoints = new float[]{-116.7F, 3.2F, -112.4F, -42.7F, 0.05F, 69.0F, 98.0F, 0.05F, 128.9F, -18.1F, 0.05F, 26.7F};
      var1.objectIds = new int[]{213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241};
      MapLoader.sub_41().sub_2f3(var1);
      (var1 = new MapParameters()).mapName = "Fortress";
      var1.mapFilePath = "/res/map/fortress/fortress.m3g";
      var1.isEnabled = true;
      var1.spawnPoints = new float[]{-2.3F, 3.2F, -8.3F, 1.5F, 0.05F, -96.0F, -5.4F, 0.05F, 102.3F, 90.0F, 0.05F, 50.20508F};
      var1.objectIds = new int[]{314, 315, 316, 317, 318, 319, 320, 321, 323, 324, 325, 326, 327, 328, 329, 330, 331, 332, 333, 334, 335, 336, 337, 338, 339, 340, 341, 342, 343, 344, 345, 346, 347, 348, 349, 350, 351, 352, 353, 354, 355, 356, 357, 358, 359};
      MapLoader.sub_41().sub_2f3(var1);
      (var1 = new MapParameters()).mapName = "Construction";
      var1.mapFilePath = "/res/map/construction/construction.m3g";
      var1.isEnabled = true;
      var1.spawnPoints = new float[]{-51.9F, 3.2F, 123.8F, -13.59F, 0.05F, -101.9F, -104.8F, 0.05F, -127.3F, 101.2F, 0.05F, 119.4F};
      var1.objectIds = new int[]{274, 275, 277, 278, 279, 281, 282, 283, 284, 285, 286, 287, 288, 289, 290, 291, 292, 293, 295, 297, 298, 299, 300, 301, 302, 303, 304, 305, 306, 307, 309, 310, 312};
      MapLoader.sub_41().sub_2f3(var1);
   }

   public final void initializeAllWeapons() {
      WeaponParameters var1;
      (var1 = new WeaponParameters()).name = "MP5";
      var1.clipCapacity = 30;
      var1.initialAmmo = var1.clipCapacity * 3;
      var1.price = 1500;
      var1.weight = "3.42KG";
      var1.weaponType = 10;
      var1.fireAnimation = new int[2][1][4];
      var1.fireAnimation[0][0][0] = 0;
      var1.fireAnimation[0][0][1] = 0;
      var1.fireAnimation[0][0][2] = 87;
      var1.fireAnimation[0][0][3] = 68;
      var1.fireAnimation[1][0][0] = 0;
      var1.fireAnimation[1][0][1] = 0;
      var1.fireAnimation[1][0][2] = 64;
      var1.fireAnimation[1][0][3] = 50;
      var1.spriteData = new int[2][4];
      var1.spriteData[0][0] = 0;
      var1.spriteData[0][1] = 0;
      var1.spriteData[0][2] = 71;
      var1.spriteData[0][3] = 24;
      var1.spriteData[1][0] = 0;
      var1.spriteData[1][1] = 0;
      var1.spriteData[1][2] = 53;
      var1.spriteData[1][3] = 18;
      WeaponShop.registerWeapon(var1);
      WeaponParameters var2;
      (var2 = new WeaponParameters()).name = "M4A1";
      var2.clipCapacity = 30;
      var2.initialAmmo = var2.clipCapacity * 3;
      var2.price = 3000;
      var2.weight = "2.22KG";
      var2.weaponType = 10;
      var2.fireAnimation = new int[2][1][4];
      var2.fireAnimation[0][0][0] = 0;
      var2.fireAnimation[0][0][1] = 68;
      var2.fireAnimation[0][0][2] = 87;
      var2.fireAnimation[0][0][3] = 68;
      var2.fireAnimation[1][0][0] = 0;
      var2.fireAnimation[1][0][1] = 50;
      var2.fireAnimation[1][0][2] = 64;
      var2.fireAnimation[1][0][3] = 51;
      var2.spriteData = new int[2][4];
      var2.spriteData[0][0] = 0;
      var2.spriteData[0][1] = 24;
      var2.spriteData[0][2] = 80;
      var2.spriteData[0][3] = 24;
      var2.spriteData[1][0] = 0;
      var2.spriteData[1][1] = 18;
      var2.spriteData[1][2] = 58;
      var2.spriteData[1][3] = 18;
      WeaponShop.registerWeapon(var2);
      WeaponParameters var3;
      (var3 = new WeaponParameters()).name = "AK47";
      var3.clipCapacity = 30;
      var3.initialAmmo = var3.clipCapacity * 3;
      var3.price = 3000;
      var3.weight = "4.79KG";
      var3.weaponType = 10;
      var3.fireAnimation = new int[2][1][4];
      var3.fireAnimation[0][0][0] = 0;
      var3.fireAnimation[0][0][1] = 136;
      var3.fireAnimation[0][0][2] = 87;
      var3.fireAnimation[0][0][3] = 68;
      var3.fireAnimation[1][0][0] = 0;
      var3.fireAnimation[1][0][1] = 101;
      var3.fireAnimation[1][0][2] = 64;
      var3.fireAnimation[1][0][3] = 50;
      var3.spriteData = new int[2][4];
      var3.spriteData[0][0] = 0;
      var3.spriteData[0][1] = 48;
      var3.spriteData[0][2] = 95;
      var3.spriteData[0][3] = 24;
      var3.spriteData[1][0] = 0;
      var3.spriteData[1][1] = 36;
      var3.spriteData[1][2] = 69;
      var3.spriteData[1][3] = 19;
      WeaponShop.registerWeapon(var3);
      WeaponParameters var4;
      (var4 = new WeaponParameters()).name = "AWP";
      var4.clipCapacity = 10;
      var4.initialAmmo = var4.clipCapacity * 3;
      var4.price = 5000;
      var4.weight = "6KG";
      var4.weaponType = 11;
      var4.fireAnimation = new int[2][1][4];
      var4.fireAnimation[0][0][0] = 0;
      var4.fireAnimation[0][0][1] = 204;
      var4.fireAnimation[0][0][2] = 87;
      var4.fireAnimation[0][0][3] = 68;
      var4.fireAnimation[1][0][0] = 0;
      var4.fireAnimation[1][0][1] = 151;
      var4.fireAnimation[1][0][2] = 64;
      var4.fireAnimation[1][0][3] = 51;
      var4.spriteData = new int[2][4];
      var4.spriteData[0][0] = 0;
      var4.spriteData[0][1] = 72;
      var4.spriteData[0][2] = 119;
      var4.spriteData[0][3] = 24;
      var4.spriteData[1][0] = 0;
      var4.spriteData[1][1] = 55;
      var4.spriteData[1][2] = 75;
      var4.spriteData[1][3] = 18;
      WeaponShop.registerWeapon(var4);
      WeaponParameters var5;
      (var5 = new WeaponParameters()).name = "USP";
      var5.clipCapacity = 12;
      var5.initialAmmo = var5.clipCapacity * 5;
      var5.price = 500;
      var5.weight = "1KG";
      var5.weaponType = 20;
      var5.fireAnimation = new int[2][1][4];
      var5.fireAnimation[0][0][0] = 114;
      var5.fireAnimation[0][0][1] = 0;
      var5.fireAnimation[0][0][2] = 52;
      var5.fireAnimation[0][0][3] = 68;
      var5.fireAnimation[1][0][0] = 83;
      var5.fireAnimation[1][0][1] = 0;
      var5.fireAnimation[1][0][2] = 38;
      var5.fireAnimation[1][0][3] = 50;
      var5.spriteData = new int[2][4];
      var5.spriteData[0][0] = 81;
      var5.spriteData[0][1] = 24;
      var5.spriteData[0][2] = 39;
      var5.spriteData[0][3] = 24;
      var5.spriteData[1][0] = 58;
      var5.spriteData[1][1] = 18;
      var5.spriteData[1][2] = 29;
      var5.spriteData[1][3] = 19;
      WeaponShop.registerWeapon(var5);
      WeaponParameters var6;
      (var6 = new WeaponParameters()).name = "DE";
      var6.clipCapacity = 7;
      var6.initialAmmo = var6.clipCapacity * 5;
      var6.price = 650;
      var6.weight = "1.8KG";
      var6.weaponType = 20;
      var6.fireAnimation = new int[2][1][4];
      var6.fireAnimation[0][0][0] = 116;
      var6.fireAnimation[0][0][1] = 68;
      var6.fireAnimation[0][0][2] = 50;
      var6.fireAnimation[0][0][3] = 68;
      var6.fireAnimation[1][0][0] = 84;
      var6.fireAnimation[1][0][1] = 50;
      var6.fireAnimation[1][0][2] = 37;
      var6.fireAnimation[1][0][3] = 51;
      var6.spriteData = new int[2][4];
      var6.spriteData[0][0] = 73;
      var6.spriteData[0][1] = 0;
      var6.spriteData[0][2] = 47;
      var6.spriteData[0][3] = 24;
      var6.spriteData[1][0] = 52;
      var6.spriteData[1][1] = 0;
      var6.spriteData[1][2] = 35;
      var6.spriteData[1][3] = 18;
      WeaponShop.registerWeapon(var6);
      WeaponParameters var7;
      (var7 = new WeaponParameters()).name = "57";
      var7.clipCapacity = 20;
      var7.initialAmmo = var7.clipCapacity * 5;
      var7.price = 750;
      var7.weight = "0.618KG";
      var7.weaponType = 20;
      var7.fireAnimation = new int[2][1][4];
      var7.fireAnimation[0][0][0] = 120;
      var7.fireAnimation[0][0][1] = 136;
      var7.fireAnimation[0][0][2] = 46;
      var7.fireAnimation[0][0][3] = 68;
      var7.fireAnimation[1][0][0] = 87;
      var7.fireAnimation[1][0][1] = 101;
      var7.fireAnimation[1][0][2] = 34;
      var7.fireAnimation[1][0][3] = 50;
      var7.spriteData = new int[2][4];
      var7.spriteData[0][0] = 0;
      var7.spriteData[0][1] = 145;
      var7.spriteData[0][2] = 40;
      var7.spriteData[0][3] = 24;
      var7.spriteData[1][0] = 0;
      var7.spriteData[1][1] = 111;
      var7.spriteData[1][2] = 29;
      var7.spriteData[1][3] = 18;
      WeaponShop.registerWeapon(var7);
      WeaponParameters var8;
      (var8 = new WeaponParameters()).name = "Knife";
      var8.clipCapacity = 1;
      var8.initialAmmo = var8.clipCapacity;
      var8.price = 0;
      var8.weaponType = 30;
      var8.fireAnimation = new int[2][5][4];
      var8.fireAnimation[0][0][0] = 0;
      var8.fireAnimation[0][0][1] = 272;
      var8.fireAnimation[0][0][2] = 70;
      var8.fireAnimation[0][0][3] = 100;
      var8.fireAnimation[0][1][0] = 0;
      var8.fireAnimation[0][1][1] = 392;
      var8.fireAnimation[0][1][2] = 166;
      var8.fireAnimation[0][1][3] = 46;
      var8.fireAnimation[0][2][0] = 0;
      var8.fireAnimation[0][2][1] = 438;
      var8.fireAnimation[0][2][2] = 166;
      var8.fireAnimation[0][2][3] = 57;
      var8.fireAnimation[0][3][0] = 70;
      var8.fireAnimation[0][3][1] = 310;
      var8.fireAnimation[0][3][2] = 28;
      var8.fireAnimation[0][3][3] = 62;
      var8.fireAnimation[0][4][0] = 100;
      var8.fireAnimation[0][4][1] = 272;
      var8.fireAnimation[0][4][2] = 66;
      var8.fireAnimation[0][4][3] = 120;
      var8.fireAnimation[1][0][0] = 0;
      var8.fireAnimation[1][0][1] = 202;
      var8.fireAnimation[1][0][2] = 52;
      var8.fireAnimation[1][0][3] = 74;
      var8.fireAnimation[1][1][0] = 0;
      var8.fireAnimation[1][1][1] = 290;
      var8.fireAnimation[1][1][2] = 107;
      var8.fireAnimation[1][1][3] = 35;
      var8.fireAnimation[1][2][0] = 0;
      var8.fireAnimation[1][2][1] = 325;
      var8.fireAnimation[1][2][2] = 90;
      var8.fireAnimation[1][2][3] = 42;
      var8.fireAnimation[1][3][0] = 50;
      var8.fireAnimation[1][3][1] = 230;
      var8.fireAnimation[1][3][2] = 22;
      var8.fireAnimation[1][3][3] = 46;
      var8.fireAnimation[1][4][0] = 72;
      var8.fireAnimation[1][4][1] = 202;
      var8.fireAnimation[1][4][2] = 49;
      var8.fireAnimation[1][4][3] = 88;
      var8.spriteData = new int[2][4];
      var8.spriteData[0][0] = 40;
      var8.spriteData[0][1] = 148;
      var8.spriteData[0][2] = 80;
      var8.spriteData[0][3] = 14;
      var8.spriteData[1][0] = 29;
      var8.spriteData[1][1] = 113;
      var8.spriteData[1][2] = 58;
      var8.spriteData[1][3] = 11;
      WeaponShop.registerWeapon(var8);
      WeaponParameters var9;
      (var9 = new WeaponParameters()).name = "Grenade";
      var9.clipCapacity = 1;
      var9.initialAmmo = var9.clipCapacity;
      var9.price = 300;
      var9.weaponType = 40;
      var9.fireAnimation = new int[2][1][4];
      var9.fireAnimation[0][0][0] = 88;
      var9.fireAnimation[0][0][1] = 204;
      var9.fireAnimation[0][0][2] = 78;
      var9.fireAnimation[0][0][3] = 68;
      var9.fireAnimation[1][0][0] = 64;
      var9.fireAnimation[1][0][1] = 151;
      var9.fireAnimation[1][0][2] = 57;
      var9.fireAnimation[1][0][3] = 51;
      var9.spriteData = new int[2][4];
      var9.spriteData[0][0] = 0;
      var9.spriteData[0][1] = 96;
      var9.spriteData[0][2] = 46;
      var9.spriteData[0][3] = 40;
      var9.spriteData[1][0] = 0;
      var9.spriteData[1][1] = 73;
      var9.spriteData[1][2] = 34;
      var9.spriteData[1][3] = 29;
      WeaponShop.registerWeapon(var9);
      WeaponParameters var10;
      (var10 = new WeaponParameters()).name = "Kevlar";
      var10.clipCapacity = 1;
      var10.initialAmmo = var10.clipCapacity;
      var10.price = 650;
      var10.weaponType = 60;
      var10.spriteData = new int[2][4];
      var10.spriteData[0][0] = 78;
      var10.spriteData[0][1] = 96;
      var10.spriteData[0][2] = 42;
      var10.spriteData[0][3] = 52;
      var10.spriteData[1][0] = 58;
      var10.spriteData[1][1] = 73;
      var10.spriteData[1][2] = 29;
      var10.spriteData[1][3] = 40;
      WeaponShop.registerWeapon(var10);
      WeaponParameters var11;
      (var11 = new WeaponParameters()).name = "1 ammo";
      var11.price = 60;
      var11.weaponType = 50;
      var11.spriteData = new int[2][4];
      var11.spriteData[0][0] = 0;
      var11.spriteData[0][1] = 136;
      var11.spriteData[0][2] = 49;
      var11.spriteData[0][3] = 9;
      var11.spriteData[1][0] = 0;
      var11.spriteData[1][1] = 102;
      var11.spriteData[1][2] = 36;
      var11.spriteData[1][3] = 8;
      WeaponShop.registerWeapon(var11);
      WeaponParameters var12;
      (var12 = new WeaponParameters()).name = "2 ammo";
      var12.price = 25;
      var12.weaponType = 51;
      var12.spriteData = new int[2][4];
      var12.spriteData[0][0] = 49;
      var12.spriteData[0][1] = 136;
      var12.spriteData[0][2] = 29;
      var12.spriteData[0][3] = 11;
      var12.spriteData[1][0] = 36;
      var12.spriteData[1][1] = 102;
      var12.spriteData[1][2] = 22;
      var12.spriteData[1][3] = 9;
      WeaponShop.registerWeapon(var12);
   }

   public final void sub_52b() {
      Camera var1 = new Camera();
      Class_24d.sub_d().sub_7d("MAIN", var1);
   }
}
