package com.novytskyi.listener;

import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseListener;
import com.novytskyi.enums.MouseButton;
import com.novytskyi.script.Script;
import com.novytskyi.util.PressedKeys;

import java.util.Set;

public class GlobalMouseListener implements NativeMouseListener {

    private final Set<Script> scripts;

    public GlobalMouseListener(Set<Script> scripts) {
        this.scripts = scripts;
    }

    @Override
    public void nativeMouseClicked(NativeMouseEvent e) {
        String buttonName = MouseButton.getMouseButtonByNumber(e.getButton()).name();
        scripts.forEach(s -> s.mouseClicked(buttonName));
    }

    @Override
    public void nativeMousePressed(NativeMouseEvent e) {
        String buttonName = MouseButton.getMouseButtonByNumber(e.getButton()).name();
        PressedKeys.values.add(buttonName);
        scripts.forEach(s -> s.mouseButtonPressed(buttonName));
    }

    @Override
    public void nativeMouseReleased(NativeMouseEvent e) {
        String buttonName = MouseButton.getMouseButtonByNumber(e.getButton()).name();
        PressedKeys.values.remove(buttonName);
        scripts.forEach(s -> s.mouseButtonReleased(buttonName));
    }
}