package view;

import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ControlManager;

import javax.swing.JButton;
import javax.swing.JPasswordField;

public class LoginView extends View
{
    private JTextField usernameField;
    private JPasswordField passwordField;

    private JButton loginButton;
    private JButton backButton;

    private JLabel message;

    public LoginView(ControlManager m)
    {
        super(m);

        // init elements
        JLabel title = new JLabel("Login");
        
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(12);

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(12);

        loginButton = new JButton("Submit");
        backButton = new JButton("Back");

        message = new JLabel("");
        
        // layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5,5,5);

        // ADD ITEMS WITH LAYOUT CONSTRAINTS

        // title
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(title, gbc);

        // username stuff
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(usernameLabel, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(usernameField, gbc);

        // password stuff
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        add(passwordLabel, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(passwordField, gbc);
        
        // message
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(message, gbc);
        
        // buttons
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(loginButton, gbc);
        gbc.gridy = 5;
        add(backButton, gbc);
    }

    public void addLoginListener(ActionListener l){loginButton.addActionListener(l);}
    public void addBackListener(ActionListener l){backButton.addActionListener(l);}

    // SETGET

    public JTextField getUsernameField() {
        return this.usernameField;
    }

    public void setUsernameField(JTextField usernameField) {
        this.usernameField = usernameField;
    }

    public JPasswordField getPasswordField() {
        return this.passwordField;
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public JButton getLoginButton() {
        return this.loginButton;
    }

    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
    }

    public JButton getBackButton() {
        return this.backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    public JLabel getMessage() {
        return this.message;
    }

    public void setMessage(JLabel message) {
        this.message = message;
    }
    
}
