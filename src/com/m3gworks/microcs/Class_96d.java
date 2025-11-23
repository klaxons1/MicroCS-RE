package com.m3gworks.microcs; 
import java.util.TimerTask;

public final class Class_96d extends TimerTask {
   public int var_4a;

   public Class_96d(int var1) {
      this.var_4a = var1 + 1;
   }

   public final void run() {
      --this.var_4a;
      if (this.var_4a == 0) {
         this.cancel();
      }

   }
}
