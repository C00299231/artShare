package View;

import java.awt.event.ActionListener;

import javax.swing.*;

import Controller.ControlManager;

public class SplashView extends View
{

    public JButton loginButton;
    public JButton signupButton;

    public SplashView(ControlManager m)
    {
        super(m);

        loginButton = new JButton("Log In");
        signupButton = new JButton("Sign Up");

        add(loginButton);
        add(signupButton);
    }

    public void addLoginListener(ActionListener l){loginButton.addActionListener(l);}

    public void addSignUpListener(ActionListener l){signupButton.addActionListener(l);}
}
