package dev.cloudmc.utils;

import java.io.File;

public class ReferenceUtils {

    public final static String name = "Cloud";
    public final static String clientJarName = "";
    public final static String clientJar = "";

    private static final String currentOS = System.getProperty("os.name").toLowerCase();

    public static boolean isWindows() { return (currentOS.contains("windows")); }
    public static boolean isMac() { return (currentOS.contains("mac")); }
    public static boolean isLinux() { return (currentOS.contains("linux")); }

    public static String getDirectory() {
        if (isWindows()) {
            return System.getenv("APPDATA") + File.separator + ".minecraft" + File.separator;
        }
        else if (isLinux()) {
            return System.getProperty("user.home") + File.separator + ".minecraft" + File.separator;
        }
        else if (isMac()) {
            return System.getProperty("user.home") + File.separator + "Library" + File.separator + "Application Support" + File.separator + "minecraft" + File.separator;
        }
        else {
            return null;
        }
    }

    public static String getModsDirectory(){
        return getDirectory() + "mods";
    }
}
