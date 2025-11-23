package com.m3gworks.microcs; 
import com.m3gworks.engine.GameMIDlet;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class Class_58d extends Canvas implements Runnable {
   private static Image var_23 = null;
   private int var_45 = this.getWidth();
   private static int var_d1 = 10;
   private static int var_216 = 1000;
   private int var_25a = 0;

   private Class_58d() {
      this.setFullScreenMode(true);
   }

   public final void paint(Graphics var1) {
      var1.setColor(0, 0, 0);
      var1.fillRect(0, 0, this.getWidth(), this.getHeight());
      var1.drawImage(var_23, this.var_45, this.getHeight() / 2, 6);
   }

   public final void run() {
      while(true) {
         if (this.var_45 <= (this.getWidth() - var_23.getWidth()) / 2) {
            this.var_25a += var_d1;
            if (this.var_25a > var_216) {
               sub_ae();
               GameMIDlet.sub_f().var_3a.setCurrent(GameCanvas.getInstance());
               GameCanvas.getInstance().onSizeChanged();
               return;
            }
         }

         try {
            Thread.sleep((long)var_d1);
         } catch (InterruptedException var2) {
            var2.printStackTrace();
         }

         if (this.var_45 > (this.getWidth() - var_23.getWidth()) / 2) {
            this.var_45 -= 2;
         }

         this.repaint();
      }
   }

   private static void sub_57() {
      var_23 = null;
   }

   public static void sub_ae() {
      GameCanvas.initializeMainMenu();
   }

   public static void sub_db() {
      sub_57();
      GameCanvas.loadMainMenuResources();
   }
}
