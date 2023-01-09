import java.awt.*;

public class Frame extends java.awt.Frame {

    public Frame() throws HeadlessException {
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
    }
}
