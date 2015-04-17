package tk.coolv1994.plugins.warps;

import tk.coolv1994.gawdapi.plugin.Plugin;

import java.io.*;
import java.util.Properties;
import java.util.Set;

/**
 * Created by Vinnie on 2/2/2015.
 */
public class Warps implements Plugin {
    private final File warpFile = new File("./plugins/Warps/warps.txt");
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
        } catch (IOException e) {
            System.out.println("Error loading warps.\n" + e.getMessage());
        }
    }

    private void saveWarps() {
        try {
            warps.store(new FileOutputStream(warpFile), "Warps (name=x y z)");
        } catch (IOException e) {
            System.out.println("Error saving warps.\n" + e.getMessage());
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
