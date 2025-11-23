package com.m3gworks.microcs;

import com.m3gworks.engine.GameMIDlet;

public class MicroCsMIDlet extends GameMIDlet {
    public final void sub_35() {
        Class_58d.sub_ae();
        GameMIDlet.sub_f().var_3a.setCurrent(GameCanvas.getInstance());
        GameCanvas.getInstance().onSizeChanged();
    }
}
