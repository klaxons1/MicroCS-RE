package com.m3gworks.microcs; 
import java.util.Enumeration;
import java.util.Hashtable;

public class Class_2fa extends Class_1f1 {
   private int var_33 = 0;
   private int var_8c = 0;

   public final void sub_c6() {
      Class_497.sub_33().sub_10f();
      if (GameConfig.sub_17().isMultiplayer()) {
         Class_852.sub_42().sub_106(MapLoader.sub_41().var_168);
      }

   }

   public final void sub_e2() {
      InputHandler.sub_5f().sub_107(-1, false);
   }

   public final void sub_ee() {
      this.sub_79();
   }

   public final void sub_128() {
      this.var_33 = 0;
      this.var_8c = 0;
      Class_145.sub_56();
      Class_145.sub_ef();
   }

   public final void sub_1a(Class_79b var1) {
      ChooseTeam var2;
      int var3 = (var2 = (ChooseTeam)var1).getTeamId();
      boolean var4 = true;
      Hashtable var5;
      Enumeration var6 = (var5 = Class_497.sub_33().var_52).keys();

      while(var6.hasMoreElements()) {
         Integer var7 = (Integer)var6.nextElement();
         ChooseTeam var8;
         if ((var8 = (ChooseTeam)var5.get(var7)).getTeamId() == var3 && var8.getHealth() > 0) {
            var4 = false;
            break;
         }
      }

      Class_497.sub_33();
      if (var4) {
         if (var2.getTeamId() == 0) {
            super.var_102 = 2;
            ++this.var_8c;
            return;
         }

         super.var_102 = 1;
         ++this.var_33;
      }

   }
}
