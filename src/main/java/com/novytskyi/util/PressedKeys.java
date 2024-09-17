package com.novytskyi.util;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class PressedKeys {

    public static final Set<String> values = ConcurrentHashMap.newKeySet(10);

    private PressedKeys() {
    }
}
