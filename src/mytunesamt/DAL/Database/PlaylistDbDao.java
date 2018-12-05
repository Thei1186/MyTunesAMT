/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunesamt.DAL.Database;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mytunesamt.BE.Playlist;
import mytunesamt.BE.Song;


public class PlaylistDbDao
{
    
    DbConnectionProvider ds;
    
    public Playlist newPlaylist (String name, int id) throws IOException, SQLServerException, SQLException
    {
         ds = new DbConnectionProvider();
         Connection con = ds.getConnection();
         
         Playlist newPlaylist = null;
         
         String SQL = "INSERT iNTO Playlist VALUES (?)";
         PreparedStatement pstmt = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
         pstmt.setInt(1, id);
         pstmt.setString(2, name);
         pstmt.execute();
         
         try (ResultSet generatedKeys = pstmt.getGeneratedKeys())
         {
             if (generatedKeys.next())
             {
                 newPlaylist = new Playlist (generatedKeys.getInt(1), name);

                 
             }
         }
         
        return newPlaylist;
    }
    
     public List<Playlist> getAllPlaylists() throws SQLException
    {
        List<Playlist> playlistList = new ArrayList<>();
        try (Connection con = ds.getConnection())
        {

            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Playlist");
            while (rs.next())
            {
                String name = rs.getString("Name");
                int id = rs.getInt("id");
                playlistList.add(new Playlist(id, name));
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return playlistList;
    }
     
     
}
