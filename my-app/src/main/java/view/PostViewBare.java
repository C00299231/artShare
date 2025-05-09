package view;

import model.InteractionOption;
import model.UserOption;
import tools.ImageTools;
import tools.UiTools;
import controller.ControlManager;
import objects.Post;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;

import java.awt.event.MouseEvent;       // For MouseEvent class
import java.awt.event.MouseAdapter;     // For MouseAdapter (an abstract class)

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

public class PostViewBare extends View
{
    private AuthorView author;

    private int postId;

    private JLabel title;
    private JLabel description;

    private JLabel image;

    private JLabel interactions;
    private int likes;
    private int shares;
    private int comments;

    private JButton likeButton;
    private JButton shareButton;

    public PostViewBare(ControlManager m, Post p)
    {
        super(m);

        postId = p.getPostId();

        // author stuff
        author = new AuthorView(m, UserOption.readUser(p.getUserId()));

        title = new JLabel(p.getTitle());
        description = new JLabel(p.getDescription());

        ImageIcon imageIcon = new ImageIcon(p.getFilePath());
        System.out.println("FILEPATH: " + p.getFilePath());
        image = new JLabel(ImageTools.resize(imageIcon, 200, 150));
        
        interactions = new JLabel();
        resetInteractionText();

        likeButton = new JButton("Like");
        shareButton = new JButton("Share");

        // layout stuff
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5,5,5);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 0.0;
        gbc.gridwidth = 2;
        add(author, gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy = 2;
        add(title, gbc);

        gbc.gridy = 3;
        add(description, gbc);

        gbc.gridy = 4;
        add(image, gbc);

        gbc.gridy = 5;
        add(interactions, gbc);

        // buttons
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridy = 6;
        add(likeButton, gbc);
        gbc.gridx = 1;
        add(shareButton, gbc);

        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(UiTools.DEFAULT_GREY_DARK)));

        // CLICKABLE
        addListeners();
    }

    public void addLikeListener(ActionListener l){likeButton.addActionListener(l);}
    public void addShareListener(ActionListener l){shareButton.addActionListener(l);}

    public void resetInteractionText()
    {
        int[] i = InteractionOption.getInteraction(postId);
        
        // ensure i exists
        if(i == null)
        {
            i = new int[3];
            for(int index = 0; index < i.length; index++)
            {
                i[index] = 0;
            }
        }

        likes = i[0];
        shares = i[1];
        comments = i[2];
        String newText = "LIKES: " + likes + ", SHARES: " + shares + ", COMMENTS: " + comments;
        interactions.setText(newText);
    }

    public void addListeners()
    {
        super.addListeners();
        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                System.out.println("Panel clicked at position: " + e.getPoint());
                getManager().getMainHome().makeActivePost(postId);
            }
        }
        );
    }

    // SETGET

    public AuthorView getAuthor() {
        return this.author;
    }

    public void setAuthor(AuthorView author) {
        this.author = author;
    }

    public int getPostId() {
        return this.postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public JLabel getTitle() {
        return this.title;
    }

    public void setTitle(JLabel title) {
        this.title = title;
    }

    public JLabel getDescription() {
        return this.description;
    }

    public void setDescription(JLabel description) {
        this.description = description;
    }

    public JLabel getImage() {
        return this.image;
    }

    public void setImage(JLabel image) {
        this.image = image;
    }

    public JLabel getInteractions() {
        return this.interactions;
    }

    public void setInteractions(JLabel interactions) {
        this.interactions = interactions;
    }

    public int getLikes() {
        return this.likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getShares() {
        return this.shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public int getComments() {
        return this.comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public JButton getLikeButton() {
        return this.likeButton;
    }

    public void setLikeButton(JButton likeButton) {
        this.likeButton = likeButton;
    }

    public JButton getShareButton() {
        return this.shareButton;
    }

    public void setShareButton(JButton shareButton) {
        this.shareButton = shareButton;
    }

}
