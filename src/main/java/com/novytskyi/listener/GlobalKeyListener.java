package com.novytskyi.listener;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import com.novytskyi.script.Script;
import com.novytskyi.util.PressedKeys;

import java.util.Set;

import static com.novytskyi.util.ListenerUtils.getKeyAsText;

public class GlobalKeyListener implements NativeKeyListener {

    private final Set<Script> scripts;

    public GlobalKeyListener(Set<Script> scripts) {
        this.scripts = scripts;
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {
        char typed = e.getKeyChar();
        scripts.forEach(s -> s.keyTyped(typed));
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        String pressed = getKeyAsText(e);
        PressedKeys.values.add(pressed);
        scripts.forEach(s -> s.keyPressed(pressed));
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
        String released = getKeyAsText(e);
        PressedKeys.values.remove(released);
        scripts.forEach(s -> s.keyReleased(released));
    }
}