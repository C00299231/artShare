package View;

import Controller.ControlManager;
import javax.swing.*;

import java.awt.event.MouseEvent;       // For MouseEvent class
import java.awt.event.MouseListener;    // For MouseListener interface
import java.awt.Color;
import java.awt.event.MouseAdapter;     // For MouseAdapter (an abstract class)

import Objects.*;

public class AuthorView extends View
{
    JLabel authorName;
    User user;

    public AuthorView(ControlManager m, User u)
    {
        super(m);

        user = u;

        authorName = new JLabel(u.getUsername());

        add(authorName);
        System.out.println("author panel created");

        addListeners();
    }

    public void addListeners()
    {
        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                System.out.println("AUTHOR Panel clicked at position: " + e.getPoint());
                getManager().getMainHome().makeActiveProfile(user.getUserId());
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
                setBackground(new Color(150, 150, 255));
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                setBackground(new Color(200, 200, 255));
            }
        }
        );
    }
}
