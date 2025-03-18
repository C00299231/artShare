package Controller;

import javax.swing.JFrame;

import Model.*;
import View.*;
import Objects.*;

public class ControlManager
{
    //UIHelper.setup();
    // frame
    MainFrame f = new MainFrame();

    //-----------------------------main
    MainControl main;
    MainView mainV;

    //-----------------------------children of main
    LoginControl mainLogin;
    LoginView mainLoginV;

    HomeControl mainHome;
    HomeView mainHomeV;

    //-----------------------------children of home
    ArrayPostControl homeArray;
    ArrayPostView homeArrayV;

    ProfileControl homeProfile;
    ProfileView homeProfileV;

    // VIEW
    MainView mainView = new MainView(this);

    public void run()
    {
        main = new MainControl(this);
        mainV = new MainView(this);

        mainLogin = new LoginControl(this);
        mainHome = new HomeControl(this);

        homeArray = new ArrayPostControl(this, -1);
        homeProfile = new ProfileControl(this);


        f.add(mainV);
        f.frameReset();
        

        makeActiveLogin();
    }

    //-------------------------------------------------

    void makeActiveLogin()
    {
        // place mainLogin's view inside main's view
        mainLoginV = new LoginView(this);
        mainV.replaceContainer(mainLoginV);

        mainLoginV.addLoginListener(e -> mainLogin.login("adamN", "password"));

        f.frameReset();
    }

    void makeActiveHome()
    {
        // place mainHome's view inside main's view
        mainHome = new HomeControl(this);
        mainV.replaceContainer(mainHome.view);

        f.frameReset();
    }

    //-------------------------------------------------

    

    void makeActiveProfile(int userId)
    {
        // place inside Home View
        homeProfileV = new ProfileView(this);
        mainV.container = homeProfileV;

        f.frameReset();
    }

    void viewReset(View v)
    {
        v.repaint();
        v.revalidate();
    }

    // SETGET
    public MainFrame getFrame(){return f;}
}
