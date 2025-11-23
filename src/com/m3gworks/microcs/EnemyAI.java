package com.m3gworks.microcs;
import java.util.Enumeration;
import java.util.Hashtable;

public abstract class EnemyAI {
    private static EnemyAI var_1d;

    public static EnemyAI sub_53() {
        if (var_1d == null) {
            try {
                var_1d = (EnemyAI) GameConfig.sub_17().sub_2b8().newInstance();
            } catch (InstantiationException var1) {
                var1.printStackTrace();
            } catch (IllegalAccessException var2) {
                var2.printStackTrace();
            }
        }

        return var_1d;
    }

    public final void sub_77() {
        if (Class_1f1.sub_27().var_7a != 1) {
            Hashtable var1;
            Enumeration var2 = (var1 = Class_497.sub_33().var_52).keys();

            while(var2.hasMoreElements()) {
                Integer var3 = (Integer)var2.nextElement();
                Class_79b var4;
                if ((var4 = (Class_79b)var1.get(var3)).var_140 == 2) {
                    this.sub_98(var4);
                    sub_f3(var4);
                }
            }

        }
    }

    public abstract void sub_98(Class_79b var1);

    public static void sub_f3(Class_79b var0) {
        boolean var2 = Class_497.sub_33().var_2c.sub_126(var0);
        var0.var_37b = var2;
    }
}