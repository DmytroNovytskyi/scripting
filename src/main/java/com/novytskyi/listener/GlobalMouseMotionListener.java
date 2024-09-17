package com.novytskyi.listener;

import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseMotionListener;
import com.novytskyi.script.Script;

import java.awt.*;
import java.util.Set;

public class GlobalMouseMotionListener implements NativeMouseMotionListener {

    private final Set<Script> scripts;

    public GlobalMouseMotionListener(Set<Script> scripts) {
        this.scripts = scripts;
    }

    @Override
    public void nativeMouseMoved(NativeMouseEvent e) {
        Point point = e.getPoint();
        scripts.forEach(s -> s.mouseMoved(point));
    }

    @Override
    public void nativeMouseDragged(NativeMouseEvent e) {
        Point point = e.getPoint();
        scripts.forEach(s -> s.mouseDragged(point));
    }
}