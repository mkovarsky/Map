package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class FileOpenManagerTest {

    FileOpenManager manager = new FileOpenManager();

    @BeforeEach
    void setUp() {
        manager.registerNew("psd", "Adobe Photoshop");
        manager.registerNew("txt", "Notepad");
        manager.registerNew("html", "Google Chrome");
        manager.registerNew("HTML", "Google Chrome");
        manager.registerNew("doc", "Microsoft Word");
    }

    @Test
    void shouldShowAllApps() {
        Collection<String> actual = manager.getAllApps();
        Collection<String> expected = new ArrayList<>();
        expected.add("Adobe Photoshop");
        expected.add("Notepad");
        expected.add("Microsoft Word");
        expected.add("Google Chrome");

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    void shouldShowAllExtensions() {
        Set<String> actual = manager.getAllExtensions();
        Set<String> expected = new HashSet<>();
        expected.add("psd");
        expected.add("txt");
        expected.add("html");
        expected.add("doc");
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    void shouldRemoveExtension() {
        manager.removeExtension("psd");
        Collection<String> actual = manager.getAllApps();
        Collection<String> expected = new ArrayList<>();
        expected.add("Notepad");
        expected.add("Microsoft Word");
        expected.add("Google Chrome");
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    void shouldGetAppForExistedExtension() {
        String actual = manager.getApp("txt");
        String expected = "Notepad";
        assertEquals(expected, actual);
    }
    @Test
    void shouldNotGetAppForNotExistedExtension() {
        String actual = manager.getApp("sys");
        assertNull(actual);
    }

}
