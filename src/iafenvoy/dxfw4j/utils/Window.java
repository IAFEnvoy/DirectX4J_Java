package iafenvoy.dxfw4j.utils;

public class Window {

    public Window(String id) {
        createInstance(id);
    }

    public native void setIcon();

    public native void setCursor();

    public native void setBackgroundColor(int r, int g, int b);

    public native void setTitle(String title);

    public native void create();

    public native void show();

    public static native String[] getInstances();

    public static native void createInstance(String id);

    public static native void deleteInstance(String id);
}
