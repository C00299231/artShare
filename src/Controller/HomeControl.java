package Controller;

import View.View;
import View.HomeView;
import Objects.User;
import Objects.Post;

public class HomeControl extends Control
{
    HomeView view;
    Control middleControl;
    View middleView;

    public HomeControl(ControlManager m)
    {
        super(m);

        // set basic middleControl
        middleControl = new ArrayPostControl(manager, -1);

        view = new HomeView(m);

        view.setContainer(new View(m));
        view.add(view.getCont());
        //manager.getFrame().frameReset();

        view.addLogoutListener(e -> logout());
        view.addCreateListener(e -> makeActiveCreate());
        view.addMyProfileListener(e -> makeActiveProfile(m.getCurrentUserId()));
        view.addArrayPostListener(e -> makeActiveArrayPost(-1));

        makeActiveArrayPost(-1);
    }

    public void makeActivePost(int postId)
    {
        // place homePost's view inside home's view
        // give post values to post

        PostControl pCtrl = new PostControl(manager, postId);
        view.replaceContainer(pCtrl.getView());

        middleControl = pCtrl;
    }

    // move to post scroll (-1 for home feed)
    public void makeActiveArrayPost(int userId)
    {
        ArrayPostControl a = new ArrayPostControl(manager, userId);
        view.replaceContainer(a.getView());

        middleControl = a;
    }

    public void makeActiveCreate()
    {
        CreatePostControl c = new CreatePostControl(manager);
        view.replaceContainer(c.getView());
                
        middleControl = c;
    }

    public void makeActiveEdit(Post p)
    {
        CreatePostControl e = new CreatePostControl(manager, p);
        view.replaceContainer(e.getView());

        middleControl = e;
    }

    public void makeActiveEditProfile(User u)
    {
        EditProfileControl e = new EditProfileControl(manager, u);
        view.replaceContainer(e.getView());

        middleControl = e;
    }

    public void makeActiveProfile(int userId)
    {
        ProfileControl c = new ProfileControl(manager, userId);
        view.replaceContainer(c.view);

        middleControl = c;
    }

    public void logout()
    {
        manager.logout();
        manager.makeActiveSplash();
    }

    public void Hello()
    {
        System.err.println("Hello");
    }

    // SETGET

    public HomeView getView() {
        return this.view;
    }

    public void setView(HomeView view) {
        this.view = view;
    }

    public Control getMiddleControl() {
        return this.middleControl;
    }

    public void setMiddleControl(Control middleControl) {
        this.middleControl = middleControl;
    }

    public View getMiddleView() {
        return this.middleView;
    }

    public void setMiddleView(View middleView) {
        this.middleView = middleView;
    }
    
}
