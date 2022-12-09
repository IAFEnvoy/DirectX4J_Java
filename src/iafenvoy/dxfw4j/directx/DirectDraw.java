package iafenvoy.dxfw4j.directx;

public class DirectDraw {
    public static native boolean create();

    public static native void setBackgroundColor(int r,int g,int b);

    public static native void setTextColor(int r,int g,int b);

    public static native void textOut(int x,int y,String s);

    public static native void destroy();
}
