package com.novytskyi.util;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseWheelEvent;
import com.novytskyi.enums.WheelDirection;

import static com.novytskyi.enums.WheelDirection.*;

public class ListenerUtils {

    private ListenerUtils() {
    }

    public static String getKeyAsText(NativeKeyEvent event) {
        return NativeKeyEvent.getKeyText(event.getKeyCode());
    }

    public static WheelDirection getMouseWheelDirection(NativeMouseWheelEvent event) {
        return switch (event.getWheelRotation()) {
            case -1 -> UP;
            case 1 -> DOWN;
            default -> UNDEFINED;
        };
    }
}
