package com.m3gworks.microcs; 
import javax.microedition.m3g.Appearance;
import javax.microedition.m3g.Mesh;
import javax.microedition.m3g.Node;
import javax.microedition.m3g.VertexArray;
import javax.microedition.m3g.World;

public abstract class Class_719 {
   public Node var_bf;
   public Node var_d4;

   public Class_719() {
   }

   public Class_719(Class_79b var1) {
   }

   public abstract Node sub_41(World var1);

   public void sub_1c() {
      this.var_bf = null;
      this.var_d4 = null;
   }

   public static void sub_31(Mesh var0, Mesh var1) {
      var1.setAppearance(0, (Appearance)null);
      var1.setAppearance(0, var0.getAppearance(0));
      VertexArray var2 = var0.getVertexBuffer().getNormals();
      var1.getVertexBuffer().setNormals(var2);
      float[] var3 = new float[4];
      VertexArray var4 = var0.getVertexBuffer().getPositions(var3);
      float[] var5 = new float[]{var3[1], var3[2], var3[3]};
      var1.getVertexBuffer().setPositions(var4, var3[0], var5);
      VertexArray var6 = var0.getVertexBuffer().getTexCoords(0, var3);
      var5[0] = var3[1];
      var5[1] = var3[2];
      var5[2] = var3[3];
      var1.getVertexBuffer().setTexCoords(0, var6, var3[0], var5);
   }

   public final void sub_8c(boolean var1) {
      this.var_bf.setRenderingEnable(var1);
   }
}
