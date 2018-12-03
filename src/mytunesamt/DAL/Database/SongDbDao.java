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
import mytunesamt.BE.Song;

/**
 *
 * @author kokus
 */
public class SongDbDao
{

    DbConnectionProvider ds;

    public SongDbDao() throws IOException
    {
        ds = new DbConnectionProvider();

    }

    public void addSong(Song song) throws SQLServerException, SQLException
    {
        String artist = song.getArtist();
        String title = song.getTitle();
        String location = song.getLocation();
        
        try (Connection con = ds.getConnection())
        {
            String sql = "INSERT INTO Songs VALUES(?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, title);
            pstmt.setString(2, artist);
            pstmt.setString(3, location);
           // pstmt.setInt(4, Statement.RETURN_GENERATED_KEYS);
            pstmt.execute();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void editSong(Song song)
    {
        try (Connection con = ds.getConnection())
        {
            PreparedStatement pstmt = con.prepareStatement("UPDATE Songs SET Title = (?), Artist = (?), Location = (?) WHERE ID = (?)");
            pstmt.setString(1, song.getTitle());
            pstmt.setString(2, song.getArtist());
            pstmt.setString(3, song.getLocation());
            pstmt.execute();
            pstmt.close();

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void deleteSong(Song song)
    {
        int id = song.getId();
        try (Connection con = ds.getConnection())
        {

            PreparedStatement pstmt = con.prepareStatement("DELETE FROM Songs WHERE ID=(?)");
            pstmt.setInt(1, id);
            pstmt.execute();
            pstmt.close();
            System.out.println(id + "has been deleted");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public List<Song> getAllSongs() throws SQLException
    {
        List<Song> songList = new ArrayList<>();
        try (Connection con = ds.getConnection())
        {

            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Songs");
            while (rs.next())
            {
                String title = rs.getString("Title");
                String artist = rs.getString("Artist");
                String location = rs.getString("Location");
                int id = rs.getInt("id");
                songList.add(new Song(title, artist, location, id));
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return songList;
    }

    public Song getSong(int ID)
    {
        Song wantedSong = null;
        try (Connection con = ds.getConnection())
        {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Songs WHERE ID = (?)");
            pstmt.setInt(1, ID);
            
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                int id = rs.getInt("ID");
                String title = rs.getString("Title");
                String artist = rs.getString("Artist");
                String location = rs.getString("Location");
                wantedSong = new Song(title, artist, location, id);
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return wantedSong;
    }
}
