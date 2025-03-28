package Controller;

import View.*;

public class SplashControl extends Control
{
    SplashView view;
    MainControl parent;

    public SplashControl(ControlManager m)
    {
        super(m);

        view = new SplashView(m);

        // add listeners
        view.addLoginListener(e -> m.makeActiveLogin());
        view.addSignUpListener(e -> m.makeActiveSignUp());
    }
    
}
