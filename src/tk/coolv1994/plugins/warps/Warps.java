package tk.coolv1994.plugins.warps;

import tk.coolv1994.gawdserver.plugin.Plugin;

import java.io.*;
import java.util.Properties;

/**
 * Created by Vinnie on 2/2/2015.
 */
public class Warps implements Plugin {
    private static final File warpFile = new File("./plugins/Warps/warps.txt");
    public static final Properties warps = new Properties();

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
