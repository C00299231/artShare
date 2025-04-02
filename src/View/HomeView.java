package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.*;
import Controller.*;

public class HomeView extends View
{
    private JButton logoutButton;
    private JButton createButton;
    private JButton myProfileButton;
    public JButton arrayPostButton;

    private View container;

    private GridBagConstraints gbc;

    public HomeView(ControlManager m)
    {
        super(m);

        logoutButton = new JButton("LogOut");

        createButton = new JButton("Create"); 
        myProfileButton = new JButton("My Profile");      
        arrayPostButton = new JButton("Home");

        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
        buttons.add(arrayPostButton);
        buttons.add(myProfileButton);
        buttons.add(createButton);
        buttons.add(logoutButton);

        // layout stuff

        setLayout(new BorderLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1;
        gbc.weightx = 1;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(buttons, BorderLayout.LINE_START);
    }

    public void replaceContainer(View newContainer)
    {
        remove(container);
        container = newContainer;

        // layout
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.weightx = 1;

        add(newContainer, BorderLayout.CENTER);
        
        setUpView();
    }
    
    public void addLogoutListener(ActionListener l)
    {
        logoutButton.addActionListener(l);
    }
    public void addCreateListener(ActionListener l)
    {
        createButton.addActionListener(l);
    }
    public void addMyProfileListener(ActionListener l)
    {
        myProfileButton.addActionListener(l);
    }
    public void addArrayPostListener(ActionListener l)
    {
        arrayPostButton.addActionListener(l);
    }

    // SETGET


    public JButton getLogoutButton() {
        return this.logoutButton;
    }
    public void setLogoutButton(JButton logoutButton) {
        this.logoutButton = logoutButton;
    }

    public JButton getCreateButton() {
        return this.createButton;
    }
    public void setCreateButton(JButton createButton) {
        this.createButton = createButton;
    }

    public View getCont() {
        return this.container;
    }
    public void setContainer(View container) {
        this.container = container;
    }

    public JButton getMyProfileButton() {
        return this.myProfileButton;
    }
    public void setMyProfileButton(JButton myProfileButton) {
        this.myProfileButton = myProfileButton;
    }

}
