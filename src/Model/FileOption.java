package Model;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;

public class FileOption
{
    public static File[] loadFiles(int postId)
    {
        File[] files = null;
        String sql = "SELECT path FROM File WHERE postId = ?";

        try
        {
            Connection c = Global.getCon();
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, postId);

            ResultSet rs = pst.executeQuery();

            ArrayList<File> list = new ArrayList<File>();
            while(rs.next())
            {
                File f = new File(rs.getString("path"));
                list.add(f);
            }

            files = list.toArray(files);
        }
        catch(SQLException s)
        {
            s.printStackTrace();
            return null;
        }
        return files;
    }

    public static String getFilePath(int postId)
    {
        String path = null;

        String sql = "SELECT path FROM File WHERE postId = ?";

        try
        {
            Connection c = Global.getCon();
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, postId);

            ResultSet rs = pst.executeQuery();

            if(!rs.next())
            {
                System.out.println("NO FILE FOR " + postId);
                return null;
            }

            path = rs.getString("path");
            System.out.println("POSTID: " + postId + " - PATH!: " + path);
        }
        catch(SQLException s)
        {
            s.printStackTrace();
            return null;
        }
        

        return path;
    }

    public int saveFile(int postId, int userId, String link)
    {
        return 0;
    }
}
