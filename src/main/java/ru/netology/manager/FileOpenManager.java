package ru.netology.manager;

import lombok.NoArgsConstructor;

import java.util.*;

@NoArgsConstructor
public class FileOpenManager {
    Map<String, String> map = new HashMap<>();

    public void registerNew(String extension, String app) {
        map.put(extension.toLowerCase(), app);
    }

    public String getApp(String extension) {
        return map.get(extension.toLowerCase());
    }

    public void removeExtension(String extension) {
        map.remove(extension);
    }

    public Collection<String> getAllApps() {
        return map.values();
    }

    public Set<String> getAllExtensions() {
        return map.keySet();
    }
}
