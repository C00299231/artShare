package frontend;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PostVisual
{
    // Main driver method
    public static void draw()
    {
        // Creating instance of JFrame
        JFrame postFrame = new JFrame();

        // Creating instance of JButton
        JButton button = new JButton("like post");

        // x axis, y axis, width, height
        button.setBounds(150, 200, 220, 50);

        // adding button in JFrame
        postFrame.add(button);

        // 400 width and 500 height
        postFrame.setSize(500, 600);

        // using no layout managers
        postFrame.setLayout(null);

        // making the frame visible
        postFrame.setVisible(true);
    }
}