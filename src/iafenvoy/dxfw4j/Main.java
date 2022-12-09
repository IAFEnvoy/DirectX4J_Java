package iafenvoy.dxfw4j;

import iafenvoy.dxfw4j.utils.MessageBox;

public class Main {
    public static void main(String[] args) {
        DllLoader.LoadDll("DirectX4J.dll");

        MessageBox.show("This is a dialog", "This is the title",MessageBox.Buttons.YesNoCancel);
    }
}