package com.novytskyi;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.novytskyi.listener.GlobalKeyListener;
import com.novytskyi.listener.GlobalMouseListener;
import com.novytskyi.listener.GlobalMouseMotionListener;
import com.novytskyi.listener.GlobalMouseWheelListener;
import com.novytskyi.script.BasicLoggingScript;
import com.novytskyi.script.Script;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

public class Main {

    private static final Set<Script> SCRIPTS = Set.of(new BasicLoggingScript());

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            LOGGER.info("Looks like native hook feature is unavailable or disabled. Exception message: {}",
                    e.getMessage());
            System.exit(-1);
        }

        enableListenersForScripts();

        LOGGER.info("Application started successfully!");
    }

    private static void enableListenersForScripts() {
        GlobalScreen.addNativeMouseListener(new GlobalMouseListener(Main.SCRIPTS));
        GlobalScreen.addNativeMouseMotionListener(new GlobalMouseMotionListener(Main.SCRIPTS));
        GlobalScreen.addNativeMouseWheelListener(new GlobalMouseWheelListener(Main.SCRIPTS));
        GlobalScreen.addNativeKeyListener(new GlobalKeyListener(Main.SCRIPTS));
    }
}
