package io.github.gawdserver.warps;

import io.github.gawdserver.api.plugin.Plugin;
import io.github.gawdserver.api.plugin.PluginDir;

import java.io.*;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Vinnie on 2/2/2015.
 */
public class Warps implements Plugin {
    public static final Logger logger = Logger.getLogger("Warps");
    private final File warpFile = new File(PluginDir.getPluginDir(), "Warps/warps.txt");
    private static Properties warps;

    public Warps() {
        warps = new Properties();
    }

    public static boolean hasWarp(String name) {
        return warps.containsKey(name);
    }

    public static String getWarp(String name) {
        return warps.getProperty(name);
    }

    public static Set<Object> getWarpSet() {
        return warps.keySet();
    }

    public static void setWarp(String name, String coords) {
        warps.setProperty(name, coords);
    }

    private void loadWarps() {
        try {
            warps.load(new FileInputStream(warpFile));
        } catch (FileNotFoundException e) {
            warpFile.getParentFile().mkdirs();
            saveWarps();
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Error loading warps.", ex);
        }
    }

    private void saveWarps() {
        try {
            warps.store(new FileOutputStream(warpFile), "Warps (name=x y z)");
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Error saving warps.", ex);
        }
    }

    @Override
    public void startup() {
        loadWarps();
    }

    @Override
    public void shutdown() {
        saveWarps();
    }
}
