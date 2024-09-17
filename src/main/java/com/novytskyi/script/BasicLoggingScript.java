package com.novytskyi.script;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;

public class BasicLoggingScript implements Script {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void keyTyped(char keyChar) {
        LOGGER.info("Key typed: {}", keyChar);
    }

    @Override
    public void keyPressed(String keyText) {
        LOGGER.info("Key pressed: {}", keyText);
    }

    @Override
    public void keyReleased(String keyText) {
        LOGGER.info("Key released: {}", keyText);
    }

    @Override
    public void mouseClicked(String buttonName) {
        LOGGER.info("Mouse Button Clicked: {}", buttonName);
    }

    @Override
    public void mouseButtonPressed(String buttonName) {
        LOGGER.info("Mouse Button Pressed: {}", buttonName);
    }

    @Override
    public void mouseButtonReleased(String buttonName) {
        LOGGER.info("Mouse Button Released: {}", buttonName);
    }

    @Override
    public void mouseMoved(Point point) {
        LOGGER.info("Mouse Moved to: {}, {}", point.getX(), point.getY());
    }

    @Override
    public void mouseDragged(Point point) {
        LOGGER.info("Mouse Dragged to: {}, {}", point.getX(), point.getY());
    }

    @Override
    public void mouseWheelMoved(String direction) {
        LOGGER.info("Wheel moved: {}", direction);
    }
}
