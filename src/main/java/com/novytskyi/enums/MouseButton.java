package com.novytskyi.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum MouseButton {
    UNDEFINED(Integer.MIN_VALUE),
    MOUSE_1(1),
    MOUSE_2(2),
    MOUSE_3(3),
    MOUSE_4(4),
    MOUSE_5(5);

    private static final Map<Integer, MouseButton> numberMouseButtonMap;

    static {
        numberMouseButtonMap = new HashMap<>();
        for (MouseButton button : MouseButton.values()) {
            numberMouseButtonMap.put(button.number, button);
        }
    }

    private final int number;

    MouseButton(int number) {
        this.number = number;
    }

    public static MouseButton getMouseButtonByNumber(int number) {
        return Optional.of(numberMouseButtonMap.get(number)).orElse(UNDEFINED);
    }

    public int getNumber() {
        return number;
    }
}
