package Model;

import java.sql.*;

import Exceptions.InteractionTypeException;

//      Interaction:
// interactionId
// postId
// userId
// type         0: like, 1: share, 2: comment
// comment

public class InteractionOption
{
    // check if given interaction type is valid
    public static void checkTypeValid(int type, int max, int min) throws InteractionTypeException
    {
        if(type > max || type < min)
        {
            throw new InteractionTypeException("Interaction type invalid.");
        }
    }

    // create non-comment interaction
    public static int createInteraction(int postId, int userId, int type) throws InteractionTypeException
    {
        String sql = "INSERT INTO Interaction (postId, userId, type) VALUES (?, ?, ?)";

        try
        {
            checkTypeValid(type, 1, 0);

            Connection c = DriverManager.getConnection(Global.fullUrl());
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, postId);
        }
        catch(InteractionTypeException i)
        {
            return 1;
        }
        catch(SQLException s)
        {
            s.printStackTrace();
            return 1;
        }

        return 0;
    }

    // create comment interaction
    public static int createComment(int postId, int userId, String comment)
    {
        // auto set type to 2
        String sql = "INSERT INTO Interaction (postId, userId, type, comment) VALUES (?, ?, 2, ?)";

        try
        {

            Connection c = DriverManager.getConnection(Global.fullUrl());
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, postId);
            pst.setInt(2, userId);
            pst.setString(3, comment);

            pst.executeUpdate();
        }
        catch(SQLException s)
        {
            s.printStackTrace();
            return 1;
        }

        return 0;
    }

    public static int deleteInteraction(int interactionId)
    {
        String sql = "DELETE FROM Interaction WHERE InteractionId = ?";

        try
        {

            Connection c = DriverManager.getConnection(Global.fullUrl());
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, interactionId);

            pst.executeUpdate();
        }
        catch(SQLException s)
        {
            s.printStackTrace();
            return 1;
        }

        return 0;
    }
}
