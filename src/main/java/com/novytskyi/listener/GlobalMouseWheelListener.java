package com.novytskyi.listener;

import com.github.kwhat.jnativehook.mouse.NativeMouseWheelEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseWheelListener;
import com.novytskyi.script.Script;

import java.util.Set;

import static com.novytskyi.util.ListenerUtils.getMouseWheelDirection;

public class GlobalMouseWheelListener implements NativeMouseWheelListener {

    private final Set<Script> scripts;

    public GlobalMouseWheelListener(Set<Script> scripts) {
        this.scripts = scripts;
    }

    @Override
    public void nativeMouseWheelMoved(NativeMouseWheelEvent e) {
        String direction = getMouseWheelDirection(e).name();
        scripts.forEach(s -> s.mouseWheelMoved(direction));
    }
}