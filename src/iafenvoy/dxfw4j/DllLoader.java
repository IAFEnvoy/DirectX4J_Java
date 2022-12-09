package iafenvoy.dxfw4j;

import java.io.File;

public class DllLoader {
    public static void LoadDll(String... dllName) {
        String path = System.getProperty("user.dir") + "\\";
        for (String dll : dllName) {
            try {
                File dllFile = new File(path + dll);
                System.load(dllFile.getPath());
                dllFile.deleteOnExit();
            } catch (Throwable e) {
                throw new RuntimeException("Fail to load " + dll, e);
            }
        }
    }
}
