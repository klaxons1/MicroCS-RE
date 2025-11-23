package com.m3gworks.microcs; 
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.m3g.Camera;
import javax.microedition.m3g.Graphics3D;
import javax.microedition.m3g.Transform;

public class Class_900 extends GameCanvas {
   private static Class_900 var_8d;
   private Graphics3D var_b5 = Graphics3D.getInstance();
   private Graphics var_1bb = this.getGraphics();
   public boolean var_234;

   public Class_900() {
      super(false);
      this.sub_18();
   }

   public final void sub_18() {
      if (GameConfig.sub_17().sub_361()) {
         this.setFullScreenMode(true);
      }

      MapLoader.sub_41().sub_2e1(this.getWidth(), this.getHeight());
      Class_24d.sub_d().sub_fb(Class_24d.sub_d().sub_db("MAIN"), this);
      this.sub_19e(false);
   }

   public static Class_900 sub_7a() {
      var_8d = null;

      try {
         var_8d = (Class_900) GameConfig.sub_17().sub_106().newInstance();
      } catch (InstantiationException var1) {
         var1.printStackTrace();
      } catch (IllegalAccessException var2) {
         var2.printStackTrace();
      }

      return var_8d;
   }

   public static Class_900 sub_d6() {
      return var_8d;
   }

   public final void sub_100() {
      try {
         this.sub_11f();
         this.sub_14e();
         this.flushGraphics();
      } catch (Exception var2) {
         System.out.println(var2);
         var2.printStackTrace();
      }
   }

   private void sub_11f() {
      try {
         InputHandler.sub_5f().sub_bb();
         EnemyAI.sub_53().sub_77();
         Class_497.sub_33().sub_19b();
         this.sub_40();
         this.var_b5.bindTarget(this.var_1bb, true, 6);
         this.var_b5.render(MapLoader.sub_41().var_168);
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         this.var_b5.releaseTarget();
         this.var_b5.setCamera((Camera)null, (Transform)null);
         this.var_b5.resetLights();
      }

   }

   public final void sub_14e() {
      Class_62a.sub_48().sub_88(this.var_1bb, this);
      Class_5e3.sub_be().sub_e7(this.var_1bb, this);
   }

   public void sub_40() {
   }

   public final void sub_19e(boolean var1) {
      this.var_234 = var1;
      float var2 = (float)this.getWidth() / (float)this.getHeight();
      Camera var3 = Class_24d.sub_d().var_c8;
      float var4 = 60.0F / var2;
      if (var1) {
         var4 /= 2.0F;
      }

      var3.setPerspective(var4, var2, 0.1F, 300.0F);
   }

   public void keyPressed(int var1) {
      Class_646.sub_62().sub_28(var1, this);
   }

   public void keyReleased(int var1) {
      Class_646.sub_62().sub_4a(var1, this);
   }

   public static void sub_1f3() {
      var_8d.var_1bb = null;
      var_8d.var_b5 = null;
      var_8d = null;
   }

   public void sizeChanged(int var1, int var2) {
      this.var_1bb = this.getGraphics();
   }
}
