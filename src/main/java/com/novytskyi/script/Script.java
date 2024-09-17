package com.novytskyi.script;

import java.awt.*;

public interface Script {

    default void keyTyped(char keyChar) {
    }

    default void keyPressed(String keyText) {
    }

    default void keyReleased(String keyText) {
    }

    default void mouseClicked(String buttonName) {
    }

    default void mouseButtonPressed(String buttonName) {
    }

    default void mouseButtonReleased(String buttonName) {
    }

    default void mouseMoved(Point point) {
    }

    default void mouseDragged(Point point) {
    }

    default void mouseWheelMoved(String direction) {
    }
}
