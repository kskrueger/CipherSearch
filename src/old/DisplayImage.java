package old;

import javax.swing.*;
import java.io.File;

public class DisplayImage extends JFrame{
    private JPanel panel;
    private JLabel showImage;

    public static void main(String[] args) {
        DisplayImage window = new DisplayImage();
    }

    private DisplayImage() {
        final int WINDOW_WIDTH = 500;   // Window width in pixels
        final int WINDOW_HEIGHT = 500;  // Window height in pixels

        setTitle("Display Image");

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        buildPanel();

        add(panel);

        setVisible(true);
    }

    private void buildPanel() {
        JFileChooser fileChooser = new JFileChooser();
        int status = fileChooser.showOpenDialog(null);
        String filename = "";
        if (status == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            filename = selectedFile.getPath();
        }

        ImageIcon image = new ImageIcon(filename);

        showImage = new JLabel(image);

        panel = new JPanel();
        panel.add(showImage);
    }
}
