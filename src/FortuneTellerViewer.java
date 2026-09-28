import javax.swing.*;
import java.awt.*;

public class FortuneTellerViewer
{
    public static void main(String[] args)
    {
        FortuneTellerFrame frame = new FortuneTellerFrame();

        // Get the screen size so the frame is 3/4 of the display width and centered
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        int frameWidth = screenWidth * 3 / 4;
        int frameHeight = screenHeight * 3 / 4;
        frame.setSize(frameWidth, frameHeight);
        frame.setLocation((screenWidth - frameWidth) / 2, (screenHeight - frameHeight) / 2);

        frame.setTitle("Fortune Teller");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
