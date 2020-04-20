package ru.netology.manager;

import lombok.NoArgsConstructor;

import java.util.*;

@NoArgsConstructor
public class FileOpenManager {
    private Map<String, String> extensionMap = new HashMap<>();

    public void registerNew(String extension, String app) {
        extensionMap.put(extension.toLowerCase(), app);
    }

    public String getApp(String extension) {
        return extensionMap.get(extension.toLowerCase());
    }

    public void removeExtension(String extension) {
        extensionMap.remove(extension.toLowerCase());
    }

    public Collection<String> getAllApps() {
        return extensionMap.values();
    }

    public Set<String> getAllExtensions() {
        return extensionMap.keySet();
    }
}
